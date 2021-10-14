-- create database strategic_planning;
create table if not exists organizations
(
    id bigserial
        constraint organizations_pk
            primary key,
    register_number varchar,
    corporate_name varchar

);

insert into organizations(corporate_name,register_number) values ('Amazing Company',0981234567);

