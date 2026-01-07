package br.com.ryan.gestao_projetos.dto;

import br.com.ryan.gestao_projetos.enums.Status;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record TarefaRequest(
        @NotBlank(message = "Titulo é obrigatório")
        String titulo,
        Status status,
        LocalDate prazo,
        Long projetoId
) {
}
