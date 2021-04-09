package br.com.hibejix.restaws.pessoa.api;

import br.com.hibejix.restaws.pessoa.model.dto.LivroDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author macrusal on 03/04/21
 * @project rest-aws
 */
@Api(tags = "Livro")
public interface LivroAPI {

    @ApiOperation(value = "Cadastrar livro", notes = "", httpMethod = "POST", produces = "application/json")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Livro cadastrado com sucesso", response = Void.class),
            @ApiResponse(code = 500, message = "Erro interno", response = Void.class)
    })
    LivroDTO post( @RequestBody LivroDTO livroDTO) ;

    @ApiOperation(value = "Procurar livro", notes = "", httpMethod = "GET", produces = "application/json")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Busca pela Livro executada com sucesso", response = Void.class),
            @ApiResponse(code = 204, message = "Livro não encontrada", response = Void.class),
            @ApiResponse(code = 404, message = "Erro na busca, livro não encontrada", response = Void.class),
            @ApiResponse(code = 500, message = "Erro interno", response = Void.class)
    })
    LivroDTO get(@PathVariable final ObjectId id);

    @ApiOperation(value = "Atualizar dados do livro", notes = "", httpMethod = "PUT", produces = "application/json")
    @ApiResponses({
            @ApiResponse(code = 204, message = "Livro atualizada com sucesso", response = Void.class),
            @ApiResponse(code = 404, message = "Livro não encontrada", response = Void.class),
            @ApiResponse(code = 422, message = "O ID do livro não pode ser nulo", response = Void.class),
            @ApiResponse(code = 500, message = "Erro interno", response = Void.class)
    })
    LivroDTO update(@RequestBody LivroDTO livro);

    @ApiOperation(value = "Excluir livro", notes = "", httpMethod = "DELETE", produces = "application/json")
    @ApiResponses({
            @ApiResponse(code = 204, message = "Livro excluida com sucesso", response = Void.class),
            @ApiResponse(code = 404, message = "Livro não encontrada", response = Void.class),
            @ApiResponse(code = 500, message = "Erro interno", response = Void.class)
    })
    void delete(@PathVariable final ObjectId id);

    @ApiOperation(value = "Listar todas as livros", notes = "", httpMethod = "GET", produces = "application/json")
    List<LivroDTO>  getAll();
}
