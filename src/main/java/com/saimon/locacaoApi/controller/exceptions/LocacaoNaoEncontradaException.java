package com.saimon.locacaoApi.controller.exceptions;

public class LocacaoNaoEncontradaException extends RuntimeException {
    public LocacaoNaoEncontradaException(String message) {
        super(message);
    }

    public LocacaoNaoEncontradaException(Long id) {
        super("Locação com ID " + id + " não encontrada");
    }
}
