package br.com.projeto.ForumHub.domain.curso;

public record DadosCurso(String nome, String categoria) {
    public String getNome() {
        return nome;
    }
}
