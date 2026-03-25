package com.api.gestao_projetos.controller;

import com.api.gestao_projetos.dto.TarefaRequestDTO;
import com.api.gestao_projetos.dto.TarefaResponseDTO;
import com.api.gestao_projetos.service.TarefaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {
    private TarefaService tarefaService;

    public TarefaController (TarefaService tarefaService){
        this.tarefaService = tarefaService;
    }

    @PostMapping
    public ResponseEntity<TarefaResponseDTO> adicionarTarefa (@Valid @RequestBody TarefaRequestDTO dto){
        TarefaResponseDTO tarefaSalva = tarefaService.adicionarTarefa(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(tarefaSalva);
    }

    @GetMapping
    public ResponseEntity<List<TarefaResponseDTO>> listarTodasTarefas(){
        List<TarefaResponseDTO> todasTarefas = tarefaService.listarTodos();
        return ResponseEntity.status(HttpStatus.OK).body(todasTarefas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TarefaResponseDTO> listarPorId(@PathVariable Long id){
        try {
            TarefaResponseDTO tarefaEncontrada = tarefaService.buscarPorId(id);
            return ResponseEntity.status(HttpStatus.OK).body(tarefaEncontrada);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @Operation(summary = "Conclui uma tarefa")
    @ApiResponse(responseCode = "200", description = "Tarefa concluída com sucesso")
    @ApiResponse(responseCode = "404", description = "Tarefa não encontrada")
    @PutMapping("/{id}/concluir")
    public ResponseEntity<TarefaResponseDTO> atualizarStatus(@PathVariable Long id){
        try {
            TarefaResponseDTO tarefaAtualizada = tarefaService.atualizarStatuTarefa(id);
            return ResponseEntity.status(HttpStatus.OK).body(tarefaAtualizada);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTarefa (@PathVariable Long id){
        try {
            tarefaService.deletar(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


}
