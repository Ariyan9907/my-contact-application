package com.bridgelabz.search;

import com.bridgelabz.model.Contact;

public class NameCriteria implements SearchCriteria {

    @Override
    public boolean isSatisfied(Contact contact, String keyword) {

        return contact.getName()
                .toLowerCase()
                .contains(keyword.toLowerCase());

    }
}