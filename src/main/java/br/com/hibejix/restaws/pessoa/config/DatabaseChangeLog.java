package br.com.hibejix.restaws.pessoa.config;

import br.com.hibejix.restaws.pessoa.model.Livro;
import br.com.hibejix.restaws.pessoa.model.Pessoa;
import br.com.hibejix.restaws.pessoa.model.enums.Perfil;
import br.com.hibejix.restaws.pessoa.repository.LivroRepository;
import br.com.hibejix.restaws.pessoa.repository.PessoaRepository;
import br.com.hibejix.restaws.pessoa.security.model.Permissao;
import br.com.hibejix.restaws.pessoa.security.model.Usuario;
import br.com.hibejix.restaws.pessoa.security.model.UsuarioPermissao;
import br.com.hibejix.restaws.pessoa.security.repository.PermissaoRepository;
import br.com.hibejix.restaws.pessoa.security.repository.UsuarioRepository;
import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @autor macrusal on 03/04/21
 * @project rest-aws
 */
@ChangeLog
public class DatabaseChangeLog {

    BCryptPasswordEncoder pe = new BCryptPasswordEncoder();

    @ChangeSet( order = "001", id = "pessoa", author = "Marcelo")
    public void pessoa( PessoaRepository repository ) {
        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add( Pessoa.builder()
                .primeiroNome( "João" )
                .ultimoNome( "Cunha" )
                .email( "cunha.joao@email.com" )
                .endereco( "São Paulo - SP - Brasil" )
                .sexo( "Masculino" )
                .senha( pe.encode( "rest123" ) )
                .perfis( Set.<Integer>of(
                        Perfil.ADMIN.getCodigo(),
                        Perfil.MANAGER.getCodigo())
                        )
                .dataCriacao( new Date() )
                .build()
        );
        pessoas.add( Pessoa.builder()
                .primeiroNome( "Pedro" )
                .ultimoNome( "Simas" )
                .email( "pedrosimas@email.com" )
                .endereco( "São Paulo - SP - Brasil" )
                .sexo( "Masculino" )
                .senha( pe.encode( "rest321" ) )
                .perfis( Set.<Integer>of( Perfil.CLIENTE.getCodigo() ) )
                .dataCriacao( new Date() )
                .build()
        );
        pessoas.add( Pessoa.builder()
                .primeiroNome( "Maria" )
                .ultimoNome( "Holanda" )
                .email( "maria.holanda@email.com" )
                .endereco( "São Paulo - SP - Brasil" )
                .sexo( "Feminino" )
                .senha( pe.encode( "rest113" ) )
                .perfis( Set.<Integer>of(Perfil.CLIENTE.getCodigo()) )
                .dataCriacao( new Date() )
                .build()
        );
        pessoas.add( Pessoa.builder()
                .primeiroNome( "Silvia" )
                .ultimoNome( "Duarte" )
                .email( "silvia.duarte@email.com" )
                .endereco( "São Paulo - SP - Brasil" )
                .sexo( "Feminino" )
                .senha( pe.encode( "rest311" ) )
                .perfis( Set.<Integer>of(Perfil.CLIENTE.getCodigo()) )
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

    @ChangeSet( order = "003", id = "permissao", author = "Marcelo")
    public void permissao( PermissaoRepository repository ) {
        List< Permissao > permissoes = new ArrayList<>();
        permissoes.add( Permissao.builder()
                .descricao( "ADMIN" )
                .build() );
        permissoes.add( Permissao.builder()
                .descricao( "MANAGER" )
                .build() );
        permissoes.add( Permissao.builder()
                .descricao( "COMMON_USER" )
                .build() );
        permissoes = repository.saveAll( permissoes );
    }

    @ChangeSet( order = "004", id = "usuario", author = "Marcelo")
    public void usuario( UsuarioRepository repository ) {
        List< Usuario > usuarios = new ArrayList<>();
        usuarios.add( Usuario.builder()
                .conta_nao_bloqueada( 1 )
                .conta_nao_expirada( 1 )
                .credencial_nao_expirada( 1 )
                .habilitada( 1 )
                .nome_completo( "Ingles da Silva" )
                .senha( "rest123" )
                .usuario_nome( "ingles.silva" )
                .build() );
        usuarios.add( Usuario.builder()
                .conta_nao_bloqueada( 1 )
                .conta_nao_expirada( 1 )
                .credencial_nao_expirada( 1 )
                .habilitada( 1 )
                .nome_completo( "Irlandes Honorio" )
                .senha( "rest321" )
                .usuario_nome( "irlandes.honorio" )
                .build() );
        usuarios = repository.saveAll( usuarios );
    }

    @ChangeSet( order = "005", id = "usuarioPermissao", author = "Marcelo")
    public void usuarioPermissao( UsuarioRepository repository ) {
        List< UsuarioPermissao > usuarioPermissoes = new ArrayList<>();
        usuarioPermissoes.add( UsuarioPermissao.builder()
                .id_permissao( new ObjectId() )
                .id_usuario( new ObjectId() )
                .build() );
    }
}
