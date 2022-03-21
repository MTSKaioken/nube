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
- [x] Create
- [x] Read
- [x] Update
- [x] Delete
## Feature's futuras
- [ ] Imagem do Software em docker 
- [ ] Paginação
- [ ] Autenticações e Controle de acessos a partir de middlewares
- [ ] Log de rotas
- [ ] Subir os schemas do Banco de dados junto a aplicação, sem ajuda de ORM'S ou frameworks java
- [ ] Filtros especificos
- [ ] Deleção em massa
- [ ] Configurações de variaveis de ambiente do projeto com .env ou .properties
- [ ] Relatórios do projeto com PDF'S e otros tipos de arquivos, ex: excel
- [ ] disponibilização dos dados da aplicação através de uma API 
- [ ] Consumo da API em versão desktop
- [ ] CRUD usuario
- [ ] Sessions
