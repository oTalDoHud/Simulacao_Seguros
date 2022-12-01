package com.HudLuca.TestTKM.service;

import com.HudLuca.TestTKM.domain.propriedades.Automovel;
import com.HudLuca.TestTKM.repositories.AutomovelRepository;
import com.HudLuca.TestTKM.service.exception.ObjetoNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.HudLuca.TestTKM.service.utils.StringUtils.getSTIdNaoEncontrado;

@Service
public class AutomovelService {

    @Autowired
    private AutomovelRepository repository;

    public Automovel buscarPorId(Long id) {
        Optional<Automovel> automovel = repository.findById(id);
        return automovel.orElseThrow(() -> new ObjetoNaoEncontradoException(
                getSTIdNaoEncontrado("Automóvel", "o", id, Automovel.class.getSimpleName())
        ));
    }
}
