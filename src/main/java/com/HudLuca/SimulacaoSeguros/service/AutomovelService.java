package com.HudLuca.SimulacaoSeguros.service;

import com.HudLuca.SimulacaoSeguros.domain.dto.AutomovelNovoDTO;
import com.HudLuca.SimulacaoSeguros.domain.enums.TempoHabilitacaoEnum;
import com.HudLuca.SimulacaoSeguros.domain.propriedades.Automovel;
import com.HudLuca.SimulacaoSeguros.repositories.AutomovelRepository;
import com.HudLuca.SimulacaoSeguros.service.exception.ObjetoNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static com.HudLuca.SimulacaoSeguros.service.utils.StringUtils.getSTIdNaoEncontrado;

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

    @Transactional
    public Automovel inserir(Automovel automovel){
        automovel.setId(null);
        Automovel automovelNovo = repository.save(automovel);
        return automovelNovo;
    }

    public Automovel DTOparaAutomovel(AutomovelNovoDTO dto){

        return new Automovel(dto.getValor(), dto.getQuantidade(), dto.getPlaca(), dto.getModelo(),
                dto.getMarca(), dto.getAnoFabricacao(), dto.getQuantidadeDeProprietarios(),
                dto.getQuilometragem(), TempoHabilitacaoEnum.toEnum(4));
    }
}
