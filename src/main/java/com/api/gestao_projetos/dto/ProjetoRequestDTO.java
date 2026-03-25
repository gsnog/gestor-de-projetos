package com.api.gestao_projetos.dto;

import jakarta.validation.constraints.NotBlank;

public record ProjetoRequestDTO(
        @NotBlank
        String nome,
        String descricao) {
}
