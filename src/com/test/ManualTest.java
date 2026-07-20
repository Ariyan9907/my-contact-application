package com.test;

import com.bridgelabz.model.User;
import com.bridgelabz.service.UserService;

import java.time.LocalDate;

public class ManualTest {

    public static void main(String[] args) {

        UserService service = new UserService();

        service.register(
                "Aryan",
                "aryan@gmail.com",
                "Aryan@9907",
                "Aryan@9907");

        User user = service.login(
                "aryan@gmail.com",
                "Aryan@9907");

        service.addContact(user, "Ramesh", "9999999999", "ram@gmail.com");
        service.addContact(user, "Rahul", "8888888888", "rahul@gmail.com");
        service.addContact(user, "Ajay", "7777777777", "ajay@gmail.com");

        user.getContacts().get(0).setTag("Family");
        user.getContacts().get(1).setTag("Friends");
        user.getContacts().get(2).setTag("Office");

        user.getContacts().get(0).setContactCount(12);
        user.getContacts().get(1).setContactCount(5);
        user.getContacts().get(2).setContactCount(20);

        System.out.println("----- Filter By Tag -----");
        service.filterContacts(user, "Family", null, false);

        System.out.println("\n----- Sort By Frequently Contacted -----");
        service.filterContacts(user, null, null, true);

        System.out.println("\n----- Filter By Tag + Sort -----");
        service.filterContacts(user, "Office", null, true);

        System.out.println("\n----- Filter By Date -----");
        service.filterContacts(user, null, LocalDate.now(), false);
    }
}