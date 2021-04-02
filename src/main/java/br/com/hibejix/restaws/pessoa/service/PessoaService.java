package br.com.hibejix.restaws.pessoa.service;

import br.com.hibejix.restaws.pessoa.model.Pessoa;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author macrusal on 02/04/21
 * @project rest-aws
 */
@Service
public class PessoaService {

    private final AtomicLong counter = new AtomicLong();
    public Pessoa findById(String id) {
        var pessoa = Pessoa.builder()
                .id(counter)
                .primeiroNome( "Marcelo" )
                .ultimoNome( "Salvador" )
                .sexo( "Masculino" )
                .endereco( "São Paulo - SP - Brasil" )
                .build();
        return pessoa;
    }
}
