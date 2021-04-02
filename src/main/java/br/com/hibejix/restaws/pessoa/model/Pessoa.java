package br.com.hibejix.restaws.pessoa.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author macrusal on 02/04/21
 * @project rest-aws
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa {

    private AtomicLong id;
    private String primeiroNome;
    private String ultimoNome;
    private String endereco;
    private String sexo;
}
