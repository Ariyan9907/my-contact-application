package com.bridgelabz.search;

import com.bridgelabz.model.Contact;

import java.util.List;
import java.util.stream.Collectors;

public class SearchHandler {

    private final SearchCriteria criteria;
    private SearchHandler nextHandler;

    public SearchHandler(SearchCriteria criteria) {
        this.criteria = criteria;
    }

    public void setNext(SearchHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public List<Contact> search(List<Contact> contacts, String keyword) {

        List<Contact> result = contacts.stream()
                .filter(contact -> criteria.isSatisfied(contact, keyword))
                .collect(Collectors.toList());

        if (!result.isEmpty()) {
            return result;
        }

        if (nextHandler != null) {
            return nextHandler.search(contacts, keyword);
        }

        return List.of();
    }
}