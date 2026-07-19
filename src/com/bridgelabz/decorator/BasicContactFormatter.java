package com.bridgelabz.decorator;

import com.bridgelabz.model.Contact;

public class BasicContactFormatter implements ContactFormatter {

    @Override
    public String format(Contact contact) {

        return "===== CONTACT DETAILS =====\n" +
                "ID      : " + contact.getId() + "\n" +
                "Name    : " + contact.getName() + "\n" +
                "Phone   : " + contact.getPhoneNumber() + "\n" +
                "Email   : " + contact.getEmail() + "\n" +
                "Created : " + contact.getCreatedAt();
    }
}