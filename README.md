# 📦 Sistema de Controle de Estoque

Sistema de gerenciamento de estoque desenvolvido em **Java**, utilizando **MySQL** como banco de dados e **Docker** para conteinerização da aplicação e do banco de dados.

O objetivo do projeto é fornecer uma aplicação simples para o gerenciamento de produtos, permitindo o cadastro, consulta, atualização e remoção de itens do estoque de forma eficiente.

---

## 🚀 Tecnologias Utilizadas

- ☕ Java
- 🐬 MySQL
- 🐳 Docker
- Docker Compose
- JDBC
- Maven

---

## 📁 Estrutura do Projeto

```
estoque/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   └── resources/
│   │
│   └── test/
│
├── docker/
│
├── docker-compose.yml
├── Dockerfile
├── pom.xml
└── README.md
```

---

## ⚙️ Funcionalidades

- Cadastro de produtos
- Listagem de produtos
- Busca por produto
- Atualização de informações
- Exclusão de produtos
- Controle de quantidade em estoque
- Persistência dos dados em banco MySQL
- Cadastro de usuário

---

## 🐳 Executando com Docker

### Clone o repositório

```bash
git clone https://github.com/seu-usuario/estoque.git
```

Entre na pasta do projeto

```bash
cd estoque
```

Suba os containers

```bash
docker-compose up --build
```

O Docker irá iniciar:

- Aplicação Java
- Banco de dados MySQL

---

## 📈 Possíveis Melhorias

- Controle de permissões
- Relatórios
- Dashboard
- Testes automatizados
- Deploy em nuvem

---

## 👩‍💻 Desenvolvido por

**Gisele Maria Sousa Santana**

Projeto desenvolvido para fins de estudo, aplicando conceitos de:

- Programação Orientada a Objetos (POO)
- Persistência de dados
- JDBC
- Banco de Dados Relacional
- Docker
- Conteinerização de aplicações
