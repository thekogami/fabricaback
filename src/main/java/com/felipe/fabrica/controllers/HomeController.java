package com.felipe.fabrica.controllers;

import com.felipe.fabrica.core.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @Autowired
    HomeService homeService;

    @GetMapping("inicio")
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("/inicio");
        // obter valores
        long chamados = homeService.obterChamados();
        // adicionar valores
        view.addObject("chamados", chamados);
        return view;
    }

    @GetMapping("inicio/sair")
    public String sair() {
        return "/sair";
    }
}
