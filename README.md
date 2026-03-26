# 🚀 Spring Boot GraphQL Demo

## 📌 Overview

This project demonstrates how to build **GraphQL APIs using Spring Boot**.

Unlike traditional REST APIs, GraphQL allows:

* Fetching **only required data**
* Combining multiple queries in a single request
* Handling **nested data efficiently** ([GitHub][1])

---

## 🏗️ Architecture

```text
Client → GraphQL Endpoint (/graphql) → Spring Boot → Database
```

* GraphQL acts as a query layer
* Spring Boot handles business logic
* Database stores application data

---

## 🔥 Features

* ✅ GraphQL Query implementation
* ✅ GraphQL Mutation support
* ✅ Nested data fetching
* ✅ Clean API design (no over-fetching)
* ✅ Spring Boot integration

---

## ⚙️ Technologies Used

* Java 21
* Spring Boot 3
* Spring GraphQL
* Spring Data JPA
* Hibernate
* Maven
* Lombok

---

## 📂 Project Structure

```text
src/main/java
 ├── controller      → GraphQL resolvers (@QueryMapping, @MutationMapping)
 ├── service         → Business logic
 ├── repository      → Data access layer
 ├── entity          → Database models
 └── config          → GraphQL configuration
```

---

## 🧠 GraphQL Concepts Used

### 🔹 Query

Fetch data

```graphql
query {
  getAllBookings {
    id
    customerName
    amount
  }
}
```

---

### 🔹 Mutation

Modify data

```graphql
mutation {
  createBooking(customerName: "Chandan", amount: 1500) {
    id
    status
  }
}
```

---

### 🔹 Schema Definition

GraphQL schema is defined in:

```text
src/main/resources/graphql/*.graphqls
```

Example:

```graphql
type Booking {
  id: ID
  customerName: String
  amount: Float
}

type Query {
  getAllBookings: [Booking]
}

type Mutation {
  createBooking(customerName: String, amount: Float): Booking
}
```

---

## 📡 API Endpoint

```http
POST /graphql
```

---

## 🧪 Sample Request

```json
{
  "query": "query { getAllBookings { id customerName amount } }"
}
```

---

## 🧪 Sample Response

```json
{
  "data": {
    "getAllBookings": [
      {
        "id": 1,
        "customerName": "Chandan",
        "amount": 1500
      }
    ]
  }
}
```

---

## 🛠️ Setup Instructions

### 1️⃣ Clone Repository

```bash
git clone https://github.com/chandansinghpatel007/SpringBootGraphQLDemo.git
cd SpringBootGraphQLDemo
```

---

### 2️⃣ Run Application

```bash
mvn clean install
mvn spring-boot:run
```

---

### 3️⃣ Access GraphQL Playground

Open:

```text
http://localhost:8080/graphql
```

Use:

* Postman
* Altair GraphQL Client
* GraphiQL UI

---

## ⚠️ Common Issues & Fixes

### ❌ Schema not loading

✔ Ensure `.graphqls` file is inside:

```text
resources/graphql/
```

---

### ❌ 404 on /graphql

✔ Add dependency:

```xml
<artifactId>spring-boot-starter-graphql</artifactId>
```

---

### ❌ Null data in response

✔ Check:

* Query field names
* Schema mapping

---

## 🔁 REST vs GraphQL

| Feature        | REST     | GraphQL |
| -------------- | -------- | ------- |
| Multiple calls | ❌        | ✅       |
| Over-fetching  | ❌        | ✅       |
| Flexibility    | Low      | High    |
| Endpoint       | Multiple | Single  |

---

## 🚀 Future Enhancements

* GraphQL Subscriptions (Real-time)
* Authentication & Authorization
* Pagination support
* API Gateway integration
* Microservices GraphQL federation

---

## 👨‍💻 Author

**Chandan Singh Patel**
