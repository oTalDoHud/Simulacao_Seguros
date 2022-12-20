package com.HudLuca.TestTKM.domain.enums;

public enum TipoTrabalhoEnum {
    TRABALHO_INSALUBRE(1, "Trabalho insalubre"),
    TRABALHO_COM_ESFORCO_FISICO(2, "Trabalho com esforco físico"),
    TRABALHO_SEM_ESFORCO_FISICO(3, "Trabalho sem esforco físico"),
    ;

    private int cd;
    private String descricao;

    private TipoTrabalhoEnum(int cd, String descricao) {
        this.cd = cd;
        this.descricao = descricao;
    }

    public int getCd() {
        return cd;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TipoTrabalhoEnum toEnum(Integer integer) {

        if (integer == null) {
            return null;
        }

        for (TipoTrabalhoEnum x : TipoTrabalhoEnum.values()) {
            if (integer.equals(x.cd)) {
                return x;
            }
        }
        throw new IllegalArgumentException("Id inválido " + integer);
    }
}
