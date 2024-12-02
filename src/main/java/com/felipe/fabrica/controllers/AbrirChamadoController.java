package com.felipe.fabrica.controllers;

import com.felipe.fabrica.core.entity.Chamado;
import com.felipe.fabrica.core.service.ChamadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/chamados")
public class AbrirChamadoController {

    private static final Logger logger = LoggerFactory.getLogger(AbrirChamadoController.class);

    @Autowired
    private ChamadoService chamadoService;

    @GetMapping
    public List<Chamado> listarChamados() {
        return chamadoService.obterTodos();
    }

    @GetMapping("/{id}")
    public Optional<Chamado> obterChamado(@PathVariable("id") long id) {
        return chamadoService.obterPeloId(id);
    }

    @PostMapping
    public Chamado criarChamado(@RequestBody Chamado chamado) {
        chamado.setId(0); // Garantir que um novo chamado seja criado
        Chamado novoChamado = chamadoService.salvar(chamado);
        logger.info("Novo chamado cadastrado: {}", novoChamado);
        return novoChamado;
    }

    @PutMapping("/{id}")
    public Chamado atualizarChamado(@PathVariable("id") long id, @RequestBody Chamado chamado) {
        chamado.setId(id);
        return chamadoService.salvar(chamado);
    }

    @DeleteMapping("/{id}")
    public void excluirChamado(@PathVariable("id") long id) {
        chamadoService.excluirPeloId(id);
    }
}