package com.bridgelabz.command;

import com.bridgelabz.model.Contact;

public class EditContactCommand implements Command {

    private final Contact contact;

    // Old Values
    private final String oldName;
    private final String oldPhone;
    private final String oldEmail;

    // New Values
    private final String newName;
    private final String newPhone;
    private final String newEmail;

    public EditContactCommand(Contact contact,
                              String newName,
                              String newPhone,
                              String newEmail) {

        this.contact = contact;

        // Save old values
        this.oldName = contact.getName();
        this.oldPhone = contact.getPhoneNumber();
        this.oldEmail = contact.getEmail();

        // Save new values
        this.newName = newName;
        this.newPhone = newPhone;
        this.newEmail = newEmail;
    }

    @Override
    public void execute() {

        contact.setName(newName);
        contact.setPhoneNumber(newPhone);
        contact.setEmail(newEmail);

    }

    @Override
    public void undo() {

        contact.setName(oldName);
        contact.setPhoneNumber(oldPhone);
        contact.setEmail(oldEmail);

    }
}