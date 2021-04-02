package br.com.hibejix.restaws.pessoa.controller;

import br.com.hibejix.restaws.pessoa.model.Pessoa;
import br.com.hibejix.restaws.pessoa.service.PessoaService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
