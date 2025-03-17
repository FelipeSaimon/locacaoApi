package com.saimon.locacaoApi.controller;

import com.saimon.locacaoApi.controller.dto.LocacaoDTO;
import com.saimon.locacaoApi.controller.dto.VeiculoDTO;
import com.saimon.locacaoApi.domain.model.Veiculo;
import com.saimon.locacaoApi.service.VeiculoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.swing.plaf.PanelUI;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {
    private final VeiculoService veiculoService;

    public VeiculoController(VeiculoService veiculoService){
        this.veiculoService = veiculoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Veiculo> findById(@PathVariable Long id){
        var veiculo = veiculoService.findById(id);

        return ResponseEntity.ok(veiculo);
    }

    @PostMapping
    public ResponseEntity<Veiculo> create(@RequestBody Veiculo veiculoCreated){
        var veiculo = veiculoService.create(veiculoCreated);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(veiculoCreated.getId())
                .toUri();

        return ResponseEntity.ok(veiculoCreated);
    }

    @GetMapping
    public ResponseEntity<List<VeiculoDTO>> findAll() {
        var veiculosRegistrados = veiculoService.findAll();

        List<VeiculoDTO> veiculosDto = veiculosRegistrados.stream()
                .map(VeiculoDTO::new) // Assumindo que há um construtor adequado
                .toList(); // Em versões anteriores do Java, use .collect(Collectors.toList());

        return ResponseEntity.ok(veiculosDto);
    }
}
