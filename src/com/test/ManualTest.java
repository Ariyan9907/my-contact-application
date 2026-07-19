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

        // ==========================
        // View Before Update
        // ==========================
        System.out.println("\n===== BEFORE UPDATE =====");
        userService.viewContacts(loggedUser);

        // Get Contact ID
        Contact contact = loggedUser.getContacts().get(0);

        // ==========================
        // Update Contact
        // ==========================
        System.out.println(
                userService.updateContact(
                        loggedUser,
                        contact.getId(),
                        "Rajesh",
                        "9999999999",
                        "rajesh@gmail.com"
                )
        );

        // ==========================
        // View After Update
        // ==========================
        System.out.println("\n===== AFTER UPDATE =====");
        userService.viewContacts(loggedUser);

        // ==========================
        // Undo
        // ==========================
        System.out.println("\n===== UNDO =====");
        userService.undoLastEdit();

        userService.viewContacts(loggedUser);

        // ==========================
        // Redo
        // ==========================
        System.out.println("\n===== REDO =====");
        userService.redoLastEdit();

        userService.viewContacts(loggedUser);

    }
}