package com.HudLuca.TestTKM.domain.dto;

import com.HudLuca.TestTKM.service.validacao.AutomovelInserir;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;

@AutomovelInserir
public class AutomovelNovoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @Positive(message = "Valor não pode ser zero ou negativo")
    private Double valor;
    @Positive(message = "Quantidade não pode ser zero ou negativo")
    private Integer quantidade;
    @NotEmpty(message = "Placa não pode estar vazia placa")
    private String placa;
    @NotEmpty(message = "Modelo não pode estar vazio")
    @Length(min = 3, max = 150, message = "O campo nome deve ter entre 5 e 150 caracteres")
    private String modelo;
    @NotEmpty(message = "Marca não pode estar vazia")
    @Length(min = 3, max = 150, message = "O campo nome deve ter entre 5 e 150 caracteres")
    private String marca;
    @PastOrPresent(message = "O ano de fabricação não pode ser futuro")
    private Date anoFabricacao;
    @Positive(message = "Quantidade de proprietarios não pode ser zero ou negativo")
    private Integer quantidadeDeProprietarios;
    @Positive(message = "Quilometragem não pode ser zero ou negativo")
    private Double quilometragem;
    @Positive(message = "Tempo de habilitação do proprietarios não pode ser zero ou negativo")
    private Integer tempoHabilitacaoProprietario;

    public AutomovelNovoDTO() {
    }

    public AutomovelNovoDTO(String placa, String modelo, String marca, Date anoFabricacao,
                            Integer quantidadeDeProprietarios, Double quilometragem,
                            Integer tempoHabilitacaoProprietario) {
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.anoFabricacao = anoFabricacao;
        this.quantidadeDeProprietarios = quantidadeDeProprietarios;
        this.quilometragem = quilometragem;
        this.tempoHabilitacaoProprietario = tempoHabilitacaoProprietario;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
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

    public Integer getTempoHabilitacaoProprietario() {
        return tempoHabilitacaoProprietario;
    }

    public void setTempoHabilitacaoProprietario(Integer tempoHabilitacaoProprietario) {
        this.tempoHabilitacaoProprietario = tempoHabilitacaoProprietario;
    }
}
