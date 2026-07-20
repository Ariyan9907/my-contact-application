package com.bridgelabz.filter;

import com.bridgelabz.model.Contact;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class DateFilter implements ContactFilter {

    private final LocalDate date;

    public DateFilter(LocalDate date) {
        this.date = date;
    }

    @Override
    public List<Contact> filter(List<Contact> contacts) {

        return contacts.stream()
                .filter(contact ->
                        contact.getDateAdded().equals(date))
                .collect(Collectors.toList());

    }
}