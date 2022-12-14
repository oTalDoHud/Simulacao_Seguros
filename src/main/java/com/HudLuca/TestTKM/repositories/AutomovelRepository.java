package com.HudLuca.TestTKM.repositories;

import com.HudLuca.TestTKM.domain.propriedades.Automovel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface AutomovelRepository extends JpaRepository<Automovel, Long> {

    @Transactional(readOnly=true)
    Automovel findByPlaca(String placa);
}
