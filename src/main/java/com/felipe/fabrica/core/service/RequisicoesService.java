package com.felipe.fabrica.core.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipe.fabrica.core.entity.Requisicoes;
import com.felipe.fabrica.core.repository.RequisicoesRepository;

@Service
public class RequisicoesService {

    @Autowired
    private RequisicoesRepository requisicoesRepository;

    public List<Requisicoes> obterTodos() {
        return requisicoesRepository.findAll();
    }

    public Optional<Requisicoes> obterPeloId(long id) {
        return requisicoesRepository.findById(id);
    }

    public Requisicoes salvar(Requisicoes requisicoes) {
        return requisicoesRepository.save(requisicoes);
    }

    public void excluirPeloId(long id) {
        requisicoesRepository.deleteById(id);
    }
}
