package com.felipe.fabrica.core.service;

import com.felipe.fabrica.core.entity.Usuario;
import com.felipe.fabrica.core.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario salvar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> obterPeloEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    public boolean verificarCredenciais(String email, String password) {
        Optional<Usuario> usuario = usuarioRepository.findByEmail(email);
        return usuario.isPresent() && usuario.get().getPassword().equals(password);
    }
}
