package com.felipe.fabrica.core.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipe.fabrica.core.repository.ChamadoRepository;


@Service
public class HomeService {

    @Autowired
    ChamadoRepository chamadoRepository;

    public long obterChamados(){
        long chamados = chamadoRepository.count();
        return chamados;
    }

}
