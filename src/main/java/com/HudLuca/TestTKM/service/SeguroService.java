package com.HudLuca.TestTKM.service;

import com.HudLuca.TestTKM.domain.*;
import com.HudLuca.TestTKM.domain.Seguro;
import com.HudLuca.TestTKM.domain.dto.SeguroNovoDTO;
import com.HudLuca.TestTKM.domain.enums.CoberturasAutomovelEnum;
import com.HudLuca.TestTKM.domain.enums.SexoClienteEnum;
import com.HudLuca.TestTKM.domain.enums.TempoHabilitacaoEnum;
import com.HudLuca.TestTKM.domain.propriedades.Automovel;
import com.HudLuca.TestTKM.domain.propriedades.Propriedade;
import com.HudLuca.TestTKM.repositories.SeguroRepository;
import com.HudLuca.TestTKM.service.exception.ObjetoNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static com.HudLuca.TestTKM.service.utils.StringUtils.getSTIdNaoEncontrado;

@Service
public class SeguroService {

    @Autowired
    private SeguroRepository repository;
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private PropriedadeService propriedadeService;

    public Seguro buscarPorId(Long id) {
        Optional<Seguro> seguro = repository.findById(id);
        return seguro.orElseThrow(() -> new ObjetoNaoEncontradoException(
                getSTIdNaoEncontrado("Seguro", "o", id, Seguro.class.getSimpleName())
        ));
    }

    @Transactional
    public Seguro inserir(Seguro seguro) {
        seguro.setId(null);
        Seguro seguroNovo = repository.save(seguro);
        return seguroNovo;
    }

    public Seguro DTOParaSeguro(SeguroNovoDTO seguroNovoDTO) {
        Cliente cliente = clienteService.buscarPorId(seguroNovoDTO.getCliente());
        Propriedade propriedade = propriedadeService.buscarPorId(seguroNovoDTO.getPropriedade());

        Double valorAnual = calcularValorAnual(propriedade, cliente, seguroNovoDTO);
        Seguro seguro = new Seguro(seguroNovoDTO.getTituloSeguro(), valorAnual, cliente, propriedade);
        cliente.getSeguros().add(seguro);

        for (Integer x : seguroNovoDTO.getCoberturas()) {
            seguro.addCoberturas(x);
        }

        return seguro;
    }

    private Double calcularValorAnual(Propriedade propriedade, Cliente cliente, SeguroNovoDTO seguroNovoDTO) {

        Double valorAnual = null;

        if (propriedade instanceof Automovel) {
            valorAnual = propriedade.getValorDaPropriedade() * 0.04;
            valorAnual = calcularAcrescimentoPorSexo(cliente.getSexo(), valorAnual);
            valorAnual = calcularAcrescimentoPorTempoHabilitacao(((Automovel) propriedade).getTempoHabilitacaoProprietario(), valorAnual);
            valorAnual = calcularAcrescimentoPorCobertura(seguroNovoDTO.getCoberturas(), valorAnual);
        }

        return valorAnual;
    }

    private Double calcularAcrescimentoPorCobertura(List<Integer> coberturas, Double valorAnual) {
        for (Integer x : coberturas) {

            switch (CoberturasAutomovelEnum.toEnum(x)) {
                case INCENDIO:
                    valorAnual += valorAnual * 0.18;
                    break;
                case DESASTRE_NATURAL:
                    valorAnual += valorAnual * 0.09;
                    break;
                case ACIDENTE:
                    valorAnual += valorAnual * 0.12;
                    break;
                case ROUBO:
                    valorAnual += valorAnual * 0.15;
                    break;
                case REBOQUE:
                    valorAnual += 264.00;
                    break;
                case TERCEIROS_DIRIGINDO:
                    valorAnual += valorAnual * 0.1;
                    break;
            }
        }
        return valorAnual;
    }

    private Double calcularAcrescimentoPorTempoHabilitacao(TempoHabilitacaoEnum tempoHabilitacaoProprietario, Double valorAnual) {
        switch (tempoHabilitacaoProprietario) {
            case NOVATO:
                valorAnual += valorAnual * 0.09;
                break;
            case MEDIANO:
                valorAnual += valorAnual * 0.07;
                break;
            case EXPERIENTE:
                valorAnual += valorAnual * 0.03;
                break;
            case INDEFERIDO:
                throw new IllegalArgumentException("O tempo de experiência não pode ser indeferido");
        }
        return valorAnual;
    }

    private Double calcularAcrescimentoPorSexo(SexoClienteEnum sexo, Double valorAnual) {
        switch (sexo) {
            case MASCULINO:
                valorAnual += valorAnual * 0.05;
                break;
            case FEMININO:
                valorAnual += valorAnual * 0.04;
                break;
            case NAO_DEFINIDO:
                valorAnual += valorAnual * 0.06;
                break;
            default:
                throw new IllegalArgumentException("Sexo do cliente está vazio");
        }

        return valorAnual;
    }
}
