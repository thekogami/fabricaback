package com.felipe.fabrica.core.service;

import com.felipe.fabrica.core.entity.RelatorioGeral;
import com.felipe.fabrica.core.repository.RelatorioGeralRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RelatorioGeralService {

    @Autowired
    private RelatorioGeralRepository relatorioGeralRepository;

    public Map<String, Object> getChart1Data() {
        List<RelatorioGeral> relatorios = relatorioGeralRepository.findAll();
        Map<String, Object> data = new HashMap<>();
        data.put("columns", new Object[][] {
            {"data1", relatorios.stream().mapToInt(RelatorioGeral::getValor1).toArray()},
            {"data2", relatorios.stream().mapToInt(RelatorioGeral::getValor2).toArray()}
        });
        data.put("type", "bar");
        return data;
    }

    public Map<String, Object> getChart2Data() {
        List<RelatorioGeral> relatorios = relatorioGeralRepository.findAll();
        Map<String, Object> data = new HashMap<>();
        data.put("columns", new Object[][] {
            {"data1", relatorios.stream().mapToInt(RelatorioGeral::getValor1).toArray()},
            {"data2", relatorios.stream().mapToInt(RelatorioGeral::getValor2).toArray()}
        });
        data.put("type", "bar");
        return data;
    }
}
