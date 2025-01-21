package br.com.projeto.ForumHub.domain.autor;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    Autor findByEmail(String email);
}
