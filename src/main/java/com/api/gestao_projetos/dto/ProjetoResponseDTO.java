package com.api.gestao_projetos.dto;

import com.api.gestao_projetos.model.Projeto;

public record ProjetoResponseDTO(Long id, String nome, String descricao) {
    public ProjetoResponseDTO(Projeto projeto){
        this(projeto.getId(), projeto.getNome(), projeto.getDescricao());
    }
}
