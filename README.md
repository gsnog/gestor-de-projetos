# 📋 API de Gestão de Projetos e Tarefas (To-Do Corporativo)

Uma API RESTful desenvolvida para gerenciar projetos e tarefas de equipes corporativas. Este projeto foca na implementação de relacionamentos de banco de dados, validações rigorosas de entrada de dados e endpoints customizados focados em regras de negócio.

---

## 🛠️ Tecnologias Utilizadas

* **Java 21+**
* **Spring Boot 3.x**
* **Spring Data JPA** (Mapeamento Objeto-Relacional)
* **H2 Database** (Banco de dados em memória)
* **Jakarta Bean Validation** (Segurança e integridade de dados)
* **Swagger / OpenAPI** (Documentação interativa)

---

## 🏗️ Arquitetura e Padrões

* **Padrão MVC em Camadas:** Separação clara entre `Controllers`, `Services` e `Repositories`.
* **Data Transfer Objects (DTOs):** Utilização de `records` do Java para criar contratos de entrada e saída rígidos, prevenindo a vulnerabilidade de *Overposting* e ocultando as Entidades do banco de dados.
* **Relacionamento 1:N:** Implementação de chaves estrangeiras (`@ManyToOne`) onde um Projeto pode conter múltiplas Tarefas.
* **Respostas HTTP Padronizadas:** Uso rigoroso de Status Codes (ex: `201 Created` para postagens, `204 No Content` para deleções, `404 Not Found` para buscas vazias).

---

## 🚀 Endpoints da API

A documentação interativa (Swagger) pode ser acessada rodando o projeto e visitando: `http://localhost:8080/swagger-ui/index.html`

### 📁 Projetos
* `POST /projetos` - Cria um novo projeto.
* `GET /projetos` - Lista todos os projetos.
* `GET /projetos/{id}` - Busca um projeto específico pelo ID.

### ✅ Tarefas
* `POST /tarefas` - Cria uma tarefa vinculada a um projeto (Requer `projetoId`).
* `GET /tarefas` - Lista todas as tarefas com o nome de seus respectivos projetos.
* `PUT /tarefas/{id}/concluir` - Endpoint de regra de negócio: Altera o status da tarefa para concluída (`true`) sem necessidade de enviar Body.
* `DELETE /tarefas/{id}` - Remove uma tarefa do sistema.

---

## ⚙️ Como executar localmente

1. Clone o repositório:
   ```bash
   git clone [https://github.com/gsnog/gestor-de-projetos.git](https://github.com/gsnog/gestor-de-projetos.git)
