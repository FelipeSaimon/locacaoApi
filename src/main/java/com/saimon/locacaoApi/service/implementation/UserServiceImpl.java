package com.saimon.locacaoApi.service.implementation;

import com.saimon.locacaoApi.domain.model.User;
import com.saimon.locacaoApi.domain.repository.UserRepository;
import com.saimon.locacaoApi.service.UserService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    // Injetando dependencias do repository
    private final UserRepository userRepository;
    private User userCreated;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {

        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userCreated) {

        // Verificando se o cpf já está cadastrado, isso pode evitar uso de um mesmo cpf por pessoas diferentes.
        if(userRepository.existsByCPF(userCreated.getCpf())){
            throw new IllegalArgumentException("Este cpf já está cadastrado.");
        }

        return userRepository.save(userCreated);
    }
}
