package com.HudLuca.TestTKM.domain.dto;


import com.HudLuca.TestTKM.domain.Cliente;
import com.HudLuca.TestTKM.service.validacao.ClienteAtualizar;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@ClienteAtualizar
public class ClienteDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    @NotEmpty(message = "O campo nome é obrigatório")
    @Length(min = 5, max = 150, message = "O campo nome deve ter entre 5 e 150 caracteres")
    private String nome;
    @NotEmpty(message = "O campo e-mail é obrigatório")
    @Email(message = "E-mail é inválido")
    private String email;

    public ClienteDTO() {
    }

    public ClienteDTO(Long id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public ClienteDTO(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.email = cliente.getEmail();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
