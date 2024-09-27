create table items(
    id uuid primary key,
    name varchar(128) unique not null,
    description text not null,
    price numeric not null default 0 check(price >= 0),
    category_id uuid references categories(id),
    image_id uuid references images(id)
);