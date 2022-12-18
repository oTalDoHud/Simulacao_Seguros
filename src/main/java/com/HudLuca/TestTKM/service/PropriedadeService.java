package com.HudLuca.TestTKM.service;

import com.HudLuca.TestTKM.domain.propriedades.Propriedade;
import com.HudLuca.TestTKM.repositories.PropriedadeRepository;
import com.HudLuca.TestTKM.service.exception.ObjetoNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.HudLuca.TestTKM.service.utils.StringUtils.getSTIdNaoEncontrado;

@Service
public class PropriedadeService {

    @Autowired
    private PropriedadeRepository propriedadeRepository;

    public Propriedade buscarPorId(Long id) {
        Optional<Propriedade> propriedade = propriedadeRepository.findById(id);
        return propriedade.orElseThrow(() -> new ObjetoNaoEncontradoException(
                getSTIdNaoEncontrado("Propriedade", "", id, Propriedade.class.getSimpleName())
        ));
    }
}
