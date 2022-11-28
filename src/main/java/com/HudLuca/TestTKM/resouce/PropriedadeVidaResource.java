package com.HudLuca.TestTKM.resouce;

import com.HudLuca.TestTKM.domain.propriedades.PropriedadeVida;
import com.HudLuca.TestTKM.service.PropriedadeVidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/vida")
public class PropriedadeVidaResource {

    @Autowired
    private PropriedadeVidaService service;

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<PropriedadeVida> buscarPorId(@PathVariable Long id){
        PropriedadeVida propriedadeVida = service.buscarPorId(id);
        return ResponseEntity.ok().body(propriedadeVida);
    }
}
