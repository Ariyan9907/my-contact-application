# UC2 – User Authentication (Login)

## Objective

Implement a simple and secure user authentication system that allows registered users to log in using their email and password.

## Features

* Login using registered email and password.
* Search user by email using `UserRepository`.
* Hash the entered password using SHA-256.
* Compare the hashed password with the stored hashed password.
* Return the authenticated `User` object on successful login.
* Return `null` if authentication fails.

## Classes Used

### UserService

Added:

```java
login(String email, String password)
```

Responsibilities:

* Find the user by email.
* Verify that the user exists.
* Hash the entered password.
* Compare password hashes.
* Return the authenticated `User` object or `null`.

### UserRepository

Reused:

```java
findUserByEmail(String email)
```

### PasswordHasher

Reused:

```java
hashPassword(String password)
```

Uses the SHA-256 algorithm to securely hash passwords before comparison.

## Authentication Flow

```text
Enter Email
      │
      ▼
Find User by Email
      │
      ▼
User Exists?
      │
 ┌────┴────┐
 │         │
No        Yes
 │         │
 ▼         ▼
Invalid   Hash Entered Password
              │
              ▼
      Compare Password Hashes
              │
      ┌───────┴────────┐
      ▼                ▼
 Login Successful   Invalid Credentials
```

## Testing

### Successful Login

* Email exists.
* Correct password entered.
* Returns the authenticated `User`.

### Invalid Password

* Email exists.
* Incorrect password entered.
* Returns `null`.

### Invalid Email

* Email does not exist.
* Returns `null`.

## Outcome

UC2 successfully provides a simple authentication mechanism by reusing the existing registration components from UC1 without introducing additional design patterns. The authenticated `User` object can now be reused in upcoming use cases such as User Profile and Contact Management.
