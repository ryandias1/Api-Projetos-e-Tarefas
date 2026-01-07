package br.com.ryan.gestao_projetos.service;

import br.com.ryan.gestao_projetos.dto.ProjetoRequest;
import br.com.ryan.gestao_projetos.dto.ProjetoResponse;
import br.com.ryan.gestao_projetos.dto.TarefaResponse;
import br.com.ryan.gestao_projetos.mapper.ProjetoMapper;
import br.com.ryan.gestao_projetos.mapper.TarefasMapper;
import br.com.ryan.gestao_projetos.model.Projeto;
import br.com.ryan.gestao_projetos.repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;

    @Autowired
    private ProjetoMapper projetoMapper;

    @Autowired
    private TarefasMapper tarefaMapper;

    public Projeto criarProjeto(ProjetoRequest projetoRequest) {
        if (projetoRequest.nome().isBlank()) throw new IllegalArgumentException("Nome do projeto é obrigatório");
        Projeto projeto = projetoMapper.toProjeto(projetoRequest);
        return projetoRepository.save(projeto);
    }

    public List<ProjetoResponse> ListarProjetos() {
        return projetoRepository.findAll().stream().map(p -> projetoMapper.toProjetoResponse(p)).toList();
    }

    public List<TarefaResponse> listarTarefasPorProjeto(Long projetoId) {
        Projeto projeto = buscarProjetoPorId(projetoId);
        return projeto.getTarefas().stream().map(t -> tarefaMapper.toTarefaResponse(t)).toList();
    }

    public void deletarProjeto(Long id) {
        projetoRepository.deleteById(id);
    }

    public ProjetoResponse atualizarProjeto(Long id, ProjetoRequest projetoRequest) {
        Projeto projeto = buscarProjetoPorId(id);
        if (!(projetoRequest.nome().isBlank())) projeto.setNome(projetoRequest.nome());
        if (!(projetoRequest.descricao().isBlank())) projeto.setDescricao(projetoRequest.descricao());
        if (projetoRequest.dataInicio() != null) projeto.setDataInicio(projetoRequest.dataInicio());
        return projetoMapper.toProjetoResponse(projetoRepository.save(projeto));
    }

    public Projeto buscarProjetoPorId(Long id) {
        return projetoRepository.findById(id).orElseThrow(() -> new RuntimeException("Projeto não existe"));
    }
}
