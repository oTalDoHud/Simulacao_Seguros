package com.HudLuca.SimulacaoSeguros.domain.enums;

public enum TempoHabilitacaoEnum {

    NOVATO(1, "Novato"),
    MEDIANO(2, "Mediano"),
    EXPERIENTE(3, "Experiente"),
    INDEFERIDO(4, "Indeferido"),
    ;

    private int cd;
    private String descricao;

    private TempoHabilitacaoEnum(int cd, String descricao) {
        this.cd = cd;
        this.descricao = descricao;
    }

    public int getCd() {
        return cd;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TempoHabilitacaoEnum toEnum(Integer integer) {

        if (integer == null) {
            return null;
        }

        for (TempoHabilitacaoEnum x : TempoHabilitacaoEnum.values()) {
            if (integer.equals(x.cd)) {
                return x;
            }
        }
        throw new IllegalArgumentException("Id inválido " + integer);
    }
}
