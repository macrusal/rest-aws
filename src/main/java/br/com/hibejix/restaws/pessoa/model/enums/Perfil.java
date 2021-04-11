package br.com.hibejix.restaws.pessoa.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author macrusal on 11/04/21
 * @project rest-aws
 */
@Getter
@AllArgsConstructor
public enum Perfil {

    ADMIN(1, "ROLE_ADMIN"),
    CLIENTE(2, "ROLE_CLIENTE"),
    MANAGER(3, "ROLE_MANAGER");

    private int codigo;
    private String descricao;

    public static Perfil toEnum(Integer codigo) {
        if(codigo == null) {
            return null;
        }

        for (Perfil x : Perfil.values()) {
            if(codigo.equals(x.getCodigo())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Id inválido: " + codigo);
    }
}
