package br.com.ryan.gestao_projetos.mapper;

import br.com.ryan.gestao_projetos.dto.ProjetoRequest;
import br.com.ryan.gestao_projetos.dto.ProjetoResponse;
import br.com.ryan.gestao_projetos.dto.TarefaResponse;
import br.com.ryan.gestao_projetos.model.Projeto;
import br.com.ryan.gestao_projetos.model.Tarefa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class ProjetoMapper {

    @Autowired
    private TarefasMapper tarefasMapper;

    public Projeto toProjeto(ProjetoRequest projetoRequest) {
        Projeto projeto = new Projeto();
        projeto.setNome(projetoRequest.nome());
        projeto.setDescricao(projetoRequest.descricao());
        if (projetoRequest.dataInicio().isBefore(LocalDate.now())) throw new IllegalArgumentException("Data de inicio invalida");
        else projeto.setDataInicio(projetoRequest.dataInicio());
        List<Tarefa> tarefas = projetoRequest.tarefas().stream().map(t -> {
            Tarefa tarefa = tarefasMapper.toTarefa(t);
            tarefa.setProjeto(projeto);
            return tarefa;
        }).toList();
        projeto.setTarefas(tarefas);
        return projeto;
    }

    public ProjetoResponse toProjetoResponse(Projeto projeto) {
        List<TarefaResponse> tarefas = projeto.getTarefas().stream().map(t -> tarefasMapper.toTarefaResponse(t)).toList();
        return new ProjetoResponse(projeto.getId(), projeto.getNome(), projeto.getDescricao(), projeto.getDataInicio(), tarefas);
    }
}
