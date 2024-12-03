package com.felipe.fabrica.controllers;

import com.felipe.fabrica.core.service.RelatorioGeralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/relatorio")
public class RelatorioGeralController {

    @Autowired
    private RelatorioGeralService relatorioGeralService;

    @GetMapping("/chart")
    public Map<String, Object> getChartData() {
        return relatorioGeralService.getChartData();
    }
}