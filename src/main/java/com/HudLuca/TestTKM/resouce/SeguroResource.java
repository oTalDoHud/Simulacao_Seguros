package com.HudLuca.TestTKM.resouce;

import com.HudLuca.TestTKM.domain.Seguro;
import com.HudLuca.TestTKM.domain.dto.SeguroCategoriaDTO;
import com.HudLuca.TestTKM.domain.dto.SeguroNovoDTO;
import com.HudLuca.TestTKM.service.SeguroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/seguros")
public class SeguroResource {

    @Autowired
    private SeguroService service;

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Seguro> buscarPorId(@PathVariable Long id) {
        Seguro seguro = service.buscarPorId(id);
        return ResponseEntity.ok().body(seguro);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> inserirSeguro(@Valid @RequestBody SeguroNovoDTO seguroNovoDTO) {
        Seguro seguro = service.DTOParaSeguro(seguroNovoDTO);

        seguro = service.inserir(seguro);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
                buildAndExpand(seguro.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> atualizarSeguro(@Valid @RequestBody SeguroCategoriaDTO seguroCategoriaDTO, @PathVariable Long id) {
        Seguro seguro = service.DTOParaSeguro(seguroCategoriaDTO, id);
        seguro.setId(id);
        service.atualizar(seguro);
        return ResponseEntity.noContent().build();
    }
}
