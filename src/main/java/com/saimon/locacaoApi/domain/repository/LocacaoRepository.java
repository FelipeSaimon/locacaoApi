package com.saimon.locacaoApi.domain.repository;

import com.saimon.locacaoApi.domain.model.Locacao;
import com.saimon.locacaoApi.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LocacaoRepository extends JpaRepository<Locacao, Long> {
    Optional<Locacao> findByUserLocacaoAtiva(User user);
}
