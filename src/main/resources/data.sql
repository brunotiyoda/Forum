-- USUARIO --
INSERT INTO USUARIO(nome, email, senha) VALUES('Aluno', 'aluno@email.com', '$2a$10$6r2PcQG/8JdMi1q0hqDCluZd9X8XkY41PwmmzHmbn8H1Rc/MkLA9G');
INSERT INTO USUARIO(nome, email, senha) VALUES('Moderador', 'moderador@email.com', '$2a$10$6r2PcQG/8JdMi1q0hqDCluZd9X8XkY41PwmmzHmbn8H1Rc/MkLA9G');

-- PERFIL --
INSERT INTO PERFIL(id, tipo) VALUES (1, 'ROLE_ALUNO');
INSERT INTO PERFIL(id, tipo) VALUES (2, 'ROLE_MODERADOR');

-- USUARIO PERFIL --
INSERT INTO USUARIO_PERFIS(usuario_id, perfis_id) VALUES (1, 1);
INSERT INTO USUARIO_PERFIS(usuario_id, perfis_id) VALUES (2, 2);

-- CURSO --
INSERT INTO CURSO(nome, categoria) VALUES('Spring Boot', 'Backend');
INSERT INTO CURSO(nome, categoria) VALUES('Kotlin', 'Backend');
INSERT INTO CURSO(nome, categoria) VALUES('Java', 'Backend');
INSERT INTO CURSO(nome, categoria) VALUES('Python', 'Backend');
INSERT INTO CURSO(nome, categoria) VALUES('Clojure', 'Backend');
INSERT INTO CURSO(nome, categoria) VALUES('HTML 5', 'Frontend');

-- TOPICO --
INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id)
VALUES('A', 'A', '2019-05-05 18:00:00', 'NAO_RESPONDIDO', 1, 1);

INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id)
VALUES('B', 'B', '2019-05-05 18:00:00', 'NAO_RESPONDIDO', 1, 1);

INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id)
VALUES('C', 'C', '2019-05-05 18:00:00', 'NAO_RESPONDIDO', 1, 1);

INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id)
VALUES('D', 'D', '2019-05-05 18:00:00', 'NAO_RESPONDIDO', 1, 1);

INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id)
VALUES('1', '1', '2019-05-05 18:00:00', 'NAO_RESPONDIDO', 1, 1);

INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id)
VALUES('2', '2', '2019-05-05 18:00:00', 'NAO_RESPONDIDO', 1, 1);

INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id)
VALUES('3', '3', '2019-05-05 18:00:00', 'NAO_RESPONDIDO', 1, 1);

INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id)
VALUES('E', 'E', '2019-05-05 18:00:00', 'NAO_RESPONDIDO', 1, 1);

INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id)
VALUES('1A', '1A', '2019-05-05 18:00:00', 'NAO_RESPONDIDO', 1, 1);

INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id)
VALUES('2B', '2B', '2019-05-05 18:00:00', 'NAO_RESPONDIDO', 1, 1);

INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id)
VALUES('3D', '3D', '2019-05-05 18:00:00', 'NAO_RESPONDIDO', 1, 1);

INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id)
VALUES('Z', 'Z', '2019-05-05 18:00:00', 'NAO_RESPONDIDO', 1, 1);

INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id)
VALUES('A1', 'A1', '2019-05-05 18:00:00', 'NAO_RESPONDIDO', 1, 1);

INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id)
VALUES('B2', 'B2', '2019-05-05 18:00:00', 'NAO_RESPONDIDO', 1, 1);

INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id)
VALUES('C4', 'C4', '2019-05-05 18:00:00', 'NAO_RESPONDIDO', 1, 1);

INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id)
VALUES('*1A', '*1A', '2019-05-05 18:00:00', 'NAO_RESPONDIDO', 1, 1);

INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id)
VALUES('Projeto não compila', 'Projeto não compila', '2019-05-05 19:00:00', 'NAO_RESPONDIDO', 1, 1);

INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id)
VALUES('Tag HTML', 'Tag HTML', '2019-05-05 20:00:00', 'NAO_RESPONDIDO', 1, 2);