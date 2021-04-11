package br.com.hibejix.restaws.pessoa.security.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author macrusal on 09/04/21
 * @project rest-aws
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection = "usuarios")
public class Usuario {

    @Id
    private ObjectId id;
    private String usuario_nome;
    private String nome_completo;
    private String senha;
    private Integer conta_nao_expirada;
    private Integer conta_nao_bloqueada;
    private Integer credencial_nao_expirada;
    private Integer habilitada;

}
