-- create database strategic_planning;
create table if not exists organizations
(
    id bigserial
        constraint organizations_pkey
            primary key,
    register_number varchar,
    corporate_name varchar

);

insert into organizations(corporate_name,register_number) values ('Amazing Company',0981234567);
-------------------------------------------------------------

create table if not exists users
(
    id bigserial
        constraint users_pkey
            primary key,
    login varchar,
    password text,
    organization_id bigint not null
        constraint fk_organizations_users
            references organizations
);

insert into users(login,password,organization_id) values ('admin',123,1);

-------------------------------------------------------------

create table if not exists departments
(
    id              bigserial
        constraint departments_pkey
            primary key,
    description     varchar(255),
    organization_id bigint not null
        constraint fk_organizations_departments
            references organizations
);

insert into departments (description, organization_id)  values ('Finances', 1);




