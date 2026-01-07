package br.com.ryan.gestao_projetos.controller;

import br.com.ryan.gestao_projetos.dto.ProjetoAtualizarRequest;
import br.com.ryan.gestao_projetos.dto.ProjetoRequest;
import br.com.ryan.gestao_projetos.dto.ProjetoResponse;
import br.com.ryan.gestao_projetos.dto.TarefaResponse;
import br.com.ryan.gestao_projetos.service.ProjetoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projetos")
public class ProjetoController {
    @Autowired
    private ProjetoService projetoService;

    @PostMapping
    public ResponseEntity<ProjetoResponse> criarProjeto(@Valid @RequestBody ProjetoRequest projetoRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(projetoService.criarProjeto(projetoRequest));
    }

    @GetMapping
    public ResponseEntity<List<ProjetoResponse>> listarProjetos(){
        return ResponseEntity.ok(projetoService.ListarProjetos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<TarefaResponse>> buscarTarefas(@PathVariable Long id){
        return ResponseEntity.ok(projetoService.listarTarefasPorProjeto(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjetoResponse> atualizarProjeto(@PathVariable Long id, @RequestBody ProjetoAtualizarRequest projetoRequest){
        return ResponseEntity.ok(projetoService.atualizarProjeto(id, projetoRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProjeto(@PathVariable Long id){
        projetoService.deletarProjeto(id);
        return ResponseEntity.noContent().build();
    }
}
