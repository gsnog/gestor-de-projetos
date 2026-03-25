package com.api.gestao_projetos.dto;

import jakarta.validation.constraints.NotBlank;

public record ProjetoRequestDTO(
        Long id,
        @NotBlank
        String nome,
        String descricao) {
}
