package com.HudLuca.TestTKM.domain.propriedades;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

import static com.HudLuca.TestTKM.utils.FormatUtils.formatDinheiro;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "tb_propriedade")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "@type")
public abstract class Propriedade implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    protected Double valorDaPropriedade;
    private int quantidade;

    protected Propriedade(Long id, Double valorDaPropriedade, int quantidade) {
        this.id = id;
        this.valorDaPropriedade = valorDaPropriedade;
        this.quantidade = quantidade;
    }

    protected Propriedade(Double valorDaPropriedade, int quantidade) {
        this.valorDaPropriedade = valorDaPropriedade;
        this.quantidade = quantidade;
    }

    protected Propriedade() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValorDaPropriedadeFormatado() {
        return formatDinheiro(valorDaPropriedade);
    }

    public Double getValorDaPropriedade() {
        return valorDaPropriedade;
    }

    public void setValorDaPropriedade(Double valorDaPropriedade) {
        this.valorDaPropriedade = valorDaPropriedade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Propriedade that = (Propriedade) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
