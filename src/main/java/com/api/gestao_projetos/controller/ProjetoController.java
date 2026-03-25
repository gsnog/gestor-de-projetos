package com.api.gestao_projetos.controller;

import com.api.gestao_projetos.dto.ProjetoRequestDTO;
import com.api.gestao_projetos.dto.ProjetoResponseDTO;
import com.api.gestao_projetos.service.ProjetoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projetos")
public class ProjetoController {
    private ProjetoService projetoService;

    public ProjetoController(ProjetoService projetoService){
        this.projetoService = projetoService;
    }

    @PostMapping
    public ResponseEntity<ProjetoResponseDTO> adicionarProjeto(@Valid @RequestBody ProjetoRequestDTO dto){
        ProjetoResponseDTO projetoNovo = projetoService.adicionarProjeto(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(projetoNovo);
    }

    @GetMapping
    public ResponseEntity<List<ProjetoResponseDTO>> listarTodos(){
        List<ProjetoResponseDTO> todosProjetos = projetoService.listarTodos();
        return ResponseEntity.status(HttpStatus.OK).body(todosProjetos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjetoResponseDTO> buscarPorId(@PathVariable Long id){
        try{
            ProjetoResponseDTO projetoEncontrado = projetoService.buscarPorId(id);
            return ResponseEntity.status(HttpStatus.OK).body(projetoEncontrado);
        } catch (IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjetoResponseDTO> atualizarProjeto (@PathVariable Long id, @Valid @RequestBody ProjetoRequestDTO dto){
        try{
            ProjetoResponseDTO projetoAtualizado = projetoService.atualizarProjeto(id, dto);
            return ResponseEntity.status(HttpStatus.OK).body(projetoAtualizado);
        } catch (IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProjeto (@PathVariable Long id){
        try {
            projetoService.deletarProjeto(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
