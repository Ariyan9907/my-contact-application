# UC11 – Create and Manage Tags using Flyweight Pattern

## Objective

Implement a **Tag Management** feature that allows a logged-in user to create, assign, remove, and view tags for contacts. The implementation uses the **Flyweight Design Pattern** to share tag objects between multiple contacts, reducing memory usage and avoiding duplicate tag instances.

---

# Features

- Create custom tags.
- Assign one or more tags to a contact.
- Remove tags from a contact.
- View all tags assigned to a contact.
- Prevent duplicate tags using `HashSet`.
- Reuse existing tag objects using the Flyweight Pattern.

---

# Classes Used

## Tag

Represents a tag object.

### Responsibilities

- Store the tag name.
- Override `equals()` for duplicate detection.
- Override `hashCode()` for proper HashSet behavior.
- Override `toString()` for displaying tags.

---

## TagFactory

Implements the **Flyweight Pattern**.

### Responsibilities

- Create a tag if it does not already exist.
- Return the existing tag if it has already been created.
- Share the same tag object among multiple contacts.

### Method

```java
getTag(String name)
```

---

## TagValidator

Validates user input.

### Responsibilities

- Check for null tags.
- Check for empty or blank tag names.

### Method

```java
isValid(String tagName)
```

---

## TagService

Handles all tag operations.

### Responsibilities

- Add tag to a contact.
- Remove tag from a contact.
- Display all tags of a contact.

### Methods

```java
addTag(Contact contact, String tagName)
```

```java
removeTag(Contact contact, String tagName)
```

```java
viewTags(Contact contact)
```

---

## Contact

Updated to support multiple tags.

### New Field

```java
private Set<Tag> tags = new HashSet<>();
```

This creates a **many-to-many relationship**:

- One contact can have many tags.
- One tag object can belong to many contacts.

---

## ContactFactory

Updated to support the modified `Contact` constructor after introducing multiple tags.

---

## UserService

Added methods:

### addTag()

Assigns a tag to a contact.

### removeTag()

Removes a tag from a contact.

### viewTags()

Displays all tags assigned to a contact.

---

## ManualTest

Demonstrates:

- User Registration
- Login
- Add Contact
- Add Multiple Tags
- View Tags
- Remove Tag
- View Updated Tags

---

# Process Flow

```text
User Login
      │
      ▼
Select Contact
      │
      ▼
Enter Tag
      │
      ▼
TagValidator
      │
      ▼
TagFactory
      │
      ▼
Existing Tag?
   │
 ┌─┴────────────┐
 │              │
Yes            No
 │              │
 ▼              ▼
Reuse Tag    Create Tag
      │
      ▼
Add Tag to Contact
      │
      ▼
Display Result
```

---

# Flyweight Pattern

```
                 TagFactory
                      │
      ┌───────────────┴───────────────┐
      ▼                               ▼
 Family Tag                     Friends Tag
      │                               │
 ┌────┴────┐                    ┌─────┴─────┐
 ▼         ▼                    ▼           ▼
Contact1 Contact2          Contact2    Contact3
```

Only one object is created for each unique tag and shared across contacts.

---

# Java Concepts Used

## HashSet

```java
Set<Tag> tags = new HashSet<>();
```

Ensures unique tags for every contact.

---

## equals()

```java
equals(Object obj)
```

Determines when two tag objects are considered equal.

---

## hashCode()

```java
hashCode()
```

Ensures duplicate tags are not stored in the HashSet.

---

## HashMap

```java
Map<String, Tag>
```

Used inside `TagFactory` to store and reuse Flyweight objects.

---

## Many-to-Many Relationship

```
Contact
   ▲
   │
   │
Tag
```

A contact can have multiple tags, and the same tag can be shared among multiple contacts.

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
```

---

## Test Case 4 – View Tags

### Expected Output

```
Tags : [Family]
```

---

## Test Case 5 – Invalid Tag

### Input

```
""
```

### Expected Output

```
Invalid Tag
```

---

## Test Case 6 – User Not Logged In

### Expected Output

```
Please login first
```

---

# Outcome

Successfully implemented **UC11 – Create and Manage Tags** using the **Flyweight Design Pattern**.

The implementation demonstrates:

- Flyweight Pattern
- HashSet
- HashMap
- equals()
- hashCode()
- Many-to-Many Relationship
- Validation
- Object Sharing
- Clean and reusable object-oriented design following SOLID principles.