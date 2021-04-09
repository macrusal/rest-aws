package br.com.hibejix.restaws.pessoa.controller;

import br.com.hibejix.restaws.pessoa.api.LivroAPI;
import br.com.hibejix.restaws.pessoa.model.dto.LivroDTO;
import br.com.hibejix.restaws.pessoa.service.LivroService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.bson.types.ObjectId;
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
 * @author macrusal on 08/04/21
 * @project rest-aws
 */
@RestController
@RequestMapping("/livro")
@Api(value = "Livro", description = "Entrypoint - Livro", tags = "Cadastro de Livros")
public class LivroController implements LivroAPI {

    private LivroService livroService;

    public LivroController( LivroService livroService ) {
        this.livroService = livroService;
    }

    @ApiOperation( "Retorna um livro pelo Id" )
    @GetMapping(value = "/{id}", produces = {"application/json", "application/xml"})
    public LivroDTO get( @PathVariable("id") ObjectId id ) {
        return livroService.findById( id );
    }

    @ApiOperation( "Retorna uma lista de livros" )
    @GetMapping(produces = {"application/json", "application/xml"})
    public List<LivroDTO> getAll(  ) {
        return livroService.findAll( );
    }

    @ApiOperation( "Cadastra um livro" )
    @PostMapping(produces = {"application/json", "application/xml"}
            , consumes = {"application/json", "application/xml"})
    public LivroDTO post( @RequestBody LivroDTO livro ) {
        return livroService.create( livro );
    }

    @ApiOperation( "Atualiza um livro" )
    @PutMapping(produces = {"application/json", "application/xml"},
            consumes = {"application/json", "application/xml"})
    public LivroDTO update( @RequestBody LivroDTO livro ) {
        return livroService.update( livro );
    }

    @ApiOperation( "Remove um livro pelo Id" )
    @DeleteMapping(value = "/{id}")
    public void delete( @PathVariable("id") ObjectId id ) {
        livroService.delete( id );
    }
}
