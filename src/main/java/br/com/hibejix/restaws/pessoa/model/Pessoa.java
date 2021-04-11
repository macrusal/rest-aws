package br.com.hibejix.restaws.pessoa.model;

import br.com.hibejix.restaws.pessoa.model.enums.Perfil;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author macrusal on 02/04/21
 * @project rest-aws
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection = "pessoa")
public class Pessoa {

    @Id
    private ObjectId id;
    private String primeiroNome;
    private String ultimoNome;
    private String email;
    private String endereco;
    private String sexo;
    @JsonIgnore
    private String senha;
    private Set<Integer> perfis = new HashSet<>();
    @CreatedDate
    private Date dataCriacao;
    @LastModifiedDate
    private Date dataModificacao;

    public Set< Perfil > getPerfis() {
        return perfis.stream()
                .map(x -> Perfil.toEnum(x))
                .collect( Collectors.toSet());
    }
    public void addPerfil(Perfil perfil) {
        perfis.add(perfil.getCodigo());
    }
}
