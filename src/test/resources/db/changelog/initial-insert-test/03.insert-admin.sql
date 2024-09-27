insert into accounts(id, nickname, login, password)
    values('229ccc83-f332-422b-aed8-4e1b3598eb55', 'admin', 'admin', 'root');

insert into accounts_roles(id, account_id, role_id)
    values('ebc34e03-0d82-43d9-80d5-f24bbcd876e8', '229ccc83-f332-422b-aed8-4e1b3598eb55', 'ea6b81db-ce23-48e9-bb88-fb21368a709c');