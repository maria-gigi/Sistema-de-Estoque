USE PinkiePie;

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    
    username VARCHAR(50) NOT NULL,
    psw VARCHAR(255) NOT NULL,
    
    nameFirst VARCHAR(100),
    sobrenome VARCHAR(100),
    
    matricula VARCHAR(50),
    cpf VARCHAR(14),
    
    sexo VARCHAR(10),
    dtaNascimento DATE,
    
    email VARCHAR(150),
    telefone VARCHAR(20),
    
    funcao VARCHAR(100),
    
    cep VARCHAR(10),
    endereco VARCHAR(150),
    numero VARCHAR(10),
    bairro VARCHAR(100),
    cidade VARCHAR(100),
    estado VARCHAR(50),
    complemento VARCHAR(150),
    
);

CREATE TABLE Livros(
    id INT AUTO_INCREMENT PRIMARY KEY,
    codigoBarras VARCHAR(100) NOT NULL UNIQUE ,
    titulo VARCHAR(255) NOT NULL,
    editora VARCHAR(255) NOT NULL,
    genero VARCHAR(100) NOT NULL,
    localArmazenamento VARCHAR(255),
    dataPublicacao DATE,
    quantidade INT,
    quantidadeMin INT,
    valor DECIMAL (10,2)
);


CREATE TABLE Venda{
	id INT AUTO_INCREMENT PRIMARY KEY,
	CodBarProduto VARCHAR(100),
	CONSTRAINT itensVenda_CodBarProduto FOREIGN KEY (CodBarProduto) 
	REFERENCES produtos(codigoBarras) ON UPDATE CASCADE,
	valorTotal DECIMAL(10,2);
	quantidade INT,
	desconto DECIMAL(10,2)
}

CREATE TABLE Estoque{
	id INT AUTO_INCREMENT PRIMARY KEY,
	CodBarProduto VARCHAR(100),
	CONSTRAINT itensVenda_CodBarProduto FOREIGN KEY (CodBarProduto) 
	REFERENCES produtos(codigoBarras) ON UPDATE CASCADE,
	quantidade INT
}























