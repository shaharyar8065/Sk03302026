SELECT * FROM customer; -- Works but SLOW retrieval do to grabbing all columns
SELECT c.first_name, c.last_name, c.email, a.balance, a.type FROM customers c INNER JOIN accounts a ON c.id = a.customer_id WHERE a.balance > 250; -- WORKS was able to retrieve 14 customer data
select c.id, c.first_name, c.email, c.last_name, a.account_number, a.type FROM customers c, accounts a order by id; -- WORKS was able to find the total 10 customers with different accounts
select a.balance From accounts a WHERE account_number='JDB-1001-CHK'; -- WORKS was able to find the account balance