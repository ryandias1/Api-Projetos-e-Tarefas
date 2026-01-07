package br.com.ryan.gestao_projetos.controller;

import br.com.ryan.gestao_projetos.dto.TarefaRequest;
import br.com.ryan.gestao_projetos.dto.TarefaResponse;
import br.com.ryan.gestao_projetos.model.Tarefa;
import br.com.ryan.gestao_projetos.service.TarefaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @PostMapping
    public ResponseEntity<TarefaResponse> save(@Valid @RequestBody TarefaRequest tarefaRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(tarefaService.AdicionarTarefa(tarefaRequest));
    }
}
