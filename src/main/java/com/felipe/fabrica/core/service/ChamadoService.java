package com.felipe.fabrica.core.service;

import com.felipe.fabrica.core.entity.Chamado;
import com.felipe.fabrica.core.repository.ChamadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChamadoService {

    @Autowired
    private ChamadoRepository chamadoRepository;

    public List<Chamado> obterTodos() {
        return chamadoRepository.findAll();
    }

    public Optional<Chamado> obterPeloId(long id) {
        return chamadoRepository.findById(id);
    }

    public Chamado salvar(Chamado chamado) {
        if (chamado.getDescricao() == null || chamado.getDescricao().isEmpty()) {
            throw new RuntimeException("Favor informar a descrição");
        }
        return chamadoRepository.save(chamado);
    }

    public void excluirPeloId(long id) {
        chamadoRepository.deleteById(id);
    }
}