# 📚 Sistema Biblioteca

Sistema de gerenciamento de biblioteca desenvolvido em Java utilizando Programação Orientada a Objetos (POO), arquitetura em camadas, persistência de dados em arquivos e controle de acesso por usuários.

Este projeto foi desenvolvido com o objetivo de praticar conceitos fundamentais de desenvolvimento backend, organização de código e versionamento utilizando Git e GitHub.

---

## 🚀 Funcionalidades

### 📖 Gerenciamento de Livros
- Adicionar livros
- Listar livros cadastrados
- Buscar livro por título
- Remover livros
- Controle de empréstimo
- Controle de devolução

### 👤 Gerenciamento de Usuários
- Login de usuários
- Controle de permissões
- Perfil ADMIN
- Persistência de usuários

### 🔒 Segurança
- Armazenamento de senhas utilizando hash SHA-256
- Validação de autenticação

### 💾 Persistência de Dados
- Armazenamento em arquivos TXT
- Carregamento automático dos dados ao iniciar o sistema

---

## 🏗️ Arquitetura do Projeto

O projeto foi estruturado utilizando separação de responsabilidades em camadas.

```text
src/
└── biblioteca
    ├── model
    │   ├── Livro.java
    │   └── Usuario.java
    │
    ├── repository
    │   ├── LivroRepository.java
    │   └── UsuarioRepository.java
    │
    ├── service
    │   ├── BibliotecaService.java
    │   └── UsuarioService.java
    │
    └── view
        └── Main.java
```

### Camadas

#### Model
Responsável pelas entidades do sistema.

- Livro
- Usuario

#### Repository
Responsável pela persistência dos dados.

- Leitura de arquivos
- Escrita de arquivos

#### Service
Responsável pelas regras de negócio.

- Login
- Cadastro
- Empréstimos
- Devoluções
- Estatísticas

#### View
Responsável pela interação com o usuário via console.

---

## 🛠️ Tecnologias Utilizadas

- Java
- Programação Orientada a Objetos (POO)
- Collections Framework
- Manipulação de Arquivos (File I/O)
- Git
- GitHub

---

## ▶️ Como Executar

### Pré-requisitos

- Java JDK 17 ou superior
- IntelliJ IDEA (recomendado)

### Passos

Clone o repositório:

```bash
git clone https://github.com/devrodrigoandrade/SistemaBiblioteca.git
```

Acesse o projeto:

```bash
cd SistemaBiblioteca
```

Abra no IntelliJ IDEA.

Execute a classe:

```text
Main.java
```

---

## 🔑 Usuário Padrão

Na primeira execução o sistema cria automaticamente:

```text
Usuário: admin
Senha: 123
Perfil: ADMIN
```

---

## 📊 Funcionalidades Implementadas

| Funcionalidade | Status |
|---------------|--------|
| Cadastro de livros | ✅ |
| Listagem de livros | ✅ |
| Busca de livros | ✅ |
| Remoção de livros | ✅ |
| Empréstimo | ✅ |
| Devolução | ✅ |
| Login | ✅ |
| Controle de usuários | ✅ |
| Persistência em arquivos | ✅ |
| Hash de senha | ✅ |

---

## 🎯 Próximas Melhorias

- API REST com Spring Boot
- Banco de dados MySQL
- JPA/Hibernate
- Swagger
- JWT Authentication
- Testes Unitários com JUnit
- Docker
- Deploy em nuvem

---

## 📚 Conceitos Aplicados

- Programação Orientada a Objetos
- Encapsulamento
- Abstração
- Separação de Responsabilidades
- Arquitetura em Camadas
- Persistência de Dados
- Controle de Acesso
- Versionamento com Git

---

## 👨‍💻 Autor

**Rodrigo Andrade**

Desenvolvedor em formação, pastor, escritor e entusiasta de tecnologia.

### Contato

GitHub:
https://github.com/devrodrigoandrade

LinkedIn:
https://linkedin.com/in/rodrigoandrade-dev

---

## ⭐ Objetivo do Projeto

Este projeto faz parte da minha jornada de aprendizado em desenvolvimento de software e composição de portfólio para oportunidades de estágio e desenvolvimento júnior.

Toda evolução do projeto será registrada através de commits e novas versões publicadas neste repositório.
