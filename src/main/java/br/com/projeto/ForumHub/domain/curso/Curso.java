package br.com.projeto.ForumHub.domain.curso;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Table(name = "cursos")
@Entity(name = "Curso")
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String categoria;

    public Curso() {
    }

    public Curso(DadosCurso curso) {
        this.nome = curso.nome();
        this.categoria = curso.categoria();
    }
}
