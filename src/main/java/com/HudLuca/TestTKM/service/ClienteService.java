package com.HudLuca.TestTKM.service;

import com.HudLuca.TestTKM.domain.Cliente;
import com.HudLuca.TestTKM.repositories.ClienteRepository;
import com.HudLuca.TestTKM.service.exception.ObjetoNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente buscarPorId(Long id){
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.orElseThrow(() -> new ObjetoNaoEncontradoException(
                "Cliente não encontrada! id: " + id + ". Tipo: " + Cliente.class
        ));
    }
}
