package br.com.hibejix.restaws.pessoa.api;

import br.com.hibejix.restaws.pessoa.model.dto.PessoaDTO;
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
@Api(tags = "Pessoa")
public interface PessoaAPI {

    @ApiOperation(value = "Cadastrar pessoa", notes = "", httpMethod = "POST", produces = "application/json")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Pessoa cadastrado com sucesso", response = Void.class),
            @ApiResponse(code = 500, message = "Erro interno", response = Void.class)
    })
    PessoaDTO post( @RequestBody PessoaDTO pessoaDTO) ;

    @ApiOperation(value = "Procurar pessoa", notes = "", httpMethod = "GET", produces = "application/json")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Busca pela Pessoa executada com sucesso", response = Void.class),
            @ApiResponse(code = 204, message = "Pessoa não encontrada", response = Void.class),
            @ApiResponse(code = 404, message = "Erro na busca, pessoa não encontrada", response = Void.class),
            @ApiResponse(code = 500, message = "Erro interno", response = Void.class)
    })
    PessoaDTO get(@PathVariable final ObjectId id);

    @ApiOperation(value = "Atualizar dados do pessoa", notes = "", httpMethod = "PUT", produces = "application/json")
    @ApiResponses({
            @ApiResponse(code = 204, message = "Pessoa atualizada com sucesso", response = Void.class),
            @ApiResponse(code = 404, message = "Pessoa não encontrada", response = Void.class),
            @ApiResponse(code = 422, message = "O ID do pessoa não pode ser nulo", response = Void.class),
            @ApiResponse(code = 500, message = "Erro interno", response = Void.class)
    })
    PessoaDTO update(@RequestBody PessoaDTO pessoa);

    @ApiOperation(value = "Excluir pessoa", notes = "", httpMethod = "DELETE", produces = "application/json")
    @ApiResponses({
            @ApiResponse(code = 204, message = "Pessoa excluida com sucesso", response = Void.class),
            @ApiResponse(code = 404, message = "Pessoa não encontrada", response = Void.class),
            @ApiResponse(code = 500, message = "Erro interno", response = Void.class)
    })
    void delete(@PathVariable final ObjectId id);

    @ApiOperation(value = "Listar todas as pessoas", notes = "", httpMethod = "GET", produces = "application/json")
    List<PessoaDTO>  getAll();
}
