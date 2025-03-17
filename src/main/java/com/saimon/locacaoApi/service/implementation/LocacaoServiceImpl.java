package com.saimon.locacaoApi.service.implementation;

import com.saimon.locacaoApi.controller.exceptions.LocacaoNaoEncontradaException;
import com.saimon.locacaoApi.domain.model.Locacao;
import com.saimon.locacaoApi.domain.model.User;
import com.saimon.locacaoApi.domain.model.Veiculo;
import com.saimon.locacaoApi.domain.model.dto.LocacaoCreateDTO;
import com.saimon.locacaoApi.domain.repository.LocacaoRepository;
import com.saimon.locacaoApi.domain.repository.UserRepository;
import com.saimon.locacaoApi.domain.repository.VeiculoRepository;
import com.saimon.locacaoApi.service.LocacaoService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Transactional
@Service
public class LocacaoServiceImpl implements LocacaoService {

    // INJEÇÃO DE DEPENDENCIAS.
    private final UserRepository userRepository;
    private final VeiculoRepository veiculoRepository;
    private final LocacaoRepository locacaoRepository;


    public LocacaoServiceImpl(UserRepository user, VeiculoRepository veiculo, LocacaoRepository locacaoRepository){
        this.userRepository = user;
        this.veiculoRepository = veiculo;
        this.locacaoRepository = locacaoRepository;
    }


    @Override
    public Locacao findById(Long id) {
        return locacaoRepository.findById(id).orElseThrow(() -> new LocacaoNaoEncontradaException(id));
    }

    @Override
    public List<Locacao> findAll() {
        return locacaoRepository.findAll();
    }

    @Override
    public Locacao create(LocacaoCreateDTO locacaoCreateDTO) {
        User user = userRepository.findById(locacaoCreateDTO.getUserId()).orElseThrow(() -> new EntityNotFoundException("Usuario não encontrado"));

        if (locacaoRepository.findByUserAndAtivoTrue(user).isPresent()){
            throw new RuntimeException("Usuario %s já possui locacao ativa: " + user.getNome());
        }

        Veiculo veiculo = veiculoRepository.findById(locacaoCreateDTO.getVeiculoId()).orElseThrow(() -> new EntityNotFoundException("Veiculo não encontrado"));

        if (!veiculo.isDisponivel()){
            throw new RuntimeException("Veiculo já está em uso (alugado!)");
        }

        Locacao locacao = new Locacao();
        locacao.setUser(user);
        locacao.setVeiculo(veiculo);
        locacao.setDataLocacao(LocalDate.now());
        locacao.setAtivo(true);

        veiculo.setDisponivel(false);
        veiculoRepository.save(veiculo);

        return locacaoRepository.save(locacao);
    }
}
