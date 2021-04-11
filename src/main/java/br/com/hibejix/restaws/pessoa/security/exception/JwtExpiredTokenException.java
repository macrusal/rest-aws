package br.com.hibejix.restaws.pessoa.security.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * @author macrusal on 11/04/21
 * @project rest-aws
 */
public class JwtExpiredTokenException extends AuthenticationException {

    private String token;

    public JwtExpiredTokenException(String msg) {
        super(msg);
        System.out.println(msg);
    }

    public JwtExpiredTokenException(String token, String msg, Throwable t) {
        super(msg, t);
        this.token = token;
        System.out.println(msg);
    }

    public String token() {
        return this.token;
    }
}
