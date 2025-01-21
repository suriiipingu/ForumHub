package br.com.projeto.ForumHub.domain.autor;

public record DadosAutor(String nome, String email, String senha) {
    public String getEmail() {
        return email;
    }
}
