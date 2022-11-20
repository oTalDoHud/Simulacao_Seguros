package com.HudLuca.TestTM.service;

import com.HudLuca.TestTM.domain.Automovel;
import com.HudLuca.TestTM.domain.Propriedade;
import com.HudLuca.TestTM.repositories.AutomovelRepository;
import com.HudLuca.TestTM.repositories.PropriedadeRepository;
import com.HudLuca.TestTM.service.exception.ObjetoNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AutomovelService {

    @Autowired
    private AutomovelRepository repository;

    public Automovel buscarPorId(Long id) {
        Optional<Automovel> produto = repository.findById(id);
        return produto.orElseThrow(() -> new ObjetoNaoEncontradoException(
                "Automóvel não encontrada! id: " + id + ". Tipo: " + Automovel.class
        ));
    }
}
