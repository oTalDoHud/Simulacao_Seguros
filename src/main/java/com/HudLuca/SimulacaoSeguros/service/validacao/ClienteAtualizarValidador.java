package com.HudLuca.SimulacaoSeguros.service.validacao;

import com.HudLuca.SimulacaoSeguros.domain.Cliente;
import com.HudLuca.SimulacaoSeguros.domain.dto.ClienteDTO;
import com.HudLuca.SimulacaoSeguros.repositories.ClienteRepository;
import com.HudLuca.SimulacaoSeguros.resouce.exception.CampoMenssagemErro;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class ClienteAtualizarValidador implements ConstraintValidator<ClienteAtualizar, ClienteDTO> {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private HttpServletRequest servletRequest;

    @Override
    public void initialize(ClienteAtualizar clienteAtualizar) {
    }

    @Override
    public boolean isValid(ClienteDTO clienteDTO, ConstraintValidatorContext context) {
        List<CampoMenssagemErro> list = new ArrayList<>();

        Cliente clienteAux = clienteRepository.findByEmail(clienteDTO.getEmail());

        if (clienteAux != null && !clienteAux.getId().equals(clienteDTO.getId())) {
            list.add(new CampoMenssagemErro("email", "E-mail já existente"));
        }

        for (CampoMenssagemErro e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMenssagem())
                    .addPropertyNode(e.getCampo()).addConstraintViolation();
        }
        return list.isEmpty();
    }
}