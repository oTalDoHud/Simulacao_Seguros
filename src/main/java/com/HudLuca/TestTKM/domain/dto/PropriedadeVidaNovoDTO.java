package com.HudLuca.TestTKM.domain.dto;



import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PropriedadeVidaNovoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @NotEmpty(message = "Prática esporte radical não pode ser vazio")
    private List<Long> atestadoSaude = new ArrayList<>();
    @NotEmpty(message = "Prática esporte radical não pode ser vazio")
    private List<Integer> praticaEsporteRadical = new ArrayList<>();

    @Positive(message = "Valor a receber não pode ser zero ou negativo")
    private Integer valorAReceber;

    @NotEmpty(message = "Consumo de drogas não pode ser vazio")
    private Set<Integer> consumoDrogas = new HashSet<>();

    @Positive(message = "Trabalho não pode ser zero ou negativo")
    private Integer trabalho;

    public PropriedadeVidaNovoDTO() {
    }

    public PropriedadeVidaNovoDTO(Integer valorAReceber, Integer trabalho) {
        this.valorAReceber = valorAReceber;
        this.trabalho = trabalho;
    }

    public List<Long> getAtestadoSaude() {
        return atestadoSaude;
    }

    public void setAtestadoSaude(List<Long> atestadoSaude) {
        this.atestadoSaude = atestadoSaude;
    }

    public List<Integer> getPraticaEsporteRadical() {
        return praticaEsporteRadical;
    }

    public void setPraticaEsporteRadical(List<Integer> praticaEsporteRadical) {
        this.praticaEsporteRadical = praticaEsporteRadical;
    }

    public Integer getValorAReceber() {
        return valorAReceber;
    }

    public void setValorAReceber(Integer valorAReceber) {
        this.valorAReceber = valorAReceber;
    }

    public Set<Integer> getConsumoDrogas() {
        return consumoDrogas;
    }

    public void setConsumoDrogas(Set<Integer> consumoDrogas) {
        this.consumoDrogas = consumoDrogas;
    }

    public Integer getTrabalho() {
        return trabalho;
    }

    public void setTrabalho(Integer trabalho) {
        this.trabalho = trabalho;
    }
}