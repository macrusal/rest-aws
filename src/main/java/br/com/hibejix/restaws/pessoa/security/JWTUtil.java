package br.com.hibejix.restaws.pessoa.security;

import br.com.hibejix.restaws.pessoa.security.exception.JwtExpiredTokenException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author macrusal on 11/04/21
 * @project rest-aws
 */
@Component
public class JWTUtil {

    private static final Logger logger = LoggerFactory.getLogger( JWTUtil.class );

    @Value( "${jwt.secret}" )
    private String secret;

    @Value( "${jwt.expiration}" )
    private Long expiration;

    public String generateToken( String userName ) {
        return Jwts.builder()
                .setSubject( userName )
                .setExpiration( new Date( System.currentTimeMillis() + expiration ) )
                .signWith( SignatureAlgorithm.HS512, secret.getBytes() )
                .compact();
    }

    public boolean tokenValido( String token ) {
        Claims claims = getClaims( token );
        if( claims != null ) {
            String username = claims.getSubject();
            Date expirationDate = claims.getExpiration();
            Date now = new Date( System.currentTimeMillis() );
            if( username != null && expirationDate != null && now.before( expirationDate ) ) {
                return true;
            }
        }
        return false;
    }

    private Claims getClaims( String token ) {
        try {
            return Jwts.parser().setSigningKey( secret.getBytes() ).parseClaimsJws( token ).getBody();
        } catch( UnsupportedJwtException | MalformedJwtException | IllegalArgumentException | SignatureException ex ) {
            logger.error( "Invalid JWT Token", ex );
            throw new BadCredentialsException( "Invalid JWT token: ", ex );
        } catch( ExpiredJwtException expiredEx ) {
            logger.info( "JWT Token is expired", expiredEx );
            throw new JwtExpiredTokenException( token, "JWT Token expired", expiredEx );
        }
    }

    public String getUsername( String token ) {
        Claims claims = getClaims( token );
        if( claims != null ) {
            return claims.getSubject();
        }
        return null;
    }
}
