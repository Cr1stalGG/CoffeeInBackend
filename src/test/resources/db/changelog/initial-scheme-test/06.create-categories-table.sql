create table categories(
    id uuid primary key,
    name varchar unique not null,
    description text unique not null
);
