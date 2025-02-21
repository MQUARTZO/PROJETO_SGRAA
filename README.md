# 🐕 SGRAA - Sistema de Gestão para Adoção de Animais Domésticos

## 📝 Descrição do Projeto

O **SGRAA** é uma solução inovadora para a gestão de adoção de animais domésticos, promovendo um processo transparente e eficiente. O sistema permite o cadastro de animais, controle de adoções, gerenciamento de voluntários, registro de resgates e administração de doações. Ele foi desenvolvido com um foco especial em segurança, escalabilidade e facilidade de uso.

A aplicação utiliza **Spring Boot** para um backend eficiente, **Spring Security** para autenticação e controle de acessos, além de **MySQL** para armazenamento dos dados. O Postman pode ser utilizado para testar as requisições e validar os endpoints.

---

## 🔧 Tecnologias Utilizadas

- ☕ **Java 23**
- 🚀 **Spring Boot 3.x**
- 🔐 **Spring Security** (Autenticação baseada em sessão e banco de dados)
- 📦 **Spring Data JPA** (Hibernate para manipulação de dados)
- 🗄️ **MySQL** (Banco de dados relacional)
- 📜 **Maven** (Gerenciamento de dependências)
- 📝 **Lombok** (Redução de código boilerplate)
- 🛠️ **Postman** (Testes de API REST)

---

## 🏗 Configuração do Projeto

### 1️⃣ Configurar o Banco de Dados

1. Instale o MySQL e crie o banco de dados:

```sql
CREATE DATABASE sgraa CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```

2. Atualize o arquivo \`\` com suas credenciais:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/sgraa?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=SUA_SENHA_AQUI
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# Configuração do Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

### 2️⃣ Compilar e Rodar o Projeto

No terminal, navegue até a pasta do projeto e execute:

```sh
mvn clean install
```

Para iniciar a aplicação:

```sh
mvn spring-boot:run
```

A aplicação estará disponível em:

```
http://localhost:8080
```

---

## 🔒 Autenticação e Segurança

O **SGRAA** utiliza **Spring Security** para autenticação baseada em sessão e controle de acesso. Os usuários possuem diferentes papéis no sistema:

- 👨‍💼 **ADMIN**: Acesso total ao sistema, incluindo a gestão de usuários.
- 👨‍🚒 **VOLUNTARIO**: Acesso restrito às funcionalidades operacionais.

### 🔹 Endpoints de Autenticação

#### 🔑 Registrar um usuário (ADMIN ou VOLUNTÁRIO)

```http
POST http://localhost:8080/api/auth/register
```

```json
{
    "nome": "Admin",
    "email": "admin@email.com",
    "senha": "123456"
}
```

#### 🔑 Login (Gerenciado pelo Spring Security)

```http
GET http://localhost:8080/api/auth/me
```

*Retorna os dados do usuário logado.*

---

## 📌 Principais Endpoints da API

### 🦴 Animais

- ➕ **POST** `/api/animais` → Cadastrar um novo animal.
- 🔍 **GET** `/api/animais` → Listar todos os animais disponíveis.

### 🤝 Voluntários

- ➕ **POST** `/api/voluntarios` → Cadastrar um voluntário.
- 🔍 **GET** `/api/voluntarios` → Listar todos os voluntários.

### 🏡 Pretendentes à Adoção

- ➕ **POST** `/api/pretendentes` → Cadastrar um pretendente à adoção.
- 🔍 **GET** `/api/pretendentes` → Listar todos os pretendentes.

### 📜 Adoções

- ➕ **POST** `/api/adocoes` → Registrar uma nova adoção.
- 🔍 **GET** `/api/adocoes` → Listar todas as adoções registradas.

### 🎁 Doações

- ➕ **POST** `/api/doacoes` → Registrar uma nova doação.
- 🔍 **GET** `/api/doacoes` → Listar todas as doações recebidas.

### 🚑 Resgates

- ➕ **POST** `/api/resgates` → Registrar um novo resgate de animal.
- 🔍 **GET** `/api/resgates` → Listar todos os resgates registrados.

---

## 🔜 Próximos Passos

✅ **Aprimorar regras de negócio** (ex.: validar a compatibilidade entre pretendente e animal).\
✅ **Implementar logs e tratamento de erros** (uso de `@ExceptionHandler`).\
🔜 **Desenvolver testes automatizados** com **JUnit e Mockito**.\
🔜 **Melhorar a documentação** utilizando **Swagger**.

---

## 💡 Contribuição

Se deseja contribuir com o projeto, siga os passos abaixo:

1. Faça um **fork** do repositório.
2. Crie uma nova **branch** para a funcionalidade:

```sh
git checkout -b minha-feature
```

3. Faça as alterações e os commits:

```sh
git commit -m "Minha nova feature"
```

4. Envie para o repositório remoto:

```sh
git push origin minha-feature
```

5. Abra um **Pull Request** para análise.

---

🚀 **SGRAA: Tornando a adoção mais organizada, segura e eficiente!** 🐾🏠

