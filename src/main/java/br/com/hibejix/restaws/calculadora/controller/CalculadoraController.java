package br.com.hibejix.restaws.calculadora.controller;

import br.com.hibejix.restaws.calculadora.service.CalculadoraService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author macrusal on 02/04/21
 * @project rest-aws
 */
@RestController
public class CalculadoraController {

    private CalculadoraService service;

    public CalculadoraController( CalculadoraService service ) {
        this.service = service;
    }

    @RequestMapping(value = "/sum/{numeroUm}/{numeroDois}", method = RequestMethod.GET)
    public Double soma( @PathVariable("numeroUm") String numeroUm, @PathVariable("numeroDois") String numeroDois ) throws Exception {
        return service.soma(numeroUm, numeroDois);
    }

    @RequestMapping(value = "/sub/{numeroUm}/{numeroDois}", method = RequestMethod.GET)
    public Double subtracao( @PathVariable("numeroUm") String numeroUm, @PathVariable("numeroDois") String numeroDois ) throws Exception {
        return service.subtracao(numeroUm, numeroDois);
    }

    @RequestMapping(value = "/mult/{numeroUm}/{numeroDois}", method = RequestMethod.GET)
    public Double mult( @PathVariable("numeroUm") String numeroUm, @PathVariable("numeroDois") String numeroDois ) throws Exception {
        return service.multiplicacao(numeroUm, numeroDois);
    }

    @RequestMapping(value = "/div/{numeroUm}/{numeroDois}", method = RequestMethod.GET)
    public Double div( @PathVariable("numeroUm") String numeroUm, @PathVariable("numeroDois") String numeroDois ) throws Exception {
        return service.divisao(numeroUm, numeroDois);
    }

    @RequestMapping(value = "/avg/{numeroUm}/{numeroDois}", method = RequestMethod.GET)
    public Double average( @PathVariable("numeroUm") String numeroUm, @PathVariable("numeroDois") String numeroDois ) throws Exception {
        return service.media(numeroUm, numeroDois);
    }

    @RequestMapping(value = "/sqr/{numeroUm}", method = RequestMethod.GET)
    public Double square( @PathVariable("numeroUm") String numeroUm ) throws Exception {
        return service.raizQuadrada(numeroUm);
    }

}
