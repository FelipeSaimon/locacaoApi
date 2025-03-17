package com.saimon.locacaoApi.controller.dto;

import com.saimon.locacaoApi.domain.model.Locacao;
import com.saimon.locacaoApi.domain.model.User;
import com.saimon.locacaoApi.domain.model.Veiculo;

import java.time.LocalDate;

public class LocacaoDTO {
    private Long id;
    private User cliente;
    private Veiculo veiculo;
    private LocalDate dataLocacao;
    private LocalDate dataDevolucao;

    public LocacaoDTO(Locacao locacao) {
        this.id = locacao.getId();
        this.cliente = locacao.getUser();
        this.veiculo = locacao.getVeiculo();
        this.dataLocacao = locacao.getDataLocacao();
        this.dataDevolucao = locacao.getDataDevolucao();
    }

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getCliente() {
        return cliente;
    }

    public void setCliente(User cliente) {
        this.cliente = cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public LocalDate getDataLocacao() {
        return dataLocacao;
    }

    public void setDataLocacao(LocalDate dataLocacao) {
        this.dataLocacao = dataLocacao;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }
}
