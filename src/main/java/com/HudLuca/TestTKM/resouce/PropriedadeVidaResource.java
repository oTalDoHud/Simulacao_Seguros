package com.HudLuca.TestTKM.resouce;

import com.HudLuca.TestTKM.domain.dto.PropriedadeVidaNovoDTO;
import com.HudLuca.TestTKM.domain.propriedades.PropriedadeVida;
import com.HudLuca.TestTKM.service.PropriedadeVidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/vidas")
public class PropriedadeVidaResource {

    @Autowired
    private PropriedadeVidaService service;

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<PropriedadeVida> buscarPorId(@PathVariable Long id){
        PropriedadeVida propriedadeVida = service.buscarPorId(id);
        return ResponseEntity.ok().body(propriedadeVida);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> inserirPropriedadeVida(@Valid @RequestBody PropriedadeVidaNovoDTO propriedadeVidaNovoDTO){
        PropriedadeVida propriedadeVida = service.DTOparaPropriedadeVida(propriedadeVidaNovoDTO );

        propriedadeVida = service.inserir(propriedadeVida);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
                buildAndExpand(propriedadeVida.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }
}
