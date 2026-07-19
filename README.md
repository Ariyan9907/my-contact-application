# UC6 – Edit Contact with Undo/Redo (Command Pattern)

## Objective

Implement the **Edit Contact** feature using the **Command Design Pattern**. This enables users to update contact information while supporting **Undo** and **Redo** operations without directly modifying the contact from the service layer.

---

# Features

- Edit an existing contact.
- Validate updated contact details.
- Undo the last contact update.
- Redo the previously undone update.
- Maintain command history using stacks.
- Separate edit logic from business logic using the Command Pattern.

---

# Classes Used

## `Command`

- Interface representing a command.
- Declares:
  ```java
  void execute();
  void undo();
  ```

---

## `EditContactCommand`

Implements `Command`.

Responsibilities:

- Store old contact details.
- Store new contact details.
- Execute the update.
- Restore previous values during Undo.

---

## `CommandManager`

Responsibilities:

- Execute commands.
- Maintain Undo history.
- Maintain Redo history.
- Perform Undo.
- Perform Redo.

Uses:

- `Stack<Command> undoStack`
- `Stack<Command> redoStack`

---

## `UserService`

Updated Methods:

### `updateContact()`

- Validate user.
- Validate contact details.
- Create an `EditContactCommand`.
- Execute the command using `CommandManager`.

### `undoLastEdit()`

Calls:

```java
commandManager.undo();
```

### `redoLastEdit()`

Calls:

```java
commandManager.redo();
```

---

## `ManualTest`

Updated to:

- Register a user.
- Login.
- Add a contact.
- Update the contact.
- Display updated contact.
- Undo the update.
- Display restored contact.
- Redo the update.
- Display updated contact again.

---

# Process Flow

```text
User Login
      │
      ▼
Select Contact
      │
      ▼
Update Contact
      │
      ▼
Create EditContactCommand
      │
      ▼
CommandManager.executeCommand()
      │
      ▼
Contact Updated
      │
      ├──────────────┐
      ▼              ▼
Undo           Redo
```

---

# Command Pattern Flow

```text
               UserService
                    │
                    ▼
         EditContactCommand
                    │
        execute() / undo()
                    │
                    ▼
            CommandManager
             │          │
             ▼          ▼
        Undo Stack   Redo Stack
```

---

# Testing

## Test Case 1 – Update Contact

### Input

```text
Name  : Rajesh
Phone : 9999999999
Email : rajesh@gmail.com
```

### Expected Output

```text
Contact Updated Successfully
```

---

## Test Case 2 – Undo Update

### Action

```text
Undo
```

### Expected Output

```text
Undo Successful
```

Contact details should return to their previous values.

---

## Test Case 3 – Redo Update

### Action

```text
Redo
```

### Expected Output

```text
Redo Successful
```

Updated contact details should be restored.

---

## Test Case 4 – Invalid Contact ID

### Expected Output

```text
Contact Not Found
```

---

## Test Case 5 – Invalid User

### Expected Output

```text
Please login first
```

---

## Test Case 6 – Invalid Email

### Expected Output

```text
Invalid Contact Email
```

---

## Test Case 7 – Invalid Name

### Expected Output

```text
Invalid Contact Name
```

---

# Outcome

Successfully implemented **UC6 – Edit Contact with Undo/Redo** using the **Command Design Pattern**.

The implementation demonstrates:

- Encapsulation of edit operations as command objects.
- Separation of business logic from edit execution.
- Support for multiple Undo and Redo operations.
- Easy extensibility for future commands such as Add Contact, Delete Contact, and Restore Contact.
- Compliance with the **Single Responsibility Principle (SRP)** and **Open/Closed Principle (OCP)**.

---

# Git Workflow

## Create Feature Branch

```bash
git checkout -b feature/uc6-edit-contact-command-pattern
```

## Stage Changes

```bash
git add .
```

## Commit

```bash
git commit -m "[Ariyan Pujari] Implement UC6: Edit Contact with Undo/Redo using Command Pattern"
```

## Push Branch

```bash
git push origin feature/uc6-edit-contact-command-pattern
```

## Merge into Development Branch

```bash
git checkout dev
git merge feature/uc6-edit-contact-command-pattern
```

## Delete Feature Branch (Optional)

```bash
git branch -d feature/uc6-edit-contact-command-pattern
git push origin --delete feature/uc6-edit-contact-command-pattern
```