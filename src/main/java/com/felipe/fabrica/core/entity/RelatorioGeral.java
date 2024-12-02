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
public class RelatorioGeral {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String nome;
    private int valor1;
    private int valor2;
    private int valor3;

    public RelatorioGeral(String nome, int valor1, int valor2, int valor3) {
        this.nome = nome;
        this.valor1 = valor1;
        this.valor2 = valor2;
        this.valor3 = valor3;
    }
}