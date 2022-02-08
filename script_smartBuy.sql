CREATE TABLE IF NOT EXISTS usuario (
  id SERIAL NOT NULL,
  email VARCHAR(100) NULL,
  name VARCHAR(50) NULL,
  lastname VARCHAR(100) NULL,
  password VARCHAR(50) NULL,
  PRIMARY KEY (id)
);


CREATE TABLE IF NOT EXISTS categoria (
  id SERIAL NOT NULL,
  descricao VARCHAR(100) NULL,
  situacao VARCHAR(1) NULL,
  PRIMARY KEY (id)
);


CREATE TABLE IF NOT EXISTS produto (
  id SERIAL NOT NULL,
  descricao VARCHAR(50) NULL,
  quantidade INT NULL,
  precoVenda DECIMAL(12,2) NULL,
  estoque INT NULL,
  status VARCHAR(1) NULL,
  categoria_id INT NOT NULL,
  img BYTEA NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (categoria_id) REFERENCES categoria (id)
);

CREATE TABLE IF NOT EXISTS compraProduto (
  id SERIAL NOT NULL,
  descricao VARCHAR(50) NULL,
  quantidade INT NULL,
  precoVenda DECIMAL(12,2) NULL,
  categoria_id INT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (categoria_id) REFERENCES categoria (id)
);





==================== COMANDOS ===========================================================
SELECT * FROM usuario
INSERT INTO usuario VALUES (default, 'tiago@gmail.com', 'Tiago', 'Wermann', md5('1234'))
DELETE FROM usuario WHERE id=4
ALTER TABLE produto ADD COLUMN img BYTEA
DROP TABLE produto