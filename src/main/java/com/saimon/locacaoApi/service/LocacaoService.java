package com.saimon.locacaoApi.service;

import com.saimon.locacaoApi.domain.model.Locacao;
import com.saimon.locacaoApi.domain.model.dto.LocacaoDTO;

public interface LocacaoService {
    Locacao findById(Long id);
    Locacao create(LocacaoDTO locacaoDTO);
}
