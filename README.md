# UC3 – User Profile

## Objective

Implement a simple user profile feature that allows an authenticated user to view their profile information after a successful login.

## Features

* Display the logged-in user's profile.
* Reuse the authenticated `User` object returned by the login process.
* Display the following information:

    * User ID
    * Name
    * Email
    * Account Creation Date
* Show an "Invalid User" message if no authenticated user is available.

## Classes Used

### UserService

Added:

```java
viewProfile(User loggedUser)
```

Responsibilities:

* Accept the authenticated `User`.
* Verify that the user is not `null`.
* Display the user's profile details.
* Display an appropriate message for an invalid user.

### User

Reused:

* `getId()`
* `getName()`
* `getEmail()`
* `getCreatedAt()`

These getters are used to retrieve and display the user's profile information.

## Profile View Flow

```text
User Login
      │
      ▼
Authenticated User
      │
      ▼
viewProfile(User)
      │
      ▼
User Exists?
      │
 ┌────┴─────┐
 │          │
No         Yes
 │          │
 ▼          ▼
Invalid   Display
 User     User Profile
```

## Testing

### Valid User

* Login successfully.
* Pass the authenticated `User` object to `viewProfile()`.
* Profile details are displayed.

### Invalid User

* Pass `null` to `viewProfile()`.
* Displays:

```
Invalid User
```

## Outcome

UC3 successfully allows authenticated users to view their profile information by reusing the `User` object obtained during login. The implementation remains simple and prepares the project for upcoming features such as Contact Management, where the authenticated user will perform actions on their personal contacts.
