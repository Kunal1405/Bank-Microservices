# 🏦 Bank Microservices

This repository contains a **Banking System** built using **Java Spring Boot** that consists of three microservices:

- **Accounts Service** 🌐
- **Loans Service** 💼
- **Cards Service** 🌊

Each microservice provides **CRUD RESTful APIs** and is documented with **OpenAPI**.

## 🛠️ Tech Stack

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
![Swagger](https://img.shields.io/badge/OpenAPI-85EA2D?style=for-the-badge&logo=swagger&logoColor=black)
![Lombok](https://img.shields.io/badge/Lombok-CA4245?style=for-the-badge&logo=lombok&logoColor=white)

- **Spring Boot** (Microservices Framework)
- **Spring Data JPA** (Database ORM)
- **Spring Validation** (Data validation)
- **Audit Aware** (Tracking changes)
- **MySQL** (Database)
- **OpenAPI (Swagger)** (API Documentation)

## 🛠️ Setup & Installation

1. Clone the repository:
    ```sh
    git clone https://github.com/Kunal1405/Bank-Microservices.git
    cd bank-microservices
    ```
2. Configure **MySQL Database** in `application.properties`.
3. Build and run the services:
    ```sh
    mvn clean install
    mvn spring-boot:run
    ```
4. Access **Swagger API Docs**:
    - **Accounts Service**: `http://localhost:8080/swagger-ui/index.html`
    - **Loans Service**: `http://localhost:8081/swagger-ui/index.html`
    - **Cards Service**: `http://localhost:8082/swagger-ui/index.html`

---

## 🔗 API Endpoints

### ✅ Accounts Service (`/api`)

| Method | Endpoint       | Description |
|--------|--------------|-------------|
| **POST** | `/api/create` | Create a new account |
| **GET**  | `/api/fetch?mobileNo={number}` | Fetch account details |
| **PUT**  | `/api/update` | Update account details |
| **DELETE** | `/api/delete?mobileNo={number}` | Delete an account |

### 💼 Loans Service (`/loans`)

| Method | Endpoint           | Description |
|--------|------------------|-------------|
| **POST** | `/loans/apply?mobileNo={number}` | Apply for a new loan |
| **GET**  | `/loans/fetchLoan/{mobileNo}` | Fetch loan details |
| **POST** | `/loans/update` | Update loan details |
| **DELETE** | `/loans/deleteAccount/{mobileNo}` | Delete a loan account |

### 🌊 Cards Service (`/cards`)

| Method | Endpoint            | Description |
|--------|-------------------|-------------|
| **POST** | `/cards/create?mobileNo={number}` | Create a new card |
| **GET**  | `/cards/fetchCard/{mobileNo}` | Fetch card details |
| **POST** | `/cards/updateCard` | Update card details |
| **DELETE** | `/cards/delete/{mobileNo}` | Delete a card |

---

## 🎉 Contributors
- **Kunal Sangwan** (Developer)

## ✨ Features
- RESTful APIs with **CRUD operations**
- **Swagger API Documentation** with OpenAPI
- **Audit Aware** for tracking changes
- **Validation with Spring Boot**

## 🛡️ License
This project is **MIT Licensed**. Feel free to use and modify!

🔗 **GitHub Repository**: [https://github.com/your-username/bank-microservices](https://github.com/Kunal1405/Bank-Microservices)

