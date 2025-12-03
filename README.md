# Sistema de Gerenciamento de Tarefas (CRUD em Java)

Este projeto consiste em um sistema simples de gerenciamento de tarefas executado no console, desenvolvido em Java e organizado seguindo boas práticas de programação orientada a objetos. O sistema permite criar, listar, atualizar e excluir tarefas, mantendo uma estrutura limpa e separada em camadas (Model, Repository, Service e App).

Cada tarefa possui: id autoincrementado, título, descrição e data de conclusão (LocalDate).

---

## Estrutura do Projeto

O projeto segue a seguinte organização de pacotes:

src/
 └── main/
      └── java/
           ├── model/
           │     └── Tarefa.java
           ├── repository/
           │     └── TarefaRepository.java
           ├── service/
           │     └── TarefaService.java
           └── app/
                 └── Main.java

- model: contém a classe responsável pela representação da entidade Tarefa.
- repository: camada de acesso a dados, responsável por salvar, buscar, listar e remover tarefas.
- service: contém as regras de negócio e validações do CRUD.
- app: contém a classe principal responsável pela execução do menu da aplicação.

---

## Funcionalidades do Sistema

O sistema oferece um menu no console com as seguintes operações:

1. Cadastrar tarefa  
2. Listar tarefas  
3. Atualizar tarefa  
4. Excluir tarefa  
0. Sair  

As operações CRUD funcionam totalmente em memória, utilizando ArrayList.

---

## Como Executar

1. Certifique-se de ter o Java instalado (versão 17 ou superior recomendada).
2. Baixe ou clone este repositório.
3. Abra o projeto em uma IDE (IntelliJ, Eclipse, VS Code) ou compile no terminal.
