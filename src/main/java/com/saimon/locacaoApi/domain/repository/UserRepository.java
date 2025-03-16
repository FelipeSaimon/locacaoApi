package com.saimon.locacaoApi.domain.repository;

import com.saimon.locacaoApi.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByCPF(String cpf);
}
