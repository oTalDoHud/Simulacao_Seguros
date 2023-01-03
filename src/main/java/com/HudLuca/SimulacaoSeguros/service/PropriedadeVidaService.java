package com.HudLuca.SimulacaoSeguros.service;

import com.HudLuca.SimulacaoSeguros.domain.GerenciadorArquivo;
import com.HudLuca.SimulacaoSeguros.domain.dto.PropriedadeVidaNovoDTO;
import com.HudLuca.SimulacaoSeguros.domain.enums.ConsumoDrogasEnum;
import com.HudLuca.SimulacaoSeguros.domain.enums.TipoTrabalhoEnum;
import com.HudLuca.SimulacaoSeguros.domain.enums.ValoAReceberSeguroVidaEnum;
import com.HudLuca.SimulacaoSeguros.domain.propriedades.PropriedadeVida;
import com.HudLuca.SimulacaoSeguros.repositories.GerenciadorArquivoRepository;
import com.HudLuca.SimulacaoSeguros.repositories.PropriedadeVidaRepository;
import com.HudLuca.SimulacaoSeguros.service.exception.ObjetoNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import static com.HudLuca.SimulacaoSeguros.service.utils.StringUtils.getSTIdNaoEncontrado;

@Service
public class PropriedadeVidaService {

    @Autowired
    private PropriedadeVidaRepository repository;
    @Autowired
    private GerenciadorArquivoRepository gerenciadorArquivoRepository;
    @Autowired
    private GerenciadorArquivoService gerenciadorArquivoService;

    public PropriedadeVida buscarPorId(Long id) {
        Optional<PropriedadeVida> propriedadeVida = repository.findById(id);
        return propriedadeVida.orElseThrow(() -> new ObjetoNaoEncontradoException(
                getSTIdNaoEncontrado("Propriedade vida", "a", id, PropriedadeVida.class.getSimpleName())
        ));
    }

    @Transactional
    public PropriedadeVida inserir(PropriedadeVida propriedadeVida) {
        propriedadeVida.setId(null);
        PropriedadeVida propriedadeVidaSave = repository.save(propriedadeVida);
        gerenciadorArquivoRepository.saveAll(propriedadeVidaSave.getAtestadoDeSaude());
        return propriedadeVidaSave;
    }

    public PropriedadeVida DTOparaPropriedadeVida(PropriedadeVidaNovoDTO propriedadeVidaNovoDTO) {
        PropriedadeVida propriedadeVida = new PropriedadeVida(
                ValoAReceberSeguroVidaEnum.toEnum(propriedadeVidaNovoDTO.getValorAReceber()),
                TipoTrabalhoEnum.toEnum(propriedadeVidaNovoDTO.getTrabalho())
        );

        List<GerenciadorArquivo> gerenciadorArquivoList = new ArrayList<>();

        for (Long x : propriedadeVidaNovoDTO.getAtestadoSaude()) {
            GerenciadorArquivo gerenciadorArquivo = gerenciadorArquivoService.buscarPorId(x);

            if (gerenciadorArquivo.getPropriedadeVida() != null) {
                throw new IllegalArgumentException("O atestado já está associado a uma vida. Escolhe ou registre outro.");
            }

            gerenciadorArquivoList.add(gerenciadorArquivo);

        }

        for (GerenciadorArquivo x : gerenciadorArquivoList) {
            x.setPropriedadeVida(propriedadeVida);
        }

        propriedadeVida.getAtestadoDeSaude().addAll(gerenciadorArquivoList);

        Set<Integer> consumoDrogasList = new HashSet<>();

        for (Integer x : propriedadeVidaNovoDTO.getConsumoDrogas()) {
            consumoDrogasList.add(x);
        }
        verificarSeConsumoDrogas(propriedadeVidaNovoDTO.getConsumoDrogas());

        propriedadeVida.getConsumoDrogas().addAll(consumoDrogasList);

        List<Integer> praticaEsportesRadicais = new ArrayList<>();

        for (Integer x : propriedadeVidaNovoDTO.getPraticaEsporteRadical()) {
            praticaEsportesRadicais.add(x);
        }
        propriedadeVida.getPraticaEsportesRadicais().addAll(praticaEsportesRadicais);

        return propriedadeVida;
    }

    private void verificarSeConsumoDrogas(Set<Integer> consumoDrogas) {

        boolean naoConsomeDrogas = false;

        for (Integer x : consumoDrogas) {
            if (x.equals(ConsumoDrogasEnum.NAO_CONSOME.getCd())) {
                naoConsomeDrogas = true;
            }
        }

        for (Integer x : consumoDrogas) {
            if (naoConsomeDrogas) {
                if (!x.equals(ConsumoDrogasEnum.NAO_CONSOME.getCd())) {
                    throw new IllegalArgumentException("A lista de drogas consumidas não pode contar \"Não consome\" seguido por alguma droga consumida.");
                }
            }
        }
    }
}
