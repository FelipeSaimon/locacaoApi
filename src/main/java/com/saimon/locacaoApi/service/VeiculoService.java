package com.saimon.locacaoApi.service;

import com.saimon.locacaoApi.domain.model.Veiculo;

import java.util.List;

public interface VeiculoService {
    Veiculo findById(Long id);
    List<Veiculo> findAll();
    Veiculo create(Veiculo veiculoCreated);
}
