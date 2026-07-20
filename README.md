# UC9 – Search Contacts using Specification Pattern and Chain of Responsibility

## Objective

Implement an advanced contact search feature that allows a logged-in user to search contacts by **Name**, **Phone Number**, or **Email Address** using the **Specification Pattern** and **Chain of Responsibility Pattern**.

---

# Features

- Search contacts by name.
- Search contacts by phone number.
- Search contacts by email address.
- Case-insensitive search for name and email.
- Displays all matching contacts.
- Validates whether the user is logged in before searching.

---

# Classes Used

## SearchCriteria

Acts as the **Specification Interface**.

### Method

```java
boolean isSatisfied(Contact contact, String keyword);
```

Responsibilities:

- Defines the rule for checking whether a contact satisfies a search condition.

---

## NameCriteria

Implements `SearchCriteria`.

Responsibilities:

- Checks whether the contact name contains the search keyword.

---

## PhoneCriteria

Implements `SearchCriteria`.

Responsibilities:

- Checks whether the phone number contains the search keyword.

---

## EmailCriteria

Implements `SearchCriteria`.

Responsibilities:

- Checks whether the email contains the search keyword.

---

## SearchHandler

Implements the **Chain of Responsibility Pattern**.

Responsibilities:

- Holds a search criteria.
- Searches contacts using the assigned criteria.
- Passes the request to the next handler if no match is found.

### Methods

```java
setNext(SearchHandler nextHandler)
```

Links the next handler in the chain.

```java
search(List<Contact> contacts, String keyword)
```

Searches contacts using the current criteria and forwards the request if necessary.

---

## UserService

Added:

### searchContacts()

Responsibilities:

- Validate logged-in user.
- Create the search chain.
- Perform search.
- Display matching contacts.
- Display "No Contact Found" when no matches exist.

---

## ManualTest

Demonstrates:

- User Registration
- Login
- Add Contacts
- Search by Name
- Search by Phone
- Search by Email
- Invalid Search

---

# Process Flow

```text
User Login
      │
      ▼
Enter Search Keyword
      │
      ▼
Create Search Chain
      │
      ▼
Name Search
      │
      ▼
Match Found?
   │
 ┌─┴─────────────┐
 │               │
Yes             No
 │               │
 ▼               ▼
Return      Phone Search
                  │
                  ▼
             Match Found?
                │
          ┌─────┴─────┐
          │           │
         Yes         No
          │           │
          ▼           ▼
      Return     Email Search
                     │
                     ▼
                 Match Found?
                │
          ┌─────┴─────┐
          │           │
         Yes         No
          │           │
          ▼           ▼
      Return      No Contact Found
```

---

# Design Patterns Used

## Specification Pattern

Each search condition is implemented independently.

```text
SearchCriteria
      ▲
      │
 ┌────┼──────────┐
 ▼    ▼          ▼
Name Phone     Email
```

Benefits:

- Single Responsibility Principle
- Easy to extend
- Reusable search conditions

---

## Chain of Responsibility Pattern

Each handler gets an opportunity to process the search request.

```text
SearchHandler(Name)
        │
        ▼
SearchHandler(Phone)
        │
        ▼
SearchHandler(Email)
```

Benefits:

- Loose coupling
- Easy to add new search handlers
- Cleaner search logic

---

# Java Concepts Used

## Stream API

```java
contacts.stream()
```

---

## Lambda Expression

```java
contact -> criteria.isSatisfied(contact, keyword)
```

---

## Predicate Logic

Implemented through the `isSatisfied()` method in each criteria class.

---

## Case-Insensitive Search

```java
toLowerCase().contains(keyword.toLowerCase())
```

Used for searching names and email addresses.

---

# Testing

## Test Case 1 – Search by Name

### Input

```
Rah
```

### Expected Output

```
Rahul
```

---

## Test Case 2 – Search by Phone

### Input

```
7777
```

### Expected Output

```
Ajay
```

---

## Test Case 3 – Search by Email

### Input

```
gmail
```

### Expected Output

Displays contacts having Gmail addresses.

---

## Test Case 4 – Invalid Search

### Input

```
XYZ
```

### Expected Output

```
No Contact Found
```

---

## Test Case 5 – User Not Logged In

### Expected Output

```
Please login first
```

---

# Outcome

Successfully implemented **UC9 – Advanced Contact Search** using the **Specification Pattern** and **Chain of Responsibility Pattern**.

The implementation demonstrates:

- Specification Pattern
- Chain of Responsibility Pattern
- Stream API
- Lambda Expressions
- Case-insensitive searching
- Clean and extensible search architecture