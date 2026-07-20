package com.bridgelabz.filter;

import com.bridgelabz.model.Contact;

import java.util.List;
import java.util.stream.Collectors;

public class TagFilter implements ContactFilter {

    private final String tag;

    public TagFilter(String tag) {
        this.tag = tag;
    }

    @Override
    public List<Contact> filter(List<Contact> contacts) {

        return contacts.stream()
                .filter(contact ->
                        contact.getTag().equalsIgnoreCase(tag))
                .collect(Collectors.toList());

    }
}