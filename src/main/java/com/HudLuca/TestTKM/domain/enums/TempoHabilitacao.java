package com.HudLuca.TestTKM.domain.enums;

public enum TempoHabilitacao {

    NOVATO(1, "Novato"),
    MEDIANO(2, "Mediano"),
    EXPERIENTE(3, "Experiente");

    private int cd;
    private String descricao;

    private TempoHabilitacao(int cd, String descricao) {
        this.cd = cd;
        this.descricao = descricao;
    }

    public int getCd() {
        return cd;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TempoHabilitacao toEnum(Integer integer) {

        if (integer == null) {
            return null;
        }

        for (TempoHabilitacao x : TempoHabilitacao.values()) {
            if (integer.equals(x.cd)) {
                return x;
            }
        }
        throw new IllegalArgumentException("Id inválido " + integer);
    }
}
