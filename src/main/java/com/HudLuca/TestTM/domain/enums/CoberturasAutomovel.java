package com.HudLuca.TestTM.domain.enums;

public enum CoberturasAutomovel {

    INCENDIO(1, "Novato"),
    DESASTRE_NATURAL(2, "Mediano"),
    ACIDENTE(3, "Mediano"),
    ROUBO(4, "Mediano"),
    REBOQUE(5, "Mediano"),
    TERCEIROS_DIRIGINDO(6, "Mediano"),
    ;

    private int cd;
    private String descricao;

    private CoberturasAutomovel(int cd, String descricao) {
        this.cd = cd;
        this.descricao = descricao;
    }

    public int getCd() {
        return cd;
    }

    public String getDescricao() {
        return descricao;
    }

    public static CoberturasAutomovel toEnum(Integer integer) {

        if (integer == null) {
            return null;
        }

        for (CoberturasAutomovel x : CoberturasAutomovel.values()) {
            if (integer.equals(x.cd)) {
                return x;
            }
        }
        throw new IllegalArgumentException("Id inválido " + integer);
    }
}
