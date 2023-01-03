package com.HudLuca.SimulacaoSeguros.service.validacao;

import com.HudLuca.SimulacaoSeguros.domain.dto.AutomovelNovoDTO;
import com.HudLuca.SimulacaoSeguros.domain.propriedades.Automovel;
import com.HudLuca.SimulacaoSeguros.repositories.AutomovelRepository;
import com.HudLuca.SimulacaoSeguros.resouce.exception.CampoMenssagemErro;
import com.HudLuca.SimulacaoSeguros.service.validacao.utils.BR;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class AutomovelInserirValidador implements ConstraintValidator<AutomovelInserir, AutomovelNovoDTO> {

    @Autowired
    private AutomovelRepository automovelRepository;

    @Override
    public void initialize(AutomovelInserir automovelInserir) {
    }

    @Override
    public boolean isValid(AutomovelNovoDTO automovelNovoDTO, ConstraintValidatorContext context) {
        List<CampoMenssagemErro> list = new ArrayList<>();

        if (automovelNovoDTO.getPlaca() != null && !BR.isValidPlaca(automovelNovoDTO.getPlaca())) {
            list.add(new CampoMenssagemErro("placa", "Placa invalida"));
        }

        Automovel automovelComMesmaPlaca = automovelRepository.findByPlaca(automovelNovoDTO.getPlaca());

        if (automovelComMesmaPlaca != null) {
            list.add(new CampoMenssagemErro("placa", "Placa já existe"));
        }

        return list.isEmpty();
    }
}