create table cards(
    id uuid primary key,
    number varchar(16) unique not null,
    password varchar(64) unique not null,
    cvv varchar(64) unique not null,
    money numeric not null check(money >= 0),
    account_id uuid references accounts(id)
);