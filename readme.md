## Descrição
Teste para estágio na empresa: Support Inf. Equip. e Sists. Ltda.

Vaga Nº 196329 na plataforma Nube

CRUD básico com java web, usando servlets e jsp's. 

## Requisitos

- Um navegador de sua preferência

- Um servidor web, no meu caso é o Apache Toomcat

- Netbeans, Eclipse ou Spring tools como IDE.

- O seguinte esquema no banco de dados (preferencialmente o Postgresql):

```SQL
CREATE TABLE clientes (
	id serial PRIMARY KEY,
	firstName VARCHAR(20) NOT NULL, 
	lastName VARCHAR(20) NOT NULL,
	contactNumber VARCHAR(20) NOT NULL,
	address VARCHAR(50) NOT NULL,
	email VARCHAR(50) UNIQUE NOT NULL
);
```

## Etapas

1. Clonar o repositório na workspace da IDE desejada

2. Feito isso o gradle baixará as dependências necessárias.

3. Abra a classe ConnectionFactory.java e altere os dados referentes ao seu banco de dados (login, senha, porta e nome do Banco de dados). 

4. Prontinho, só dar run no projeto :)

## Checklist

## Feature's futuras