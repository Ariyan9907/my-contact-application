package com.test;

import com.bridgelabz.model.Contact;
import com.bridgelabz.model.User;
import com.bridgelabz.service.UserService;

import java.util.List;

public class ManualTest {

    public static void main(String[] args) {

        UserService service = new UserService();

        service.register(
                "Aryan",
                "aryan@gmail.com",
                "Aryan@9907",
                "Aryan@9907");

        User user =
                service.login(
                        "aryan@gmail.com",
                        "Aryan@9907");

        service.addContact(user,"Ramesh","9999999999","ram@gmail.com");
        service.addContact(user,"Rahul","8888888888","rahul@gmail.com");
        service.addContact(user,"Ajay","7777777777","ajay@gmail.com");
        service.addContact(user,"Amit","6666666666","amit@gmail.com");

        System.out.println("------ BULK VIEW ------");
        service.viewBulkContacts(user);

        System.out.println("\n------ SEARCH 'A' ------");
        service.searchContact(user,"A");

        System.out.println("\n------ BULK DELETE ------");
        service.bulkDeleteContacts(
                user,
                List.of("Ajay","Rahul"));

        System.out.println("\n------ AFTER DELETE ------");
        service.viewBulkContacts(user);

        System.out.println("\n------ EXPORT ------");
        service.exportContacts(user);



    }
}