package com.HudLuca.TestTKM.domain;

import com.HudLuca.TestTKM.domain.enums.CoberturasAutomovelEnum;
import com.HudLuca.TestTKM.domain.enums.CoberturasSeguroVidaEnum;
import com.HudLuca.TestTKM.domain.propriedades.Automovel;
import com.HudLuca.TestTKM.domain.propriedades.Propriedade;
import com.HudLuca.TestTKM.domain.propriedades.Residencia;
import com.HudLuca.TestTKM.domain.propriedades.PropriedadeVida;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

import static com.HudLuca.TestTKM.utils.FormatUtils.formatDinheiro;

@Entity
@Table(name = "tb_seguro")
public class Seguro implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tituloSeguro;
    private Double valorSeguroAnual;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    @JsonIgnore
    private Cliente cliente;
    @OneToOne
    @JoinColumn(name = "propriedade_id")
    private Propriedade propriedade;
    @ElementCollection
    @CollectionTable(name = "tb_coberturas")
    private Set<Integer> coberturas = new HashSet<>();

    public Seguro() {
    }

    public Seguro(String tituloSeguro, Double valorSeguroAnual, Cliente cliente, Propriedade propriedade) {
        this.tituloSeguro = tituloSeguro;
        this.valorSeguroAnual = valorSeguroAnual;
        this.cliente = cliente;
        this.propriedade = propriedade;
    }

    public Seguro(Long id, String tituloSeguro, Double valorSeguroAnual, Cliente cliente, Propriedade propriedade) {
        this.id = id;
        this.tituloSeguro = tituloSeguro;
        this.valorSeguroAnual = valorSeguroAnual;
        this.cliente = cliente;
        this.propriedade = propriedade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTituloSeguro() {
        return tituloSeguro;
    }

    public void setTituloSeguro(String tituloSeguro) {
        this.tituloSeguro = tituloSeguro;
    }

    public String getValorSeguroAnual() {
        return formatDinheiro(valorSeguroAnual);
    }

    public String getValorSeguroMensal() {
        return formatDinheiro(valorSeguroAnual / 12);
    }

    public void setValorSeguroAnual(Double valorSeguroAnual) {
        this.valorSeguroAnual = valorSeguroAnual;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Propriedade getPropriedade() {
        return propriedade;
    }

    public void setPropriedade(Propriedade propriedade) {
        this.propriedade = propriedade;
    }

    public List<String> getCoberturas() {
        List<String> coberturasList = new ArrayList<>();

        if (this.propriedade instanceof Automovel) {
            for (Integer x : coberturas) {
                coberturasList.add(CoberturasAutomovelEnum.toEnum(x).getDescricao());
            }
        } else if (this.propriedade instanceof PropriedadeVida) {
            for (Integer x : coberturas) {
                coberturasList.add(CoberturasSeguroVidaEnum.toEnum(x).getDescricao());
            }
        } else if (this.propriedade instanceof Residencia) {
            //implementar coberturas de Residencia
        }

        return coberturasList;
    }

    public void setCoberturas(Set<Integer> coberturas) {
        this.coberturas = coberturas;
    }

    public void addCoberturas(Integer... coberturas) {

        if (this.propriedade instanceof Automovel) {
            for (Integer x : coberturas) {
                if (CoberturasAutomovelEnum.toEnum(x) != null) {
                    this.coberturas.add(x);
                } else {
                    throw new IllegalArgumentException();
                }
            }
        } else if (this.propriedade instanceof PropriedadeVida) {
            for (Integer x : coberturas) {
                if (CoberturasSeguroVidaEnum.toEnum(x) != null) {
                    this.coberturas.add(x);
                } else {
                    throw new IllegalArgumentException();
                }
            }
        } else if (this.propriedade instanceof Residencia) {
            //implementar coberturas de Residencia
        } else {
            throw new IllegalArgumentException("Informe uma cobertura válida - Propriedade informada não existe");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Seguro seguro = (Seguro) o;

        return Objects.equals(id, seguro.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
