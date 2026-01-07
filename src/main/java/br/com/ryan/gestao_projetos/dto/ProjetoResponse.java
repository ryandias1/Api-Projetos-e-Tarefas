package br.com.ryan.gestao_projetos.dto;

import java.time.LocalDate;
import java.util.List;

public record ProjetoResponse(
        Long id,
        String nome,
        String descricao,
        LocalDate dataInicio,
        List<TarefaResponse> tarefas
) {
}
