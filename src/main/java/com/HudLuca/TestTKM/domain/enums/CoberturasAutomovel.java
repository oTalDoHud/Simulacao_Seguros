package com.HudLuca.TestTKM.domain.enums;

public enum CoberturasAutomovel {

    INCENDIO(1, "Novato"),
    DESASTRE_NATURAL(2, "Desastre natural"),
    ACIDENTE(3, "Acidente"),
    ROUBO(4, "Roubo"),
    REBOQUE(5, "Reboque"),
    TERCEIROS_DIRIGINDO(6, "Terceiros dirigindo"),
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
