create table accounts(
    id uuid primary key,
    nickname varchar(128) unique not null,
    login varchar(128) unique not null,
    password varchar(64) not null,
    image_id uuid references images(id)
);