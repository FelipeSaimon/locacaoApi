package com.saimon.locacaoApi.controller.exceptions;

public class UsuarioNaoEncontradoException extends RuntimeException{
    public UsuarioNaoEncontradoException(String message) {
        super(message);
    }

    public UsuarioNaoEncontradoException(Long id) {
        super("Usuário com ID " + id + " não encontrado");
    }
}

