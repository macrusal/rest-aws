package br.com.hibejix.restaws.pessoa.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author macrusal on 11/04/21
 * @project rest-aws
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CredenciaisDTO {

    private String email;

    private String senha;

}
