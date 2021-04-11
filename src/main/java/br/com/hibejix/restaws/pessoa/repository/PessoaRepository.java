package br.com.hibejix.restaws.pessoa.repository;

import br.com.hibejix.restaws.pessoa.model.Pessoa;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author macrusal on 03/04/21
 * @project rest-aws
 */
@Repository
public interface PessoaRepository extends MongoRepository< Pessoa, ObjectId > {

    @Transactional(readOnly=true)
    Pessoa findByEmail(final String email);
}
