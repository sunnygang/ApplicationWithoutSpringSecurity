CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255),
    password VARCHAR(255),
    role VARCHAR(255)
);

insert into users (username, password, role) values ('admin', 'admin123', 'ADMIN');
insert into users (username, password, role) values ('user', 'user123', 'USER');
