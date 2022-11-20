package com.HudLuca.TestTKM.service;

import com.HudLuca.TestTKM.domain.Automovel;
import com.HudLuca.TestTKM.domain.enums.TempoHabilitacao;
import com.HudLuca.TestTKM.repositories.PropriedadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Service
public class DBservice {

    @Autowired
    private PropriedadeRepository propriedadeRepository;
    public void instanciandoBancoDeDados() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Automovel automovel1 = new Automovel("Seguro Hudson", 35000.00, 1,
                "JDZ-6416", "Civic 2017", sdf.parse("12/03/2018"),
                2, "m", 40000.00, TempoHabilitacao.MEDIANO);

        propriedadeRepository.save(automovel1);
    }
}
