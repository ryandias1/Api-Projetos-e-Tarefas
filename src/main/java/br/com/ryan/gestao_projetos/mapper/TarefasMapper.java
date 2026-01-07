package br.com.ryan.gestao_projetos.mapper;

import br.com.ryan.gestao_projetos.dto.TarefaRequest;
import br.com.ryan.gestao_projetos.dto.TarefaResponse;
import br.com.ryan.gestao_projetos.model.Tarefa;
import org.springframework.stereotype.Component;

@Component
public class TarefasMapper {
    public Tarefa toTarefa(TarefaRequest tarefaRequest) {
        Tarefa tarefa = new Tarefa();
        tarefa.setTitulo(tarefaRequest.titulo());
        tarefa.setStatus(tarefaRequest.status());
        tarefa.setPrazo(tarefaRequest.prazo());
        return tarefa;
    }

    public TarefaResponse toTarefaResponse(Tarefa tarefa) {
        return new TarefaResponse(tarefa.getId(), tarefa.getTitulo(), tarefa.getStatus(), tarefa.getPrazo(),tarefa.getProjeto().getId());
    }
}
