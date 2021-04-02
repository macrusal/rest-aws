package br.com.hibejix.restaws.calculadora.service.math;

/**
 * @author macrusal on 02/04/21
 * @project rest-aws
 */
public class NumberConverter {

    public static Double converteNumeroParaDouble( String numero ) {
        if( numero ==  null )
            return 0D;

        if( isNumeric( numero ) )
            return Double.parseDouble( numero );

        return 0D;
    }

    public static boolean isNumeric( String numero ) {
        if( numero ==  null )
            return false;
        String retorno = numero.replaceAll( ",", "." );
        return retorno.matches( "[-+]?[0-9]*\\.?[0-9]+" );
    }
}
