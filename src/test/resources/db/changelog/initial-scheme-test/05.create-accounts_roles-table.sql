create table accounts_roles(
    id uuid primary key,
    account_id uuid references accounts(id),
    role_id uuid references roles(id)
);