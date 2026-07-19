package com.bridgelabz.decorator;

import com.bridgelabz.model.Contact;

public abstract class ContactDecorator implements ContactFormatter {

    protected ContactFormatter formatter;

    public ContactDecorator(ContactFormatter formatter) {
        this.formatter = formatter;
    }

    @Override
    public String format(Contact contact) {
        return formatter.format(contact);
    }
}