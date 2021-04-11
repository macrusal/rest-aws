package br.com.hibejix.restaws.pessoa.security.repository;

import br.com.hibejix.restaws.pessoa.security.model.Permissao;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author macrusal on 09/04/21
 * @project rest-aws
 */
@Repository
public interface PermissaoRepository extends MongoRepository< Permissao, ObjectId > {
}
