package com.HudLuca.SimulacaoSeguros.repositories;

import com.HudLuca.SimulacaoSeguros.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Transactional(readOnly=true)
    Cliente findByEmail(String email);

}
