package br.com.hibejix.restaws.pessoa.config;

import br.com.hibejix.restaws.pessoa.model.Livro;
import br.com.hibejix.restaws.pessoa.model.Pessoa;
import br.com.hibejix.restaws.pessoa.repository.LivroRepository;
import br.com.hibejix.restaws.pessoa.repository.PessoaRepository;
import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @autor macrusal on 03/04/21
 * @project rest-aws
 */
@ChangeLog
public class DatabaseChangeLog {

    @ChangeSet( order = "001", id = "pessoa", author = "Marcelo")
    public void pessoa( PessoaRepository repository ) {
        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add( Pessoa.builder()
                .primeiroNome( "João" )
                .ultimoNome( "Cunha" )
                .endereco( "São Paulo - SP - Brasil" )
                .sexo( "Masculino" )
                .dataCriacao( new Date() )
                .build()
        );
        pessoas.add( Pessoa.builder()
                .primeiroNome( "Pedro" )
                .ultimoNome( "Simas" )
                .endereco( "São Paulo - SP - Brasil" )
                .sexo( "Masculino" )
                .dataCriacao( new Date() )
                .build()
        );
        pessoas.add( Pessoa.builder()
                .primeiroNome( "Maria" )
                .ultimoNome( "Holanda" )
                .endereco( "São Paulo - SP - Brasil" )
                .sexo( "Feminino" )
                .dataCriacao( new Date() )
                .build()
        );
        pessoas.add( Pessoa.builder()
                .primeiroNome( "Silvia" )
                .ultimoNome( "Duarte" )
                .endereco( "São Paulo - SP - Brasil" )
                .sexo( "Feminino" )
                .dataCriacao( new Date() )
                .build()
        );

        repository.saveAll( pessoas );
    }

    @ChangeSet( order = "002", id = "livro", author = "Marcelo")
    public void livro( LivroRepository repository ) {
        List< Livro > livros = new ArrayList<>();
        livros.add( Livro.builder().autor( "João Prado" )
                .dataLancamento( new Date() )
                .preco( 115.00 )
                .titulo( "Java 8" )
                .dataCriacao( new Date() )
                .build() );
        livros.add( Livro.builder().autor( "Laerth Leão" )
                .dataLancamento( new Date() )
                .preco( 118.00 )
                .titulo( "Java 9" )
                .dataCriacao( new Date()  )
                .build() );
        livros.add( Livro.builder().autor( "Ella Sabe" )
                .dataLancamento( new Date()  )
                .preco( 137.00 )
                .titulo( "Java 9 Dicas e Truques" )
                .dataCriacao( new Date()  )
                .build() );
        livros.add( Livro.builder().autor( "Mariana Conta Hum" )
                .dataLancamento( new Date()  )
                .preco( 178.00 )
                .titulo( "Java 11" )
                .dataCriacao( new Date()  )
                .build() );

        repository.saveAll( livros );
    }
}
