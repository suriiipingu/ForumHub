package br.com.projeto.ForumHub.domain.topico;

import br.com.projeto.ForumHub.domain.autor.Autor;
import br.com.projeto.ForumHub.domain.curso.Curso;
import br.com.projeto.ForumHub.domain.resposta.Resposta;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Table(name = "topicos")
@Entity(name = "Topico")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String mensagem;

    @Column(name = "data_criacao")
    private LocalDate dataCriacao;

    //private String status;

    @ManyToOne (cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_autor")
    private Autor autor;

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    @ManyToOne (cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_curso")
    private Curso curso;

    @OneToOne (cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_resposta")
    private Resposta resposta;

    public Topico(DadosTopico dados) {
        this.titulo = dados.titulo();
        this.mensagem = dados.mensagem();
        this.dataCriacao = LocalDate.parse(dados.datacriacao(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.autor = new Autor(dados.autor());
        this.curso = new Curso(dados.curso());
        this.resposta = new Resposta(dados.resposta());
    }

    public void setCurso(Curso curso) {
    }
}
