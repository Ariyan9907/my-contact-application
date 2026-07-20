package com.bridgelabz.search;

import com.bridgelabz.model.Contact;

public class EmailCriteria implements SearchCriteria {

    @Override
    public boolean isSatisfied(Contact contact, String keyword) {

        return contact.getEmail()
                .toLowerCase()
                .contains(keyword.toLowerCase());

    }
}