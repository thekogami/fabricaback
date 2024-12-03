package com.felipe.fabrica.core.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
    private LocalDateTime dataFechamento;
    private String descricaoProblema;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Movimentacao> movimentacoes = new ArrayList<>();

    public Chamado(String descricao, String status, String descricaoProblema) {
        this.descricao = descricao;
        this.status = status;
        this.descricaoProblema = descricaoProblema;
        this.dataAbertura = LocalDateTime.now();
        this.dataFechamento = null;
        addMovimentacao("Usuário", this.dataAbertura.toString(), descricaoProblema, "bg-green-3");
    }

    @PrePersist
    protected void onCreate() {
        this.dataAbertura = LocalDateTime.now();
    }

    public void addMovimentacao(String usuario, String data, String mensagem, String cor) {
        this.movimentacoes.add(new Movimentacao(usuario, data, mensagem, cor));
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @ToString
    @Entity
    public static class Movimentacao {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long id;
        private String usuario;
        private String data;
        private String mensagem;
        private String cor;

        public Movimentacao(String usuario, String data, String mensagem, String cor) {
            this.usuario = usuario;
            this.data = data;
            this.mensagem = mensagem;
            this.cor = cor;
        }
    }
}