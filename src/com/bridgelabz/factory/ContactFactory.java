package com.bridgelabz.factory;

import com.bridgelabz.model.Contact;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class ContactFactory {

    public static Contact createContact(String name,
                                        String phoneNumber,
                                        String email) {

        return new Contact(
                UUID.randomUUID().toString(),
                name,
                phoneNumber,
                email,
                LocalDateTime.now(),
                LocalDate.now(),
                0
        );
    }
}
