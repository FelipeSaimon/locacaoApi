package com.saimon.locacaoApi.controller.dto;

import com.saimon.locacaoApi.domain.model.User;

import java.time.LocalDate;

public class UserDTO {

    private Long id;
    private String nomeCliente;
    private String cpfCliente;
    private String telefoneCliente;

    public UserDTO(User user) {
        this.id = user.getId();
        this.nomeCliente = user.getNome();
        this.cpfCliente = user.getCpf();
        this.telefoneCliente = user.getTelefone();
    }

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public String getTelefoneCliente() {
        return telefoneCliente;
    }

    public void setTelefoneCliente(String telefoneCliente) {
        this.telefoneCliente = telefoneCliente;
    }
}
