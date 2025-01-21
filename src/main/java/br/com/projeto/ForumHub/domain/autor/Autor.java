package br.com.projeto.ForumHub.domain.autor;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Table(name = "autores")
@Entity(name = "Autor")
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    private String senha;

    public Autor() {
    }

    public Autor(DadosAutor autor) {
        this.nome = autor.nome();
        this.email = autor.email();
        this.senha = autor.senha();
    }
}
