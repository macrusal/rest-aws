package br.com.hibejix.restaws.pessoa.exception.handler;

import br.com.hibejix.restaws.pessoa.exception.PessoaNotFoundException;
import br.com.hibejix.restaws.pessoa.responnse.PessoaResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

/**
 * @author macrusal on 03/04/21
 * @project rest-aws
 */
@RestController
@RestControllerAdvice
public class PessoaExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity< PessoaResponse > handler( Exception exception, WebRequest request ) {
        var response = PessoaResponse.builder()
                .timestamp( new Date() )
                .details( request.getDescription( false ) )
                .message( exception.getMessage() )
                .build();
        return new ResponseEntity<>( response, HttpStatus.INTERNAL_SERVER_ERROR );
    }

    @ExceptionHandler( PessoaNotFoundException.class)
    public final ResponseEntity< PessoaResponse > handlerPessoaNotFoundException( Exception exception, WebRequest request ) {
        var response = PessoaResponse.builder()
                .timestamp( new Date() )
                .details( request.getDescription( false ) )
                .message( exception.getMessage() )
                .build();
        return new ResponseEntity<>( response, HttpStatus.NOT_FOUND );
    }
}
