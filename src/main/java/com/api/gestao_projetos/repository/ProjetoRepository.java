package com.api.gestao_projetos.repository;

import com.api.gestao_projetos.model.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
}
