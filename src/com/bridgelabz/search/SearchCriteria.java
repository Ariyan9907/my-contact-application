package com.bridgelabz.search;

import com.bridgelabz.model.Contact;

public interface SearchCriteria {

    boolean isSatisfied(Contact contact, String keyword);

}