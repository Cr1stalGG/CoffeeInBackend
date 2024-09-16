create table cards(
    id uuid primary key,
    number varchar(16) unique not null,
    password varchar(64) unique not null,
    cvv varchar(64) unique not null,
    account_id uuid references accounts(id)
);