package br.com.hibejix.restaws.pessoa.controller;

import br.com.hibejix.restaws.pessoa.model.Pessoa;
import br.com.hibejix.restaws.pessoa.service.PessoaService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Pessoa get( @PathVariable("id") String id ) {
        return pessoaService.findById( id );
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Pessoa> getAll(  ) {
        return pessoaService.findAll( );
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Pessoa post( @RequestBody Pessoa pessoa ) {
        return pessoaService.create( pessoa );
    }

    @RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Pessoa update( @RequestBody Pessoa pessoa ) {
        return pessoaService.update( pessoa );
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void update( @PathVariable("id") String id ) {
        pessoaService.delete( id );
    }
}
