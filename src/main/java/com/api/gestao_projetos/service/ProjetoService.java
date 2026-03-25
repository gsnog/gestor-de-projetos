package com.api.gestao_projetos.service;

import com.api.gestao_projetos.dto.ProjetoRequestDTO;
import com.api.gestao_projetos.dto.ProjetoResponseDTO;
import com.api.gestao_projetos.model.Projeto;
import com.api.gestao_projetos.repository.ProjetoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjetoService {
    private ProjetoRepository repository;

    public ProjetoService (ProjetoRepository repository){
        this.repository = repository;
    }

    private Projeto buscarEntidade(Long id){
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Projeto não encontrado"));
    }

    public ProjetoResponseDTO adicionarProjeto(ProjetoRequestDTO dto){
        Projeto projeto = new Projeto(dto.nome(), dto.descricao());
        repository.save(projeto);
        return new ProjetoResponseDTO(projeto);
    }

    public List<ProjetoResponseDTO> listarTodos(){
        return repository.findAll().stream().map(ProjetoResponseDTO::new).toList();
    }

    public ProjetoResponseDTO buscarPorId(Long id){
        return new ProjetoResponseDTO(buscarEntidade(id));
    }

    public ProjetoResponseDTO atualizarProjeto(Long id, ProjetoRequestDTO dto){
        Projeto projetoAtualizado = buscarEntidade(id);
        projetoAtualizado.setNome(dto.nome());
        projetoAtualizado.setDescricao(dto.descricao());
        repository.save(projetoAtualizado);
        return new ProjetoResponseDTO(projetoAtualizado);
    }

    public void deletarProjeto(Long id){
        Projeto projetoDeletado = buscarEntidade(id);
        repository.delete(projetoDeletado);
    }
}
