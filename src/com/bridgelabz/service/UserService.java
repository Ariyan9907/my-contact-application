package com.bridgelabz.service;

import com.bridgelabz.factory.UserFactory;
import com.bridgelabz.model.User;
import com.bridgelabz.repository.UserRepository;
import com.bridgelabz.util.PasswordHasher;

import static com.bridgelabz.validations.Validation.*;

public class UserService {

    private final UserRepository repository = new UserRepository();

    public String register(String name,
                           String email,
                           String password,
                           String confirmPassword) {

        if (!validateName(name)) {
            return "Invalid Name";
        }

        if (!validateEmail(email)) {
            return "Invalid Email";
        }

        if (!validatePassword(password)) {
            return "Invalid Password";
        }

        if (!password.equals(confirmPassword)) {
            return "Passwords do not match";
        }

        if (repository.existsByEmail(email)) {
            return "Email already registered";
        }

        String hashedPassword = PasswordHasher.hashPassword(password);

        User user = UserFactory.createUser(
                name,
                email,
                hashedPassword
        );

        repository.save(user);

        return "Registration Successful";
    }

    public UserRepository getRepository() {
        return repository;
    }
}