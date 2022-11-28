package com.HudLuca.TestTKM.domain.enums;

public enum ConsumoDrogas {

    ALCOOL(1, "Uso de bebidas alcóolicas"),
    TABACO(2, "Uso de tabaco/cigarro"),
    MACONHA(3, "Uso recreativo de Maconha"),
    MEDICAMENTOS_NAO_PRESCRITOS(4, "Uso de Medicamentes não prescritos"),
    MEDICAMENTOS_RECORRENTES(5, "Uso de medicamentos para tratamento"),
    HEROINA(6, "Uso de Heroína"),
    COCAINA(7, "Uso de Cocaína"),
    CRACK(8, "Uso de Crack"),
    ;

    private int cd;
    private String descricao;

    private ConsumoDrogas(int cd, String descricao) {
        this.cd = cd;
        this.descricao = descricao;
    }

    public int getCd() {
        return cd;
    }

    public String getDescricao() {
        return descricao;
    }

    public static ConsumoDrogas toEnum(Integer integer) {

        if (integer == null) {
            return null;
        }

        for (ConsumoDrogas x : ConsumoDrogas.values()) {
            if (integer.equals(x.cd)) {
                return x;
            }
        }
        throw new IllegalArgumentException("Id inválido " + integer);
    }
}
