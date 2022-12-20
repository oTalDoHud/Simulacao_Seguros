package com.HudLuca.TestTKM.domain.enums;

public enum PraticaEsportesRadicaisEnum {
    NAO_PRATICA(1, "Não prática"),
    PARAQUEDISMO(2, "Paraquedismo"),
    SURFE(3, "Surfe"),
    RAPEL(4, "Rapel"),
    RAFTING(5, "Rafting"),
    MOTOCROSS(6, "Motocross"),
    BALONISMO(7, "Balonismo"),
    ;

    private int cd;
    private String descricao;

    private PraticaEsportesRadicaisEnum(int cd, String descricao) {
        this.cd = cd;
        this.descricao = descricao;
    }

    public int getCd() {
        return cd;
    }

    public String getDescricao() {
        return descricao;
    }

    public static PraticaEsportesRadicaisEnum toEnum(Integer integer) {

        if (integer == null) {
            return null;
        }

        for (PraticaEsportesRadicaisEnum x : PraticaEsportesRadicaisEnum.values()) {
            if (integer.equals(x.cd)) {
                return x;
            }
        }
        throw new IllegalArgumentException("Id inválido " + integer);
    }
}
