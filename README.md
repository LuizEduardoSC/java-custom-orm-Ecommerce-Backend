# java-custom-orm (Ecommerce Backend) 🚀

Este é o projeto desenvolvido durante o Módulo 30 do curso Backend (Ebac), com o objetivo de criar uma infraestrutura de **Persistência de Dados** utilizando **JDBC** puro e um padrão **Generic DAO** baseado em **Reflection** e **Anotações customizadas** em Java.

## 🎯 Objetivo do Projeto
Demonstrar a construção de um mini "ORM" (Object-Relational Mapping) do zero em Java. O projeto utiliza anotações customizadas para mapear entidades diretamente para tabelas do banco de dados relacional (PostgreSQL), executando operações de **CRUD** (Create, Read, Update, Delete) de forma genérica sem precisar rescrever SQL repetidamente para novas entidades.

## 🛠️ Tecnologias e Ferramentas Utilizadas
- **Java** (JDK)
- **JDBC (Java Database Connectivity)**
- **PostgreSQL** (Banco de dados relacional)
- **JUnit 4** (Testes Unitários Automatizados)
- **Custom Annotations** (`@Tabela`, `@ColunaTabela`, `@TipoChave`)
- **Reflection API** (para o Generic DAO ler os metadados das classes em tempo de execução)

## 🗂️ Estrutura e Arquitetura

1. **Anotações (`anotacao`)**: Foram criadas anotações personalizadas para marcar as classes de domínio (`@Tabela` para referenciar qual será a tabela do DB, `@ColunaTabela` para as colunas e `@TipoChave` para identificar a PK no banco).
2. **Entidades (`domain`)**:
   - `Cliente`: Representa a tabela `tb_cliente`, agora contendo funcionalidades estendidas, incluindo gerenciamento de datas recentes com `java.time.Instant` (`data_nascimento`).
   - `Produto`: Representa a tabela `tb_produto`, mapeando chaves, valores decimais e demais informações do comércio.
3. **Persistência Genérica (`dao.generic`)**:
   - `GenericDAO`: O coração do projeto. Classe que recebe qual é a Entidade sendo utilizada e, varrendo as anotações do Java via `Reflection`, gera as strings SQL (`INSERT`, `UPDATE`, `DELETE`, `SELECT`) dinamicamente.
4. **Fábrica de Conexões (`dao.generic.jdbc`)**:
   - `ConnectionFactory`: Classe baseada no padrão *Singleton* que estabelece e gerencia as conexões com o PostgreSQL (`vendas_online_2`).
5. **Testes Unitários (`src/test/`)**:
   - Cobertura de testes (`ClienteDAOTest`, `ProdutoDAOTest`) validando cenários de Sucesso, Inserção, Edição, Buscas e deleções automatizadas garantindo que o banco reage propriamente ao nosso ORM Customizado.

## ⚙️ Como executar

### 1. Preparando o Banco de Dados
Certifique-se de possuir o **PostgreSQL** instalado e crie um database chamado `vendas_online_2`. O Generic DAO espera que as tabelas já estejam criadas com o seguinte formato:

**Tabela Cliente:**
```sql
CREATE TABLE tb_cliente (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cpf BIGINT NOT NULL UNIQUE,
    tel BIGINT NOT NULL,
    endereco VARCHAR(150) NOT NULL,
    numero INT NOT NULL,
    cidade VARCHAR(100) NOT NULL,
    estado VARCHAR(50) NOT NULL,
    data_nascimento TIMESTAMP
);
```

**Tabela Produto:**
```sql
CREATE TABLE tb_produto (
    id BIGSERIAL PRIMARY KEY,
    codigo VARCHAR(50) NOT NULL UNIQUE,
    nome VARCHAR(100) NOT NULL,
    descricao VARCHAR(150) NOT NULL,
    valor NUMERIC(10,2) NOT NULL,
    data_validade TIMESTAMP
);
```

### 2. Configurando o Projeto no seu Ambiente
- Importe o projeto no seu editor (Eclipse ou VS Code).
- Verifique a dependência do *Driver do PostgreSQL*. No arquivo `.classpath`, a biblioteca deve apontar para algo como `lib/postgresql-42.7.10.jar`. Se não existir, baixe-a e coloque na pasta `lib/` do projeto.
- Verifique a dependência do JUnit no `.classpath`.
- Ajuste caso necessário seu usuário e senha do Postgres no arquivo `ConnectionFactory.java`.

### 3. Executando os Testes
- Rode a suite `AllTests.java` ou as classes `ClienteDAOTest.java` e `ProdutoDAOTest.java` como um **Teste JUnit**.
- O sucesso da barra verde validará que sua conexão está saudável e que as varreduras de Reflection do Custom ORM no Banco PostgreSQL foram bem-sucedidas!

---

*Projeto construído abordando conceitos profundos do Java e fortalecendo as bases de frameworks complexos do mercado como Hibernate/JPA.*
