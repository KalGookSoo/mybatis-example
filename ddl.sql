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

/* 사용자 */
CREATE TABLE tb_user
(
    id             SERIAL PRIMARY KEY,
    username       VARCHAR(255) UNIQUE,
    name           VARCHAR(255),
    password       VARCHAR(255),
    email          VARCHAR(255),
    contact_number VARCHAR(255),
    created_at     TIMESTAMP,
    updated_at     TIMESTAMP,
    deleted_at     TIMESTAMP
);

/* 권한 */
CREATE TABLE tb_authority
(
    id         SERIAL PRIMARY KEY,
    name       VARCHAR(255) UNIQUE,
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    deleted_at TIMESTAMP
);

INSERT INTO tb_authority (name, created_at) VALUES ('CREATE_PRIVILEGE', CURRENT_TIMESTAMP);
INSERT INTO tb_authority (name, created_at) VALUES ('READ_PRIVILEGE', CURRENT_TIMESTAMP);
INSERT INTO tb_authority (name, created_at) VALUES ('UPDATE_PRIVILEGE', CURRENT_TIMESTAMP);
INSERT INTO tb_authority (name, created_at) VALUES ('DELETE_PRIVILEGE', CURRENT_TIMESTAMP);

/* 역할 */
CREATE TABLE tb_role
(
    id         SERIAL PRIMARY KEY,
    name       VARCHAR(255) UNIQUE,
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    deleted_at TIMESTAMP
);

INSERT INTO tb_user (name, created_at) VALUES ('ROLE_USER', CURRENT_TIMESTAMP);
INSERT INTO tb_user (name, created_at) VALUES ('ROLE_MANAGER', CURRENT_TIMESTAMP);
INSERT INTO tb_user (name, created_at) VALUES ('ROLE_ADMIN', CURRENT_TIMESTAMP);

/* 사용자 - 권한 연계 */
CREATE TABLE tb_user_authority
(
    id           SERIAL PRIMARY KEY,
    user_id      INTEGER REFERENCES tb_user (id),
    authority_id INTEGER REFERENCES tb_authority (id),
    created_at   TIMESTAMP,
    updated_at   TIMESTAMP,
    deleted_at   TIMESTAMP
);

/* 사용자 - 역할 연계 */
CREATE TABLE tb_user_role
(
    id         SERIAL PRIMARY KEY,
    user_id    INTEGER REFERENCES tb_user (id),
    role_id    INTEGER REFERENCES tb_role (id),
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    deleted_at TIMESTAMP
);

/* 권한 - 역할 연계 */
CREATE TABLE tb_authority_role
(
    id           SERIAL PRIMARY KEY,
    authority_id INTEGER REFERENCES tb_authority (id),
    role_id      INTEGER REFERENCES tb_role (id),
    created_at   TIMESTAMP,
    updated_at   TIMESTAMP,
    deleted_at   TIMESTAMP
);