create table transactions(
    id uuid primary key,
    card_id uuid references cards(id),
    order_id uuid references orders(id),
    time_of_transaction timestamp not null
);