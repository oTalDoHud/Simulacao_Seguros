package com.HudLuca.TestTKM.domain.enums;

public enum CoberturasSeguroVida {

    MORTE_NATURA(1, "Morte natural"),
    HOMICIDIO(2, "Homicídio"),
    SUICIDIO(3, "Suicídio"),
    INVALIDEZ_MENTAL(4, "Invalidez mental"),
    ;

    private int cd;
    private String descricao;

    private CoberturasSeguroVida(int cd, String descricao) {
        this.cd = cd;
        this.descricao = descricao;
    }

    public int getCd() {
        return cd;
    }

    public String getDescricao() {
        return descricao;
    }

    public static CoberturasSeguroVida toEnum(Integer integer) {

        if (integer == null) {
            return null;
        }

        for (CoberturasSeguroVida x : CoberturasSeguroVida.values()) {
            if (integer.equals(x.cd)) {
                return x;
            }
        }
        throw new IllegalArgumentException("Id inválido do enum: " + CoberturasSeguroVida.class + "Id: " + integer);
    }
}
