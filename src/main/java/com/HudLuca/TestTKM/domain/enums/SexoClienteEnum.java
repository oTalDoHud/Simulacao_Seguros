package com.HudLuca.TestTKM.domain.enums;

public enum SexoClienteEnum {
    MASCULINO(1, "Masculino"),
    FEMININO(2, "Feminino"),
    NAO_DEFINIDO(3, "Não definido"),
    ;

    private int cd;
    private String descricao;

    private SexoClienteEnum(int cd, String descricao) {
        this.cd = cd;
        this.descricao = descricao;
    }

    public int getCd() {
        return cd;
    }

    public String getDescricao() {
        return descricao;
    }

    public static SexoClienteEnum toEnum(Integer integer) {

        if (integer == null) {
            return null;
        }

        for (SexoClienteEnum x : SexoClienteEnum.values()) {
            if (integer.equals(x.cd)) {
                return x;
            }
        }
        throw new IllegalArgumentException("Id inválido " + integer);
    }
}
