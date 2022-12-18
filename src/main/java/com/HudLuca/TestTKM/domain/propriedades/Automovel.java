package com.HudLuca.TestTKM.domain.propriedades;

import com.HudLuca.TestTKM.domain.enums.TempoHabilitacaoEnum;
import com.fasterxml.jackson.annotation.JsonTypeName;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "tb_propriedade_automovel")
@JsonTypeName("propriedadeAutomovel")
public class Automovel extends Propriedade {

    private String placa;
    private String modelo;
    private String marca;
    private Date anoFabricacao;
    private Integer quantidadeDeProprietarios;
    private Double quilometragem;
    private Integer tempoHabilitacaoProprietario;

    public Automovel() {
        super();
    }

    public Automovel
            (double valorDaPropriedade, int quantidade, String placa, String modelo, String marca,
             Date anoFabricacao, Integer quantidadeDeProprietarios, Double quilometragem,
             TempoHabilitacaoEnum tempoHabilitacaoEnumProprietario) {
        super(valorDaPropriedade, quantidade);
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.anoFabricacao = anoFabricacao;
        this.quantidadeDeProprietarios = quantidadeDeProprietarios;
        this.quilometragem = quilometragem;
        this.tempoHabilitacaoProprietario = (tempoHabilitacaoEnumProprietario == null) ? null : tempoHabilitacaoEnumProprietario.getCd();
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Date getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(Date anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public Integer getQuantidadeDeProprietarios() {
        return quantidadeDeProprietarios;
    }

    public void setQuantidadeDeProprietarios(Integer quantidadeDeProprietarios) {
        this.quantidadeDeProprietarios = quantidadeDeProprietarios;
    }

    public Double getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(Double quilometragem) {
        this.quilometragem = quilometragem;
    }

    public String getTempoHabilitacaoProprietarioDescricao() {
        return TempoHabilitacaoEnum.toEnum(this.tempoHabilitacaoProprietario).getDescricao();
    }

    public TempoHabilitacaoEnum getTempoHabilitacaoProprietario() {
        return TempoHabilitacaoEnum.toEnum(this.tempoHabilitacaoProprietario);
    }

    public void setTempoHabilitacaoProprietario(TempoHabilitacaoEnum tempoHabilitacaoEnumProprietario) {
        this.tempoHabilitacaoProprietario = tempoHabilitacaoEnumProprietario.getCd();
    }

}
