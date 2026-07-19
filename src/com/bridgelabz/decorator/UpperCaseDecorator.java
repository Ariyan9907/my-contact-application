package com.bridgelabz.decorator;

import com.bridgelabz.model.Contact;

public class UpperCaseDecorator extends ContactDecorator {

    public UpperCaseDecorator(ContactFormatter formatter) {
        super(formatter);
    }

    @Override
    public String format(Contact contact) {

        String result = super.format(contact);

        return result.replace(
                contact.getName(),
                contact.getName().toUpperCase()
        );
    }
}