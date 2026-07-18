package com.bridgelabz.factory;

import com.bridgelabz.model.User;

import java.time.LocalDateTime;
import java.util.UUID;

public class UserFactory {

    private UserFactory() {
    }

    public static User createUser(String name,
                                  String email,
                                  String password) {

        return new User(
                UUID.randomUUID().toString(),
                name,
                email,
                password,
                LocalDateTime.now()
        );
    }
}
