package br.com.hibejix.restaws.calculadora.service.math;

import org.springframework.stereotype.Component;

/**
 * @author macrusal on 02/04/21
 * @project rest-aws
 */
@Component
public class SimpleMath {

    public Double soma(Double numeroUm, Double numeroDois) {
        return numeroUm + numeroDois;
    }

    public Double subtracao(Double numeroUm, Double numeroDois) {
        return numeroUm - numeroDois;
    }

    public Double multiplicacao(Double numeroUm, Double numeroDois) {
        return numeroUm * numeroDois;
    }

    public Double divisao(Double numeroUm, Double numeroDois) {
        return numeroUm / numeroDois;
    }

    public Double media(Double numeroUm, Double numeroDois) {
        return (numeroUm + numeroDois)/2;
    }

    public Double raizQuadrada(Double numero) {
        return (Double) Math.sqrt( numero );
    }
}
