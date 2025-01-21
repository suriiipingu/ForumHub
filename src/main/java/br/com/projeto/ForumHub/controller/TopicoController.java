package br.com.projeto.ForumHub.controller;

import br.com.projeto.ForumHub.domain.autor.Autor;
import br.com.projeto.ForumHub.domain.autor.AutorRepository;
import br.com.projeto.ForumHub.domain.curso.Curso;
import br.com.projeto.ForumHub.domain.curso.CursoRepository;
import br.com.projeto.ForumHub.domain.resposta.Resposta;
import br.com.projeto.ForumHub.domain.resposta.RespostaRepository;
import br.com.projeto.ForumHub.domain.topico.DadosTopico;
import br.com.projeto.ForumHub.domain.topico.Topico;
import br.com.projeto.ForumHub.domain.topico.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topico")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private RespostaRepository respostaRepository;

    @PostMapping
    public void cadastrar(@RequestBody DadosTopico dados) {

        Autor autorTopico = autorRepository.findByEmail(dados.autor().getEmail());
        if (autorTopico == null) {
            autorTopico = new Autor(dados.autor());
            autorRepository.save(autorTopico);
        }

        Curso curso = cursoRepository.findByNome(dados.curso().getNome());
        if (curso == null) {
            curso = new Curso(dados.curso());
            cursoRepository.save(curso);
        }

        Topico topico = new Topico(dados);
        topico.setAutor(autorTopico);
        topico.setCurso(curso);

        topicoRepository.save(topico);

        Resposta resposta = new Resposta(dados.resposta());
        Autor autorResposta = autorRepository.findByEmail(dados.resposta().getAutor().getEmail());
        if (autorResposta == null) {
            autorResposta = new Autor(dados.resposta().getAutor());
            autorRepository.save(autorResposta);
        }

        resposta.setAutor(autorResposta);
        resposta.setTopico(topico);

        respostaRepository.save(resposta);
    }
}
