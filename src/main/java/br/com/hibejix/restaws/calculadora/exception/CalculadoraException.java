package br.com.hibejix.restaws.calculadora.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author macrusal on 02/04/21
 * @project rest-aws
 */
@ResponseStatus( HttpStatus.BAD_REQUEST)
public class CalculadoraException extends RuntimeException {

    public CalculadoraException( String message ) {
        super( message );
    }
}
