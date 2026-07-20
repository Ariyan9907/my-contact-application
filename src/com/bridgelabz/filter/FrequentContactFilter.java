package com.bridgelabz.filter;

import com.bridgelabz.model.Contact;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FrequentContactFilter implements ContactFilter {

    @Override
    public List<Contact> filter(List<Contact> contacts) {

        return contacts.stream()
                .sorted(Comparator.comparingInt(Contact::getContactCount).reversed())
                .collect(Collectors.toList());

    }
}