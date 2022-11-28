package com.HudLuca.TestTKM.resouce;

import com.HudLuca.TestTKM.domain.Cliente;
import com.HudLuca.TestTKM.domain.dto.ClienteDTO;
import com.HudLuca.TestTKM.domain.dto.ClienteNovoDTO;
import com.HudLuca.TestTKM.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
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

    @RequestMapping(path = "/page", method = RequestMethod.GET)
    public ResponseEntity<Page<ClienteDTO>> buscarPaginada(
            @RequestParam(value = "paginas", defaultValue = "0") Integer paginas,
            @RequestParam(value = "linhas", defaultValue = "24")Integer linhas,
            @RequestParam(value = "ordenacao", defaultValue = "nome")String ordenacao,
            @RequestParam(value = "direcaoOrdenacao", defaultValue = "ASC")String direcaoOrdenacao){
        Page<Cliente> clientes = clienteService.buscarPage(paginas, linhas, ordenacao, direcaoOrdenacao);
        Page<ClienteDTO> clientesDTO = clientes.map(x -> new ClienteDTO(x));

        return ResponseEntity.ok().body(clientesDTO);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> inserirCliente(@Valid @RequestBody ClienteNovoDTO clienteNovoDTO){
        Cliente cliente = clienteService.DTOParaCliente(clienteNovoDTO);

        cliente = clienteService.inserir(cliente);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
                buildAndExpand(cliente.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }
}
