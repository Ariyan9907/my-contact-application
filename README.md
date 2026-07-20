# UC10 – Advanced Filtering using Strategy Pattern and Composite Pattern

## Objective

Implement an **Advanced Filtering** feature that enables a logged-in user to filter contacts based on multiple criteria such as **Tag**, **Date Added**, and **Frequently Contacted** using the **Strategy Pattern** and **Composite Pattern**.

---

# Features

- Filter contacts by Tag.
- Filter contacts by Date Added.
- Sort contacts based on Frequently Contacted.
- Combine multiple filters.
- Validate logged-in user before filtering.
- Display filtered contacts.

---

# Classes Used

## ContactFilter

Acts as the Strategy Interface.

### Method

```java
List<Contact> filter(List<Contact> contacts);
```

Responsibilities:

- Defines a common filtering method.
- Allows multiple filtering algorithms.

---

## TagFilter

Implements `ContactFilter`.

Responsibilities:

- Filters contacts by Tag.

---

## DateFilter

Implements `ContactFilter`.

Responsibilities:

- Filters contacts by Date Added.

---

## FrequentContactFilter

Implements `ContactFilter`.

Responsibilities:

- Sorts contacts according to contact frequency.

Uses:

- Comparator
- Stream API

---

## CompositeFilter

Implements `ContactFilter`.

Responsibilities:

- Stores multiple filters.
- Executes each filter sequentially.
- Returns the final filtered result.

Methods

```java
addFilter(ContactFilter filter)
```

Adds a new filter.

```java
filter(List<Contact> contacts)
```

Applies all filters one after another.

---

## Contact

Added new fields:

```java
private String tag;
private LocalDate dateAdded;
private int contactCount;
```

These fields support advanced filtering.

---

## ContactFactory

Updated to initialize:

- Default Tag
- Current Date
- Contact Count = 0

---

## UserService

Added:

### filterContacts()

Responsibilities:

- Validate logged-in user.
- Dynamically create filters.
- Combine filters using Composite Pattern.
- Display filtered contacts.

---

## ManualTest

Demonstrates:

- User Registration
- Login
- Add Contacts
- Assign Tags
- Update Contact Count
- Filter by Tag
- Filter by Date
- Sort by Frequently Contacted
- Combine Multiple Filters

---

# Process Flow

```text
User Login
      │
      ▼
Choose Filters
      │
      ▼
Create CompositeFilter
      │
      ├───────────────┐
      ▼               ▼
 Tag Filter      Date Filter
      │               │
      └───────┬───────┘
              ▼
 Frequency Sort
              │
              ▼
Display Filtered Contacts
```

---

# Design Patterns Used

## Strategy Pattern

Each filter implements its own filtering algorithm.

```text
ContactFilter
      ▲
      │
 ┌────┼──────────────┐
 ▼    ▼              ▼
Tag  Date     Frequent Contact
```

Benefits:

- Loose Coupling
- Easy to extend
- Reusable filtering logic

---

## Composite Pattern

Combines multiple filters into a single object.

```text
CompositeFilter
      │
      ├── TagFilter
      ├── DateFilter
      └── FrequentContactFilter
```

Benefits:

- Multi-level filtering
- Easy combination of strategies
- Cleaner code

---

# Java Concepts Used

## Stream API

```java
contacts.stream()
```

---

## filter()

```java
.filter(...)
```

---

## sorted()

```java
.sorted(...)
```

---

## Comparator

```java
Comparator.comparingInt(Contact::getContactCount)
```

---

## Lambda Expressions

```java
contact -> contact.getTag().equalsIgnoreCase(tag)
```

---

## Functional Interface

```java
ContactFilter
```

---

# Testing

## Test Case 1 – Filter by Tag

### Input

```
Family
```

### Expected Output

Displays only contacts having the tag **Family**.

---

## Test Case 2 – Filter by Date

### Input

```
LocalDate.now()
```

### Expected Output

Displays contacts added on today's date.

---

## Test Case 3 – Sort by Frequently Contacted

### Expected Output

Displays contacts in descending order of contact count.

---

## Test Case 4 – Multiple Filters

### Input

```
Tag = Office
Sort by Frequency = true
```

### Expected Output

Displays Office contacts sorted by contact count.

---

## Test Case 5 – User Not Logged In

### Expected Output

```
Please login first
```

---

# Outcome

Successfully implemented **UC10 – Advanced Filtering** using the **Strategy Pattern** and **Composite Pattern**.

The implementation demonstrates:

- Strategy Pattern
- Composite Pattern
- Comparator
- Stream API
- Lambda Expressions
- Functional Interface
- Multi-level Filtering
- Dynamic Filter Composition
- Clean and extensible design following SOLID principles.