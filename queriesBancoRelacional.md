# 🐘 Guia Prático de PostgreSQL: Comandos e Queries Básicas

O PostgreSQL é um dos sistemas de gerência de banco de dados relacional (SGBDR) mais poderosos e utilizados no mercado. Neste guia, veremos como criar estruturas e consultar dados usando a linguagem **SQL** (Structured Query Language).
O PostgreSQL esta sendo usado pois, eh o banco que mais tenho facilidade, porem, nada vai mudar muito disso
---
1. O que é um Banco de Dados e uma Tabela?

Antes de colocar a mão no código, precisamos entender a estrutura onde guardamos nossas informações de forma organizada.

🗄️ O que é um Banco de Dados?

Um Banco de Dados (Database) é como um grande arquivo digital altamente organizado, projetado para armazenar, gerenciar e recuperar grandes volumes de informações com segurança e rapidez.

Analogia: Pense em um armário de arquivos de uma empresa. O armário inteiro (com várias gavetas e pastas) é o nosso Banco de Dados.

📊 O que é uma Tabela?

Uma Tabela é uma subdivisão dentro do banco de dados usada para organizar um tipo específico de informação. Ela é estruturada em linhas (registros ou tuplas) e colunas (atributos ou campos).

Analogia: Dentro daquele armário, a tabela seria uma pasta específica, por exemplo, a "Pasta de Clientes". Cada linha da tabela é a ficha de um cliente diferente, e as colunas são as informações de cada ficha (Nome, E-mail, Telefone).

2. Criando o Banco de Dados

Antes de criarmos tabelas, precisamos criar o "recipiente" principal onde todas as tabelas e dados vão morar: o Banco de Dados.

Criando um Banco (CREATE DATABASE)

No terminal do PostgreSQL (psql) ou em ferramentas como DBeaver / pgAdmin, executamos:

CREATE DATABASE minha_mentoria;


Dica: Lembre-se de se conectar ao banco recém-criado antes de criar as tabelas (no terminal, usamos o comando \c minha_mentoria;).

3. Comandos de Estrutura (DDL - Data Definition Language)

Agora que estamos dentro do nosso banco de dados, precisamos criar as tabelas para guardar as informações.

Criando uma Tabela (CREATE TABLE)

Definimos o nome da tabela e suas colunas com os respectivos tipos de dados (VARCHAR, INT, SERIAL, etc.).

CREATE TABLE usuarios (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    idade INT,
    criado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


SERIAL: Auto-incremento (o banco gera o ID 1, 2, 3 automaticamente).

PRIMARY KEY: Chave primária, identificador único de cada linha.

UNIQUE: Garante que não haverá valores duplicados nessa coluna.

4. Manipulação de Dados (DML - Data Manipulation Language)

Com a tabela criada, podemos inserir, alterar e remover registros.

Inserindo Dados (INSERT INTO)

INSERT INTO usuarios (nome, email, idade) 
VALUES ('Ana Silva', 'ana@email.com', 28);

INSERT INTO usuarios (nome, email, idade) 
VALUES ('Carlos Souza', 'carlos@email.com', 34);


5. Consultando Dados (DQL - Data Query Language)

A consulta é o comando mais utilizado no dia a dia. Usamos o comando SELECT.

Buscando Tudo (SELECT *)

Traz todas as colunas e todas as linhas da tabela.

SELECT * FROM usuarios;


Buscando Colunas Específicas

SELECT nome, email FROM usuarios;


Filtrando com WHERE

Permite trazer apenas os registros que atendem a uma condição específica.

SELECT * FROM usuarios 
WHERE idade > 30;


Ordenando Resultados com ORDER BY

-- Do mais novo para o mais velho (ASC é o padrão, DESC inverte)
SELECT * FROM usuarios 
ORDER BY idade ASC;


6. Atualizando e Removendo Dados

Atualizando Registros (UPDATE)

⚠️ Aviso de ouro: Sempre use o WHERE no UPDATE. Se esquecer, você vai alterar todos os registros da tabela!

UPDATE usuarios 
SET idade = 29 
WHERE email = 'ana@email.com';


Removendo Registros (DELETE)

⚠️ Aviso de ouro: Da mesma forma, o WHERE aqui é obrigatório para não apagar a tabela inteira por engano.

DELETE FROM usuarios 
WHERE id = 2;


💡 Dica para a Mentoria

Mostre aos alunos a hierarquia visual do banco de dados na prática:

Banco de Dados: O prédio ou o armário (ex: minha_mentoria).

Tabelas: As pastas ou gavetas de documentos (ex: usuarios).

Dados/Queries: As fichas individuais dentro da pasta e como você as localiza (ex: SELECT * FROM usuarios WHERE ...).