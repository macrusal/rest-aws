package br.com.hibejix.restaws.pessoa.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author macrusal on 03/04/21
 * @project rest-aws
 */
@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PessoaDTO {
    private String id;
    private String primeiroNome;
    private String ultimoNome;
    private String endereco;
    private String sexo;
}
