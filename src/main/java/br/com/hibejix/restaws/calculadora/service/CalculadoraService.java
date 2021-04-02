package br.com.hibejix.restaws.calculadora.service;

import br.com.hibejix.restaws.calculadora.exception.CalculadoraException;
import br.com.hibejix.restaws.calculadora.service.math.NumberConverter;
import br.com.hibejix.restaws.calculadora.service.math.SimpleMath;
import org.springframework.stereotype.Service;

/**
 * @author macrusal on 02/04/21
 * @project rest-aws
 */
@Service
public class CalculadoraService {

    private SimpleMath math;

    public CalculadoraService( SimpleMath math ) {
        this.math = math;
    }

    public Double soma( String numeroUm, String numeroDois) {

        if(!NumberConverter.isNumeric(numeroUm) || !NumberConverter.isNumeric(numeroDois)) {
            throw new CalculadoraException( "Erro, parametro não é numero." );
        }

        return math.soma( NumberConverter.converteNumeroParaDouble(numeroUm),NumberConverter.converteNumeroParaDouble(numeroDois) );
    }

    public Double subtracao(String numeroUm, String numeroDois) {

        if(!NumberConverter.isNumeric(numeroUm) || !NumberConverter.isNumeric(numeroDois)) {
            throw new CalculadoraException( "Erro, parametro não é numero." );
        }

        return math.subtracao( NumberConverter.converteNumeroParaDouble(numeroUm),NumberConverter.converteNumeroParaDouble(numeroDois));
    }

    public Double multiplicacao(String numeroUm, String numeroDois) {

        if(!NumberConverter.isNumeric(numeroUm) || !NumberConverter.isNumeric(numeroDois)) {
            throw new CalculadoraException( "Erro, parametro não é numero." );
        }

        return math.multiplicacao( NumberConverter.converteNumeroParaDouble(numeroUm),NumberConverter.converteNumeroParaDouble(numeroDois));
    }

    public Double divisao(String numeroUm, String numeroDois) {

        if(!NumberConverter.isNumeric(numeroUm) || !NumberConverter.isNumeric(numeroDois)) {
            throw new CalculadoraException( "Erro, parametro não é numero." );
        }

        return math.divisao( NumberConverter.converteNumeroParaDouble(numeroUm), NumberConverter.converteNumeroParaDouble(numeroDois));
    }

    public Double media(String numeroUm, String numeroDois) {

        if(!NumberConverter.isNumeric(numeroUm) || !NumberConverter.isNumeric(numeroDois)) {
            throw new CalculadoraException( "Erro, parametro não é numero." );
        }

        return math.soma(NumberConverter.converteNumeroParaDouble(numeroUm) , NumberConverter.converteNumeroParaDouble(numeroDois));
    }

    public Double raizQuadrada(String numero) {

        if(!NumberConverter.isNumeric(numero)) {
            throw new CalculadoraException( "Erro, parametro não é numero." );
        }

        return math.raizQuadrada( NumberConverter.converteNumeroParaDouble(numero) );
    }

}
