package com.api.gestao_projetos.service;

import com.api.gestao_projetos.dto.TarefaRequestDTO;
import com.api.gestao_projetos.dto.TarefaResponseDTO;
import com.api.gestao_projetos.model.Projeto;
import com.api.gestao_projetos.model.Tarefa;
import com.api.gestao_projetos.repository.ProjetoRepository;
import com.api.gestao_projetos.repository.TarefaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaService {
    private ProjetoRepository projetoRepository;
    private TarefaRepository tarefaRepository;

    public TarefaService(ProjetoRepository projetoRepository, TarefaRepository tarefaRepository){
        this.tarefaRepository = tarefaRepository;
        this.projetoRepository = projetoRepository;
    }

    private Tarefa buscarEntidade(Long id){
        return tarefaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Tarefa não encontrada"));
    }

    public TarefaResponseDTO adicionarTarefa(TarefaRequestDTO dto){
        Tarefa tarefa = new Tarefa(dto.titulo());
        if (dto.projetoId() != null){
            Projeto projetoEncontrado = projetoRepository.findById(dto.projetoId()).orElseThrow(() -> new IllegalArgumentException("Projeto não encontrado"));
            tarefa.setProjeto(projetoEncontrado);
        }
        tarefaRepository.save(tarefa);
        return new TarefaResponseDTO(tarefa);
    }

    public List<TarefaResponseDTO> listarTodos(){
        return tarefaRepository.findAll().stream().map(TarefaResponseDTO::new).toList();
    }

    public TarefaResponseDTO buscarPorId(Long id){
        return new TarefaResponseDTO(buscarEntidade(id));
    }

    public TarefaResponseDTO atualizarTarefa(Long id, TarefaRequestDTO dto){
        Tarefa tarefaAtualizada = buscarEntidade(id);
        tarefaAtualizada.setTitulo(dto.titulo());
        tarefaAtualizada.setConcluida(dto.concluida());
        if(dto.projetoId() != null){
            Projeto projetoEncontrado = projetoRepository.findById(dto.projetoId()).orElseThrow(() -> new IllegalArgumentException("Projeto não encontrado"));
            tarefaAtualizada.setProjeto(projetoEncontrado);
        }
        tarefaRepository.save(tarefaAtualizada);
        return new TarefaResponseDTO(tarefaAtualizada);
    }

    public TarefaResponseDTO atualizarStatuTarefa(Long id){
        Tarefa tarefaAtualizada = buscarEntidade(id);
        tarefaAtualizada.setConcluida(true);
        tarefaRepository.save(tarefaAtualizada);
        return new TarefaResponseDTO(tarefaAtualizada);
    }

    public void deletar(Long id){
        Tarefa tarefaDeletada = buscarEntidade(id);
        tarefaRepository.delete(tarefaDeletada);
    }
}
