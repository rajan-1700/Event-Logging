# Event Logging System (Spring Boot + MongoDB)

A Spring Boot backend application that manages employees and automatically records
audit logs for every create, update, and delete operation using MongoDB.

This project demonstrates a clean layered architecture and real-world audit logging,
commonly used in enterprise applications.

---

## 🚀 Features

- Create, update, delete employees
- Automatic audit logging for all CRUD operations
- MongoDB-based persistence
- RESTful APIs
- Clean layered architecture (Controller, Service, Repository)

---

## 🛠 Tech Stack

- Java 21
- Spring Boot
- Spring Data MongoDB
- MongoDB
- Maven
- Postman (for API testing)

---



## ⚙️ Configuration

### MongoDB (`application.yml`)

```yaml
spring:
  data:
    mongodb:
      uri: mongodb://localhost:27017/audit_demo
````

---

## ▶️ How to Run

1. Start MongoDB

   ```bash
   mongosh
   ```

2. Clone the repository

   ```bash
   git clone https://github.com/rajan-1700/Event-Logging.git
   ```

3. Navigate to the project directory

   ```bash
   cd Event-Logging
   ```

4. Run the application

   ```bash
   mvn spring-boot:run
   ```

5. Application will start at

   ```
   http://localhost:8080
   ```

---

## 📬 API Endpoints

### ➕ Create Employee

```
POST /employees
```

```json
{
  "name": "Rajan",
  "salary": 60000,
  "department": "Engineering"
}
```

---

### 📄 Get All Employees

```
GET /employees
```

---

### ✏️ Update Employee

```
PUT /employees/{id}
```

```json
{
  "name": "Rajan Updated",
  "salary": 80000,
  "department": "Backend"
}
```

---

### ❌ Delete Employee

```
DELETE /employees/{id}
```

---

## 📊 Audit Logging

Every CREATE, UPDATE, and DELETE action automatically creates an audit log entry
stored in the `audit_logs` MongoDB collection.

Each audit log contains:

* Username
* Action type (CREATE / UPDATE / DELETE)
* Entity name
* Entity ID
* Timestamp

---

## 🧠 Key Learnings

* MongoDB lazy database creation behavior
* Spring Data MongoDB `save()` for insert and update
* Layered architecture best practices
* Handling real-world configuration and debugging issues

---



---

## 👤 Author

**Rajan Lature**
GitHub: [https://github.com/rajan-1700](https://github.com/rajan-1700)



