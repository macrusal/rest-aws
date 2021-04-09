package br.com.hibejix.restaws.pessoa.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author macrusal on 08/04/21
 * @project rest-aws
 */
@ResponseStatus( HttpStatus.NOT_FOUND )
public class LivroNotFoundException extends RuntimeException {
    public LivroNotFoundException( String message ) {
        super( message );
    }
}
