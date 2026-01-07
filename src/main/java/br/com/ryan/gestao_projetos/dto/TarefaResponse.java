package br.com.ryan.gestao_projetos.dto;

import br.com.ryan.gestao_projetos.enums.Status;

import java.time.LocalDate;

public record TarefaResponse(
        Long id,
        String titulo,
        Status status,
        LocalDate prazo,
        Long projetoId
) {
}
