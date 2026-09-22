package com.estudos.business.exception;

public class TransportadoraNaoEncontradaException extends RuntimeException{
    public TransportadoraNaoEncontradaException(Long id){
        super("Transportadora com id " + id + " não encontrada.");
    }
}
