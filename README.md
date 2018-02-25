# Spring Boot sample REST project

## How to run

### Requirements
1. Running PostgreSQL (10.1) server.
2. Database with the name `springdb` created.

### Steps
1. Install Maven.
2. Install dependencies with Maven: `mvn clean install`.
3. Run the application `mvn spring-boot:run`.

The application will listen on port *9000*.

## Test
There is only one endpoint: `/users` which has GET (list all and get by ID) and POST methods.

Sample requests:

```bash
curl -d '{
  "firstName": "Tsvetan",
  "lastName": "Ganev",
  "email": "s136510@stud.uni-ruse.bg"
}' 'localhost:9000/users'
```

```bash
curl -X GET localhost:9000/users
```

```bash
curl -X GET localhost:9000/users/1
```
