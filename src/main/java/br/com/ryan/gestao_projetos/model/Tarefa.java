package br.com.ryan.gestao_projetos.model;

import br.com.ryan.gestao_projetos.enums.Status;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    private Status status;

    private LocalDate prazo;

    @ManyToOne
    @JoinColumn(name = "projeto_id")
    @JsonBackReference
    private Projeto projeto;
}
