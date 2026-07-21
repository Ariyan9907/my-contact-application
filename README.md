# MyContacts Application

A **Java Console-Based Contact Management System** developed using **Core Java**, **Object-Oriented Programming (OOP)** principles, **SOLID Principles**, and multiple **GoF Design Patterns**. The application allows users to securely manage contacts while demonstrating real-world software design concepts.

---

# Objective

Develop a contact management application that demonstrates:

- Object-Oriented Programming
- SOLID Principles
- Design Patterns
- Java Collections
- Java 8 Features
- Clean Architecture
- Secure User Authentication

---

# Features

## User Management

- User Registration
- Secure Login
- Password Hashing (SHA-256)
- View User Profile

---

## Contact Management

- Add Contact
- View Contacts
- View Contact Details
- Update Contact
- Delete Contact

---

## Undo / Redo

- Undo Contact Update
- Redo Contact Update

---

## Bulk Operations

- Bulk View Contacts
- Bulk Delete Contacts
- Export Contacts

---

## Search

Search contacts by:

- Name
- Phone Number
- Email

---

## Advanced Filtering

Filter contacts using:

- Tags
- Date Added
- Frequently Contacted

---

## Tag Management

- Create Tags
- Assign Multiple Tags
- Remove Tags
- View Tags

---

## Notifications

- Delete Contact Notifications
- Tag Update Notifications

---

# Technologies Used

- Java 8+
- Collections Framework
- Stream API
- Lambda Expressions
- Method References
- SHA-256 Password Hashing
- UUID
- LocalDate
- LocalDateTime
- Regex
- Comparator
- Maven

---

# Project Structure

```text
src
└── com
    └── bridgelabz
        ├── command
        ├── composite
        ├── decorator
        ├── factory
        ├── filter
        ├── model
        ├── observer
        ├── repository
        ├── search
        ├── service
        ├── tag
        ├── tagobserver
        ├── util
        └── validations
```

---

# Design Patterns Implemented

| Use Case | Design Pattern |
|-----------|----------------|
| UC1 | Factory Pattern |
| UC4 | Factory Pattern |
| UC5 | Decorator Pattern |
| UC6 | Command Pattern |
| UC7 | Observer Pattern |
| UC8 | Composite Pattern |
| UC9 | Specification Pattern |
| UC9 | Chain of Responsibility Pattern |
| UC10 | Strategy Pattern |
| UC10 | Composite Pattern |
| UC11 | Flyweight Pattern |
| UC12 | Observer Pattern |

---

# SOLID Principles Applied

### Single Responsibility Principle (SRP)

Examples:

- UserFactory
- ContactFactory
- TagValidator
- NotificationObserver
- CommandManager

---

### Open/Closed Principle (OCP)

Examples:

- Decorator Pattern
- Strategy Pattern
- Specification Pattern

---

### Liskov Substitution Principle (LSP)

Examples:

- ContactFilter
- SearchCriteria
- Command
- ContactObserver

---

### Interface Segregation Principle (ISP)

Examples:

- Command
- ContactFilter
- SearchCriteria
- ContactObserver
- TagObserver

---

### Dependency Inversion Principle (DIP)

Examples:

- SearchHandler → SearchCriteria
- CompositeFilter → ContactFilter
- CommandManager → Command
- TagSubject → TagObserver

---

# OOP Concepts Used

- Classes & Objects
- Encapsulation
- Abstraction
- Inheritance
- Polymorphism
- Composition
- Association
- Many-to-Many Relationship

---

# Java Concepts Covered

- Collections Framework
- List
- Set
- HashSet
- HashMap
- Stack
- Stream API
- Lambda Expressions
- Method References
- Comparator
- Functional Interfaces
- UUID
- LocalDate
- LocalDateTime
- SHA-256 Hashing
- Regex Validation
- Exception Handling

---

# Use Cases Implemented

| UC | Feature |
|----|---------|
| UC1 | User Registration |
| UC2 | User Login |
| UC3 | View Profile |
| UC4 | Contact Management |
| UC5 | View Contact Details |
| UC6 | Undo / Redo Contact Updates |
| UC7 | Delete Contact |
| UC8 | Bulk Operations |
| UC9 | Search Contacts |
| UC10 | Advanced Filtering |
| UC11 | Create & Manage Tags |
| UC12 | Apply Tags to Contacts |

---

# Project Workflow

```text
Register User
      │
      ▼
Login
      │
      ▼
Manage Contacts
      │
      ├───────────────┐
      ▼               ▼
 Search          Bulk Operations
      │               │
      ▼               ▼
 Advanced Filtering   Tag Management
      │               │
      └───────┬───────┘
              ▼
       Notifications
```

---

# Learning Outcomes

This project demonstrates practical implementation of:

- Object-Oriented Programming
- SOLID Principles
- GoF Design Patterns
- Java Collections
- Java 8 Functional Programming
- Clean Code Practices
- Layered Architecture
- Real-world Software Design

---

# Future Enhancements

- File-Based Contact Storage
- Database Integration (MySQL)
- Spring Boot REST APIs
- JWT Authentication
- Import/Export Contacts (CSV/Excel)
- Contact Groups
- Favorites
- Search by Multiple Criteria
- GUI using JavaFX
- Unit Testing with JUnit
- Logging using Log4j/SLF4J

---

# Author

**Aryan Pujari**

Java Full Stack Developer

---

# License

This project is created for learning purposes to demonstrate Java, OOP, SOLID Principles, and Design Patterns.