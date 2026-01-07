package br.com.ryan.gestao_projetos.mapper;

import br.com.ryan.gestao_projetos.dto.ProjetoResponse;
import br.com.ryan.gestao_projetos.dto.TarefaResponse;
import br.com.ryan.gestao_projetos.model.Projeto;

import java.util.List;

public class ProjetoMapper {
    public static ProjetoResponse toProjetoResponse(Projeto projeto) {
        List<TarefaResponse> tarefas = projeto.getTarefas().stream().map(t -> TarefasMapper.toTarefaResponse(t)).toList();
        return new ProjetoResponse(projeto.getId(), projeto.getNome(), projeto.getDescricao(), projeto.getDataInicio(), tarefas);
    }
}
