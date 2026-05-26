# 👨‍💼 Sistema de Cadastro de RH

<p align="center">
  <img src="https://i.pinimg.com/736x/ff/b8/7e/ffb87e3108268bcfcb220962e424eb6d.jpg" width="500">
</p>

---

# 📌 Sistema de Cadastro de RH

Projeto backend desenvolvido com Java e Spring Boot para gerenciamento de funcionários em um sistema de Recursos Humanos.

---

## 🛠️ Tecnologias Utilizadas

* Java
* Spring Boot
* Spring Data JPA
* MySQL
* Maven
* Git & GitHub
* Insomnia
* STS / Eclipse

---

# 📚 Table of Contents

* 📌 About
* 🚀 Features
* 👓 Revised Concepts
* 📕 Installation
* 🎮 Getting Started
* 🌐 Technologies
* 🔄 Endpoints
* 👥 Team
* 📝 License

---

# 📌 About

O Sistema de Cadastro de RH é uma aplicação backend desenvolvida para auxiliar no gerenciamento de funcionários dentro de uma empresa.

A aplicação foi construída utilizando Java com Spring Boot, seguindo o padrão de arquitetura MVC e utilizando banco de dados MySQL para persistência dos dados.

O sistema permite:

* Cadastro de funcionários
* Consulta de registros
* Atualização de dados
* Exclusão de funcionários
* Busca personalizada por atributos

---

# 🚀 Features

## Funcionalidades do Projeto

* CRUD completo de Funcionários
* Busca de funcionário por ID
* Busca por função
* Busca por salário maior que o informado
* Integração com banco MySQL
* API REST
* Validação de dados
* Arquitetura MVC
* Persistência com Spring Data JPA

---

# 👓 Revised Concepts

## Conceitos Aplicados no Projeto

* Arquitetura MVC
* Desenvolvimento de API REST
* CRUD com Spring Boot
* Persistência de dados com JPA
* Relacionamento com banco MySQL
* Versionamento com Git e GitHub
* Validações com Bean Validation
* Endpoints REST
* Organização em camadas
* Testes de API com Insomnia

---

# 📕 Installation

## Pré-requisitos

Você deve possuir instalado:

* Java JDK
* Maven
* MySQL
* STS ou Eclipse

---

## Recomendações

* Utilizar o Insomnia para testar os endpoints
* Utilizar STS ou Eclipse como IDE de desenvolvimento

---

## Instalação do Projeto

### 1. Clonar o repositório

```bash id="ndtpkt"
git clone https://github.com/Projeto-Integrador-Grupo-06
```

---

### 2. Configurar o banco de dados

Criar o banco MySQL:

```sql id="t2jgnr"
CREATE DATABASE db_sistemarh;
```

---

### 3. Configurar o application.properties

```properties id="hrr1dj"
spring.datasource.url=jdbc:mysql://localhost/db_sistemarh
spring.datasource.username=root
spring.datasource.password=sua_senha

spring.jpa.hibernate.ddl-auto=update
```

---

### 4. Executar a aplicação

Abra o projeto na IDE e execute a classe:

```text id="8uqabm"
ProjetoIntegradorSistemaRhApplication
```

---

# 🎮 Getting Started

Após executar a aplicação, o backend iniciará localmente.

Agora você poderá testar os endpoints utilizando o Insomnia.

Exemplo:

```http id="1s49s8"
GET http://localhost:8080/funcionarios
```

---

# 🔄 Endpoints

## CREATE

Cadastrar funcionário:

```http id="w7fuh6"
POST /funcionarios
```

---

## READ

Listar funcionários:

```http id="br7rmr"
GET /funcionarios
```

Buscar funcionário por ID:

```http id="zk54ec"
GET /funcionarios/{id}
```

---

## UPDATE

Atualizar funcionário:

```http id="bwgm3x"
PUT /funcionarios
```

---

## DELETE

Excluir funcionário:

```http id="wo8hph"
DELETE /funcionarios/{id}
```

---

## Busca por função

```http id="w8f2c2"
GET /funcionarios/funcao/{funcao}
```

---

## Busca por salário maior que o informado

```http id="9nmk18"
GET /funcionarios/salario/{salario}
```

---

# 📨 Exemplo de Requisição

## Cadastro de Funcionário

```json id="0wfxqg"
{
  "nome": "Rafael",
  "funcao": "Desenvolvedor",
  "salario": 5000,
  "setor": "TI"
}
```

---

# 🌐 Technologies

* Java
* Spring Boot
* Spring Data JPA
* MySQL
* Maven
* GitHub
* Insomnia

---

# 👥 Team

| Integrantes       |
| ----------------- |
| Giovanna Mendes   |
| Bianca Casagrande |
| Jonhatan de Jesus |
| Dayane Santana    |
| Isabella Rodrigues|
| Rafael Scherer    |

---

# 📝 License

Projeto desenvolvido para fins educacionais durante o bootcamp da Generation Brasil.

---

# 🔗 Repositório

[Projeto Integrador Grupo 06](https://github.com/Projeto-Integrador-Grupo-06/rh-backend/tree/main)
