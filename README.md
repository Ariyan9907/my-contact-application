# UC7 – Delete Contact using Observer Pattern

## Objective

Implement the **Delete Contact** feature using the **Observer Design Pattern**. This enables the application to notify interested components whenever a contact is deleted while keeping the deletion logic separate from notification logic.

---

# Features

- Delete an existing contact.
- Validate logged-in user before deletion.
- Notify observers after successful deletion.
- Demonstrate loose coupling using the Observer Pattern.
- Allow future observers (Email, Logger, Audit, etc.) to be added without modifying the service layer.

---

# Classes Used

## `ContactObserver`

An interface representing an observer.

### Method

```java
void update(Contact contact);
```

Responsibilities:

- Receive notification whenever a contact is deleted.

---

## `NotificationObserver`

Implements `ContactObserver`.

Responsibilities:

- Display a notification after a contact is deleted.

Example:

```text
===== NOTIFICATION =====
Deleted Contact : Ramesh
```

---

## `ContactDeleteSubject`

Acts as the Subject (Publisher).

Responsibilities:

- Register observers.
- Remove observers.
- Notify all registered observers after deletion.

### Methods

```java
addObserver(ContactObserver observer)
```

```java
removeObserver(ContactObserver observer)
```

```java
notifyObservers(Contact contact)
```

---

## `UserService`

Updated:

### Constructor

Registers observers.

```java
deleteSubject.addObserver(new NotificationObserver());
```

### `deleteContact()`

Responsibilities:

- Validate logged-in user.
- Find the contact.
- Remove the contact.
- Notify all observers.
- Return success message.

---

## `ManualTest`

Updated to:

- Register user.
- Login.
- Add contacts.
- Display contacts.
- Delete a contact.
- Notify observers.
- Display remaining contacts.

---

# Process Flow

```text
User Login
      │
      ▼
View Contact List
      │
      ▼
Select Contact
      │
      ▼
Delete Contact
      │
      ▼
ContactDeleteSubject
      │
      ▼
Notify Observers
      │
      ▼
NotificationObserver
      │
      ▼
Display Notification
```

---

# Observer Pattern Flow

```text
                 UserService
                      │
                      ▼
          ContactDeleteSubject
             │             │
             ▼             ▼
 NotificationObserver   Future Observers
                             │
                    ┌────────┴────────┐
                    ▼                 ▼
              EmailObserver     LogObserver
```

---

# Testing

## Test Case 1 – Delete Existing Contact

### Input

```text
Contact ID : Valid Contact ID
```

### Expected Output

```text
Contact Deleted Successfully

===== NOTIFICATION =====
Deleted Contact : Ramesh
```

---

## Test Case 2 – Invalid Contact ID

### Expected Output

```text
Contact Not Found
```

---

## Test Case 3 – User Not Logged In

### Expected Output

```text
Please login first
```

---

## Test Case 4 – Verify Contact Removal

### Before Delete

```text
1. Ramesh
2. Rahul
```

### After Delete

```text
1. Rahul
```

---

## Test Case 5 – Observer Notification

### Expected Output

```text
===== NOTIFICATION =====
Deleted Contact : Ramesh
```

---

# Outcome

Successfully implemented **UC7 – Delete Contact** using the **Observer Design Pattern**.

The implementation demonstrates:

- Separation of deletion and notification logic.
- Loose coupling between service and observers.
- Easy extensibility for additional observers.
- Better maintainability following the **Open/Closed Principle (OCP)**.
- Single Responsibility Principle (SRP) by separating notification behavior from business logic.

---

# Git Workflow

## Create Feature Branch

```bash
git checkout -b feature/uc7-delete-contact-observer
```

## Stage Changes

```bash
git add .
```

## Commit

```bash
git commit -m "[Ariyan Pujari] Implement UC7: Delete Contact using Observer Pattern"
```

## Push Branch

```bash
git push -u origin feature/uc7-delete-contact-observer
```

## Merge into Development Branch

```bash
git checkout dev
git merge feature/uc7-delete-contact-observer
```

## Push Development Branch

```bash
git push origin dev
```

## Delete Feature Branch (Optional)

```bash
git branch -d feature/uc7-delete-contact-observer
git push origin --delete feature/uc7-delete-contact-observer
```