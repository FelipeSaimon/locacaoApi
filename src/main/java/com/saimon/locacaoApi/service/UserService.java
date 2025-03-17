package com.saimon.locacaoApi.service;

import com.saimon.locacaoApi.domain.model.User;

import java.util.List;

public interface UserService {
    User findById(Long id);
    List<User> findAllUsers();
    User create(User userCreated);
}
