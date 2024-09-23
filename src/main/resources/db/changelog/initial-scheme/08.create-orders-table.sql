create table orders(
    id uuid primary key,
    account_id uuid references accounts(id),
    summary_price numeric not null check(summary_price >= 0),
    closing_time timestamp
);