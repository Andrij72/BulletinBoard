create table role
(
    id   bigint not null auto_increment,
    name varchar(255),
    primary key (id)
)
    engine = MyISAM;

create table usr
(
    id         bigint not null auto_increment,
    email      varchar(255),
    first_name varchar(255),
    last_name  varchar(255),
    password   varchar(255),
    primary key (id)
) engine = MyISAM;

CREATE TABLE user_role
(
    user_id int NOT NULL,
    role_id int NOT NULL,
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES usr (id) ON UPDATE CASCADE,
    FOREIGN KEY (role_id) REFERENCES role (id) ON UPDATE CASCADE
)engine = MyISAM;

CREATE TABLE posts
(
    id             bigint not null auto_increment,
    title          VARCHAR(255),
    view          VARCHAR(255),
    full_text      VARCHAR(2048),
    reg_data       TIMESTAMP,
    author         VARCHAR(64),
    user_id        int NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES usr (id) ON DELETE CASCADE

)engine = MyISAM;

