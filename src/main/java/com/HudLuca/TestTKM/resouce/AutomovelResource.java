package com.HudLuca.TestTKM.resouce;

import com.HudLuca.TestTKM.domain.dto.AutomovelNovoDTO;
import com.HudLuca.TestTKM.domain.propriedades.Automovel;
import com.HudLuca.TestTKM.service.AutomovelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/automoveis")
public class AutomovelResource {

    @Autowired
    private AutomovelService service;

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Automovel> buscarPorId(@PathVariable Long id){
        Automovel automovel = service.buscarPorId(id);
        return ResponseEntity.ok().body(automovel);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> inserirAutomovel(@Valid @RequestBody AutomovelNovoDTO automovelNovoDTO){
        Automovel automovel = service.DTOparaAutomovel(automovelNovoDTO );

        automovel = service.inserir(automovel);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
                buildAndExpand(automovel.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }
}
