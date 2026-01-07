package br.com.ryan.gestao_projetos.mapper;

import br.com.ryan.gestao_projetos.dto.TarefaResponse;
import br.com.ryan.gestao_projetos.model.Tarefa;

public class TarefasMapper {
    public static TarefaResponse toTarefaResponse(Tarefa tarefa) {
        return new TarefaResponse(tarefa.getId(), tarefa.getTitulo(), tarefa.getStatus(), tarefa.getPrazo(),tarefa.getProjeto().getId());
    }
}
