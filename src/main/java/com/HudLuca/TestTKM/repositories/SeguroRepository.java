package com.HudLuca.TestTKM.repositories;

import com.HudLuca.TestTKM.domain.Cidade;
import com.HudLuca.TestTKM.domain.Seguro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeguroRepository extends JpaRepository<Seguro, Long> {

}
