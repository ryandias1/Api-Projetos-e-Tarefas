package br.com.ryan.gestao_projetos.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.util.List;

public record ProjetoRequest(
        @NotBlank(message = "O nome do projeto não pode ser nulo")
        String nome,
        String descricao,
        LocalDate dataInicio,
        List<TarefaRequest> tarefas
) {
}
