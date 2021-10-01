-- create database strategic_planning;
create table if not exists organizations
(
    id serial
        constraint organizations_pk
            primary key,
    corporate_name varchar,
    register_number varchar
);

insert into organizations(corporate_name,register_number) values ('Amazing Company',0981234567);

