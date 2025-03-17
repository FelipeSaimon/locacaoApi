package com.saimon.locacaoApi.controller.exceptions;

public class PlacaCadastradaException extends RuntimeException {
    public PlacaCadastradaException(String placa) {
        super("Já existe um veículo cadastrado com a placa: " + placa);
    }
}
