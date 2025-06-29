
# Insurance Management System 🛡️

This is a Spring Boot based backend project for managing an Insurance system. It supports user registration, customer policy management, premium handling, nominee management, claims, pagination, sorting, search, and more.

## 📌 Tech Stack

- Java 17 (can be downgraded to Java 8 if needed)
- Spring Boot
- Spring Data JPA
- Spring Security (Basic Auth)
- MySQL
- Hibernate
- Swagger for API documentation

---

## 🔐 Authentication

- User Registration: `POST /api/auth/register`
  - Sample JSON:
```json
{
  "username": "john_doe",
  "password": "password123",
  "role": "ROLE_USER"
}
```

Basic Auth is used for all protected endpoints.

---

## 📦 Customer APIs

- Add Customer: `POST /api/customer/add`
```json
{
  "fullName": "Avishkar Yadav",
  "emailId": "avishkar@gmail.com",
  "phoneNumber": "9022884452",
  "city": "Pune",
  "pinCode": 413207
}
```

- Get All Customers with Pagination & Sorting:
```
GET /api/customer/all?page=0&size=5&sort=fullName
```

---

## 📄 Policy APIs

- Add Policy: `POST /api/policy/add`
```json
{
  "policyNumber": 123456,
  "policyType": "Health Insurance",
  "startDate": "2025-07-01",
  "endDate": "2026-07-01",
  "coverageAmount": 500000,
  "premiumAmount": 8000,
  "customerId": 1
}
```

---

## 👨‍👩‍👦 Nominee APIs

- Add Nominee: `POST /api/nominee/add`
```json
{
  "nomineeNumber": 7890,
  "fullName": "Sanket Yadav",
  "relation": "Brother",
  "age": 26,
  "policyId": 1
}
```

---

## 💰 Premium APIs

- Add Premium: `POST /api/premium/add`
```json
{
  "amount": 4000,
  "dueDate": "2025-12-01",
  "paymentDate": "2025-12-05",
  "status": "paid",
  "policyId": 1
}
```

---

## 📄 Claim APIs

- Add Claim: `POST /api/claim/add`
```json
{
  "claimAmount": 10000,
  "claimDate": "2025-12-10",
  "status": "PENDING",
  "description": "Accident Recovery",
  "policyId": 1
}
```

---

## 🔁 Transactional Flow

- Uses `@Transactional` annotation in services to maintain consistency during multi-table operations.

---

## 📚 Swagger

API documentation is available at:  
```
http://localhost:8080/swagger-ui/index.html
```

---

## 🧪 Sample Credentials

```txt
Username: admin
Password: admin123
```

---

## 📂 Folder Structure (Important Packages)

- `controller` - REST APIs
- `serviceimpl` - Business logic
- `repository` - Spring Data JPA interfaces
- `model` - Entities
- `dto` - Request payloads
- `config` - Security configuration

---

## 🏁 How to Run

1. Start MySQL and create the database
2. Run the Spring Boot application
3. Use Postman or Swagger to test the endpoints

---

## ✅ Features

- Basic Authentication
- Role-Based Access
- Pagination, Sorting, Search
- One-to-Many and Many-to-One Mappings
- Swagger Documentation

---

## 📌 Author

Avishkar Yadav  
Java Backend Developer  
