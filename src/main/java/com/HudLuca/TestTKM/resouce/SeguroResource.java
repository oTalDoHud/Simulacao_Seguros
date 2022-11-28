package com.HudLuca.TestTKM.resouce;

import com.HudLuca.TestTKM.domain.Seguro;
import com.HudLuca.TestTKM.service.SeguroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/seguros")
public class SeguroResource {

    @Autowired
    private SeguroService service;

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Seguro> buscarPorId(@PathVariable Long id){
        Seguro seguro = service.buscarPorId(id);
        return ResponseEntity.ok().body(seguro);
    }
}
