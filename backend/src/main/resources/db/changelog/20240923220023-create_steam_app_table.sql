-- liquibase formatted SQL

-- changeset alyamovsky:1
create table if not exists steam_apps
(
    id     uuid primary key,
    app_id int not null
);

-- rollback drop table steam_apps;