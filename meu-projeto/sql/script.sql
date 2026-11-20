CREATE DATABASE IF NOT EXISTS db_sistema;
USE db_sistema;

-- Tabela de cadastros do sistema
CREATE TABLE IF NOT EXISTS usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL
);

-- Tabela de logins para acesso
CREATE TABLE IF NOT EXISTS autenticacao (
    id INT AUTO_INCREMENT PRIMARY KEY,
    login VARCHAR(50) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL
);
