package br.com.hibejix.restaws.pessoa.repository;

import br.com.hibejix.restaws.pessoa.model.Livro;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author macrusal on 04/04/21
 * @project rest-aws
 */
public interface LivroRepository extends MongoRepository< Livro, ObjectId > {

}
