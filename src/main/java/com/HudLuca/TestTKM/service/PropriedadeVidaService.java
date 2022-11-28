package com.HudLuca.TestTKM.service;

import com.HudLuca.TestTKM.domain.propriedades.PropriedadeVida;
import com.HudLuca.TestTKM.repositories.PropriedadeVidaRepository;
import com.HudLuca.TestTKM.service.exception.ObjetoNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PropriedadeVidaService {

    @Autowired
    private PropriedadeVidaRepository repository;

    public PropriedadeVida buscarPorId(Long id) {
        Optional<PropriedadeVida> propriedadeVida = repository.findById(id);
        return propriedadeVida.orElseThrow(() -> new ObjetoNaoEncontradoException(
                "Propriedade Vida não encontrada! id: " + id + ". Tipo: " + PropriedadeVida.class
        ));
    }
}
