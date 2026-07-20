package com.bridgelabz.observer;

import com.bridgelabz.model.Contact;

public class NotificationObserver implements ContactObserver {

    @Override
    public void update(Contact contact) {

        System.out.println();
        System.out.println("===== NOTIFICATION =====");
        System.out.println("Contact Deleted Successfully");
        System.out.println("Deleted Contact : " + contact.getName());

    }

}
