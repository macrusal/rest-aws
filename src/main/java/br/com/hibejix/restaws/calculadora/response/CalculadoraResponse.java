package br.com.hibejix.restaws.calculadora.response;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * @author macrusal on 02/04/21
 * @project rest-aws
 */
@Data
@Builder
public class CalculadoraResponse {

    private Date timestamp;
    private String message;
    private String details;

}
