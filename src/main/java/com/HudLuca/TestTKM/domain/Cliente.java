package com.HudLuca.TestTKM.domain;

import com.HudLuca.TestTKM.domain.enums.SexoClienteEnum;
import com.HudLuca.TestTKM.domain.enums.TipoClienteEnum;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "tb_cliente")
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Integer sexo;
    @Column(unique = true)
    private String email;
    private String cpfOuCnpj;
    private Integer tipoCliente;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Endereco> enderecos = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "tb_telefone")
    private Set<String> telefones = new HashSet<>();

    public Cliente() {
    }

    public Cliente(String nome, SexoClienteEnum sexo, String email, String cpfOuCnpj, TipoClienteEnum tipoClienteEnum) {
        this.nome = nome;
        this.sexo = (sexo == null) ? null : sexo.getCd();
        this.email = email;
        this.cpfOuCnpj = cpfOuCnpj;
        this.tipoCliente = (tipoClienteEnum == null) ? null : tipoClienteEnum.getCd();
    }

    public Cliente(Long id, String nome, SexoClienteEnum sexo, String email, String cpfOuCnpj, TipoClienteEnum tipoClienteEnum) {
        this.id = id;
        this.nome = nome;
        this.sexo = (sexo == null) ? null : sexo.getCd();
        this.email = email;
        this.cpfOuCnpj = cpfOuCnpj;
        this.tipoCliente = (tipoClienteEnum == null) ? null : tipoClienteEnum.getCd();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return SexoClienteEnum.toEnum(sexo).getDescricao();
    }

    public void setSexo(SexoClienteEnum sexo) {
        this.sexo = sexo.getCd();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpfOuCnpj() {
        return cpfOuCnpj;
    }

    public void setCpfOuCnpj(String cpfOuCnpj) {
        this.cpfOuCnpj = cpfOuCnpj;
    }

    public String getTipoCliente() {
        return TipoClienteEnum.toEnum(this.tipoCliente).getDescricao();
    }

    public void setTipoCliente(TipoClienteEnum tipoClienteEnum) {
        this.tipoCliente = tipoClienteEnum.getCd();
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public Set<String> getTelefones() {
        return telefones;
    }

    public void setTelefones(Set<String> telefones) {
        this.telefones = telefones;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cliente cliente = (Cliente) o;

        return Objects.equals(id, cliente.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
