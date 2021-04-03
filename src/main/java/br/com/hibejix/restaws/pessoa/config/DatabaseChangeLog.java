package br.com.hibejix.restaws.pessoa.config;

import br.com.hibejix.restaws.pessoa.model.Pessoa;
import br.com.hibejix.restaws.pessoa.repository.PessoaRepository;
import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;

import java.util.ArrayList;
import java.util.List;

/**
 * @author macrusal on 03/04/21
 * @project rest-aws
 */
@ChangeLog
public class DatabaseChangeLog {

    @ChangeSet( order = "001", id = "seeDatabase", author = "Marcelo")
    public void seedDatabase( PessoaRepository repository ) {
        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add( Pessoa.builder().primeiroNome( "João" ).ultimoNome( "Cunha" ).endereco( "São Paulo - SP - Brasil" ).sexo( "Masculino" ).build() );
        pessoas.add( Pessoa.builder().primeiroNome( "Pedro" ).ultimoNome( "Simas" ).endereco( "São Paulo - SP - Brasil" ).sexo( "Masculino" ).build() );
        pessoas.add( Pessoa.builder().primeiroNome( "Maria" ).ultimoNome( "Holanda" ).endereco( "São Paulo - SP - Brasil" ).sexo( "Feminino" ).build() );
        pessoas.add( Pessoa.builder().primeiroNome( "Silvia" ).ultimoNome( "Duarte" ).endereco( "São Paulo - SP - Brasil" ).sexo( "Feminino" ).build() );

        repository.saveAll( pessoas );
    }


}
