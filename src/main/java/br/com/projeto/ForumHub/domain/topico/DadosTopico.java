package br.com.projeto.ForumHub.domain.topico;

import br.com.projeto.ForumHub.domain.autor.DadosAutor;
import br.com.projeto.ForumHub.domain.curso.DadosCurso;
import br.com.projeto.ForumHub.domain.resposta.DadosResposta;

public record DadosTopico(String titulo,
                          String mensagem,
                          String datacriacao,
                          DadosAutor autor,
                          DadosCurso curso,
                          DadosResposta resposta) {

}
