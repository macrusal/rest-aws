package br.com.hibejix.restaws.calculadora.exception.handler;

import br.com.hibejix.restaws.calculadora.exception.CalculadoraException;
import br.com.hibejix.restaws.calculadora.response.CalculadoraResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

/**
 * @author macrusal on 02/04/21
 * @project rest-aws
 */
@RestController
@RestControllerAdvice
public class CalculadoraExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<CalculadoraResponse> handlerException( Exception exception, WebRequest request ) {
        var response = CalculadoraResponse.builder()
                .timestamp( new Date() )
                .details( request.getDescription( false ) )
                .message( exception.getMessage() )
                .build();
        return new ResponseEntity<>( response, HttpStatus.INTERNAL_SERVER_ERROR );
    }

    @ExceptionHandler(CalculadoraException.class)
    public final ResponseEntity<CalculadoraResponse> handlerBadRequestException( Exception exception, WebRequest request ) {
        var response = CalculadoraResponse.builder()
                .timestamp( new Date() )
                .details( request.getDescription( false ) )
                .message( exception.getMessage() )
                .build();
        return new ResponseEntity<>( response, HttpStatus.BAD_REQUEST );
    }
}
