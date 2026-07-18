# MyContacts App

## UC1 - User Registration

### Overview
UC1 implements the **User Registration** feature of the MyContacts application.

A new user can register by providing a valid name, email, and password. The application validates the input, hashes the password using SHA-256, creates a User object, and stores it in the repository.

---

## Features

- User Registration
- Name Validation
- Email Validation
- Password Validation
- Password Hashing (SHA-256)
- Unique User ID Generation (UUID)
- Registration Date & Time
- Duplicate Email Check

---

## Project Structure

```
src
│
├── com.bridgelabz
│   ├── model
│   │     └── User.java
│   │
│   ├── repository
│   │     └── UserRepository.java
│   │
│   ├── service
│   │     └── UserService.java
│   │
│   ├── validations
│   │     └── Validation.java
│   │
│   ├── util
│   │     └── PasswordHasher.java
│   │
│   └── factory
│         └── UserFactory.java
│
└── test
      └── Main.java
```

---

## Technologies Used

- Java
- OOP
- Collections (ArrayList)
- Regular Expressions (Regex)
- SHA-256 Password Hashing
- UUID
- LocalDateTime

---

## OOP Concepts Covered

- Classes & Objects
- Encapsulation
- Layered Architecture
- Factory Pattern
- Utility Class
- Repository Pattern (Basic)

---

## Registration Flow

```
Enter Name
      ↓
Validate Name
      ↓
Enter Email
      ↓
Validate Email
      ↓
Enter Password
      ↓
Validate Password
      ↓
Confirm Password
      ↓
Passwords Match?
      ↓
Email Already Exists?
      ↓
Hash Password
      ↓
Create User
      ↓
Save User
      ↓
Registration Successful
```

---

## Learning Outcomes

- Build a layered Java application
- Implement input validation using Regex
- Secure passwords using SHA-256
- Organize code using packages
- Store objects using ArrayList
- Generate unique IDs using UUID
- Work with LocalDateTime

---

## Author

**Aryan Pujari**