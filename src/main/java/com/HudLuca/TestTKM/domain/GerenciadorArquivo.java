package com.HudLuca.TestTKM.domain;

import com.HudLuca.TestTKM.domain.propriedades.PropriedadeVida;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "tb_gerenciador_arquivo")
public class GerenciadorArquivo implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "cliente_id")
    @JsonIgnore
    private Cliente cliente;
    private Date dtCadastro;
    private String nomeArquivo;
    private String caminhoArquivo;

    @ManyToOne
    @JoinColumn(name = "propriedade_vida_id")
    @JsonIgnore
    private PropriedadeVida propriedadeVida;

    public GerenciadorArquivo() {
    }

    public GerenciadorArquivo(Cliente cliente, Date dtCadastro, String nomeArquivo, String caminhoArquivo) {
        this.cliente = cliente;
        this.dtCadastro = dtCadastro;
        this.nomeArquivo = nomeArquivo;
        this.caminhoArquivo = caminhoArquivo;
    }

    public GerenciadorArquivo(Long id, Cliente cliente, Date dtCadastro, String nomeArquivo, String caminhoArquivo) {
        this.id = id;
        this.cliente = cliente;
        this.dtCadastro = dtCadastro;
        this.nomeArquivo = nomeArquivo;
        this.caminhoArquivo = caminhoArquivo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getDtCadastro() {
        return dtCadastro;
    }

    public void setDtCadastro(Date dtCadastro) {
        this.dtCadastro = dtCadastro;
    }

    public String getNomeArquivo() {
        return nomeArquivo;
    }

    public void setNomeArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public String getCaminhoArquivo() {
        return caminhoArquivo;
    }

    public void setCaminhoArquivo(String caminhoArquivo) {
        this.caminhoArquivo = caminhoArquivo;
    }

    public PropriedadeVida getPropriedadeVida() {
        return propriedadeVida;
    }

    public void setPropriedadeVida(PropriedadeVida propriedadeVida) {
        this.propriedadeVida = propriedadeVida;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GerenciadorArquivo that = (GerenciadorArquivo) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
