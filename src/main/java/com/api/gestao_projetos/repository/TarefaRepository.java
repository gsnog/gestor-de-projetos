package com.api.gestao_projetos.repository;

import com.api.gestao_projetos.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
}