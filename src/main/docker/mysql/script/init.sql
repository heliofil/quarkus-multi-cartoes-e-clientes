CREATE DATABASE IF NOT EXISTS altdb;
USE altdb;

CREATE TABLE cliente(
  cpf CHAR(11) PRIMARY KEY,
  nome_completo VARCHAR(100) NOT NULL,
  data_nascimento TIMESTAMP NOT NULL,
  telefone VARCHAR(20),
  email VARCHAR(100),
  cep CHAR(8) NOT NULL,
  uf CHAR(2) NOT NULL,
  cidade VARCHAR(40) NOT NULL,
  bairro VARCHAR(40) NOT NULL,
  logradouro VARCHAR(150),
  numero VARCHAR(20),
  complemento VARCHAR(100),
  e_ativo BOOL,
  data_criacao TIMESTAMP,
  data_atualizacao TIMESTAMP,
  UNIQUE KEY (cpf),
  INDEX (nome_completo),
  INDEX (data_nascimento)
);


CREATE TABLE bandeira(
    id TINYINT UNSIGNED PRIMARY KEY,
    nome VARCHAR(30) NOT NULL,
    data_criacao TIMESTAMP,
    data_atualizacao TIMESTAMP
);

INSERT INTO bandeira (id,nome, data_criacao, data_atualizacao) VALUES
(1,'Visa', NOW(), null),
(2,'Mastercard', NOW(), null);

CREATE TABLE motivo_reemissao(
    id TINYINT UNSIGNED PRIMARY KEY,
    nome VARCHAR(35) NOT NULL,
    data_criacao TIMESTAMP,
    data_atualizacao TIMESTAMP
);

INSERT INTO motivo_reemissao (id,nome, data_criacao, data_atualizacao) VALUES
(1,'Perda', NOW(), null),
(2,'Roubo', NOW(), null),
(3,'Dano', NOW(), null);


CREATE TABLE cartao(
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    numero VARCHAR(16) NOT NULL,
    cvv INT UNSIGNED NOT NULL,
    nome_titular VARCHAR(20) NOT NULL,
    cpf CHAR(11) NOT NULL,
    e_digital BOOL DEFAULT 0,
    e_cancelado BOOLEAN DEFAULT 0,
    motivo_reemissao TINYINT UNSIGNED,
    data_validade TIMESTAMP,
    id_bandeira TINYINT UNSIGNED,
    cartao_pai BIGINT UNSIGNED,
    data_criacao TIMESTAMP,
    data_atualizacao TIMESTAMP,
    INDEX (id_bandeira),
    INDEX (data_validade),
    INDEX (numero),
    UNIQUE KEY (id_bandeira, numero),
    FOREIGN KEY (cartao_pai) REFERENCES cartao(id),
    FOREIGN KEY (id_bandeira) REFERENCES bandeira(id),
    FOREIGN KEY (cpf) REFERENCES cliente(cpf),
    FOREIGN KEY (motivo_reemissao) REFERENCES motivo_reemissao(id)
);

CREATE TABLE pedido(
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    id_cartao BIGINT UNSIGNED NOT NULL,
    situacao ENUM ('EMITIDO','ENVIADO','RETORNO','ENTREGUE') NOT NULL,
    observacao VARCHAR(200),
    endereco_entrega VARCHAR(200),
    data_criacao TIMESTAMP,
    data_atualizacao TIMESTAMP,
    FOREIGN KEY (id_cartao) REFERENCES cartao(id)
);


