package br.com.hibejix.restaws.pessoa.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.bson.types.ObjectId;

import java.util.Date;

/**
 * @author macrusal on 03/04/21
 * @project rest-aws
 */
@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({"id", "autor", "dataLancamento", "preco", "titulo"})
public class LivroDTO {
    @JsonProperty("uid")
    private ObjectId id;
    @JsonProperty("autor")
    private String autor;
    @JsonProperty("dataLancamento")
    private Date dataLancamento;
    @JsonProperty("preco")
    private Double preco;
    @JsonProperty("titulo")
    private String titulo;
}
