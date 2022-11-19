package com.HudLuca.TestTM.config;

import com.HudLuca.TestTM.service.DBservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.text.ParseException;

@Configuration
@Profile("teste")
public class testConfig {

    @Autowired
    private DBservice dBservice;

    @Bean
    public boolean instanciandoBancoDeDados() throws ParseException {
        dBservice.instanciandoBancoDeDados();
        return true;
    }
}
