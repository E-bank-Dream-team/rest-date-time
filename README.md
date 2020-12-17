# sample_app


-   Application - http://localhost:8080/
-   Swagger UI - http://localhost:8080/swagger-ui.html
-   Application status - http://localhost:8080/api


To run spring app with application-{profile_name}.properties Profile. Default is "mock"

> mvn -P mock spring-boot:run

> mvn -P local spring-boot:run

To run spring app on Local with arguments

> mvn -P local -Dspring-boot.run.arguments="--db.user=test --db.pass=test --jwt.sec=secret" spring-boot:run


The endpoints `/api` and `/api/v1/samples` are NOT secured.
The rest resources require authorization. 
To authorize request add Authorization header with bearer token.


Mock profile has default jwt secret

> bcd7847c72d73b8fc4341f01d5cfec28f3265e8217f5d8f39fede5cc00b894c9

You can use the below Json Web Token to authorize on Mock environment

> eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.xG9oGgfEVD9r4c6DMBLJCT0K6V5XuN0IpZ_2Z3KMlAI


To get encoded Json Web Token use [jwt.io](https://jwt.io/) with selected option `secret base64 encoded` and specific `secret`.


To authorize request with Swagger click on padlock icon on the top or next to the chosen endpoint

Enter JWT like `Bearer yourJsonWebToken` and confirm with **`Authorize`**

Now all requests to the server will contain Authorization header with provided token.
