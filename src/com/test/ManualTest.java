package com.test;

import com.bridgelabz.model.User;
import com.bridgelabz.service.UserService;

import java.util.Scanner;

public class ManualTest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        UserService userService = new UserService();

        // ==========================
        // UC1 - Registration
        // ==========================
        System.out.println(userService.register(
                "Aryan",
                "aryan@gmail.com",
                "Aryan@9907",
                "Aryan@9907"
        ));

        // ==========================
        // UC2 - Login
        // ==========================
        User loggedUser = userService.login(
                "aryan@gmail.com",
                "Aryan@9907"
        );

        if (loggedUser == null) {
            System.out.println("Login Failed!");
            return;
        }

        // ==========================
        // UC3 - View Profile
        // ==========================
        userService.viewProfile(loggedUser);

        // ==========================
        // UC4 - Add Contacts
        // ==========================
        System.out.println(userService.addContact(
                loggedUser,
                "Ramesh",
                "9886484180",
                "ram@gmail.com"
        ));

        System.out.println(userService.addContact(
                loggedUser,
                "Rahul",
                "9876543210",
                "rahul@gmail.com"
        ));

        System.out.println(userService.addContact(
                loggedUser,
                "Sneha",
                "9123456789",
                "sneha@gmail.com"
        ));

        // ==========================
        // View All Contacts
        // ==========================
        System.out.println("\n===== CONTACT LIST =====");
        userService.viewContacts(loggedUser);

        // ==========================
        // UC5 - View Contact Details
        // ==========================
        System.out.print("\nEnter Contact Number : ");
        int contactNumber = sc.nextInt();

        System.out.println("""
                
Choose Display Format
1. Normal
2. Uppercase Name
3. Mask Email
4. Uppercase + Mask Email
""");

        System.out.print("Enter Choice : ");
        int choice = sc.nextInt();

        System.out.println();
        userService.viewContactDetails(loggedUser, contactNumber, choice);

        sc.close();
    }
}