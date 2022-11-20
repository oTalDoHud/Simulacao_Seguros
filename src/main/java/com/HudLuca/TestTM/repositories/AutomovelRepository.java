package com.HudLuca.TestTM.repositories;

import com.HudLuca.TestTM.domain.Automovel;
import com.HudLuca.TestTM.domain.Propriedade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutomovelRepository extends JpaRepository<Automovel, Long> {

}
