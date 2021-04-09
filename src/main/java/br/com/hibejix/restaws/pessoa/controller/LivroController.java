package br.com.hibejix.restaws.pessoa.controller;

import br.com.hibejix.restaws.pessoa.model.dto.LivroDTO;
import br.com.hibejix.restaws.pessoa.service.LivroService;
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
public class LivroController {

    private LivroService livroService;

    public LivroController( LivroService livroService ) {
        this.livroService = livroService;
    }

    @GetMapping(value = "/{id}", produces = {"application/json", "application/xml"})
    public LivroDTO get( @PathVariable("id") ObjectId id ) {
        return livroService.findById( id );
    }

    @GetMapping(produces = {"application/json", "application/xml"})
    public List<LivroDTO> getAll(  ) {
        return livroService.findAll( );
    }

    @PostMapping(produces = {"application/json", "application/xml"}
            , consumes = {"application/json", "application/xml"})
    public LivroDTO post( @RequestBody LivroDTO livro ) {
        return livroService.create( livro );
    }

    @PutMapping(produces = {"application/json", "application/xml"},
            consumes = {"application/json", "application/xml"})
    public LivroDTO update( @RequestBody LivroDTO livro ) {
        return livroService.update( livro );
    }

    @DeleteMapping(value = "/{id}")
    public void delete( @PathVariable("id") ObjectId id ) {
        livroService.delete( id );
    }
}
