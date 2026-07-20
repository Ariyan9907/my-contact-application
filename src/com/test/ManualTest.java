package com.test;

import com.bridgelabz.model.User;
import com.bridgelabz.service.UserService;
import com.bridgelabz.model.Contact;

import java.time.LocalDate;

public class ManualTest {

    public static void main(String[] args) {UserService service = new UserService();

        service.register(
                "Aryan",
                "aryan@gmail.com",
                "Aryan@9907",
                "Aryan@9907");

        User user =
                service.login(
                        "aryan@gmail.com",
                        "Aryan@9907");

        service.addContact(
                user,
                "Rahul",
                "9999999999",
                "rahul@gmail.com");

        Contact contact = user.getContacts().get(0);

        System.out.println(
                service.addTag(
                        user,
                        contact.getId(),
                        "Family"));

        System.out.println(
                service.addTag(
                        user,
                        contact.getId(),
                        "Friends"));

        System.out.println();

        service.viewTags(
                user,
                contact.getId());

        System.out.println();

        System.out.println(
                service.removeTag(
                        user,
                        contact.getId(),
                        "Friends"));

        System.out.println();

        service.viewTags(
                user,
                contact.getId());
    }
}