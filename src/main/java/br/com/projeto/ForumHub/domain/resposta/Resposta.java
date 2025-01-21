package br.com.projeto.ForumHub.domain.resposta;

import br.com.projeto.ForumHub.domain.autor.Autor;
import br.com.projeto.ForumHub.domain.topico.Topico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Table(name = "respostas")
@Entity(name = "Resposta")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Resposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mensagem;

    @Column(name = "data_criacao")
    private LocalDate dataCriacao;

    @ManyToOne
    @JoinColumn(name = "id_autor")
    private Autor autor;

    @OneToOne
    @JoinColumn(name = "id_topico")
    private Topico topico;

    public Resposta(DadosResposta resposta) {
        this.mensagem = resposta.mensagem();
        this.dataCriacao = LocalDate.parse(resposta.datacriacao(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.autor = new Autor(resposta.autor());
    }

    public void setAutor(Autor autor) {
    }

    public void setTopico(Topico topico) {

    }
}
