create table orders_items(
    id bigserial primary key,
    order_id uuid references orders(id),
    item_id uuid references items(id)
);