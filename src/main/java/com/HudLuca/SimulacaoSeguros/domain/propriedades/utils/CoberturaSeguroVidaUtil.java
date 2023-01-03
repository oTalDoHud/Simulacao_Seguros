package com.HudLuca.SimulacaoSeguros.domain.propriedades.utils;

import java.util.List;

public class CoberturaSeguroVidaUtil {
    private Long id;
    private List<Integer> coberturasSeguroVida;
    private Integer valorDoSeguro;

    public CoberturaSeguroVidaUtil(Long id, List<Integer> coberturasSeguroVida, Integer valorDoSeguro) {
        this.id = id;
        this.coberturasSeguroVida = coberturasSeguroVida;
        this.valorDoSeguro = valorDoSeguro;
    }

    public CoberturaSeguroVidaUtil(List<Integer> coberturasSeguroVida, Integer valorDoSeguro) {
        this.coberturasSeguroVida = coberturasSeguroVida;
        this.valorDoSeguro = valorDoSeguro;
    }


}
