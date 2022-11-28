package com.HudLuca.TestTKM.service;

import com.HudLuca.TestTKM.domain.Cliente;
import com.HudLuca.TestTKM.repositories.ClienteRepository;
import com.HudLuca.TestTKM.service.exception.ObjetoNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public List<Cliente> buscarTudo() {
        return clienteRepository.findAll();
    }

    public Page<Cliente> buscarPage(Integer paginas, Integer linhas, String ordenacao, String direcaoOrdenacao){
        PageRequest pageRequest = PageRequest.of(paginas,linhas, Sort.Direction.valueOf(direcaoOrdenacao), ordenacao);
        return clienteRepository.findAll(pageRequest);
    }
}
