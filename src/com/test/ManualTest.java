package com.test;

import com.bridgelabz.model.Contact;
import com.bridgelabz.model.User;
import com.bridgelabz.service.UserService;

public class ManualTest {

    public static void main(String[] args) {

        UserService userService = new UserService();

        // ==========================
        // Registration
        // ==========================
        System.out.println(
                userService.register(
                        "Aryan",
                        "aryan@gmail.com",
                        "Aryan@9907",
                        "Aryan@9907"
                )
        );

        // ==========================
        // Login
        // ==========================
        User loggedUser =
                userService.login(
                        "aryan@gmail.com",
                        "Aryan@9907"
                );

        if (loggedUser == null) {
            System.out.println("Login Failed");
            return;
        }

        // ==========================
        // Add Contact
        // ==========================
        System.out.println(
                userService.addContact(
                        loggedUser,
                        "Ramesh",
                        "9886484180",
                        "ram@gmail.com"
                )

        );
        System.out.println(
                userService.addContact(
                        loggedUser,
                        "Rahul",
                        "9876543210",
                        "rahul@gmail.com"
                )
        );

        System.out.println("\n===== CONTACTS BEFORE DELETE =====");

        userService.viewContacts(loggedUser);

        Contact contact = loggedUser.getContacts().get(1);

        System.out.println();

        System.out.println(
                userService.deleteContact(
                        loggedUser,
                        contact.getId()
                )
        );

        System.out.println();

        System.out.println("===== CONTACTS AFTER DELETE =====");

        userService.viewContacts(loggedUser);



    }
}