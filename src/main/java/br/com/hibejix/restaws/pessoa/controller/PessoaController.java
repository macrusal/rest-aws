package br.com.hibejix.restaws.pessoa.controller;

import br.com.hibejix.restaws.pessoa.model.dto.PessoaDTO;
import br.com.hibejix.restaws.pessoa.service.PessoaService;
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
public class PessoaController {

    private PessoaService pessoaService;

    public PessoaController( PessoaService pessoaService ) {
        this.pessoaService = pessoaService;
    }

    @GetMapping(value = "/{id}", produces = {"application/json", "application/xml"})
    public PessoaDTO get( @PathVariable("id") ObjectId id ) {
        return pessoaService.findById( id );
    }

    @GetMapping(produces = {"application/json", "application/xml"})
    public List<PessoaDTO> getAll(  ) {
        return pessoaService.findAll( );
    }

    @PostMapping(produces = {"application/json", "application/xml"}
               , consumes = {"application/json", "application/xml"})
    public PessoaDTO post( @RequestBody PessoaDTO pessoa ) {
        return pessoaService.create( pessoa );
    }

    @PutMapping(produces = {"application/json", "application/xml"},
                consumes = {"application/json", "application/xml"})
    public PessoaDTO update( @RequestBody PessoaDTO pessoa ) {
        return pessoaService.update( pessoa );
    }

    @DeleteMapping(value = "/{id}")
    public void delete( @PathVariable("id") ObjectId id ) {
        pessoaService.delete( id );
    }
}
