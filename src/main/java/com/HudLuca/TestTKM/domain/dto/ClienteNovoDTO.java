package com.HudLuca.TestTKM.domain.dto;

import com.HudLuca.TestTKM.service.validacao.ClienteInserir;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@ClienteInserir
public class ClienteNovoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotEmpty(message = "O campo nome é obrigatório")
    @Length(min = 5, max = 150, message = "O campo nome deve ter entre 5 e 150 caracteres")
    private String nome;
    @NotEmpty(message = "O campo e-mail é obrigatório")
    @Email(message = "E-mail inválido")
    private String email;
    @NotEmpty(message = "O campo  Cpf/Cnpj é obrigatório")
    private String cpfOuCnpj;
    private Integer tipoCliente;
    @NotEmpty(message = "O campo logradouro é obrigatório")
    private String logradouro;
    @NotEmpty(message = "O número nome é obrigatório")
    private String numero;
    @Length(max = 200, message = "O campo complemento deve conter no máximo 200 caracteres")
    private String complemento;
    @Length(max = 200, message = "O campo bairro deve conter no máximo 200 caracteres")
    private String bairro;
    @NotEmpty(message = "O campo cep é obrigatório")
    @Length(min = 8, max = 8, message = "O campo CEP deve conter 8 caracteres")
    private String cep;

    @NotEmpty(message = "O campo telefone é obrigatório")
    @Length(min = 8, max = 11, message = "O campo telefone 1 deve conter entre 8 e 11 caracteres")
    private String telefone1;
    @Length(min = 8, max = 11, message = "O campo telefone 2 deve conter entre 8 e 11 caracteres")
    private String telefone2;
    @Length(min = 8, max = 11, message = "O campo telefone 3 deve conter entre 8 e 11 caracteres")
    private String telefone3;

    private Long cidadeId;

    public ClienteNovoDTO() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public Integer getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(Integer tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getTelefone1() {
        return telefone1;
    }

    public void setTelefone1(String telefone1) {
        this.telefone1 = telefone1;
    }

    public String getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }

    public String getTelefone3() {
        return telefone3;
    }

    public void setTelefone3(String telefone3) {
        this.telefone3 = telefone3;
    }

    public Long getCidadeId() {
        return cidadeId;
    }

    public void setCidadeId(Long cidadeId) {
        this.cidadeId = cidadeId;
    }
}
