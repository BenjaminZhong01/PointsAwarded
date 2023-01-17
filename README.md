REST API FOR POINTS REWARDED
1. Description: this project use Spring Boot Framework to develop a restful api to calculate points rewarded of each customer in total and monthly.
2. The project is run with Spring Boot Framework v3.0.1 and Java 17.
3. The test dataset is in transaction-schema which has two tables: customer and transaction. There are some test records for each table, including transactions in three month from Jan 2022 to Mar 2022.
   
| customer_id | customer_name  |
|:-----------:|:--------------:|
|      2      | benjamin zhong |
|      3      |      lisa      |
|      4      |      Mary      |
|      5      |      Tom       |


| transaction+id | transaction_date | transaction_amount | transaction_customer (FK) |
|:--------------:|:----------------:|--------------------|---------------------------|
|       1        |    2022-01-01    | 10.12              | 2                         |
|       2        |    2022-01-01    | 210.12             | 2                         |
|       3        |    2022-01-09    | 210.12             | 2                         |
|       4        |    2022-02-09    | 60                 | 2                         |
|       5        |    2022-03-09    | 160                | 2                         |
|       6        |    2022-03-09    | 260                | 2                         |
|       7        |    2022-01-16    | 234.33             | 3                         |
|       8        |    2022-02-11    | 23                 | 3                         |
|       9        |    2022-02-20    | 440                | 3                         |
|       10       |    2022-03-12    | 100                | 3                         |
|       11       |    2022-01-11    | 3232               | 4                         |
|       12       |    2022-03-13    | 222                | 4                         |
|       13       |    2022-03-12    | 123                | 5                         |

5. For simplification, the project provides four API for CURD of customers, four API for CURD of transactions and two API for calculation of points rewarded. All requests are in JSON format and HTTP protocol.
* Create customer: http://localhost:8080/api/customers
* Update customer: http://localhost:8080/api/customers/{customerID}
* Read customers: http://localhost:8080/api/customers
* Delete customer: http://localhost:8080/api/customers/{customerID}

* Create transaction: http://localhost:8080/api/transactions
* Update transaction: http://localhost:8080/api/transactions/{transactionID}
* Read transactions: http://localhost:8080/api/transactions
* Delete transaction: http://localhost:8080/api/transactions/{transactionID}

* Show customer total points rewarded: http://localhost:8080/api/transactions/rewards/total/{customerID}
* Show customer monthly points rewarded: http://localhost:8080/api/transactions/rewards/monthly/{customerID}

6. Test requests:to get customer 2 total points, visit http://localhost:8080/api/transactions/rewards/total/2 and server responses 1420.0. To get customer 2 monthly points, visit http://localhost:8080/api/transactions/rewards/monthly/2 and server responses [680,10,730]. They are the monthly points rewarded from Jan to Mar in 2022. 
