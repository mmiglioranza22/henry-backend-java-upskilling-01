CREATE TABLE IF NOT EXISTS categorias
(
    id        INT PRIMARY KEY auto_increment,
    categoria VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS gastos
(
    id            INT PRIMARY KEY AUTO_INCREMENT,
    monto         INT,
    fecha         DATE,
    es_recurrente BOOLEAN,
    saldado       BOOLEAN,
    fecha_saldado DATE,
    created_at    timestamp DEFAULT CURRENT_TIMESTAMP,
    updated_at    timestamp DEFAULT CURRENT_TIMESTAMP,
    soft_delete   BOOLEAN,
    deleted_at    timestamp,
    categoria_id  INT,
    FOREIGN KEY (categoria_id) REFERENCES categorias (id)
);


-- SELECT gastos.*
-- from gastos
-- where id = 1;
--
-- SELECT a.*, b.categoria "categoria"
-- FROM gastos AS a
--          JOIN categorias AS b
--               ON a.categoria_id = b.id;
--
-- SELECT gastos.*, categorias.categoria "categoria"
-- FROM gastos
--          JOIN categorias
--               ON gastos.categoria_id = categorias.id;