package com.bridgelabz.filter;

import com.bridgelabz.model.Contact;

import java.util.List;

public interface ContactFilter {

    List<Contact> filter(List<Contact> contacts);

}