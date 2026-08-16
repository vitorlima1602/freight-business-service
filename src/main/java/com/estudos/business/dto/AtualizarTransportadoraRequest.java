package com.estudos.business.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class AtualizarTransportadoraRequest {
    @NotBlank(message = "Razão social é obrigatória.")
    private String razaoSocial;

    private String nomeFantasia;

    @NotBlank(message = "E-mail é obrigatório.")
    @Email(message = "E-mail inválido.")
    private String email;

    private String telefone;

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
