USE estoque_db;

-- =========================
-- USUÁRIOS
-- =========================

INSERT INTO users (
username, psw, nameFirst, sobrenome, matricula, cpf, sexo,
dtaNascimento, email, telefone, funcao, cep, endereco,
numero, bairro, cidade, estado, complemento
)
VALUES

('gisele', '2105', 'Gisele', 'Santana', 'ADM001', '123.456.789-00', 'Feminino',
'2000-05-21', 'gisele@livraria.com', '(71)99999-0001', 'admin',
'40000-000', 'Rua das Letras', '100', 'Centro', 'Salvador', 'BA', 'Administradora'),

('joaosilva', '1234', 'João', 'Silva', 'FUN001', '111.222.333-01', 'Masculino',
'1995-03-10', 'joao@livraria.com', '(71)99999-0002', 'vendedor',
'40001-001', 'Rua Bahia', '15', 'Pituba', 'Salvador', 'BA', NULL),

('mariaoliveira', '1234', 'Maria', 'Oliveira', 'FUN002', '111.222.333-02', 'Feminino',
'1998-07-22', 'maria@livraria.com', '(71)99999-0003', 'vendedor',
'40002-002', 'Av. Oceânica', '55', 'Barra', 'Salvador', 'BA', NULL),

('carlossantos', '1234', 'Carlos', 'Santos', 'FUN003', '111.222.333-03', 'Masculino',
'1994-09-15', 'carlos@livraria.com', '(71)99999-0004', 'estoquista',
'40003-003', 'Rua das Flores', '89', 'Itaigara', 'Salvador', 'BA', NULL),

('anapaula', '1234', 'Ana', 'Paula', 'FUN004', '111.222.333-04', 'Feminino',
'1997-01-11', 'ana@livraria.com', '(71)99999-0005', 'caixa',
'40004-004', 'Rua das Acácias', '120', 'Imbuí', 'Salvador', 'BA', NULL),

('pedrolima', '1234', 'Pedro', 'Lima', 'FUN005', '111.222.333-05', 'Masculino',
'1993-12-03', 'pedro@livraria.com', '(71)99999-0006', 'vendedor',
'40005-005', 'Rua da Paz', '45', 'Brotas', 'Salvador', 'BA', NULL),

('fernandaalves', '1234', 'Fernanda', 'Alves', 'FUN006', '111.222.333-06', 'Feminino',
'1999-08-14', 'fernanda@livraria.com', '(71)99999-0007', 'caixa',
'40006-006', 'Rua do Sol', '30', 'Graça', 'Salvador', 'BA', NULL),

('lucasrocha', '1234', 'Lucas', 'Rocha', 'FUN007', '111.222.333-07', 'Masculino',
'1996-02-18', 'lucas@livraria.com', '(71)99999-0008', 'estoquista',
'40007-007', 'Rua Verde', '80', 'Rio Vermelho', 'Salvador', 'BA', NULL),

('julianacosta', '1234', 'Juliana', 'Costa', 'FUN008', '111.222.333-08', 'Feminino',
'1995-06-28', 'juliana@livraria.com', '(71)99999-0009', 'vendedor',
'40008-008', 'Av. Sete', '210', 'Centro', 'Salvador', 'BA', NULL),

('rafaelmartins', '1234', 'Rafael', 'Martins', 'FUN009', '111.222.333-09', 'Masculino',
'1992-11-05', 'rafael@livraria.com', '(71)99999-0010', 'caixa',
'40009-009', 'Rua Horizonte', '44', 'Cabula', 'Salvador', 'BA', NULL),

('beatrizsouza', '1234', 'Beatriz', 'Souza', 'FUN010', '111.222.333-10', 'Feminino',
'2001-04-20', 'beatriz@livraria.com', '(71)99999-0011', 'vendedor',
'40010-010', 'Rua Nova', '88', 'Pituaçu', 'Salvador', 'BA', NULL),

('gustavohenrique', '1234', 'Gustavo', 'Henrique', 'FUN011', '111.222.333-11', 'Masculino',
'1998-10-12', 'gustavo@livraria.com', '(71)99999-0012', 'estoquista',
'40011-011', 'Rua Central', '72', 'Stiep', 'Salvador', 'BA', NULL),

('camilamelo', '1234', 'Camila', 'Melo', 'FUN012', '111.222.333-12', 'Feminino',
'1997-09-01', 'camila@livraria.com', '(71)99999-0013', 'vendedor',
'40012-012', 'Rua do Comércio', '19', 'Comércio', 'Salvador', 'BA', NULL),

('thiagoribeiro', '1234', 'Thiago', 'Ribeiro', 'FUN013', '111.222.333-13', 'Masculino',
'1994-05-30', 'thiago@livraria.com', '(71)99999-0014', 'caixa',
'40013-013', 'Rua Bela Vista', '60', 'Nazaré', 'Salvador', 'BA', NULL),

('larissapereira', '1234', 'Larissa', 'Pereira', 'FUN014', '111.222.333-14', 'Feminino',
'2000-03-17', 'larissa@livraria.com', '(71)99999-0015', 'vendedor',
'40014-014', 'Rua das Palmeiras', '33', 'Federação', 'Salvador', 'BA', NULL);


-- =========================
-- LIVROS
-- =========================

INSERT INTO produtos (
codigo_barras, titulo, editora, genero, selo,
data_publicacao, quantidade, valor, total, satus
)
VALUES

('9788535902775', 'Dom Casmurro', 'Companhia das Letras', 'Romance', 'Clássicos', '2019-01-01', 15, 39.90, 598.50, 'Disponível'),
('9788535920502', 'Memórias Póstumas de Brás Cubas', 'Companhia das Letras', 'Romance', 'Clássicos', '2018-05-10', 12, 42.90, 514.80, 'Disponível'),
('9788535914846', 'O Cortiço', 'Companhia das Letras', 'Romance', 'Clássicos', '2017-03-15', 10, 34.90, 349.00, 'Disponível'),
('9788520933576', 'Capitães da Areia', 'Record', 'Romance', 'Literatura Brasileira', '2020-08-20', 18, 44.90, 808.20, 'Disponível'),
('9788535933922', 'Grande Sertão: Veredas', 'Companhia das Letras', 'Romance', 'Literatura Brasileira', '2016-09-01', 8, 59.90, 479.20, 'Disponível'),

('9786555601001', '1984', 'Companhia das Letras', 'Ficção Científica', 'Penguin', '2021-01-10', 20, 49.90, 998.00, 'Disponível'),
('9788537818890', 'Admirável Mundo Novo', 'Biblioteca Azul', 'Ficção Científica', 'Azul', '2020-07-10', 14, 46.90, 656.60, 'Disponível'),
('9788576572008', 'Duna', 'Aleph', 'Ficção Científica', 'Aleph', '2022-03-01', 16, 69.90, 1118.40, 'Disponível'),

('9788595081512', 'O Hobbit', 'HarperCollins', 'Fantasia', 'Harper', '2020-01-01', 25, 54.90, 1372.50, 'Disponível'),
('9788595084742', 'O Senhor dos Anéis', 'HarperCollins', 'Fantasia', 'Harper', '2021-05-05', 12, 119.90, 1438.80, 'Disponível'),
('9788556510780', 'A Guerra dos Tronos', 'Suma', 'Fantasia', 'Suma', '2019-11-10', 10, 79.90, 799.00, 'Disponível'),

('9788532530787', 'Assassinato no Expresso do Oriente', 'L&PM', 'Mistério', 'Pocket', '2018-02-12', 15, 32.90, 493.50, 'Disponível'),
('9788525432180', 'O Nome da Rosa', 'Objetiva', 'Mistério', 'Objetiva', '2017-06-18', 9, 54.90, 494.10, 'Disponível'),

('9788573266283', 'Sapiens', 'L&PM', 'História', 'L&PM', '2021-09-01', 22, 69.90, 1537.80, 'Disponível'),
('9788535930266', 'Armas, Germes e Aço', 'Companhia das Letras', 'História', 'História', '2020-04-10', 11, 64.90, 713.90, 'Disponível'),

('9788537819064', 'Cosmos', 'Planeta', 'Ciência', 'Planeta', '2019-03-20', 13, 59.90, 778.70, 'Disponível'),
('9786555357007', 'Uma Breve História do Tempo', 'Intrínseca', 'Ciência', 'Intrínseca', '2021-08-01', 17, 49.90, 848.30, 'Disponível'),

('9788533613376', 'Crime e Castigo', 'Editora 34', 'Clássico', '34', '2016-10-01', 7, 69.90, 489.30, 'Disponível'),
('9788535930280', 'Os Irmãos Karamázov', 'Companhia das Letras', 'Clássico', 'Penguin', '2018-12-05', 6, 79.90, 479.40, 'Disponível'),

('9788535928829', 'Orgulho e Preconceito', 'Penguin', 'Romance', 'Penguin', '2022-02-15', 14, 39.90, 558.60, 'Disponível');