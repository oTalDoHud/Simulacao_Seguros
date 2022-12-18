package com.HudLuca.TestTKM.domain.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.util.List;

public class SeguroNovoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotEmpty(message = "O campo título do seguro é obrigatório")
    @Length(min = 3, max = 150, message = "O campo título do seguro deve ter entre 5 e 150 caracteres")
    private String tituloSeguro;
    @Positive(message = "Cliente não pode ser negativo ou zero")
    private Long cliente;
    @Positive(message = "Propriedade não pode ser negativo ou zero")
    private Long propriedade;
    private List<Integer> coberturas;

    public SeguroNovoDTO() {
    }

    public String getTituloSeguro() {
        return tituloSeguro;
    }

    public void setTituloSeguro(String tituloSeguro) {
        this.tituloSeguro = tituloSeguro;
    }

    public Long getCliente() {
        return cliente;
    }

    public void setCliente(Long cliente) {
        this.cliente = cliente;
    }

    public Long getPropriedade() {
        return propriedade;
    }

    public void setPropriedade(Long propriedade) {
        this.propriedade = propriedade;
    }

    public List<Integer> getCoberturas() {
        return coberturas;
    }

    public void setCoberturas(List<Integer> coberturas) {
        this.coberturas = coberturas;
    }
}
