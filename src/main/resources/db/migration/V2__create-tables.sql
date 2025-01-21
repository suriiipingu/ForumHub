CREATE TABLE autores (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(200) NOT NULL,
    email VARCHAR(100) NOT NULL,
    senha VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE cursos (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(200) NOT NULL,
    categoria VARCHAR(400) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE topicos (
    id BIGINT NOT NULL AUTO_INCREMENT,
    titulo VARCHAR(200) NOT NULL,
    mensagem VARCHAR(400) NOT NULL,
    dataCriacao DATE,
    id_autor BIGINT,
    id_curso BIGINT,
    id_resposta BIGINT,
    PRIMARY KEY (id),
    CONSTRAINT fk_autor_topico FOREIGN KEY (id_autor) REFERENCES autores(id),
    CONSTRAINT fk_curso FOREIGN KEY (id_curso) REFERENCES cursos(id)
);

CREATE TABLE respostas (
    id BIGINT NOT NULL AUTO_INCREMENT,
    mensagem VARCHAR(400) NOT NULL,
    dataCriacao DATE,
    id_topico BIGINT,
    id_autor BIGINT,
    PRIMARY KEY (id),
    CONSTRAINT fk_topico FOREIGN KEY (id_topico) REFERENCES topicos(id),
    CONSTRAINT fk_autor_resposta FOREIGN KEY (id_autor) REFERENCES autores(id)
);
