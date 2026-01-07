package br.com.ryan.gestao_projetos.service;

import br.com.ryan.gestao_projetos.dto.TarefaRequest;
import br.com.ryan.gestao_projetos.dto.TarefaResponse;
import br.com.ryan.gestao_projetos.mapper.TarefasMapper;
import br.com.ryan.gestao_projetos.model.Projeto;
import br.com.ryan.gestao_projetos.model.Tarefa;
import br.com.ryan.gestao_projetos.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    @Autowired
    private TarefasMapper tarefaMapper;

    @Autowired
    private ProjetoService projetoService;

    public TarefaResponse AdicionarTarefa(TarefaRequest tarefaRequest) {
        Projeto projeto = projetoService.buscarProjetoPorId(tarefaRequest.projetoId());
        if (tarefaRequest.prazo().isBefore(LocalDate.now())) throw new IllegalArgumentException("Prazo de tarefa invalido");
        Tarefa tarefa = tarefaMapper.toTarefa(tarefaRequest);
        tarefa.setProjeto(projeto);
        return tarefaMapper.toTarefaResponse(tarefaRepository.save(tarefa));
    }
}
