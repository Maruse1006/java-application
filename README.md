
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


WebSecurityConfig.java は、Spring Securityの基本的なセキュリティ設定を行うクラスです。これにより、ログイン処理も含めたアプリケーション全体のセキュリティ設定が管理されます。
具体的には、ログイン時に必ず使われます。


HTTPセキュリティの設定 (configure(HttpSecurity http) メソッド)

このメソッドで、ログインページへのアクセス、ログイン処理の流れ、アクセス制御を設定します。
今回の設定では、以下のセキュリティが適用されます:
すべてのリクエストが認証を必要とする (authorizeRequests().anyRequest().authenticated()).
HTTP Basic 認証を使用する (httpBasic()).
