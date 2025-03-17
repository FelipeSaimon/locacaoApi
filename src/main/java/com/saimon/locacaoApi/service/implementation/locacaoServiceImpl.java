package com.saimon.locacaoApi.service.implementation;

import com.saimon.locacaoApi.domain.model.Locacao;
import com.saimon.locacaoApi.domain.repository.LocacaoRepository;
import com.saimon.locacaoApi.domain.repository.UserRepository;
import com.saimon.locacaoApi.domain.repository.VeiculoRepository;
import com.saimon.locacaoApi.service.locacaoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

import static java.time.temporal.TemporalQueries.localDate;

public class locacaoServiceImpl implements locacaoService {

    // INJEÇÃO DE DEPENDENCIAS.
    private final UserRepository userRepository;
    private final VeiculoRepository veiculoRepository;
    private final LocacaoRepository locacaoRepository;

    @Autowired
    private Locacao locacao;

    public locacaoServiceImpl(UserRepository user, VeiculoRepository veiculo, LocacaoRepository locacao){
        this.userRepository = user;
        this.veiculoRepository = veiculo;
        this.locacaoRepository = locacao;
    }


    @Override
    public Locacao findById(Long id) {
        return null;
    }

    @Override
    public Locacao create(Long userId, Long veiculoId) {
        var user = userRepository.findById(userId).orElseThrow(() -> {
            throw new RuntimeException("Usuario não encontrado");
        });

        if (locacaoRepository.findByUserLocacaoAtiva(user).isPresent()){
            throw new RuntimeException("Usuario %s já possui locacao ativa: " + user.getNome());
        }

        var veiculo = veiculoRepository.findById(veiculoId).orElseThrow(() -> {
            throw new RuntimeException("Veiculo não encontrado");
        });

        if (!veiculo.isDisponivel()){
            throw new RuntimeException("Veiculo já está em uso (alugado!)");
        }

        new Locacao(user, veiculo, LocalDate.now());

        veiculo.setDisponivel(false);
        veiculoRepository.save(veiculo);

        return locacaoRepository.save(locacao);
    }
}
