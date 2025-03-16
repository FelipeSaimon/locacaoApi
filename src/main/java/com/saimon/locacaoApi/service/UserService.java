package com.saimon.locacaoApi.service;

import com.saimon.locacaoApi.domain.model.User;

public interface UserService {
    User findById(Long id);
    User create(User userCreated);
}
