package br.com.hibejix.restaws.pessoa.service;

import br.com.hibejix.restaws.pessoa.model.Pessoa;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

    public List<Pessoa> findAll() {

        var pessoa1 = Pessoa.builder()
                .id(counter)
                .primeiroNome( "Marcelo" )
                .ultimoNome( "Salvador" )
                .sexo( "Masculino" )
                .endereco( "São Paulo - SP - Brasil" )
                .build();

        var pessoa2 = Pessoa.builder()
                .id(counter)
                .primeiroNome( "Victor" )
                .ultimoNome( "Salvador" )
                .sexo( "Masculino" )
                .endereco( "Rio de Janeiro - SP - Brasil" )
                .build();

        var pessoa3 = Pessoa.builder()
                .id(counter)
                .primeiroNome( "Dandara" )
                .ultimoNome( "Salvador" )
                .sexo( "Feminino" )
                .endereco( "Minas Gerais - MG - Brasil" )
                .build();

        return Arrays.asList(pessoa1, pessoa2, pessoa3);
    }
}
