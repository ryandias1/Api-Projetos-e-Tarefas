package br.com.ryan.gestao_projetos.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Projeto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    private String descricao;

    private LocalDate dataInicio;

    @OneToMany(mappedBy = "projeto", cascade = CascadeType.ALL ,orphanRemoval = true)
    @JsonManagedReference
    private List<Tarefa> tarefas = new ArrayList<>();
}
