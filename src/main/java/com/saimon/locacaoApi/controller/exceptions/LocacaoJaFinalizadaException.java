package com.saimon.locacaoApi.controller.exceptions;

public class LocacaoJaFinalizadaException extends RuntimeException{
    public LocacaoJaFinalizadaException(String message) {
        super(message);
    }

    public LocacaoJaFinalizadaException(Long id) {
        super("Locação com ID " + id + " já foi finalizada");
    }}
