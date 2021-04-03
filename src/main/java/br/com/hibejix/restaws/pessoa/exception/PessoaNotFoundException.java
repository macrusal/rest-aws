package br.com.hibejix.restaws.pessoa.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author macrusal on 03/04/21
 * @project rest-aws
 */
@ResponseStatus( HttpStatus.NOT_FOUND )
public class PessoaNotFoundException extends RuntimeException {

    public PessoaNotFoundException( String message ) {
        super( message );
    }
}
