package br.com.hibejix.restaws.pessoa.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.bson.types.ObjectId;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author macrusal on 03/04/21
 * @project rest-aws
 */
@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({"id", "nome", "sobrenome", "endereco", "sexo", "senha", "perfis"})
public class PessoaDTO {
    @JsonProperty("uid")
    private ObjectId id;
    @JsonProperty("nome")
    private String primeiroNome;
    @JsonProperty("sobrenome")
    private String ultimoNome;
    @NotEmpty(message="Preenchimento obrigatório")
    @Email(message="Email inválido")
    private String email;
    private String endereco;
    private String sexo;
    private String senha;
    private List<String> perfis;
}
