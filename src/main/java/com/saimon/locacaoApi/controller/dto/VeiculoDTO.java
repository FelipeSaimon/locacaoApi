package com.saimon.locacaoApi.controller.dto;

import com.saimon.locacaoApi.domain.model.User;
import com.saimon.locacaoApi.domain.model.Veiculo;

public class VeiculoDTO {
    private Long id;
    private String modeloVeiculo;
    private String numeroPlaca;

    public VeiculoDTO(Veiculo veiculo) {
        this.id = veiculo.getId();
        this.modeloVeiculo = veiculo.getModelo();
        this.numeroPlaca = veiculo.getPlaca();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModeloVeiculo() {
        return modeloVeiculo;
    }

    public void setModeloVeiculo(String modeloVeiculo) {
        this.modeloVeiculo = modeloVeiculo;
    }

    public String getNumeroPlaca() {
        return numeroPlaca;
    }

    public void setNumeroPlaca(String numeroPlaca) {
        this.numeroPlaca = numeroPlaca;
    }
}
