package com.felipe.fabrica.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.felipe.fabrica.core.entity.Chamado;
import com.felipe.fabrica.core.service.ChamadoService;

import java.util.Optional;

@RestController
public class ChamadoAbertoController {

  @Autowired
  private ChamadoService chamadoService;

  @GetMapping("/chamados/{id}")
  public Chamado getChamado(@PathVariable Long id) {
    Optional<Chamado> chamadoOptional = chamadoService.obterPeloId(id);
    if (chamadoOptional.isPresent()) {
      Chamado chamado = chamadoOptional.get();
      // Aqui você pode adicionar lógica para manipular as movimentações, se
      // necessário
      return chamado;
    } else {
      throw new RuntimeException("Chamado não encontrado");
    }
  }
}
