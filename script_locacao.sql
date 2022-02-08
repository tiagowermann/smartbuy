-- -----------------------------------------------------
-- Table pessoa
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS pessoa (
  id SERIAL NOT NULL,
  nome VARCHAR(100) NULL,
  email VARCHAR(100) NULL,
  senha VARCHAR(100) NULL,
  situacao VARCHAR(1) NULL,
  PRIMARY KEY (id)
);


-- -----------------------------------------------------
-- Table categoria
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS categoria (
  id SERIAL NOT NULL,
  descricao VARCHAR(100) NULL,
  situacao VARCHAR(1) NULL,
  PRIMARY KEY (id)
);


-- -----------------------------------------------------
-- Table item
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS item (
  id SERIAL NOT NULL,
  descricao VARCHAR(100) NULL,
  valor DECIMAL(10,2) NULL,
  situacao VARCHAR(1) NULL,
  categoria_id INT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (categoria_id) REFERENCES categoria (id)
);


-- -----------------------------------------------------
-- Table locacao
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS locacao (
  id SERIAL NOT NULL,
  data_hora_locacao TIMESTAMP WITHOUT TIME ZONE NOT NULL,
  data_hora_devolucao TIMESTAMP WITHOUT TIME ZONE NOT NULL,
  valor DECIMAL(10,2) NULL,
  situacao VARCHAR(1) NULL,
  pessoa_id INT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (pessoa_id) REFERENCES pessoa (id)
);


-- -----------------------------------------------------
-- Table financeiro
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS financeiro (
  id SERIAL NOT NULL,
  data_vencimento TIMESTAMP WITHOUT TIME ZONE NOT NULL,
  valor_vencimento DECIMAL(10,2) NULL,
  data_pagamento TIMESTAMP WITHOUT TIME ZONE NOT NULL,
  valor_pagamento DECIMAL(10,2) NULL,
  situacao VARCHAR(1) NULL,
  locacao_id INT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (locacao_id) REFERENCES locacao (id)
);


-- -----------------------------------------------------
-- Table locacao_itens
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS locacao_itens (
  id SERIAL NOT NULL,
  quantidade DECIMAL(10,2) NULL,
  valor_item decimal (10,2),
  locacao_id INT NOT NULL,
  item_id INT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (locacao_id) REFERENCES locacao (id),
  FOREIGN KEY (item_id) REFERENCES item (id)
);

