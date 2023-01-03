package com.HudLuca.SimulacaoSeguros.domain.enums;

public enum CoberturasSeguroVidaEnum {

    MORTE_NATURA(1, "Morte natural"),
    HOMICIDIO(2, "Homicídio"),
    SUICIDIO(3, "Suicídio"),
    INVALIDEZ_MENTAL(4, "Invalidez mental"),
    ;

    private int cd;
    private String descricao;

    private CoberturasSeguroVidaEnum(int cd, String descricao) {
        this.cd = cd;
        this.descricao = descricao;
    }

    public int getCd() {
        return cd;
    }

    public String getDescricao() {
        return descricao;
    }

    public static CoberturasSeguroVidaEnum toEnum(Integer integer) {

        if (integer == null) {
            return null;
        }

        for (CoberturasSeguroVidaEnum x : CoberturasSeguroVidaEnum.values()) {
            if (integer.equals(x.cd)) {
                return x;
            }
        }
        throw new IllegalArgumentException("Id inválido do enum: " + CoberturasSeguroVidaEnum.class + "Id: " + integer);
    }
}
