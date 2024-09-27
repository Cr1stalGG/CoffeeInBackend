insert into accounts(id, nickname, login, password)
    values('d96ad304-9271-4e77-8ada-720fde20b308', 'account1', 'asdf123', '1234qwerty');
insert into accounts(id, nickname, login, password)
    values('41786770-7e45-4760-86e6-be025ef3190d', 'account2', 'some_userNn', '52forever');

insert into accounts_roles(id, account_id, role_id)
    values('d8695337-506d-4f97-b539-38ae8e03d5f9', 'd96ad304-9271-4e77-8ada-720fde20b308', 'a7fe5e10-45d2-4767-8ecd-316b920c13e7');
insert into accounts_roles(id, account_id, role_id)
    values('0f494606-cd84-4595-a6d0-4604d44a8b11', '41786770-7e45-4760-86e6-be025ef3190d', 'a7fe5e10-45d2-4767-8ecd-316b920c13e7');