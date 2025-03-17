package com.saimon.locacaoApi.service;

import com.saimon.locacaoApi.domain.model.Locacao;

public interface locacaoService {
    Locacao findById(Long id);
    Locacao create(Long userId, Long veiculoId);
}
