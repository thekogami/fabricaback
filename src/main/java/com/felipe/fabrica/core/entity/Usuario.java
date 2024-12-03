package com.felipe.fabrica.core.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String nome;
    private String email;
    private String password;
    private String role; // "TECNICO_TI" ou "USUARIO_COMUM"

    public Usuario(String nome, String email, String password, String role) {
        this.nome = nome;
        this.email = email;
        this.password = password;
        this.role = role;
    }
}