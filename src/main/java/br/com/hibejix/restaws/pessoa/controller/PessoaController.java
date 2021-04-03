package br.com.hibejix.restaws.pessoa.controller;

import br.com.hibejix.restaws.pessoa.model.Pessoa;
import br.com.hibejix.restaws.pessoa.service.PessoaService;
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

    @RequestMapping(value = "/{id}")
    public Pessoa get( @PathVariable("id") String id ) {
        return pessoaService.findById( id );
    }

    @GetMapping
    public List<Pessoa> getAll(  ) {
        return pessoaService.findAll( );
    }

    @PostMapping
    public Pessoa post( @RequestBody Pessoa pessoa ) {
        return pessoaService.create( pessoa );
    }

    @PutMapping
    public Pessoa update( @RequestBody Pessoa pessoa ) {
        return pessoaService.update( pessoa );
    }

    @GetMapping(value = "/{id}")
    public void update( @PathVariable("id") String id ) {
        pessoaService.delete( id );
    }
}
