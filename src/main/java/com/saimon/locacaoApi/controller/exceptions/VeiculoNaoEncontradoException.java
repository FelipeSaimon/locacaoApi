package com.saimon.locacaoApi.controller.exceptions;

public class VeiculoNaoEncontradoException extends RuntimeException {
    public VeiculoNaoEncontradoException(String message) {
        super(message);
    }

    public VeiculoNaoEncontradoException(Long id) {
        super("Veículo com ID " + id + " não encontrado");
    }
}
