package br.com.ryan.gestao_projetos.service;

import br.com.ryan.gestao_projetos.dto.TarefaRequest;
import br.com.ryan.gestao_projetos.mapper.TarefasMapper;
import br.com.ryan.gestao_projetos.model.Projeto;
import br.com.ryan.gestao_projetos.model.Tarefa;
import br.com.ryan.gestao_projetos.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    @Autowired
    private TarefasMapper tarefaMapper;

    @Autowired
    private ProjetoService projetoService;

    public Tarefa AdicionarTarefa(TarefaRequest tarefaRequest) {
        Projeto projeto = projetoService.buscarProjetoPorId(tarefaRequest.projetoId());
        if (tarefaRequest.titulo().isBlank()) throw new IllegalArgumentException("Titulo é obrigatorio");
        Tarefa tarefa = tarefaMapper.toTarefa(tarefaRequest);
        tarefa.setProjeto(projeto);
        return tarefaRepository.save(tarefa);
    }
}
