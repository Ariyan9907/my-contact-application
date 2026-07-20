package com.bridgelabz.search;

import com.bridgelabz.model.Contact;

public class PhoneCriteria implements SearchCriteria {

    @Override
    public boolean isSatisfied(Contact contact, String keyword) {

        return contact.getPhoneNumber()
                .contains(keyword);

    }
}