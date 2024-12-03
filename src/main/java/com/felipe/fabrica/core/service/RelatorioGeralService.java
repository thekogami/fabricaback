package com.felipe.fabrica.core.service;

import com.felipe.fabrica.core.entity.Chamado;
import com.felipe.fabrica.core.repository.ChamadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RelatorioGeralService {

    @Autowired
    private ChamadoRepository chamadoRepository;

    public Map<String, Object> getChartData() {
        List<Chamado> chamados = chamadoRepository.findAll();
        Map<String, Object> data = new HashMap<>();
        data.put("columns", new Object[][] {
            {"Aberto", chamados.stream().filter(c -> "Aberto".equals(c.getStatus())).count()},
            {"Em andamento", chamados.stream().filter(c -> "Em andamento".equals(c.getStatus())).count()},
            {"Resolvido", chamados.stream().filter(c -> "Resolvido".equals(c.getStatus())).count()}
        });
        data.put("type", "bar");
        return data;
    }
}