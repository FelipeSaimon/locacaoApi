package com.saimon.locacaoApi.controller;

import com.saimon.locacaoApi.domain.model.Locacao;
import com.saimon.locacaoApi.domain.model.dto.LocacaoDTO;
import com.saimon.locacaoApi.service.LocacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/locacoes")
public class LocacaoController {
    private final LocacaoService locacaoService;

    public LocacaoController(LocacaoService locacaoService){
        this.locacaoService = locacaoService;
    }

    @PostMapping
    public ResponseEntity<Locacao> create(@RequestBody LocacaoDTO locacaoDTO){
        var locacao = locacaoService.create(locacaoDTO);

        return ResponseEntity.ok(locacao);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Locacao> findById(Long id){
        var locacao = locacaoService.findById(id);

        return ResponseEntity.ok(locacao);
    }

}
