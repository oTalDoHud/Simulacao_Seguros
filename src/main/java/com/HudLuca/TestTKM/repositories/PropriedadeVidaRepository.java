package com.HudLuca.TestTKM.repositories;

import com.HudLuca.TestTKM.domain.propriedades.Automovel;
import com.HudLuca.TestTKM.domain.propriedades.PropriedadeVida;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropriedadeVidaRepository extends JpaRepository<PropriedadeVida, Long> {

}
