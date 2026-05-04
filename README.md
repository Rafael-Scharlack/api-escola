# 🏫 API Escola — Spring Boot + MySQL

API RESTful para gerenciamento de Alunos e Professores, desenvolvida com Spring Boot e banco de dados MySQL.

## 🛠️ Tecnologias Utilizadas

- Java 21
- Spring Boot 4.0.3
- Spring Data JPA / Hibernate
- MySQL 8.0
- Swagger / OpenAPI (SpringDoc)
- Docker
- Lombok

## ▶️ Como Rodar a Aplicação

### Pré-requisitos

- [Java 21](https://www.oracle.com/java/technologies/downloads/)
- [Docker Desktop](https://www.docker.com/products/docker-desktop/)
- [Git](https://git-scm.com/)

---

### 1. Clone o repositório

```bash
git clone https://github.com/Rafael-Scharlack/api-escola.git
cd api-escola
```

### 2. Suba o banco de dados com Docker

```bash
docker-compose up -d
```

Isso vai criar e iniciar um container MySQL com as seguintes configurações:

| Configuração | Valor |
|---|---|
| Host | localhost |
| Porta | 3306 |
| Banco | api_escola |
| Usuário | root |
| Senha | root |

### 3. Rode a aplicação

```bash
./mvnw spring-boot:run
```

A API estará disponível em: `http://localhost:8080`

### 4. Acesse o Swagger
http://localhost:8080

---

## 📋 Endpoints

### 👨‍🎓 Alunos

| Método | Rota | Descrição |
|---|---|---|
| GET | /alunos | Lista todos os alunos |
| GET | /alunos/{id} | Busca aluno por ID |
| POST | /alunos | Cria um novo aluno |
| PUT | /alunos/{id} | Atualiza um aluno |
| DELETE | /alunos/{id} | Remove um aluno |

**Exemplo de body para POST/PUT:**
```json
{
  "nome": "João Silva",
  "email": "joao@email.com",
  "turma": "Turma A",
  "mediaFinal": 8.5,
  "observacao": "Aluno destaque"
}
```

### 👨‍🏫 Professores

| Método | Rota | Descrição |
|---|---|---|
| GET | /professores | Lista todos os professores |
| GET | /professores/{id} | Busca professor por ID |
| POST | /professores | Cria um novo professor |
| PUT | /professores/{id} | Atualiza um professor |
| DELETE | /professores/{id} | Remove um professor |

**Exemplo de body para POST/PUT:**
```json
{
  "nome": "Antonio Carlos",
  "email": "antonio@fiap.com",
  "disciplina": "Microservices",
  "titulacao": "Doutor",
  "sala": "B12"
}
```

---

## 🐳 Docker

O arquivo `docker-compose.yml` já está na raiz do projeto. Para subir o banco:

```bash
docker-compose up -d
```

Para parar o banco:

```bash
docker-compose down
```