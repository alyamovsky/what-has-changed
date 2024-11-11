-- liquibase formatted SQL

-- changeset alyamovsky:1
create table steam_apps
(
    app_id int primary key,
    name varchar(255),
    added_at timestamp not null default current_timestamp,
    updated_at timestamp default null
);

-- rollback drop table steam_apps;