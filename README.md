
データベース接続
```
docker exec -it demo-postgres psql -U postgres -d mydatabase
```

```
mydatabase=# SELECT table_name FROM information_schema.tables WHERE table_schema = 'public';
      table_name
-----------------------
 flyway_schema_history
 users
(2 rows)

mydatabase=# select * from users;
 id |       username        |                               password                               |         email          |         created_at
----+-----------------------+----------------------------------------------------------------------+------------------------+----------------------------     
  1 | o9119@yahoo.ne.jp     | aaaa1111                                                             | o9119@yahoo.ne.j   | 2024-06-23 08:39:24.382806   
```
