package com.saimon.locacaoApi.controller;

import com.saimon.locacaoApi.controller.dto.LocacaoDTO;
import com.saimon.locacaoApi.controller.dto.UserDTO;
import com.saimon.locacaoApi.domain.model.User;
import com.saimon.locacaoApi.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User userCreated){
        var user = userService.create(userCreated);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userCreated.getId())
                .toUri();

        return ResponseEntity.created(location).body(userCreated);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findUserById(@PathVariable Long id){
        var user = userService.findById(id);

        return ResponseEntity.ok(user);
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        var usersRegistrados = userService.findAllUsers();

        List<UserDTO> usersDto = usersRegistrados.stream()
                .map(UserDTO::new) // Assumindo que há um construtor adequado
                .toList(); // Em versões anteriores do Java, use .collect(Collectors.toList());

        return ResponseEntity.ok(usersDto);
    }
}
