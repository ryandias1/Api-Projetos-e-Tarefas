package br.com.ryan.gestao_projetos.repository;

import br.com.ryan.gestao_projetos.model.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
}
