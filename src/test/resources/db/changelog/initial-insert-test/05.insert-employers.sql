insert into accounts(id, nickname, login, password)
    values('972de49e-fd6a-43c6-adf2-4cb101a71ec8', 'employer1', 'truDjagaSSS', '1234qwerty');
insert into accounts(id, nickname, login, password)
    values('2376c6e6-8fe5-4ea9-899a-2c98201003c8', 'employer2', 'truDjaga', '52forever');

insert into accounts_roles(id, account_id, role_id)
    values('d9f08058-19e6-46c5-b8f0-4a2d5f4b78c8', '972de49e-fd6a-43c6-adf2-4cb101a71ec8', '4e862438-c064-4db9-bebd-50ea4f089b17');
insert into accounts_roles(id, account_id, role_id)
    values('b6289504-275c-4dcb-90a6-c2925ebcc399', '2376c6e6-8fe5-4ea9-899a-2c98201003c8', '4e862438-c064-4db9-bebd-50ea4f089b17');