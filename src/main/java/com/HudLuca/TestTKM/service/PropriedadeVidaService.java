package com.HudLuca.TestTKM.service;

import com.HudLuca.TestTKM.domain.propriedades.PropriedadeVida;
import com.HudLuca.TestTKM.repositories.PropriedadeVidaRepository;
import com.HudLuca.TestTKM.service.exception.ObjetoNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.HudLuca.TestTKM.service.utils.StringUtils.getSTIdNaoEncontrado;

@Service
public class PropriedadeVidaService {

    @Autowired
    private PropriedadeVidaRepository repository;

    public PropriedadeVida buscarPorId(Long id) {
        Optional<PropriedadeVida> propriedadeVida = repository.findById(id);
        return propriedadeVida.orElseThrow(() -> new ObjetoNaoEncontradoException(
                getSTIdNaoEncontrado("Propriedade vida","a", id, PropriedadeVida.class.getSimpleName())
        ));
    }
}
