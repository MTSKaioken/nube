/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  mtskaioken
 * Created: 17 de mar de 2022
 */
CREATE TABLE clientes (
	id serial PRIMARY KEY,
	firstName VARCHAR(20) NOT NULL, 
	lastName VARCHAR(20) NOT NULL,
	contactNumber VARCHAR(20) NOT NULL,
	address VARCHAR(50) NOT NULL,
	email VARCHAR(50) UNIQUE NOT NULL
);

INSERT INTO clientes(firstName, lastName, contactNumber, address, email) values ('fernando', 
'cabral', '11111-11', 'rua são joão, 266', 'fernando234@gmail.com');


INSERT INTO clientes(firstName, lastName, contactNumber, address, email) values ('Isa', 
'Dias', '2222-21', 'rua sei la, 66', 'diasisa23@gmail.com');


INSERT INTO clientes(firstName, lastName, contactNumber, address, email) values ('ricardo', 
'Santos', '234324-11', 'rua são roque, 246', 'ricardinhonaosei@gmail.com');

