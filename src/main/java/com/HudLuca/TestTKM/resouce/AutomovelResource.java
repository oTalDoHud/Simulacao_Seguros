package com.HudLuca.TestTKM.resouce;

import com.HudLuca.TestTKM.domain.Automovel;
import com.HudLuca.TestTKM.service.AutomovelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/automovel")
public class AutomovelResource {

    @Autowired
    private AutomovelService service;

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Automovel> buscarPorId(@PathVariable Long id){
        Automovel automovel = service.buscarPorId(id);
        return ResponseEntity.ok().body(automovel);
    }
}
