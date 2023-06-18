CREATE TABLE tb_category
(
    id         SERIAL PRIMARY KEY,
    name       VARCHAR(255),
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    deleted_at TIMESTAMP
);

CREATE TABLE tb_board
(
    id          SERIAL PRIMARY KEY,
    category_id INTEGER,
    author      VARCHAR(255),
    title       VARCHAR(255),
    hit         INTEGER,
    content     TEXT,
    created_at  TIMESTAMP,
    updated_at  TIMESTAMP,
    deleted_at  TIMESTAMP,
    FOREIGN KEY (category_id) REFERENCES tb_category (id)
);

CREATE TABLE tb_attach
(
    id         SERIAL PRIMARY KEY,
    board_id   INTEGER,
    pathname   VARCHAR(255),
    size       BIGINT,
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    deleted_at TIMESTAMP,
    FOREIGN KEY (board_id) REFERENCES tb_board (id)
);

CREATE TABLE tb_comment
(
    id         SERIAL PRIMARY KEY,
    board_id   INTEGER,
    author     VARCHAR(255),
    content    TEXT,
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    deleted_at TIMESTAMP,
    FOREIGN KEY (board_id) REFERENCES tb_board (id)
);

CREATE TABLE tb_product
(
    id          SERIAL PRIMARY KEY,
    category_id INTEGER,
    name        VARCHAR(255),
    price       DECIMAL(10, 2),
    created_at  TIMESTAMP,
    updated_at  TIMESTAMP,
    deleted_at  TIMESTAMP,
    FOREIGN KEY (category_id) REFERENCES tb_category (id)
);