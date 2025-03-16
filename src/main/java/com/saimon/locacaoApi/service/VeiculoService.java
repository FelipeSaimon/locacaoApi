package com.saimon.locacaoApi.service;

import com.saimon.locacaoApi.domain.model.Veiculo;

public interface VeiculoService {
    Veiculo findById(Long id);
    Veiculo create(Veiculo veiculoCreated);
}
