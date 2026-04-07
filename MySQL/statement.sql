SELECT * FROM customer; -- Works but SLOW retrieval do to grabbing all columns
SELECT c.first_name, c.last_name, c.email, a.balance, a.type FROM customers c INNER JOIN accounts a ON c.id = a.customer_id WHERE a.balance > 250; -- WORKS was able to retrieve 14 customer data
select c.id, c.first_name, c.email, c.last_name, a.account_number, a.type FROM customers c, accounts a order by id; -- WORKS was able to find the total 10 customers with different accounts
select a.balance From accounts a WHERE account_number='JDB-1001-CHK'; -- WORKS was able to find the account balance
select a.type, c.email From accounts a, customers c LEFT join accounts ON c.first_name ; ----WORKS was able to do join and get data
insert into customers(id,email,first_name,last_name,created_at)
values(16,'abc@gmail.com','abc','abc','1999-01-20 12:20:00');---WORKS was able to insert the values
select id From customers where first_name = 'abc'; ----was able to get the id by first name
insert into accounts(customer_id,account_number,type,balance,status)
values ('16','ABC-9999-FGH', 'BUSINESS', '888.95', 'ACTIVE');-- was able to insert values in accounts
select id,customer_id,account_number,type,balance,status From accounts where balance = '888.95'; --WORKS was able to get values by balance
delete from customers where id = '16'; ---WORKS was able to delete the customer


