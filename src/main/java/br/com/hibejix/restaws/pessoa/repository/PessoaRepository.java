package br.com.hibejix.restaws.pessoa.repository;

import br.com.hibejix.restaws.pessoa.model.Pessoa;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author macrusal on 03/04/21
 * @project rest-aws
 */
@Repository
public interface PessoaRepository extends MongoRepository< Pessoa, String > {
}
