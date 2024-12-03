package com.felipe.fabrica.core.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

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
    private LocalDateTime dataAbertura;

    public Chamado(String descricao, String status) {
        this.descricao = descricao;
        this.status = status;
    }

    @PrePersist
    protected void onCreate() {
        this.dataAbertura = LocalDateTime.now();
    }
}