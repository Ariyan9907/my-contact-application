package com.test;

import com.bridgelabz.model.User;
import com.bridgelabz.service.UserService;

public class ManualTest {

    public static void main(String[] args) {

        UserService service = new UserService();

        System.out.println(
                service.register(
                        "Aryan",
                        "aryan@gmail.com",
                        "Aryan@9907",
                        "Aryan@9907"
                )
        );

        User user = service.login(
                "aryan@gmail.com",
                "Aryan@9907"
        );

        service.addContact(user, "Ramesh", "9999999999", "ramesh@gmail.com");
        service.addContact(user, "Rahul", "8888888888", "rahul@yahoo.com");
        service.addContact(user, "Ajay", "7777777777", "ajay@gmail.com");

        System.out.println("\nSearch by Name");
        service.searchContacts(user, "Rah");

        System.out.println("\nSearch by Phone");
        service.searchContacts(user, "7777");

        System.out.println("\nSearch by Email");
        service.searchContacts(user, "yahoo");

        System.out.println("\nSearch Invalid");
        service.searchContacts(user, "XYZ");
    }
}