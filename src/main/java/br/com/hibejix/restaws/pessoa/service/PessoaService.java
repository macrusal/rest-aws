package br.com.hibejix.restaws.pessoa.service;

import br.com.hibejix.restaws.pessoa.exception.PessoaNotFoundException;
import br.com.hibejix.restaws.pessoa.model.Pessoa;
import br.com.hibejix.restaws.pessoa.repository.PessoaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author macrusal on 02/04/21
 * @project rest-aws
 */
@Service
public class PessoaService {

    private static final Logger logger = LoggerFactory.getLogger(PessoaService.class);

    private PessoaRepository pessoaRepository;

    public PessoaService( PessoaRepository pessoaRepository ) {
        this.pessoaRepository = pessoaRepository;
    }

    public Pessoa create( Pessoa pessoa) {
        logger.info( "Criando pessoa: {}", pessoa.toString() );
        return pessoaRepository.save( pessoa );
    }

    public Pessoa update(Pessoa parametro) {

        var pessoa = findById( parametro.getId() );
        logger.info("Atualizando pessoa com o id: {}", parametro.getId());

        return pessoaRepository.save( pessoa.builder()
                .id( parametro.getId() )
                .primeiroNome( parametro.getPrimeiroNome() )
                .ultimoNome( parametro.getUltimoNome() )
                .sexo( parametro.getSexo() )
                .endereco( parametro.getEndereco() )
                .build()
        );
    }

    public void delete( String id ) {
        var pessoa = findById( id );
        logger.info("Excluindo pessoa com o id: {}", id);
        pessoaRepository.deleteById( pessoa.getId() );
    }

    public Pessoa findById(String id) {
        logger.info("Buscando pessoa com o id: {}", id);
        var pessoa = pessoaRepository.findById( id )
                .orElseThrow(() -> new PessoaNotFoundException("Pessoa com o id "+id+" não foi encontrada") );
        return pessoa;
    }

    public List<Pessoa> findAll() {
        var pessoas = pessoaRepository.findAll();
        logger.info("Retornnando {} pessoas do banco de dados", pessoas.stream().count());
        return pessoas;
    }

}
