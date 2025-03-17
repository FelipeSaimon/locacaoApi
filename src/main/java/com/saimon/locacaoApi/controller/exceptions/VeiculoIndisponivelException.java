package com.saimon.locacaoApi.controller.exceptions;

public class VeiculoIndisponivelException extends RuntimeException {
    public VeiculoIndisponivelException(String message) {
        super(message);
    }

    public VeiculoIndisponivelException(Long id) {
        super("Veículo com ID " + id + " não está disponível para locação");
    }
}