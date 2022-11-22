package com.HudLuca.TestTKM.domain;

import com.HudLuca.TestTKM.domain.enums.CoberturasAutomovel;
import com.HudLuca.TestTKM.domain.propriedades.Propriedade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "tb_seguro")
public class Seguro implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    @OneToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    @OneToOne
    @JoinColumn(name = "propriedade_id")
    private Propriedade propriedade;
    @ElementCollection
    @CollectionTable(name = "tb_coberturas")
    private Set<Integer> coberturas = new HashSet<>();

    public Seguro() {
    }

    public Seguro(String titulo, Cliente cliente, Propriedade propriedade) {
        this.titulo = titulo;
        this.cliente = cliente;
        this.propriedade = propriedade;
    }

    public Seguro(Long id, String titulo, Cliente cliente, Propriedade propriedade) {
        this.id = id;
        this.titulo = titulo;
        this.cliente = cliente;
        this.propriedade = propriedade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
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

    public List<CoberturasAutomovel> getCoberturas() {
        List<CoberturasAutomovel> coberturasAutomovelList = new ArrayList<>();

        for (Integer x : coberturas) {
            coberturasAutomovelList.add(CoberturasAutomovel.toEnum(x));
        }

        return coberturasAutomovelList;
    }

    public void setCoberturas(Set<Integer> coberturas) {
        this.coberturas = coberturas;
    }

    public void addCoberturas(Integer... coberturas) {

        for (Integer x : coberturas) {
            if (CoberturasAutomovel.toEnum(x) != null) {
                this.coberturas.add(x);
            } else {
                throw new IllegalArgumentException();
            }
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
