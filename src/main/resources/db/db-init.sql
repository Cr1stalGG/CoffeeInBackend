create table images(
    id uuid primary key,
    object_name varchar(128) not null,
    bucket_name varchar(128) not null
);

create table roles(
    id uuid primary key,
    name varchar(64) unique not null,
    description text unique not null
);

create table accounts(
    id uuid primary key,
    nickname varchar(128) unique not null,
    login varchar(128) unique not null,
    password varchar(64) unique not null,
    image_id uuid references images(id)
);

create table cards(
    id uuid primary key,
    number varchar(16) unique not null,
    password varchar(64) unique not null,
    cvv varchar(64) unique not null,
    account_id uuid references accounts(id)
);

create table accounts_roles(
    id uuid primary key,
    account_id uuid references accounts(id),
    role_id uuid references roles(id)
);

create table categories(
    id uuid primary key,
    name varchar unique not null,
    description text unique not null
);

create table items(
    id uuid primary key,
    name varchar(128) unique not null,
    description text not null,
    price numeric not null check(price >= 0),
    category_id uuid references categories(id),
    image_id uuid references images(id)
);

create table order_statuses(
    id uuid primary key,
    name varchar(32) unique not null,
    description text not null
);

create table orders(
    id uuid primary key,
    order_status_id uuid references order_statuses(id),
    account_id uuid references accounts(id),
    summary_price numeric not null check(summary_price > 0),
    closing_time timestamp
);

create table orders_items(
    id uuid primary key,
    order_id uuid references orders(id),
    item_id uuid references items(id)
);

create table transactions(
    id uuid primary key,
    card_id uuid references cards(id),
    order_id uuid references orders(id),
    time_of_transaction timestamp not null
);