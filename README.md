# UC5 – View Contact Details using Decorator Pattern

## Objective

Implement the **View Contact Details** feature using the **Decorator Design Pattern**. This feature allows users to view contact information in different display formats without modifying the original `Contact` object.

---

# Features

- View complete details of a selected contact.
- Display contact information in multiple formats:
  - Normal Display
  - Uppercase Name
  - Masked Email
  - Uppercase Name + Masked Email
- Apply formatting dynamically using the **Decorator Pattern**.
- Preserve original contact data while changing only the displayed output.
- Select contacts using a contact number instead of typing the generated UUID.

---

# Classes Used

## `ContactFormatter`
- Interface defining the formatting contract.
- Method:
  ```java
  String format(Contact contact);
  ```

---

## `BasicContactFormatter`
- Implements `ContactFormatter`.
- Displays contact details in the default format.

---

## `ContactDecorator`
- Abstract decorator implementing `ContactFormatter`.
- Holds a reference to another `ContactFormatter`.
- Provides the foundation for all decorators.

---

## `UpperCaseDecorator`
- Extends `ContactDecorator`.
- Converts the contact name to uppercase before displaying.

---

## `MaskEmailDecorator`
- Extends `ContactDecorator`.
- Masks the email address before displaying it.

---

## `UserService`

### Added Method

```java
viewContactDetails(User loggedUser, int contactNumber, int choice)
```

Responsibilities:

- Validate logged-in user.
- Retrieve the selected contact.
- Apply the selected decorator(s).
- Display formatted contact details.

---

## `ManualTest`

Updated to:

- Display all contacts.
- Allow the user to select a contact by number.
- Allow the user to choose a display format.
- Display the formatted contact details.

---

# Process Flow

```text
User Login
      │
      ▼
View Contact List
      │
      ▼
Select Contact Number
      │
      ▼
Choose Display Format
      │
      ▼
BasicContactFormatter
      │
      ▼
(Optional) UpperCaseDecorator
      │
      ▼
(Optional) MaskEmailDecorator
      │
      ▼
Display Contact Details
```

---

# Decorator Flow

```text
                Contact
                   │
                   ▼
      BasicContactFormatter
                   │
      ┌────────────┴────────────┐
      ▼                         ▼
UpperCaseDecorator      MaskEmailDecorator
      │                         │
      └────────────┬────────────┘
                   ▼
          Formatted Output
```

---

# Testing

## Test Case 1 – Normal Display

### Input

```text
Contact Number : 1
Choice : 1
```

### Expected Output

```text
Name  : Aryan
Phone : 9876543210
Email : aryan@gmail.com
```

---

## Test Case 2 – Uppercase Name

### Input

```text
Contact Number : 1
Choice : 2
```

### Expected Output

```text
Name  : ARYAN
Phone : 9876543210
Email : aryan@gmail.com
```

---

## Test Case 3 – Mask Email

### Input

```text
Contact Number : 1
Choice : 3
```

### Expected Output

```text
Name  : Aryan
Phone : 9876543210
Email : ar***@gmail.com
```

---

## Test Case 4 – Uppercase + Mask Email

### Input

```text
Contact Number : 1
Choice : 4
```

### Expected Output

```text
Name  : ARYAN
Phone : 9876543210
Email : ar***@gmail.com
```

---

## Test Case 5 – Invalid Contact Number

### Expected Output

```text
Invalid contact number.
```

---

## Test Case 6 – User Not Logged In

### Expected Output

```text
Please login first.
```

---

# Outcome

Successfully implemented **UC5 – View Contact Details** using the **Decorator Design Pattern**.

The implementation demonstrates:

- Dynamic addition of formatting behavior.
- Chaining multiple decorators together.
- Separation of formatting logic from the `Contact` model.
- Easy extensibility for future display formats without modifying existing classes.

---

# Git Workflow

## Create Feature Branch

```bash
git checkout -b feature/uc5-contact-details-decorator
```

## Stage Changes

```bash
git add .
```

## Commit

```bash
git commit -m "[Ariyan Pujari] Implement UC5: View Contact Details using Decorator Pattern"
```

## Push Branch

```bash
git push origin feature/uc5-contact-details-decorator
```

## Merge into Development Branch

```bash
git checkout dev
git merge feature/uc5-contact-details-decorator
```

## Delete Feature Branch (Optional)

```bash
git branch -d feature/uc5-contact-details-decorator
git push origin --delete feature/uc5-contact-details-decorator
```