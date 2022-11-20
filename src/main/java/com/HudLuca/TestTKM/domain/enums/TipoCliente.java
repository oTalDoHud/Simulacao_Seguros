

package com.HudLuca.TestTKM.domain.enums;

public enum TipoCliente {

    PESSOA_FISICA(1, "Pessoa Física"),
    PESSOA_JURIDICA(2, "Pessoa Jurídica");

    private int cd;
    private String descricao;

    private TipoCliente(int cd, String descricao) {
        this.cd = cd;
        this.descricao = descricao;
    }

    public int getCd() {
        return cd;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TipoCliente toEnum(Integer integer) {

        if (integer == null) {
            return null;
        }

        for (TipoCliente x : TipoCliente.values()) {
            if (integer.equals(x.cd)) {
                return x;
            }
        }
        throw new IllegalArgumentException("Id inválido " + integer);
    }
}
