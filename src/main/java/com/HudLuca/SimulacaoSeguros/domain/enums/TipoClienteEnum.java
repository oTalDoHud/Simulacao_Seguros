

package com.HudLuca.SimulacaoSeguros.domain.enums;

public enum TipoClienteEnum {

    PESSOA_FISICA(1, "Pessoa Física"),
    PESSOA_JURIDICA(2, "Pessoa Jurídica");

    private int cd;
    private String descricao;

    private TipoClienteEnum(int cd, String descricao) {
        this.cd = cd;
        this.descricao = descricao;
    }

    public int getCd() {
        return cd;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TipoClienteEnum toEnum(Integer integer) {

        if (integer == null) {
            return null;
        }

        for (TipoClienteEnum x : TipoClienteEnum.values()) {
            if (integer.equals(x.cd)) {
                return x;
            }
        }
        throw new IllegalArgumentException("Id inválido " + integer);
    }
}
