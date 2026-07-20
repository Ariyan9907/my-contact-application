package com.bridgelabz.filter;

import com.bridgelabz.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class CompositeFilter implements ContactFilter {

    private final List<ContactFilter> filters = new ArrayList<>();

    public void addFilter(ContactFilter filter) {

        filters.add(filter);

    }

    @Override
    public List<Contact> filter(List<Contact> contacts) {

        List<Contact> result = contacts;

        for (ContactFilter filter : filters) {

            result = filter.filter(result);

        }

        return result;

    }
}