package com.saimon.locacaoApi.service.implementation;

import com.saimon.locacaoApi.controller.exceptions.PlacaCadastradaException;
import com.saimon.locacaoApi.domain.model.Veiculo;
import com.saimon.locacaoApi.domain.repository.VeiculoRepository;
import com.saimon.locacaoApi.service.VeiculoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class VeiculoServiceImpl implements VeiculoService {

    private final VeiculoRepository veiculoRepository;

    public VeiculoServiceImpl(VeiculoRepository veiculoRepository){
        this.veiculoRepository = veiculoRepository;
    }

    @Override
    public Veiculo findById(Long id) {
        return veiculoRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<Veiculo> findAll() {
        return veiculoRepository.findAll();
    }

    @Override
    public Veiculo create(Veiculo veiculoCreated) {
        if (veiculoRepository.existsByPlaca(veiculoCreated.getPlaca())){
            throw new PlacaCadastradaException(veiculoCreated.getPlaca());
        }
        return veiculoRepository.save(veiculoCreated);
    }
}
