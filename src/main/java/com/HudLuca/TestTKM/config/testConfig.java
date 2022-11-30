package com.HudLuca.TestTKM.config;

import com.HudLuca.TestTKM.service.DBservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.text.ParseException;

@Configuration
@Profile("test")
public class testConfig {

    @Autowired
    private DBservice dBservice;

    @Bean
    public boolean instanciandoBancoDeDados() throws ParseException {
        dBservice.instanciandoBancoDeDados();
        return true;
    }
}
