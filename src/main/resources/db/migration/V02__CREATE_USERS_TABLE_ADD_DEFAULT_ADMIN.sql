create table if not exists users
(
    id bigserial
        constraint users_pk
            primary key,
    login varchar,
    password varchar,
    organization_id integer
);

insert into users(login,password,organization_id) values ('admin',123,1);

