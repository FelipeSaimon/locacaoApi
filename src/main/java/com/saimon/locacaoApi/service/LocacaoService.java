package com.saimon.locacaoApi.service;

import com.saimon.locacaoApi.domain.model.Locacao;
import com.saimon.locacaoApi.domain.model.dto.LocacaoCreateDTO;

import java.util.List;

public interface LocacaoService {
    Locacao findById(Long id);
    List<Locacao> findAll();
    Locacao create(LocacaoCreateDTO locacaoCreateDTO);
}
