package com.HudLuca.TestTM.domain;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;


public class SeguroDeVida extends Propriedade{

    public SeguroDeVida(String nome, double valor, int quantidade) {
        super(nome, valor, quantidade);
    }

    @Override
    public void valorAnual() {

    }
}
