package com.saimon.locacaoApi.service.implementation;

import com.saimon.locacaoApi.domain.model.Veiculo;
import com.saimon.locacaoApi.domain.repository.VeiculoRepository;
import com.saimon.locacaoApi.service.VeiculoService;
import org.springframework.stereotype.Service;

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
    public Veiculo create(Veiculo veiculoCreated) {
        if (veiculoRepository.existsByPlaca(veiculoCreated.getPlaca())){
            throw new IllegalArgumentException("Um veiculo com essa placa já foi cadastrado");
        }
        return veiculoRepository.save(veiculoCreated);
    }
}
