package com.HudLuca.TestTKM.service;

import com.HudLuca.TestTKM.domain.propriedades.Automovel;
import com.HudLuca.TestTKM.repositories.AutomovelRepository;
import com.HudLuca.TestTKM.service.exception.ObjetoNaoEncontradoException;
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
