package com.saimon.locacaoApi.controller.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    // Exceções genéricas já existentes
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleBusinessException(IllegalArgumentException businessException) {
        return new ResponseEntity<>(businessException.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNotFoundException(NoSuchElementException notFoundException) {
        return new ResponseEntity<>("Resource ID not found.", HttpStatus.NOT_FOUND);
    }

    // Exceções específicas para Usuário
    @ExceptionHandler(UsuarioNaoEncontradoException.class)
    public ResponseEntity<String> handleUsuarioNaoEncontradoException(UsuarioNaoEncontradoException ex) {
        logger.error("Usuário não encontrado: {}", ex.getMessage());
        return new ResponseEntity<>("Usuário não encontrado: " + ex.getMessage(), HttpStatus.NOT_FOUND);
    }


    // Exceções específicas para Veículo
    @ExceptionHandler(VeiculoNaoEncontradoException.class)
    public ResponseEntity<String> handleVeiculoNaoEncontradoException(VeiculoNaoEncontradoException ex) {
        logger.error("Veículo não encontrado: {}", ex.getMessage());
        return new ResponseEntity<>("Veículo não encontrado: " + ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(VeiculoIndisponivelException.class)
    public ResponseEntity<String> handleVeiculoIndisponivelException(VeiculoIndisponivelException ex) {
        return new ResponseEntity<>("Veículo não disponível para locação: " + ex.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(PlacaCadastradaException.class)
    public ResponseEntity<String> handlePlacaJaCadastradaException(PlacaCadastradaException ex) {
        return new ResponseEntity<>("Veículo com placa já cadastrada: " + ex.getMessage(), HttpStatus.CONFLICT);
    }

    // Exceções específicas para Locação
    @ExceptionHandler(LocacaoNaoEncontradaException.class)
    public ResponseEntity<String> handleLocacaoNaoEncontradaException(LocacaoNaoEncontradaException ex) {
        logger.error("Locação não encontrada: {}", ex.getMessage());
        return new ResponseEntity<>("Locação não encontrada: " + ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(LocacaoJaFinalizadaException.class)
    public ResponseEntity<String> handleLocacaoJaFinalizadaException(LocacaoJaFinalizadaException ex) {
        return new ResponseEntity<>("Locação já finalizada: " + ex.getMessage(), HttpStatus.CONFLICT);
    }


    // Exceção genérica para erros inesperados
    @ExceptionHandler(Throwable.class)
    public ResponseEntity<String> handleUnexpectedException(Throwable unexpectedException) {
        var message = "Unexpected server error, see the logs.";
        logger.error(message, unexpectedException);
        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}