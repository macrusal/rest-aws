package br.com.hibejix.restaws.pessoa.responnse;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * @author macrusal on 03/04/21
 * @project rest-aws
 */
@Data
@Builder
public class PessoaResponse {

    private Date timestamp;
    private String message;
    private String details;
}
