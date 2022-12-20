package com.HudLuca.TestTKM.domain.dto;


import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

public class SeguroCategoriaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotEmpty(message = "Coberturas não ser vazio ou nulo")
    private List<Integer> coberturas;

    public SeguroCategoriaDTO() {
    }

    public List<Integer> getCoberturas() {
        return coberturas;
    }

    public void setCoberturas(List<Integer> coberturas) {
        this.coberturas = coberturas;
    }
}