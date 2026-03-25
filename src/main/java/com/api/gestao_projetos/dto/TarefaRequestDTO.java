package com.api.gestao_projetos.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record TarefaRequestDTO(
        @NotBlank
        @Size(min = 5, message = "Titulo não pode ser vazio e precisa ter no mínimo 5 caracteres")
        String titulo,
        Boolean concluida,
        @NotNull(message = "O id do projeto não pode ser nulo")
        Long projetoId) {
}
