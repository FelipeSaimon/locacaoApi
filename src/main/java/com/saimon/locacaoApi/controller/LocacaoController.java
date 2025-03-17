package com.saimon.locacaoApi.controller;

import com.saimon.locacaoApi.controller.dto.LocacaoDTO;
import com.saimon.locacaoApi.domain.model.Locacao;
import com.saimon.locacaoApi.domain.model.dto.LocacaoCreateDTO;
import com.saimon.locacaoApi.service.LocacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/locacoes")
public class LocacaoController {
    private final LocacaoService locacaoService;

    public LocacaoController(LocacaoService locacaoService) {
        this.locacaoService = locacaoService;
    }

    @PostMapping
    public ResponseEntity<Locacao> create(@RequestBody LocacaoCreateDTO locacaoCreateDTO) {
        var locacao = locacaoService.create(locacaoCreateDTO);

        return ResponseEntity.ok(locacao);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Locacao> findById(Long id) {
        var locacao = locacaoService.findById(id);

        return ResponseEntity.ok(locacao);
    }


    @GetMapping
    public ResponseEntity<List<LocacaoDTO>> findAll() {
        var locacoesRegistradas = locacaoService.findAll();

        // Convertendo Locacao para LocacaoDTO
        List<LocacaoDTO> locacoesDto = locacoesRegistradas.stream()
                .map(LocacaoDTO::new) // Assumindo que há um construtor adequado
                .toList(); // Em versões anteriores do Java, use .collect(Collectors.toList());

        return ResponseEntity.ok(locacoesDto);
    }
}
