package com.bridgelabz.observer;

import com.bridgelabz.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactDeleteSubject {

    private final List<ContactObserver> observers = new ArrayList<>();

    public void addObserver(ContactObserver observer) {

        observers.add(observer);

    }

    public void removeObserver(ContactObserver observer) {

        observers.remove(observer);

    }

    public void notifyObservers(Contact contact) {

        for (ContactObserver observer : observers) {

            observer.update(contact);

        }

    }

}