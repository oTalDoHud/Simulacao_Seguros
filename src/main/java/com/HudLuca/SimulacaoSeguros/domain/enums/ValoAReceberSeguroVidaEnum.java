package com.HudLuca.SimulacaoSeguros.domain.enums;

public enum ValoAReceberSeguroVidaEnum {
    SILVER_I(1, "Silver 1", 10000.00),
    SILVER_II(2, "Silver 2", 25000.00),
    SILVER_III(3, "Silver 3", 50000.00),
    GOLD_I(4, "Gold 1", 100000.00),
    GOLD_II(5, "Gold 2", 150000.00),
    GOLD_III(6, "Gold 3", 250000.00),
    PLATINUM_I(7, "Platinum 1", 1000000.00),
    PLATINUM_II(8, "Platinum 2", 5000000.00),
    PLATINUM_III(9, "Platinum 3", 10000000.00),
    ;

    private int cd;
    private String descricao;
    private Double valorAReceber;

    private ValoAReceberSeguroVidaEnum(int cd, String descricao, double valorAReceber) {
        this.cd = cd;
        this.descricao = descricao;
        this.valorAReceber = valorAReceber;
    }

    public int getCd() {
        return cd;
    }

    public String getDescricao() {
        return descricao;
    }

    public Double getValorAReceber() {
        return valorAReceber;
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
