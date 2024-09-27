create table images(
    id uuid primary key,
    object_name varchar(128) not null,
    bucket_name varchar(128) not null
);