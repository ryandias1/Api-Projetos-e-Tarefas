package br.com.ryan.gestao_projetos.repository;

import br.com.ryan.gestao_projetos.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
}
