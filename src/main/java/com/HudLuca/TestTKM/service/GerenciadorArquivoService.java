package com.HudLuca.TestTKM.service;

import com.HudLuca.TestTKM.domain.GerenciadorArquivo;
import com.HudLuca.TestTKM.repositories.GerenciadorArquivoRepository;
import com.HudLuca.TestTKM.service.exception.ObjetoNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.HudLuca.TestTKM.service.utils.StringUtils.getSTIdNaoEncontrado;

@Service
public class GerenciadorArquivoService {

    @Autowired
    private GerenciadorArquivoRepository repository;

    public GerenciadorArquivo buscarPorId(Long id) {
        Optional<GerenciadorArquivo> gerenciadorArquivo = repository.findById(id);

        return gerenciadorArquivo.orElseThrow(() -> new ObjetoNaoEncontradoException(
                getSTIdNaoEncontrado("Gerenciador de arquivos", "", id, GerenciadorArquivo.class.getSimpleName())
        ));
    }
}
