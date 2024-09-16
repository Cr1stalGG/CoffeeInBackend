create table roles(
    id uuid primary key,
    name varchar(64) unique not null,
    description text unique not null
);