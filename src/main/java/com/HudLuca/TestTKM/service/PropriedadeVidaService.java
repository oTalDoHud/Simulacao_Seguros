package com.HudLuca.TestTKM.service;

import com.HudLuca.TestTKM.domain.GerenciadorArquivo;
import com.HudLuca.TestTKM.domain.dto.PropriedadeVidaNovoDTO;
import com.HudLuca.TestTKM.domain.enums.TipoTrabalhoEnum;
import com.HudLuca.TestTKM.domain.enums.ValoAReceberSeguroVidaEnum;
import com.HudLuca.TestTKM.domain.propriedades.Automovel;
import com.HudLuca.TestTKM.domain.propriedades.PropriedadeVida;
import com.HudLuca.TestTKM.repositories.PropriedadeVidaRepository;
import com.HudLuca.TestTKM.service.exception.ObjetoNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.HudLuca.TestTKM.service.utils.StringUtils.getSTIdNaoEncontrado;

@Service
public class PropriedadeVidaService {

    @Autowired
    private PropriedadeVidaRepository repository;

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
        return repository.save(propriedadeVida);
    }

    public PropriedadeVida DTOparaPropriedadeVida(PropriedadeVidaNovoDTO propriedadeVidaNovoDTO) {
        PropriedadeVida propriedadeVida = new PropriedadeVida(
                ValoAReceberSeguroVidaEnum.toEnum(propriedadeVidaNovoDTO.getValorAReceber()),
                TipoTrabalhoEnum.toEnum(propriedadeVidaNovoDTO.getTrabalho())
        );

        List<GerenciadorArquivo> gerenciadorArquivoList = new ArrayList<>();

        for (Long x: propriedadeVidaNovoDTO.getAtestadoSaude()){
            gerenciadorArquivoList.add(gerenciadorArquivoService.buscarPorId(x));
        }
        
        propriedadeVida.getAtestadoDeSaude().addAll(gerenciadorArquivoList);

        List<Integer> consumoDrogasList = new ArrayList<>();

        for (Integer x: propriedadeVidaNovoDTO.getConsumoDrogas()){
            System.out.println(x);
            consumoDrogasList.add(x);
        }
        propriedadeVida.getConsumoDrogas().addAll(consumoDrogasList);

        System.out.println("\nSEGUNDO FOR ");
        for (Integer x : propriedadeVida.getConsumoDrogas()){
            System.out.println(x);
        }

        List<Integer> praticaEsportesRadicais = new ArrayList<>();

        for (Integer x: propriedadeVidaNovoDTO.getPraticaEsporteRadical()){
            praticaEsportesRadicais.add(x);
        }
        propriedadeVida.getConsumoDrogas().addAll(praticaEsportesRadicais);

        return propriedadeVida;
    }
}
