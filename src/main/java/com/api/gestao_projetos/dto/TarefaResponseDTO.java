package com.api.gestao_projetos.dto;

import com.api.gestao_projetos.model.Tarefa;

public record TarefaResponseDTO(Long id, String titulo, Boolean concluida, String projeto) {
    public TarefaResponseDTO(Tarefa tarefa){
        this(tarefa.getId(), tarefa.getTitulo(), tarefa.getConcluida(), tarefa.getProjeto() != null ? tarefa.getProjeto().getNome() : "Sem projeto");
    }
}
