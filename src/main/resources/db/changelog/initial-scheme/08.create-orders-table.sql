create table orders(
    id uuid primary key,
    account_id uuid references accounts(id),
    closing_time timestamp
);