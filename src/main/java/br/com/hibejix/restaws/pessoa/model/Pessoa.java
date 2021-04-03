package br.com.hibejix.restaws.pessoa.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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
    private String id;
    private String primeiroNome;
    private String ultimoNome;
    private String endereco;
    private String sexo;
}
