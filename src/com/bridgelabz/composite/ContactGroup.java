package com.bridgelabz.composite;

import java.util.ArrayList;
import java.util.List;

public class ContactGroup implements ContactComponent {

    private final List<ContactComponent> contacts = new ArrayList<>();

    public void add(ContactComponent contact) {
        contacts.add(contact);
    }

    public void remove(ContactComponent contact) {
        contacts.remove(contact);
    }

    @Override
    public void showDetails() {

        contacts.forEach(ContactComponent::showDetails);

    }

    public List<ContactComponent> getContacts() {
        return contacts;
    }
}