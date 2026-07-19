package com.bridgelabz.decorator;

import com.bridgelabz.model.Contact;

public class MaskEmailDecorator extends ContactDecorator {

    public MaskEmailDecorator(ContactFormatter formatter) {
        super(formatter);
    }

    @Override
    public String format(Contact contact) {

        String result = super.format(contact);

        String email = contact.getEmail();

        int index = email.indexOf('@');

        if (index > 2) {

            String maskedEmail =
                    email.substring(0, 2)
                            + "***"
                            + email.substring(index);

            result = result.replace(email, maskedEmail);
        }

        return result;
    }
}