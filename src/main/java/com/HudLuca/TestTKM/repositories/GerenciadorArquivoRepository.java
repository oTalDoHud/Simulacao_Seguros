package com.HudLuca.TestTKM.repositories;

import com.HudLuca.TestTKM.domain.GerenciadorArquivo;
import com.HudLuca.TestTKM.domain.propriedades.Automovel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GerenciadorArquivoRepository extends JpaRepository<GerenciadorArquivo, Long> {

}
