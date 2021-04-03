package br.com.hibejix.restaws.pessoa.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.bson.types.ObjectId;

/**
 * @author macrusal on 03/04/21
 * @project rest-aws
 */
@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({"id", "nome", "sobrenome", "endereco", "sexo"})
public class PessoaDTO {
    @JsonProperty("uid")
    private ObjectId id;
    @JsonProperty("nome")
    private String primeiroNome;
    @JsonProperty("sobrenome")
    private String ultimoNome;
    private String endereco;
    private String sexo;
}
