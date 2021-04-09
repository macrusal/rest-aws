package br.com.hibejix.restaws.pessoa.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * @author macrusal on 04/04/21
 * @project rest-aws
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection = "livro")
public class Livro {

    @Id
    private ObjectId id;
    private String autor;
    private Date dataLancamento;
    private Double preco;
    private String titulo;
    @CreatedDate
    private Date dataCriacao;
    @LastModifiedDate
    private Date dataModificacao;
}
