package com.felipe.fabrica.core.service;

import com.felipe.fabrica.core.entity.Usuario;
import com.felipe.fabrica.core.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public Usuario salvar(Usuario usuario) {
        // Hash da senha antes de salvar
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> obterPeloEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    public boolean verificarCredenciais(String email, String password) {
        Optional<Usuario> usuario = usuarioRepository.findByEmail(email);
        if (usuario.isPresent()) {
            return passwordEncoder.matches(password, usuario.get().getPassword());
        }
        return false;
    }
}