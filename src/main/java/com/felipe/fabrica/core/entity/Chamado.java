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
public class Chamado {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String descricao;
    private String status;

    public Chamado(String descricao, String status) {
        this.descricao = descricao;
        this.status = status;
    }
}