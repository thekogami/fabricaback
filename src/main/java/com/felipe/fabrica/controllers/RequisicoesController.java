package com.felipe.fabrica.controllers;

import com.felipe.fabrica.core.entity.Requisicoes;
import com.felipe.fabrica.core.service.RequisicoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/requisicoes")
public class RequisicoesController {

    @Autowired
    private RequisicoesService requisicoesService;

    @GetMapping
    public List<Requisicoes> listarRequisicoes() {
        return requisicoesService.obterTodos();
    }

    @GetMapping("/{id}")
    public Optional<Requisicoes> obterRequisicao(@PathVariable("id") long id) {
        return requisicoesService.obterPeloId(id);
    }

    @PostMapping
    public Requisicoes criarRequisicao(@RequestBody Requisicoes requisicao) {
        requisicao.setId(0); // Garantir que uma nova requisição seja criada
        return requisicoesService.salvar(requisicao);
    }

    @PutMapping("/{id}")
    public Requisicoes atualizarRequisicao(@PathVariable("id") long id, @RequestBody Requisicoes requisicao) {
        requisicao.setId(id);
        return requisicoesService.salvar(requisicao);
    }

    @DeleteMapping("/{id}")
    public void excluirRequisicao(@PathVariable("id") long id) {
        requisicoesService.excluirPeloId(id);
    }
}