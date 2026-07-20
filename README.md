# UC8 – Bulk Operations using Composite Pattern

## Objective

Implement **Bulk Operations** that allow a logged-in user to perform actions on multiple contacts efficiently using the **Composite Design Pattern** and Java Stream API.

---

# Features

- View multiple contacts together.
- Search contacts using Stream API.
- Bulk delete contacts.
- Export contacts.
- Demonstrate Composite Pattern.
- Use Streams, Lambda Expressions, Method References, and Batch Processing.

---

# Classes Used

## ContactComponent

Acts as the Component in the Composite Pattern.

### Method

```java
void showDetails();
```

Responsibilities

- Provides a common interface for both individual contacts and groups of contacts.

---

## SingleContact

Represents an individual contact.

Responsibilities

- Stores a single Contact object.
- Displays individual contact details.

---

## ContactGroup

Represents a collection of contacts.

Responsibilities

- Store multiple ContactComponent objects.
- Display all contacts using the same interface.

Methods

```java
add(ContactComponent contact)
```

```java
remove(ContactComponent contact)
```

```java
showDetails()
```

---

## UserService

### viewBulkContacts()

Displays all contacts using Composite Pattern.

### searchContact()

Searches contacts using:

- Stream API
- Lambda Expressions
- Method References

### bulkDeleteContacts()

Deletes multiple contacts in one operation.

### exportContacts()

Exports all contacts by printing them in a structured format.

---

## ManualTest

Demonstrates:

- User Registration
- Login
- Add Contacts
- Bulk View
- Search Contacts
- Bulk Delete
- Export Contacts

---

# Process Flow

```text
User Login
      │
      ▼
Select Bulk Operation
      │
      ├──────────────┐
      ▼              ▼
 View Contacts   Search Contacts
      │              │
      ▼              ▼
Composite Pattern  Stream API
      │              │
      └──────┬───────┘
             ▼
      Bulk Delete / Export
```

---

# Composite Pattern Structure

```text
                ContactComponent
                     ▲
                     │
          ┌──────────┴──────────┐
          ▼                     ▼
    SingleContact         ContactGroup
                                 │
                    ┌────────────┴────────────┐
                    ▼                         ▼
             SingleContact             SingleContact
```

---

# Java Concepts Used

## Stream API

```java
contacts.stream()
```

---

## Lambda Expression

```java
contact -> contact.getName().contains(keyword)
```

---

## Method Reference

```java
SingleContact::new
```

```java
group::add
```

---

## Batch Processing

```java
removeIf(...)
```

Processes multiple contacts in a single operation.

---

# Testing

## Test Case 1 – Bulk View

### Expected Output

Displays all contacts.

---

## Test Case 2 – Search Contact

### Input

```
Keyword : A
```

### Expected Output

Displays contacts whose names contain "A".

---

## Test Case 3 – Bulk Delete

### Input

```
Ajay
Rahul
```

### Expected Output

```
Bulk Delete Successful
```

Both contacts are removed.

---

## Test Case 4 – Export Contacts

### Expected Output

```
Name | Phone | Email
```

All remaining contacts are displayed.

---

## Test Case 5 – Login Validation

### Expected Output

```
Please login first
```

---

# Outcome

Successfully implemented **UC8 – Bulk Operations** using the **Composite Design Pattern**.

The implementation demonstrates:

- Composite Pattern
- Stream API
- Lambda Expressions
- Method References
- Batch Processing
- Collection Operations
- Clean and reusable object-oriented design following the Open/Closed Principle (OCP).