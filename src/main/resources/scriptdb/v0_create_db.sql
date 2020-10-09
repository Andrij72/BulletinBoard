CREATE TABLE role
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE usr
(
    id         SERIAL PRIMARY KEY,
    email      VARCHAR(255),
    first_name VARCHAR(64),
    last_name  VARCHAR(64),
    password   VARCHAR(255),
    UNIQUE (email)
);

CREATE TABLE user_role
(
    user_id int NOT NULL,
    role_id int NOT NULL,
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES usr (id) ON UPDATE CASCADE,
        FOREIGN KEY (role_id) REFERENCES role (id) ON UPDATE CASCADE
);

CREATE TABLE post
(
    id             SERIAL,
    title          VARCHAR(255),
    anons          VARCHAR(255),
    file           BIGINT,
    full_text      VARCHAR(4096),
    reg_date        TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    author         VARCHAR(64),
    user_id        int NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES usr (id) ON DELETE CASCADE
);

