CREATE TABLE music (
    id bigserial not null,
    titulo varchar(50),
    autor varchar(50),
    album varchar(50),
    genero varchar(20),
    primary key (id)
    );