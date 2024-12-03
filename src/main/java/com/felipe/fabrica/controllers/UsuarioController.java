package com.felipe.fabrica.controllers;

import com.felipe.fabrica.core.entity.Usuario;
import com.felipe.fabrica.core.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private static final Logger logger = LoggerFactory.getLogger(UsuarioController.class);

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/login")
    public boolean login(@RequestBody Usuario usuario) {
        return usuarioService.verificarCredenciais(usuario.getEmail(), usuario.getPassword());
    }

    @PostMapping("/cadastro")
    public Usuario cadastrar(@RequestBody Usuario usuario) {
        Usuario novoUsuario = usuarioService.salvar(usuario);
        logger.info("Usuário cadastrado com sucesso: {}", novoUsuario);
        return novoUsuario;
    }

    @GetMapping("/{email}")
    public Optional<Usuario> obterUsuario(@PathVariable String email) {
        return usuarioService.obterPeloEmail(email);
    }
}