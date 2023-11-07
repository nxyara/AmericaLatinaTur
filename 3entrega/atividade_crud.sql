CREATE DATABASE atividade_crud;

USE atividade_crud;

CREATE TABLE usuario(
id int primary key auto_increment,
nome varchar(255) not null,
login varchar(50) not null unique,
senha varchar(50) not null,
dataNasc datetime not null
);

USE atividade_crud;
select * from usuario;




