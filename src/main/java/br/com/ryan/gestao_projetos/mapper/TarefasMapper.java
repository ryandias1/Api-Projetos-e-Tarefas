package br.com.ryan.gestao_projetos.mapper;

import br.com.ryan.gestao_projetos.dto.TarefaRequest;
import br.com.ryan.gestao_projetos.dto.TarefaResponse;
import br.com.ryan.gestao_projetos.enums.Status;
import br.com.ryan.gestao_projetos.model.Tarefa;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class TarefasMapper {
    public Tarefa toTarefa(TarefaRequest tarefaRequest) {
        Tarefa tarefa = new Tarefa();
        tarefa.setTitulo(tarefaRequest.titulo());
        if (tarefaRequest.status() != null) tarefa.setStatus(tarefaRequest.status());
        else tarefa.setStatus(Status.PENDENTE);
        tarefa.setPrazo(tarefaRequest.prazo());
        return tarefa;
    }

    public TarefaResponse toTarefaResponse(Tarefa tarefa) {
        return new TarefaResponse(tarefa.getId(), tarefa.getTitulo(), tarefa.getStatus(), tarefa.getPrazo(),tarefa.getProjeto().getId());
    }
}
