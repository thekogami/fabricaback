package com.felipe.fabrica.core.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Requisicoes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String requerente;
    private String nome;
    private String status;
    private LocalDate dataAbertura;

    public Requisicoes(String requerente, String nome, String status, LocalDate dataAbertura) {
        this.requerente = requerente;
        this.nome = nome;
        this.status = status;
        this.dataAbertura = dataAbertura;
    }
}