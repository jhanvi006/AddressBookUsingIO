-------------  UC1 - Create address_book_service database -----------------

mysql> SHOW DATABASES;
+--------------------+
| Database           |
+--------------------+
| information_schema |
| mysql              |
| payroll_services   |
| performance_schema |
| sakila             |
| sys                |
| world              |
+--------------------+
7 rows in set (0.00 sec)

mysql> CREATE DATABASE address_book_service;
Query OK, 1 row affected (0.01 sec)

mysql> SHOW DATABASES;
+----------------------+
| Database             |
+----------------------+
| address_book_service |
| information_schema   |
| mysql                |
| payroll_services     |
| performance_schema   |
| sakila               |
| sys                  |
| world                |
+----------------------+
8 rows in set (0.00 sec)

-------------  UC2 - Create address_book_table table ------------
mysql> USE address_book_service;
Database changed

mysql> CREATE TABLE address_book_table
    -> (
    -> first_name VARCHAR(150) NOT NULL,
    -> last_name VARCHAR(150) NOT NULL,
    -> address VARCHAR(150) NOT NULL,
    -> city VARCHAR(150) NOT NULL,
    -> state VARCHAR(150) NOT NULL,
    -> zip_code VARCHAR(10) NOT NULL,
    -> phone_no VARCHAR(15) NOT NULL,
    -> email VARCHAR(150) NOT NULL
    -> );
Query OK, 0 rows affected (0.04 sec)

mysql> DESC address_book_table;
+------------+--------------+------+-----+---------+-------+
| Field      | Type         | Null | Key | Default | Extra |
+------------+--------------+------+-----+---------+-------+
| first_name | varchar(150) | NO   |     | NULL    |       |
| last_name  | varchar(150) | NO   |     | NULL    |       |
| address    | varchar(150) | NO   |     | NULL    |       |
| city       | varchar(150) | NO   |     | NULL    |       |
| state      | varchar(150) | NO   |     | NULL    |       |
| zip_code   | varchar(10)  | NO   |     | NULL    |       |
| phone_no   | varchar(15)  | NO   |     | NULL    |       |
| email      | varchar(150) | NO   |     | NULL    |       |
+------------+--------------+------+-----+---------+-------+
8 rows in set (0.00 sec)

-------------  UC3 - Insert contacts in address_book_table ------------
mysql> INSERT INTO address_book_table (first_name, last_name, address, city, state, zip_code, phone_no, email)
    -> VALUES
    -> ('Mahek', 'Shah', 'Science City Road', 'Ahmedabad', 'Gujarat', '399001', '9898989800', 'mahek.shah@gmail.com'),
    -> ('Kabir', 'Mehra', 'Andheri', 'Mumbai', 'Maharashtra', '421007', '2312321111', 'kabira@yahoo.com'),
    -> ('Meera', 'Patel', 'Kalavad', 'Rajkot', 'Gujarat', '322880', '7856785600', 'meera@gmail.com');
Query OK, 3 rows affected (0.01 sec)
Records: 3  Duplicates: 0  Warnings: 0

mysql> SELECT * FROM address_book_table;
+------------+-----------+-------------------+-----------+-------------+----------+------------+----------------------+
| first_name | last_name | address           | city      | state       | zip_code | phone_no   | email                |
+------------+-----------+-------------------+-----------+-------------+----------+------------+----------------------+
| Mahek      | Shah      | Science City Road | Ahmedabad | Gujarat     | 399001   | 9898989800 | mahek.shah@gmail.com |
| Kabir      | Mehra     | Andheri           | Mumbai    | Maharashtra | 421007   | 2312321111 | kabira@yahoo.com     |
| Meera      | Patel     | Kalavad           | Rajkot    | Gujarat     | 322880   | 7856785600 | meera@gmail.com      |
+------------+-----------+-------------------+-----------+-------------+----------+------------+----------------------+
3 rows in set (0.00 sec)

-------------  UC4 - Edit contacts in table based on name ------------
mysql> UPDATE address_book_table
    -> SET email = 'kabir.mehra@yahoo.com', address = 'Baner', city = 'Pune'
    -> WHERE first_name = 'Kabir' AND last_name = 'Mehra';
Query OK, 1 row affected (0.01 sec)
Rows matched: 1  Changed: 1  Warnings: 0

mysql> SELECT * FROM address_book_table;
+------------+-----------+-------------------+-----------+-------------+----------+------------+-----------------------+
| first_name | last_name | address           | city      | state       | zip_code | phone_no   | email                 |
+------------+-----------+-------------------+-----------+-------------+----------+------------+-----------------------+
| Mahek      | Shah      | Science City Road | Ahmedabad | Gujarat     | 399001   | 9898989800 | mahek.shah@gmail.com  |
| Kabir      | Mehra     | Baner             | Pune      | Maharashtra | 421007   | 2312321111 | kabir.mehra@yahoo.com |
| Meera      | Patel     | Kalavad           | Rajkot    | Gujarat     | 322880   | 7856785600 | meera@gmail.com       |
+------------+-----------+-------------------+-----------+-------------+----------+------------+-----------------------+
3 rows in set (0.00 sec)

-------------  UC5 - Delete contact from table using first name ------------
mysql> DELETE FROM address_book_table WHERE first_name = 'Meera';
Query OK, 1 row affected (0.01 sec)

mysql> SELECT * FROM address_book_table;
+------------+-----------+-------------------+-----------+-------------+----------+------------+-----------------------+
| first_name | last_name | address           | city      | state       | zip_code | phone_no   | email                 |
+------------+-----------+-------------------+-----------+-------------+----------+------------+-----------------------+
| Mahek      | Shah      | Science City Road | Ahmedabad | Gujarat     | 399001   | 9898989800 | mahek.shah@gmail.com  |
| Kabir      | Mehra     | Baner             | Pune      | Maharashtra | 421007   | 2312321111 | kabir.mehra@yahoo.com |
+------------+-----------+-------------------+-----------+-------------+----------+------------+-----------------------+
2 rows in set (0.00 sec)

-------------  UC6 - Retrieve data based on city or state ----------------
mysql> SELECT * FROM address_book_table WHERE city = 'Pune';
+------------+-----------+---------+------+-------------+----------+------------+-----------------------+
| first_name | last_name | address | city | state       | zip_code | phone_no   | email                 |
+------------+-----------+---------+------+-------------+----------+------------+-----------------------+
| Kabir      | Mehra     | Baner   | Pune | Maharashtra | 421007   | 2312321111 | kabir.mehra@yahoo.com |
+------------+-----------+---------+------+-------------+----------+------------+-----------------------+
1 row in set (0.00 sec)

mysql> SELECT * FROM address_book_table WHERE state = 'Gujarat';
+------------+-----------+-------------------+-----------+---------+----------+------------+----------------------+
| first_name | last_name | address           | city      | state   | zip_code | phone_no   | email                |
+------------+-----------+-------------------+-----------+---------+----------+------------+----------------------+
| Mahek      | Shah      | Science City Road | Ahmedabad | Gujarat | 399001   | 9898989800 | mahek.shah@gmail.com |
+------------+-----------+-------------------+-----------+---------+----------+------------+----------------------+
1 row in set (0.00 sec)

-------------  UC7 - Get size of address book based on city and state ------------
mysql> SELECT city, count(city) AS contact_from_city FROM address_book_table WHERE city = 'Ahmedabad';
+-----------+-------------------+
| city      | contact_from_city |
+-----------+-------------------+
| Ahmedabad |                 1 |
+-----------+-------------------+
1 row in set (0.00 sec)

mysql> SELECT state, count(state) AS contact_from_state FROM address_book_table WHERE state = 'Gujarat';
+---------+--------------------+
| state   | contact_from_state |
+---------+--------------------+
| Gujarat |                  1 |
+---------+--------------------+
1 row in set (0.00 sec)

-------------  UC8 - Retrieve data sorted alphabetically ------------
mysql> SELECT * FROM address_book_table ORDER BY first_name ASC;
+------------+-----------+-------------------+-----------+-------------+----------+------------+-----------------------+
| first_name | last_name | address           | city      | state       | zip_code | phone_no   | email                 |
+------------+-----------+-------------------+-----------+-------------+----------+------------+-----------------------+
| Kabir      | Mehra     | Baner             | Pune      | Maharashtra | 421007   | 2312321111 | kabir.mehra@yahoo.com |
| Mahek      | Shah      | Science City Road | Ahmedabad | Gujarat     | 399001   | 9898989800 | mahek.shah@gmail.com  |
+------------+-----------+-------------------+-----------+-------------+----------+------------+-----------------------+
2 rows in set (0.01 sec)

-------------  UC9 - Alter table to add address_book_name & type ------------
mysql> ALTER TABLE address_book_table ADD address_book_name VARCHAR(150) AFTER email,
    -> ADD address_book_type VARCHAR(150) AFTER address_book_name;
Query OK, 0 rows affected (0.03 sec)
Records: 0  Duplicates: 0  Warnings: 0

mysql> desc address_book_table;
+-------------------+--------------+------+-----+---------+-------+
| Field             | Type         | Null | Key | Default | Extra |
+-------------------+--------------+------+-----+---------+-------+
| first_name        | varchar(150) | NO   |     | NULL    |       |
| last_name         | varchar(150) | NO   |     | NULL    |       |
| address           | varchar(150) | NO   |     | NULL    |       |
| city              | varchar(150) | NO   |     | NULL    |       |
| state             | varchar(150) | NO   |     | NULL    |       |
| zip_code          | varchar(10)  | NO   |     | NULL    |       |
| phone_no          | varchar(15)  | NO   |     | NULL    |       |
| email             | varchar(150) | NO   |     | NULL    |       |
| address_book_name | varchar(150) | YES  |     | NULL    |       |
| address_book_type | varchar(150) | YES  |     | NULL    |       |
+-------------------+--------------+------+-----+---------+-------+
10 rows in set (0.00 sec)

mysql> SELECT * FROM address_book_table;
+------------+-----------+-------------------+-----------+-------------+----------+------------+-----------------------+-------------------+-------------------+
| first_name | last_name | address           | city      | state       | zip_code | phone_no   | email                 | address_book_name | address_book_type |
+------------+-----------+-------------------+-----------+-------------+----------+------------+-----------------------+-------------------+-------------------+
| Mahek      | Shah      | Science City Road | Ahmedabad | Gujarat     | 399001   | 9898989800 | mahek.shah@gmail.com  | NULL              | NULL              |
| Kabir      | Mehra     | Baner             | Pune      | Maharashtra | 421007   | 2312321111 | kabir.mehra@yahoo.com | NULL              | NULL              |
+------------+-----------+-------------------+-----------+-------------+----------+------------+-----------------------+-------------------+-------------------+
2 rows in set (0.01 sec)

mysql> UPDATE address_book_table
    -> SET address_book_name = 'School', address_book_type = "Friends"
    -> WHERE first_name = "Mahek";
Query OK, 1 row affected (0.01 sec)
Rows matched: 1  Changed: 1  Warnings: 0

mysql> SELECT * FROM address_book_table;
+------------+-----------+-------------------+-----------+-------------+----------+------------+-----------------------+-------------------+-------------------+
| first_name | last_name | address           | city      | state       | zip_code | phone_no   | email                 | address_book_name | address_book_type |
+------------+-----------+-------------------+-----------+-------------+----------+------------+-----------------------+-------------------+-------------------+
| Mahek      | Shah      | Science City Road | Ahmedabad | Gujarat     | 399001   | 9898989800 | mahek.shah@gmail.com  | School            | Friends           |
| Kabir      | Mehra     | Baner             | Pune      | Maharashtra | 421007   | 2312321111 | kabir.mehra@yahoo.com | NULL              | NULL              |
+------------+-----------+-------------------+-----------+-------------+----------+------------+-----------------------+-------------------+-------------------+
2 rows in set (0.00 sec)

mysql> UPDATE address_book_table
    -> SET address_book_name = 'abc', address_book_type = "Family"
    -> WHERE first_name = "Kabir";
Query OK, 1 row affected (0.01 sec)
Rows matched: 1  Changed: 1  Warnings: 0

mysql> SELECT * FROM address_book_table;
+------------+-----------+-------------------+-----------+-------------+----------+------------+-----------------------+-------------------+-------------------+
| first_name | last_name | address           | city      | state       | zip_code | phone_no   | email                 | address_book_name | address_book_type |
+------------+-----------+-------------------+-----------+-------------+----------+------------+-----------------------+-------------------+-------------------+
| Mahek      | Shah      | Science City Road | Ahmedabad | Gujarat     | 399001   | 9898989800 | mahek.shah@gmail.com  | School            | Friends           |
| Kabir      | Mehra     | Baner             | Pune      | Maharashtra | 421007   | 2312321111 | kabir.mehra@yahoo.com | abc               | Family            |
+------------+-----------+-------------------+-----------+-------------+----------+------------+-----------------------+-------------------+-------------------+
2 rows in set (0.00 sec)

mysql> INSERT INTO address_book_table (first_name, last_name, address, city, state, zip_code, phone_no, email, address_book_name, address_book_type)
    -> VALUES
    -> ('Karan', 'Mehta', 'Andheri', 'Mumbai', 'Maharashtra', '411090', '4312300990', 'karanm@gmail.com', 'tcs', 'Professional'),
    -> ('Pooja', 'Nanda', 'Kalawad', 'Rajkot', 'Gujarat', '311011', '8800991200', 'pooja@gmail.com', 'tcs', 'Friends');
Query OK, 2 rows affected (0.01 sec)
Records: 2  Duplicates: 0  Warnings: 0

mysql> SELECT * FROM address_book_table;
+------------+-----------+-------------------+-----------+-------------+----------+------------+-----------------------+-------------------+-------------------+
| first_name | last_name | address           | city      | state       | zip_code | phone_no   | email                 | address_book_name | address_book_type |
+------------+-----------+-------------------+-----------+-------------+----------+------------+-----------------------+-------------------+-------------------+
| Mahek      | Shah      | Science City Road | Ahmedabad | Gujarat     | 399001   | 9898989800 | mahek.shah@gmail.com  | School            | Friends           |
| Kabir      | Mehra     | Baner             | Pune      | Maharashtra | 421007   | 2312321111 | kabir.mehra@yahoo.com | abc               | Family            |
| Karan      | Mehta     | Andheri           | Mumbai    | Maharashtra | 411090   | 4312300990 | karanm@gmail.com      | tcs               | Professional      |
| Pooja      | Nanda     | Kalawad           | Rajkot    | Gujarat     | 311011   | 8800991200 | pooja@gmail.com       | tcs               | Friends           |
+------------+-----------+-------------------+-----------+-------------+----------+------------+-----------------------+-------------------+-------------------+
4 rows in set (0.00 sec)

-------------  UC10 - Retrieve no. contacts count by type ------------
mysql> SELECT address_book_type, count(address_book_type) FROM address_book_table GROUP BY address_book_type;
+-------------------+--------------------------+
| address_book_type | count(address_book_type) |
+-------------------+--------------------------+
| Friends           |                        2 |
| Family            |                        1 |
| Professional      |                        1 |
+-------------------+--------------------------+
3 rows in set (0.01 sec)

-------------  UC18 - Add column date_added ------------
mysql> ALTER TABLE address_book_table ADD date_added DATE AFTER address_book_type;
Query OK, 0 rows affected (0.05 sec)
Records: 0  Duplicates: 0  Warnings: 0

mysql> desc address_book_table;
+-------------------+--------------+------+-----+---------+-------+
| Field             | Type         | Null | Key | Default | Extra |
+-------------------+--------------+------+-----+---------+-------+
| first_name        | varchar(150) | NO   |     | NULL    |       |
| last_name         | varchar(150) | NO   |     | NULL    |       |
| address           | varchar(150) | NO   |     | NULL    |       |
| city              | varchar(150) | NO   |     | NULL    |       |
| state             | varchar(150) | NO   |     | NULL    |       |
| zip_code          | varchar(10)  | NO   |     | NULL    |       |
| phone_no          | varchar(15)  | NO   |     | NULL    |       |
| email             | varchar(150) | NO   |     | NULL    |       |
| address_book_name | varchar(150) | YES  |     | NULL    |       |
| address_book_type | varchar(150) | YES  |     | NULL    |       |
| date_added        | date         | YES  |     | NULL    |       |
+-------------------+--------------+------+-----+---------+-------+
11 rows in set (0.00 sec)

mysql> UPDATE address_book_table SET date_added = '2019-10-01' WHERE first_name = 'Mahek';
Query OK, 1 row affected (0.04 sec)
Rows matched: 1  Changed: 1  Warnings: 0

mysql> UPDATE address_book_table SET date_added = '2018-03-21' WHERE first_name = 'Kabir';
Query OK, 1 row affected (0.01 sec)
Rows matched: 1  Changed: 1  Warnings: 0

mysql> UPDATE address_book_table SET date_added = '2022-09-15' WHERE first_name = 'Karan';
Query OK, 1 row affected (0.01 sec)
Rows matched: 1  Changed: 1  Warnings: 0

mysql> UPDATE address_book_table SET date_added = '2021-12-12' WHERE first_name = 'Pooja';
Query OK, 1 row affected (0.01 sec)
Rows matched: 1  Changed: 1  Warnings: 0

mysql> SELECT * FROM address_book_table;
+------------+-----------+-------------------+-----------+-------------+----------+------------+-----------------------+-------------------+-------------------+------------+
| first_name | last_name | address           | city      | state       | zip_code | phone_no   | email                 | address_book_name | address_book_type | date_added |
+------------+-----------+-------------------+-----------+-------------+----------+------------+-----------------------+-------------------+-------------------+------------+
| Mahek      | Shah      | Science City Road | Ahmedabad | Gujarat     | 399001   | 9898989800 | mahek.shah@gmail.com  | School            | Friends           | 2019-10-01 |
| Kabir      | Mehra     | Baner             | Pune      | Maharashtra | 421007   | 2312321111 | kabir.mehra@yahoo.com | abc               | Family            | 2018-03-21 |
| Karan      | Mehta     | Andheri           | Mumbai    | Maharashtra | 411090   | 4312300990 | karanm@gmail.com      | tcs               | Professional      | 2022-09-15 |
| Pooja      | Patel     | Kalawad           | Rajkot    | Gujarat     | 311011   | 8800991200 | pooja@gmail.com       | tcs               | Friends           | 2021-12-12 |
+------------+-----------+-------------------+-----------+-------------+----------+------------+-----------------------+-------------------+-------------------+------------+
4 rows in set (0.00 sec)