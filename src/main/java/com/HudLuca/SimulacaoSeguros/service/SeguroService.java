package com.HudLuca.SimulacaoSeguros.service;

import com.HudLuca.SimulacaoSeguros.domain.*;
import com.HudLuca.SimulacaoSeguros.domain.Seguro;
import com.HudLuca.SimulacaoSeguros.domain.dto.SeguroCategoriaDTO;
import com.HudLuca.SimulacaoSeguros.domain.dto.SeguroNovoDTO;
import com.HudLuca.SimulacaoSeguros.domain.enums.*;
import com.HudLuca.SimulacaoSeguros.domain.propriedades.Automovel;
import com.HudLuca.SimulacaoSeguros.domain.propriedades.Propriedade;
import com.HudLuca.SimulacaoSeguros.domain.propriedades.PropriedadeVida;
import com.HudLuca.SimulacaoSeguros.repositories.SeguroRepository;
import com.HudLuca.SimulacaoSeguros.service.exception.ObjetoNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static com.HudLuca.SimulacaoSeguros.service.utils.StringUtils.getSTIdNaoEncontrado;

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

    @Transactional
    public Seguro atualizar(Seguro seguro) {
        Seguro seguroNovo = repository.save(seguro);
        return seguroNovo;
    }

    public Seguro DTOParaSeguro(SeguroNovoDTO seguroNovoDTO) {
        Cliente cliente = clienteService.buscarPorId(seguroNovoDTO.getCliente());
        Propriedade propriedade = propriedadeService.buscarPorId(seguroNovoDTO.getPropriedade());

        Double valorAnual = calcularValorAnual(propriedade, cliente, seguroNovoDTO.getCoberturas());
        Seguro seguro = new Seguro(seguroNovoDTO.getTituloSeguro(), valorAnual, cliente, propriedade);
        cliente.getSeguros().add(seguro);

        for (Integer x : seguroNovoDTO.getCoberturas()) {
            seguro.addCoberturas(x);
        }

        return seguro;
    }

    public Seguro DTOParaSeguro(SeguroCategoriaDTO seguroCategoriaDTO, Long id) {
        Seguro seguro = buscarPorId(id);

        Cliente cliente = clienteService.buscarPorId(seguro.getCliente().getId());
        Propriedade propriedade = propriedadeService.buscarPorId(seguro.getPropriedade().getId());

        Double valorAnual = calcularValorAnual(propriedade, cliente, seguroCategoriaDTO.getCoberturas());
        seguro = new Seguro(seguro.getTituloSeguro(), valorAnual, cliente, propriedade);
        seguro.getCoberturas().clear();

        for (Integer x : seguroCategoriaDTO.getCoberturas()) {
            seguro.addCoberturas(x);
        }

        return seguro;
    }

    private Double calcularValorAnual(Propriedade propriedade, Cliente cliente, List<Integer> coberturas) {

        Double valorAnual = null;

        if (propriedade instanceof Automovel) {
            valorAnual = propriedade.getValorDaPropriedade() * 0.04;
            valorAnual = calcularAcrescimentoPorSexo(cliente.getSexo(), valorAnual);
            valorAnual = calcularAcrescimentoPorTempoHabilitacao(((Automovel) propriedade).getTempoHabilitacaoProprietario(), valorAnual);
            valorAnual = calcularAcrescimentoPorCoberturaAutomovel(coberturas, valorAnual);
        } else if (propriedade instanceof PropriedadeVida) {
            valorAnual = ((PropriedadeVida) propriedade).getValorAReceber().getValorAReceber() * 0.04;
            valorAnual = calcularDecrescimoPorConsumoDrogas(((PropriedadeVida) propriedade).getConsumoDrogas(), valorAnual);
            valorAnual = calcularAcrescimentoPorTrabalho(((PropriedadeVida) propriedade).getTrabalho(), valorAnual);
        }

        return valorAnual;
    }

    private Double calcularAcrescimentoPorTrabalho(TipoTrabalhoEnum trabalho, Double valorAnual) {
        switch (trabalho) {
            case TRABALHO_INSALUBRE:
                valorAnual -= valorAnual * 0.4;
                break;
            case TRABALHO_COM_ESFORCO_FISICO:
                valorAnual -= valorAnual * 0.3;
                break;
            case TRABALHO_SEM_ESFORCO_FISICO:
                valorAnual += valorAnual * 0.1;
                break;
        }

        return valorAnual;
    }

    private Double calcularDecrescimoPorConsumoDrogas(Set<Integer> consumoDrogas, Double valorAnual) {
        for (Integer x : consumoDrogas) {
            switch (ConsumoDrogasEnum.toEnum(x)) {
                case NAO_CONSOME:
                    valorAnual += valorAnual * 0.2;
                    break;
                case ALCOOL:
                    valorAnual -= valorAnual * 0.5;
                    break;
                case MACONHA:
                    valorAnual -= valorAnual * 0.1;
                    break;
                case MEDICAMENTOS_NAO_PRESCRITOS:
                    valorAnual -= valorAnual * 0.4;
                    break;
                case MEDICAMENTOS_RECORRENTES:
                    valorAnual -= valorAnual * 0.4;
                    break;
                case HEROINA:
                    valorAnual -= valorAnual * 0.4;
                    break;
                case COCAINA:
                    valorAnual -= valorAnual * 0.4;
                    break;
                case CRACK:
                    valorAnual -= valorAnual * 0.4;
                    break;

            }
        }

        return valorAnual;
    }

    private Double calcularAcrescimentoPorCoberturaAutomovel(List<Integer> coberturas, Double valorAnual) {
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
