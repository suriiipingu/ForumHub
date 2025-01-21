package br.com.projeto.ForumHub.domain.resposta;

import br.com.projeto.ForumHub.domain.autor.DadosAutor;

public record DadosResposta(String mensagem,
                            String datacriacao,
                            DadosAutor autor) {

    public DadosAutor getAutor() {
        return autor;
    }
}
