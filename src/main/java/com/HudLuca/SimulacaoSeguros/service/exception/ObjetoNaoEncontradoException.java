package com.HudLuca.SimulacaoSeguros.service.exception;

public class ObjetoNaoEncontradoException extends RuntimeException{

    public ObjetoNaoEncontradoException(String menssagem) {
        super(menssagem);
    }

    public ObjetoNaoEncontradoException(String menssagem, Throwable cause) {
        super(menssagem, cause);
    }
}
