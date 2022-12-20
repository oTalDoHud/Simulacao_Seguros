package com.HudLuca.TestTKM.domain.enums;

public enum ValoAReceberSeguroVidaEnum {
    SILVER_I(1, "Silver 1"),
    SILVER_II(2, "Silver 2"),
    SILVER_III(3, "Silver 3"),
    GOLD_I(4, "Gold 1"),
    GOLD_II(5, "Gold 2"),
    GOLD_III(6, "Gold 3"),
    PLATINUM_I(7, "Platinum 1"),
    PLATINUM_II(8, "Platinum 2"),
    PLATINUM_III(9, "Platinum 3"),
    ;

    private int cd;
    private String descricao;

    private ValoAReceberSeguroVidaEnum(int cd, String descricao) {
        this.cd = cd;
        this.descricao = descricao;
    }

    public int getCd() {
        return cd;
    }

    public String getDescricao() {
        return descricao;
    }

    public static ValoAReceberSeguroVidaEnum toEnum(Integer integer) {

        if (integer == null) {
            return null;
        }

        for (ValoAReceberSeguroVidaEnum x : ValoAReceberSeguroVidaEnum.values()) {
            if (integer.equals(x.cd)) {
                return x;
            }
        }
        throw new IllegalArgumentException("Id inválido " + integer);
    }
}
