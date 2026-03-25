package com.api.gestao_projetos.model;

import jakarta.persistence.*;

@Entity
public class Tarefa {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private Boolean concluida = false;
    @ManyToOne
    @JoinColumn(name = "projeto_id")
    private Projeto projeto;

    public Tarefa(){}

    public Tarefa(String titulo) {
        this.titulo = titulo;
    }

    public Long getId() {
        return id;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Boolean getConcluida() {
        return concluida;
    }

    public void setConcluida(Boolean concluida) {
        this.concluida = concluida;
    }
}
