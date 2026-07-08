USE PinkiePie;

INSERT INTO users (
    username, psw, nameFirst, sobrenome, matricula, cpf, 
    sexo, dtaNascimento, email, telefone, funcao, 
    cep, endereco, numero, bairro, cidade, estado, complemento
) VALUES 
(
    'gisele', 
    '2222',
    'gisele', 
    'souza', 
    'MAT202601', 
    '123.456.789-00', 
    'Masculino', 
    '1995-04-15', 
    'gisele.souza@email.com', 
    '(71) 99999-1111', 
    'admin', 
    '40000-000', 
    'Avenida Sete de Setembro', 
    '150', 
    'Centro', 
    'Salvador', 
    'Bahia', 
    'Apto 302'
);

INSERT INTO Livros (codigoBarras, titulo, editora, genero, localArmazenamento, dataPublicacao, quantidade, quantidadeMin, valor) VALUES
('9788535914849', '1984', 'Companhia das Letras', 'Distopia', 'Corredor A - Prateleira 1', '2009-01-15', 0, 10, 45.90),
('9788575226079', 'Código Limpo', 'Alta Books', 'Tecnologia', 'Corredor B - Prateleira 3', '2009-09-08', 12, 15, 89.90),
('9788535918393', 'Dom Casmurro', 'Companhia das Letras', 'Romance Clássico', 'Corredor A - Prateleira 2', '2011-03-10', 30, 8, 29.90),
('9788595081536', 'O Hobbit', 'HarperCollins', 'Fantasia', 'Corredor C - Prateleira 1', '2019-07-15', 0, 12, 59.90),
('9788535911121', 'O Cortiço', 'Companhia das Letras', 'Naturalismo', 'Corredor A - Prateleira 2', '2008-05-20', 3, 5, 24.90),
('9788544001820', 'Pai Rico, Pai Pobre', 'Alta Books', 'Finanças', 'Corredor D - Prateleira 1', '2017-08-12', 60, 15, 49.90),
('9788535926217', 'O Alienista', 'Companhia das Letras', 'Sátira', 'Corredor A - Prateleira 2', '2015-09-01', 15, 5, 19.90),
('9788575228141', 'SQL Guia Prático', 'Alta Books', 'Tecnologia', 'Corredor B - Prateleira 3', '2020-02-18', 35, 7, 69.00),
('9788595084711', 'O Senhor dos Anéis: A Sociedade do Anel', 'HarperCollins', 'Fantasia', 'Corredor C - Prateleira 1', '2019-11-20', 45, 10, 79.90),
('9788580573015', 'A Culpa é das Estrelas', 'Intrínseca', 'Romance Juvenil', 'Corredor E - Prateleira 2', '2013-01-28', 18, 4, 39.90);


INSERT INTO Venda (CodBarProduto, valorTotal, quantidade, desconto) 
VALUES ('9788575226079', 169.80, 2, 10.00);


INSERT INTO Venda (CodBarProduto, valorTotal, quantidade, desconto) 
VALUES ('9788595081536', 59.90, 1, 0.00);


INSERT INTO Venda (CodBarProduto, valorTotal, quantidade, desconto) 
VALUES ('9788535914849', 122.70, 3, 15.00);

INSERT INTO Estoque (CodBarProduto, quantidade)
SELECT codigoBarras, quantidade 
FROM Livros;
