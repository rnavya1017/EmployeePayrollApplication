# Employee Payroll Application

A comprehensive **Spring Boot REST API application** for managing employees, departments, addresses, payroll information, greetings, exception handling, external API integration, and application logging.

This project is designed to demonstrate important **Spring Boot and backend development concepts** including REST APIs, Spring Data JPA, Hibernate, DTOs, validation, exception handling, AOP, WebClient, and database relationships.

---

## 📌 Features

### 👨‍💼 Employee Management

* Create employee
* Retrieve all employees
* Retrieve employee by ID
* Update employee details
* Delete employee
* Validate employee input
* Prevent duplicate employee data

### 📍 Address Management

* Add employee address
* Retrieve addresses
* Update address details
* Delete address
* Manage employee-address relationships

### 💰 Payroll Management

* Create employee payroll information
* Retrieve payroll details
* Update payroll information
* Delete payroll information
* Manage employee-payroll relationships

### 🏢 Department Management

* Manage employee departments
* Map employees with departments
* Validate department information

### 👋 Greeting Management

* Generate and manage greeting responses through REST APIs.

### 🌐 External API Integration

The application integrates with external APIs using:

* Spring WebClient
* External Employee API
* External User API
* External Address API
* External Company API

### ⚠️ Exception Handling

The application provides centralized exception handling for:

* Employee not found
* Address not found
* Department not found
* Payroll not found
* Duplicate data
* External service failures

### 📝 Logging

Application logging is implemented using:

* Spring AOP
* Logging Aspect

This helps track method execution and improve debugging.

---

# 🛠️ Technologies Used

| Technology                       | Purpose                            |
| -------------------------------- | ---------------------------------- |
| Java                             | Programming Language               |
| Spring Boot                      | Backend Framework                  |
| Spring Web                       | REST API Development               |
| Spring Data JPA                  | Database Access                    |
| Hibernate                        | ORM Framework                      |
| Spring WebClient                 | External API Integration           |
| PostgreSQL / Relational Database | Data Storage                       |
| Maven                            | Dependency Management              |
| Spring AOP                       | Logging and Cross-Cutting Concerns |
| Jakarta Validation               | Request Validation                 |
| Lombok                           | Reducing Boilerplate Code          |
| Git                              | Version Control                    |
| GitHub                           | Remote Repository Hosting          |

---

# 📂 Project Structure

```text
EmployeePayrollApplication
│
├── .mvn
│   └── wrapper
│       └── maven-wrapper.properties
│
├── src
│   │
│   ├── main
│   │   │
│   │   ├── java
│   │   │   └── com
│   │   │       └── bridgelabz
│   │   │           └── EmployeePayrollApplication
│   │   │
│   │   │               ├── aop
│   │   │               │   └── LoggingAspect.java
│   │   │               │
│   │   │               ├── config
│   │   │               │   └── WebClientConfig.java
│   │   │               │
│   │   │               ├── controller
│   │   │               │   ├── AddressController.java
│   │   │               │   ├── EmployeeController.java
│   │   │               │   ├── ExternalEmployeeController.java
│   │   │               │   ├── GreetingController.java
│   │   │               │   └── PayrollController.java
│   │   │               │
│   │   │               ├── entity
│   │   │               │   ├── Address.java
│   │   │               │   ├── Department.java
│   │   │               │   ├── Employee.java
│   │   │               │   └── Payroll.java
│   │   │               │
│   │   │               ├── exception
│   │   │               │   ├── AddressNotFoundException.java
│   │   │               │   ├── DepartmentNotFoundException.java
│   │   │               │   ├── DuplicateDataException.java
│   │   │               │   ├── EmployeeNotFoundException.java
│   │   │               │   ├── ErrorResponse.java
│   │   │               │   ├── ExternalServiceException.java
│   │   │               │   ├── GlobalExceptionHandler.java
│   │   │               │   └── PayrollNotFoundException.java
│   │   │               │
│   │   │               ├── repository
│   │   │               │   ├── AddressRepository.java
│   │   │               │   ├── DepartmentRepository.java
│   │   │               │   ├── EmployeeRepository.java
│   │   │               │   └── PayrollRepository.java
│   │   │               │
│   │   │               ├── requestdto
│   │   │               │   ├── AddressRequestDTO.java
│   │   │               │   ├── EmployeeRequestDTO.java
│   │   │               │   └── PayrollRequestDTO.java
│   │   │               │
│   │   │               ├── responsedto
│   │   │               │   ├── AddressResponseDTO.java
│   │   │               │   ├── EmployeeResponseDTO.java
│   │   │               │   ├── ExternalAddressDTO.java
│   │   │               │   ├── ExternalCompanyDTO.java
│   │   │               │   ├── ExternalEmployeeDTO.java
│   │   │               │   ├── ExternalUserResponseDTO.java
│   │   │               │   ├── GreetingResponseDTO.java
│   │   │               │   └── PayrollResponseDTO.java
│   │   │               │
│   │   │               ├── service
│   │   │               │   ├── AddressService.java
│   │   │               │   ├── EmployeeService.java
│   │   │               │   ├── ExternalEmployeeService.java
│   │   │               │   ├── GreetingService.java
│   │   │               │   └── PayrollService.java
│   │   │               │
│   │   │               └── EmployeePayrollApplication.java
│   │   │
│   │   └── resources
│   │       └── application.properties
│   │
│   └── test
│       └── java
│           └── EmployeePayrollApplicationTests.java
│
├── .gitattributes
├── .gitignore
├── HELP.md
├── mvnw
├── mvnw.cmd
└── pom.xml
```

---

# 🏗️ Application Architecture

The application follows a layered architecture:

```text
Client
   │
   ▼
Controller Layer
   │
   ▼
Service Layer
   │
   ▼
Repository Layer
   │
   ▼
Database
```

### Controller Layer

Responsible for:

* Receiving HTTP requests
* Handling REST API endpoints
* Validating request data
* Returning responses

### Service Layer

Responsible for:

* Business logic
* Data processing
* Entity and DTO conversion
* Calling repositories
* Communicating with external APIs

### Repository Layer

Responsible for:

* Database operations
* Query execution
* Entity persistence

### Entity Layer

Responsible for:

* Database table mapping
* JPA relationships
* ORM configuration

### DTO Layer

DTOs are used to transfer data between:

```text
Client → Controller → Service
```

The project uses:

* Request DTOs
* Response DTOs
* External API Response DTOs

---

# 🔗 Entity Relationships

## Employee and Address

An employee can have address-related information associated with the employee.

```text
Employee
   │
   └──── Address
```

## Employee and Department

Employees are associated with departments.

```text
Department
    │
    └──── Employees
```

## Employee and Payroll

Payroll information is associated with an employee.

```text
Employee
   │
   └──── Payroll
```

---

# 📦 Prerequisites

Before running the application, install:

* Java 17 or above
* Maven
* PostgreSQL or the configured relational database
* Git
* IDE such as IntelliJ IDEA or Eclipse
* Postman for API testing

Check Java version:

```bash
java -version
```

Check Maven version:

```bash
mvn -version
```

---

# ⚙️ Database Configuration

Configure the database inside:

```text
src/main/resources/application.properties
```

Example:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/employee_payroll_db
spring.datasource.username=postgres
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

spring.jpa.properties.hibernate.format_sql=true
```

Create the database:

```sql
CREATE DATABASE employee_payroll_db;
```

> Update the database name, username, and password according to your local PostgreSQL configuration.

---

# ▶️ How to Run the Application

## Clone the Repository

```bash
git clone <your-repository-url>
```

## Navigate to the Project

```bash
cd EmployeePayrollApplication
```

## Run Using Maven Wrapper

For Windows:

```bash
mvnw.cmd spring-boot:run
```

For Linux or macOS:

```bash
./mvnw spring-boot:run
```

Or run the main class:

```text
EmployeePayrollApplication.java
```

The application will start on the configured Spring Boot port.

---

# 🔌 API Modules

The application contains REST API modules for:

```text
Employee Management
Address Management
Payroll Management
Greeting Management
External Employee Integration
```

## Example API Categories

### Employee APIs

```text
POST   /employee
GET    /employee
GET    /employee/{id}
PUT    /employee/{id}
DELETE /employee/{id}
```

### Address APIs

```text
POST   /address
GET    /address
GET    /address/{id}
PUT    /address/{id}
DELETE /address/{id}
```

### Payroll APIs

```text
POST   /payroll
GET    /payroll
GET    /payroll/{id}
PUT    /payroll/{id}
DELETE /payroll/{id}
```

> The exact endpoint paths may depend on the request mappings defined in the controller classes.

---

# 🧪 Testing

The project includes Spring Boot application testing.

Run tests using:

```bash
mvn test
```

Or with Maven Wrapper:

```bash
mvnw.cmd test
```

---

# 📝 Exception Handling

The application uses centralized exception handling through:

```text
GlobalExceptionHandler
```

Custom exceptions include:

```text
EmployeeNotFoundException
AddressNotFoundException
DepartmentNotFoundException
PayrollNotFoundException
DuplicateDataException
ExternalServiceException
```

The application returns structured error responses using:

```text
ErrorResponse
```

---


# 🔍 AOP Logging

The project uses:

```text
LoggingAspect
```

for implementing cross-cutting logging functionality.

This helps monitor application method execution without placing logging code repeatedly inside every business method.

---

# 🛡️ Validation

Request DTOs use validation to ensure valid data is received from the client.

Examples of commonly used validations include:

```text
@NotBlank
@NotNull
@Email
@Size
@Min
@Max
```

Validation helps prevent invalid data from entering the service and database layers.

---

# 🧠 Concepts Covered

This project demonstrates:

* Spring Boot
* REST APIs
* Spring MVC
* Spring Data JPA
* Hibernate
* Entity Mapping
* DTO Pattern
* Request and Response DTOs
* Validation
* Global Exception Handling
* Custom Exceptions
* Repository Pattern
* Service Layer
* Layered Architecture
* WebClient
* External API Integration
* Spring AOP
* Logging
* Maven
* PostgreSQL / Relational Database
* Git and GitHub

---

# 🚀 Future Enhancements

Possible future improvements include:

* Add Spring Security
* Implement JWT Authentication
* Add role-based authorization
* Add Swagger / OpenAPI documentation
* Add pagination and sorting
* Add search functionality
* Add unit tests using JUnit and Mockito
* Add Docker support
* Add CI/CD pipeline
* Deploy the application to the cloud

---

# 👩‍💻 Author

**Navya**

Java Full Stack Developer | Spring Boot | Java | REST APIs | Spring Data JPA

---

# 📄 License

This project is created for learning and educational purposes.

---

## ⭐ If you like this project

Give the repository a **star** on GitHub and feel free to explore the code.

