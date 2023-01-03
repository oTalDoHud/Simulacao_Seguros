package com.HudLuca.SimulacaoSeguros.resouce.exception;

import java.io.Serializable;

public class CampoMenssagemErro implements Serializable {
    private static final long serialVersionUID = 1L;

    private String campo;
    private String menssagem;

    public CampoMenssagemErro() {
    }

    public CampoMenssagemErro(String campo, String menssagem) {
        this.campo = campo;
        this.menssagem = menssagem;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public String getMenssagem() {
        return menssagem;
    }

    public void setMenssagem(String menssagem) {
        this.menssagem = menssagem;
    }
}
