package com.HudLuca.TestTKM.service;

import com.HudLuca.TestTKM.domain.Seguro;
import com.HudLuca.TestTKM.repositories.SeguroRepository;
import com.HudLuca.TestTKM.service.exception.ObjetoNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SeguroService {

    @Autowired
    private SeguroRepository repository;

    public Seguro buscarPorId(Long id) {
        Optional<Seguro> seguro = repository.findById(id);
        return seguro.orElseThrow(() -> new ObjetoNaoEncontradoException(
                "Seguro não encontrada! id: " + id + ". Tipo: " + Seguro.class
        ));
    }
}
