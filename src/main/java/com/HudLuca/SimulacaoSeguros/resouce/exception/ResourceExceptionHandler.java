package com.HudLuca.SimulacaoSeguros.resouce.exception;


import com.HudLuca.SimulacaoSeguros.service.exception.ObjetoNaoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ErroPadrao> ObjetoNaoEncontrado(ObjetoNaoEncontradoException e, HttpServletRequest request){
        ErroPadrao err = new ErroPadrao(HttpStatus.NOT_FOUND.value()
                , e.getMessage()
                , System.currentTimeMillis());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }
}
