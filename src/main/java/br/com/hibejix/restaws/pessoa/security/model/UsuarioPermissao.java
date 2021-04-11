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
@Document(collection = "usuarios-permissao")
public class UsuarioPermissao {


    private ObjectId id_usuario;

    @Id
    private ObjectId id_permissao;

}
