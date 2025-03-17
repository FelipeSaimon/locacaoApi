package com.saimon.locacaoApi.domain.repository;

import com.saimon.locacaoApi.domain.model.Locacao;
import com.saimon.locacaoApi.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LocacaoRepository extends JpaRepository<Locacao, Long> {
    Optional<Locacao> findByUserAndAtivoTrue(User user);
}
