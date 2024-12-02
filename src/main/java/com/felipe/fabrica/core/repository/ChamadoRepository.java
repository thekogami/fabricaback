package com.felipe.fabrica.core.repository;

import com.felipe.fabrica.core.entity.Chamado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChamadoRepository extends JpaRepository<Chamado, Long> {
}