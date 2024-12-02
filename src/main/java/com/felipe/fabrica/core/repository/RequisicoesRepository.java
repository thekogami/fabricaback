package com.felipe.fabrica.core.repository;

import com.felipe.fabrica.core.entity.Requisicoes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequisicoesRepository extends JpaRepository<Requisicoes, Long> {
}