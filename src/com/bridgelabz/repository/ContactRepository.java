package com.bridgelabz.repository;

import com.bridgelabz.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactRepository {

    private final List<Contact> contacts = new ArrayList<>();

    public void save(Contact contact) {
        contacts.add(contact);
    }

    public List<Contact> findAll() {
        return contacts;
    }

    public Contact findById(String id) {

        for (Contact contact : contacts) {
            if (contact.getId().equals(id)) {
                return contact;
            }
        }

        return null;
    }

    public boolean deleteById(String id) {

        Contact contact = findById(id);

        if (contact != null) {
            contacts.remove(contact);
            return true;
        }

        return false;
    }
}