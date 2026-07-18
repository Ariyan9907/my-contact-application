# UC4 – Contact Management

## Objective

Implement a simple Contact Management system that allows an authenticated user to manage their personal contacts.

The implementation follows CRUD (Create, Read, Update, Delete) operations while keeping the design simple and object-oriented.

---

## Features

* Add a new contact.
* View all contacts of the logged-in user.
* Update an existing contact.
* Delete a contact.
* Every contact has:

  * Unique ID (UUID)
  * Name
  * Phone Number
  * Email
  * Created Date & Time
* Each user maintains their own contact list.

---

## Classes Used

### Contact

Package

```text
com.bridgelabz.model
```

Represents a contact.

Fields

```java
id
name
phoneNumber
email
createdAt
```

Responsibilities

* Store contact information.
* Provide getters and setters.
* Represent a single contact.

---

### User

Updated by adding:

```java
private final List<Contact> contacts = new ArrayList<>();
```

Getter

```java
public List<Contact> getContacts()
```

Responsibilities

* Each authenticated user owns and manages their personal contacts.
* Maintains a one-to-many relationship with `Contact`.

---

### ContactFactory

Package

```text
com.bridgelabz.factory
```

Method

```java
createContact()
```

Responsibilities

* Generate UUID.
* Set creation timestamp.
* Return a new `Contact` object.

---

### UserService

Added methods

```java
addContact()

viewContacts()

updateContact()

deleteContact()
```

Responsibilities

* Validate contact information.
* Create contacts.
* Add contacts to the logged-in user.
* Display all contacts.
* Update contact details.
* Delete contacts.

---

## Contact Management Flow

### Add Contact

```text
Login
   │
   ▼
Enter Contact Details
   │
   ▼
Validate Contact
   │
   ▼
Create Contact
   │
   ▼
Add to User Contact List
   │
   ▼
Contact Added Successfully
```

---

### View Contacts

```text
Login
   │
   ▼
Fetch User Contact List
   │
   ▼
Contacts Available?
   │
 ┌────┴─────┐
 │          │
No         Yes
 │          │
 ▼          ▼
No Contacts Display Contacts
```

---

### Update Contact

```text
Login
   │
   ▼
Enter Contact ID
   │
   ▼
Find Contact
   │
 ┌────┴─────┐
 │          │
No         Yes
 │          │
 ▼          ▼
Contact     Update
Not Found   Details
               │
               ▼
     Contact Updated Successfully
```

---

### Delete Contact

```text
Login
   │
   ▼
Enter Contact ID
   │
   ▼
Find Contact
   │
 ┌────┴─────┐
 │          │
No         Yes
 │          │
 ▼          ▼
Contact     Remove Contact
Not Found         │
                  ▼
     Contact Deleted Successfully
```

---

## Architecture

```text
Main
   │
   ▼
UserService
   │
   ├── Validation
   ├── ContactFactory
   ├── UserRepository
   │
   ▼
Authenticated User
   │
   ▼
List<Contact>
   │
   ├── Add
   ├── View
   ├── Update
   └── Delete
```

---

## Testing

### Add Contact

* Valid contact information.
* Invalid contact name.
* Invalid contact email.
* User not logged in.

### View Contacts

* User has contacts.
* User has no contacts.
* User not logged in.

### Update Contact

* Valid contact ID.
* Invalid contact ID.
* Invalid updated information.

### Delete Contact

* Valid contact ID.
* Invalid contact ID.
* User not logged in.

---

## Outcome

UC4 successfully implements the core Contact Management functionality using CRUD operations.

The implementation maintains a simple object-oriented design where:

* Users are managed through `UserRepository`.
* Each `User` owns their own `List<Contact>`.
* Contact creation is centralized using `ContactFactory`.
* Contact operations are performed only on the authenticated user's contact list.

This design prepares the project for future enhancements such as Decorator, Command, Composite, and Specification patterns in later use cases.
