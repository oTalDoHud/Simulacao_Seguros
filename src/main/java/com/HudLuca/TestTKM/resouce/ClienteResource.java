package com.HudLuca.TestTKM.resouce;

import com.HudLuca.TestTKM.domain.Cliente;
import com.HudLuca.TestTKM.domain.dto.ClienteDTO;
import com.HudLuca.TestTKM.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {

    @Autowired
    private ClienteService clienteService;

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> buscarPorId(@PathVariable Long id){
        Cliente cliente = clienteService.buscarPorId(id);
        return ResponseEntity.ok().body(cliente);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<ClienteDTO>> buscarTudo(){
        List<Cliente> clientes = clienteService.buscarTudo();
        List<ClienteDTO> clientesDTO = new ArrayList<>();

        for (Cliente x: clientes){
            clientesDTO.add(new ClienteDTO(x));
        }

        return ResponseEntity.ok().body(clientesDTO);
    }
}
