package com.HudLuca.TestTKM.service;

import com.HudLuca.TestTKM.domain.dto.AutomovelNovoDTO;
import com.HudLuca.TestTKM.domain.enums.TempoHabilitacao;
import com.HudLuca.TestTKM.domain.propriedades.Automovel;
import com.HudLuca.TestTKM.repositories.AutomovelRepository;
import com.HudLuca.TestTKM.service.exception.ObjetoNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public Automovel inserir(Automovel automovel){
        automovel.setId(null);
        Automovel automovelNovo = repository.save(automovel);
        return automovelNovo;
    }

    public Automovel DTOparaAutomovel(AutomovelNovoDTO dto){

        Integer periciaMotorista = CalcularPericiaHabilitado(dto.getTempoHabilitacaoProprietario(), dto.getSexoProprietarioAtual());

        return new Automovel(dto.getValor(), dto.getQuantidade(), dto.getPlaca(), dto.getModelo(),
                dto.getMarca(), dto.getAnoFabricacao(), dto.getQuantidadeDeProprietarios(),
                dto.getSexoProprietarioAtual(), dto.getQuilometragem(), TempoHabilitacao.toEnum(periciaMotorista));
    }

    private Integer CalcularPericiaHabilitado(Integer tempoHabilitacaoProprietario, String sexoProprietarioAtual) {

        if(tempoHabilitacaoProprietario != null && sexoProprietarioAtual != null){
            if ("mulher".equals(sexoProprietarioAtual.toLowerCase())){
                if (tempoHabilitacaoProprietario <= 4){
                    return TempoHabilitacao.NOVATO.getCd();
                }else if(tempoHabilitacaoProprietario <= 9){
                    return TempoHabilitacao.MEDIANO.getCd();
                }else {
                    return TempoHabilitacao.EXPERIENTE.getCd();
                }
            } else if ("homem".equals(sexoProprietarioAtual.toLowerCase())) {
                if (tempoHabilitacaoProprietario <= 5){
                    return TempoHabilitacao.NOVATO.getCd();
                }else if(tempoHabilitacaoProprietario <= 10){
                    return TempoHabilitacao.MEDIANO.getCd();
                }else {
                    return TempoHabilitacao.EXPERIENTE.getCd();
                }
            }
        }
        throw new IllegalArgumentException("Sexo ou tempo de experiência dirigindo está nulo");
    }
}
