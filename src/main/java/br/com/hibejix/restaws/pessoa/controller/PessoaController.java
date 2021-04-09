package br.com.hibejix.restaws.pessoa.controller;

import br.com.hibejix.restaws.pessoa.api.PessoaAPI;
import br.com.hibejix.restaws.pessoa.model.dto.PessoaDTO;
import br.com.hibejix.restaws.pessoa.service.PessoaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.bson.types.ObjectId;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author macrusal on 02/04/21
 * @project rest-aws
 */
@RestController
@RequestMapping("/pessoa")
@Api(value = "Pessoa", description = "Entrypoint - Pessoa", tags = "Cadastro de Pessoas")
public class PessoaController implements PessoaAPI {

    private PessoaService pessoaService;

    public PessoaController( PessoaService pessoaService ) {
        this.pessoaService = pessoaService;
    }

    @ApiOperation( "Retorna uma pessoa pelo Id" )
    @GetMapping(value = "/{id}", produces = {"application/json", "application/xml"})
    public PessoaDTO get( @PathVariable("id") ObjectId id ) {
        return pessoaService.findById( id );
    }

    @ApiOperation( "Retorna uma lista de pessoas" )
    @GetMapping(produces = {"application/json", "application/xml"})
    public List<PessoaDTO> getAll(  ) {
        return pessoaService.findAll( );
    }

    @ApiOperation( "Cadastra uma pessoa" )
    @PostMapping(produces = {"application/json", "application/xml"}
               , consumes = {"application/json", "application/xml"})
    public PessoaDTO post( @RequestBody PessoaDTO pessoa ) {
        return pessoaService.create( pessoa );
    }

    @ApiOperation( "Atualiza uma pessoa" )
    @PutMapping(produces = {"application/json", "application/xml"},
                consumes = {"application/json", "application/xml"})
    public PessoaDTO update( @RequestBody PessoaDTO pessoa ) {
        return pessoaService.update( pessoa );
    }

    @ApiOperation( "Remove uma pesso pelo Id" )
    @DeleteMapping(value = "/{id}")
    public void delete( @PathVariable("id") ObjectId id ) {
        pessoaService.delete( id );
    }
}
