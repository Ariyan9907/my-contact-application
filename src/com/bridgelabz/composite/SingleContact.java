package com.bridgelabz.composite;

import com.bridgelabz.model.Contact;

public class SingleContact implements ContactComponent {

    private final Contact contact;

    public SingleContact(Contact contact) {
        this.contact = contact;
    }

    @Override
    public void showDetails() {

        System.out.println("--------------------------------");
        System.out.println("Name  : " + contact.getName());
        System.out.println("Phone : " + contact.getPhoneNumber());
        System.out.println("Email : " + contact.getEmail());

    }

    public Contact getContact() {
        return contact;
    }
}