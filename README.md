# UC12 – Apply Tags to Contacts using Observer Pattern

## Objective

Implement the **Apply Tags to Contacts** feature that allows a logged-in user to assign or remove one or more tags from contacts. The implementation uses the **Observer Pattern** to notify the system whenever tags are added or removed from a contact.

---

# Features

- Assign one or multiple tags to a contact.
- Remove tags from a contact.
- View tags assigned to a contact.
- Notify observers whenever tags are updated.
- Support multiple tags using `Set<Tag>`.

---

# Classes Used

## TagObserver

Acts as the Observer Interface.

### Method

```java
void update(Contact contact, String message);
```

Responsibilities:

- Receive notifications whenever a tag is added or removed.

---

## TagNotificationObserver

Implements `TagObserver`.

Responsibilities:

- Display notification messages whenever tag assignments change.

Example:

```
===== TAG NOTIFICATION =====
Family tag added to Rahul
```

---

## TagSubject

Acts as the Subject (Publisher).

Responsibilities:

- Register observers.
- Remove observers.
- Notify observers whenever a tag operation occurs.

### Methods

```java
addObserver(TagObserver observer)
```

```java
removeObserver(TagObserver observer)
```

```java
notifyObservers(Contact contact, String message)
```

---

## TagService

Updated to:

### addTag()

- Validate tag.
- Add tag to contact.
- Notify observers.

### removeTag()

- Remove tag.
- Notify observers.

### viewTags()

- Display all tags assigned to a contact.

---

## UserService

Updated to:

- Register `TagNotificationObserver`.
- Delegate tag operations to `TagService`.

---

## ManualTest

Demonstrates:

- User Registration
- Login
- Add Contact
- Assign Multiple Tags
- View Tags
- Remove Tag
- Observer Notification

---

# Process Flow

```text
User Login
      │
      ▼
Select Contact
      │
      ▼
Add / Remove Tag
      │
      ▼
TagService
      │
      ▼
TagSubject
      │
      ▼
Notify Observers
      │
      ▼
TagNotificationObserver
      │
      ▼
Display Notification
```

---

# Observer Pattern Flow

```text
              TagService
                  │
                  ▼
             TagSubject
                  │
        ┌─────────┴─────────┐
        ▼                   ▼
TagNotificationObserver   Future Observers
                              │
                     ┌────────┴────────┐
                     ▼                 ▼
                 Logger          EmailNotifier
```

---

# Java Concepts Used

## Set Operations

```java
contact.getTags().add(tag);
```

```java
contact.getTags().remove(tag);
```

Ensures unique tags for every contact.

---

## Bidirectional Relationship

- One contact can have multiple tags.
- One tag can be shared by multiple contacts.

---

## Observer Pattern

Automatically notifies all registered observers whenever a tag is added or removed.

---

# Testing

## Test Case 1 – Add Tag

### Input

```
Family
```

### Expected Output

```
Tag Added Successfully

===== TAG NOTIFICATION =====
Family tag added to Rahul
```

---

## Test Case 2 – Add Multiple Tags

### Input

```
Family
Friends
```

### Expected Output

```
Tags : [Family, Friends]
```

---

## Test Case 3 – Remove Tag

### Input

```
Friends
```

### Expected Output

```
Tag Removed Successfully

===== TAG NOTIFICATION =====
Friends tag removed from Rahul
```

---

## Test Case 4 – View Tags

### Expected Output

```
Tags : [Family]
```

---

## Test Case 5 – User Not Logged In

### Expected Output

```
Please login first
```

---

# Outcome

Successfully implemented **UC12 – Apply Tags to Contacts** using the **Observer Pattern**.

The implementation demonstrates:

- Observer Pattern
- Set Operations
- Bidirectional Relationship Management
- Multiple Tag Assignment
- Event Notification
- Clean separation between business logic and notification logic
- Extensible design following the Open/Closed Principle (OCP)