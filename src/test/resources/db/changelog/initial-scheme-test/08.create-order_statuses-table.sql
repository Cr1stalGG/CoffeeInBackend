create table order_statuses(
    id uuid primary key,
    name varchar(32) unique not null,
    description text not null
);