package com.bridgelabz.service;

import com.bridgelabz.command.CommandManager;
import com.bridgelabz.command.EditContactCommand;
import com.bridgelabz.composite.ContactGroup;
import com.bridgelabz.decorator.BasicContactFormatter;
import com.bridgelabz.decorator.ContactFormatter;
import com.bridgelabz.decorator.MaskEmailDecorator;
import com.bridgelabz.decorator.UpperCaseDecorator;
import com.bridgelabz.factory.ContactFactory;
import com.bridgelabz.factory.UserFactory;
import com.bridgelabz.model.Contact;
import com.bridgelabz.model.User;
import com.bridgelabz.observer.ContactDeleteSubject;
import com.bridgelabz.observer.NotificationObserver;
import com.bridgelabz.repository.UserRepository;
import com.bridgelabz.util.PasswordHasher;
import com.bridgelabz.composite.SingleContact;
import com.bridgelabz.search.EmailCriteria;
import com.bridgelabz.search.NameCriteria;
import com.bridgelabz.search.PhoneCriteria;
import com.bridgelabz.search.SearchHandler;
import com.bridgelabz.filter.CompositeFilter;
import com.bridgelabz.filter.DateFilter;
import com.bridgelabz.filter.FrequentContactFilter;
import com.bridgelabz.filter.TagFilter;

import java.time.LocalDate;
import java.util.List;

import java.util.List;
import java.util.stream.Collectors;

import static com.bridgelabz.validations.Validation.*;

public class UserService {

    private final UserRepository repository = new UserRepository();
    private final CommandManager commandManager = new CommandManager();
    private final ContactDeleteSubject deleteSubject = new ContactDeleteSubject();

    public UserService() {

        deleteSubject.addObserver(new NotificationObserver());

    }

    public String register(String name,
                           String email,
                           String password,
                           String confirmPassword) {

        if (!validateName(name)) {
            return "Invalid Name";
        }

        if (!validateEmail(email)) {
            return "Invalid Email";
        }

        if (!validatePassword(password)) {
            return "Invalid Password";
        }

        if (!password.equals(confirmPassword)) {
            return "Passwords do not match";
        }

        if (repository.existsByEmail(email)) {
            return "Email already registered";
        }

        String hashedPassword = PasswordHasher.hashPassword(password);

        User user = UserFactory.createUser(
                name,
                email,
                hashedPassword
        );

        repository.save(user);

        return "Registration Successful";
    }

    public UserRepository getRepository() {
        return repository;
    }

    public User login(String email,String password){
        User user = repository.findUserByEmail(email);

        if(user==null){
            return null;
        }
        String hashedPassword = PasswordHasher.hashPassword(password);
        if(user.getPassword().equals(hashedPassword)){
            return user;
        }

        return null;

    }

    public void  viewProfile(User logedUser){
        if(logedUser!=null){
            System.out.println("Login Successfull");
            System.out.println("\n===== USER PROFILE =====");
            System.out.println("ID         : " + logedUser.getId());
            System.out.println("Name       : " + logedUser.getName());
            System.out.println("Email      : " + logedUser.getEmail());
            System.out.println("Created At : " + logedUser.getCreatedAt());
        }
        else {
            System.out.println("Invalid User");
        }
    }

    public String addContact(User loggedInUser,
                             String name,
                             String phoneNumber,
                             String email) {

        if (loggedInUser == null) {
            return "Please login first";
        }

        if (!validateName(name)) {
            return "Invalid Contact Name";
        }

        if (!validateEmail(email)) {
            return "Invalid Contact Email";
        }

        Contact contact = ContactFactory.createContact(
                name,
                phoneNumber,
                email
        );

        loggedInUser.getContacts().add(contact);

        return "Contact Added Successfully";
    }

    public void viewContacts(User loggedInUser) {

        if (loggedInUser == null) {
            System.out.println("Please login first");
            return;
        }

        if (loggedInUser.getContacts().isEmpty()) {
            System.out.println("No contacts found.");
            return;
        }

        System.out.println("\n===== CONTACT LIST =====");

        for (Contact contact : loggedInUser.getContacts()) {

            System.out.println("----------------------------");
            System.out.println("ID      : " + contact.getId());
            System.out.println("Name    : " + contact.getName());
            System.out.println("Phone   : " + contact.getPhoneNumber());
            System.out.println("Email   : " + contact.getEmail());
            System.out.println("Created : " + contact.getCreatedAt());
        }
    }

    public String updateContact(User loggedInUser,
                                String contactId,
                                String name,
                                String phoneNumber,
                                String email) {

        if (loggedInUser == null) {
            return "Please login first";
        }

        for (Contact contact : loggedInUser.getContacts()) {

            if (contact.getId().equals(contactId)) {

                if (!validateName(name)) {
                    return "Invalid Contact Name";
                }

                if (!validateEmail(email)) {
                    return "Invalid Contact Email";
                }

                EditContactCommand command =
                        new EditContactCommand(
                                contact,
                                name,
                                phoneNumber,
                                email
                        );

                commandManager.executeCommand(command);

                return "Contact Updated Successfully";
            }
        }

        return "Contact Not Found";
    }

    public String deleteContact(User loggedInUser, String contactId) {

        if (loggedInUser == null) {
            return "Please login first";
        }

        Contact deletedContact = null;

        for (Contact contact : loggedInUser.getContacts()) {

            if (contact.getId().equals(contactId)) {

                deletedContact = contact;
                break;
            }
        }

        if (deletedContact == null) {
            return "Contact Not Found";
        }

        loggedInUser.getContacts().remove(deletedContact);

        deleteSubject.notifyObservers(deletedContact);

        return "Contact Deleted Successfully";
    }

    public void viewContactDetails(User loggedUser, int contactNumber, int choice) {

        if (loggedUser == null) {
            System.out.println("Please login first.");
            return;
        }

        List<Contact> contacts = loggedUser.getContacts();

        if (contactNumber < 1 || contactNumber > contacts.size()) {
            System.out.println("Invalid contact number.");
            return;
        }

        Contact contact = contacts.get(contactNumber - 1);

        ContactFormatter formatter = new BasicContactFormatter();

        switch (choice) {
            case 2:
                formatter = new UpperCaseDecorator(formatter);
                break;
            case 3:
                formatter = new MaskEmailDecorator(formatter);
                break;
            case 4:
                formatter = new MaskEmailDecorator(
                        new UpperCaseDecorator(formatter));
                break;
        }

        System.out.println(formatter.format(contact));
    }

    public void undoLastEdit() {

        commandManager.undo();

    }

    public void redoLastEdit() {

        commandManager.redo();

    }

    public void viewBulkContacts(User loggedInUser) {

        if (loggedInUser == null) {
            System.out.println("Please login first");
            return;
        }

        ContactGroup group = new ContactGroup();

        loggedInUser.getContacts()
                .stream()
                .map(SingleContact::new)
                .forEach(group::add);

        group.showDetails();
    }

    public String bulkDeleteContacts(User loggedInUser, List<String> names) {

        if (loggedInUser == null) {
            return "Please login first";
        }

        loggedInUser.getContacts()
                .removeIf(contact ->
                        names.contains(contact.getName()));

        return "Bulk Delete Successful";
    }

    public void exportContacts(User loggedInUser) {

        if (loggedInUser == null) {
            System.out.println("Please login first");
            return;
        }

        System.out.println("\n===== CONTACT EXPORT =====");

        loggedInUser.getContacts()
                .forEach(contact ->

                        System.out.println(
                                contact.getName()
                                        + " | "
                                        + contact.getPhoneNumber()
                                        + " | "
                                        + contact.getEmail()
                        )
                );
    }

    public void searchContact(User loggedInUser, String keyword) {

        if (loggedInUser == null) {
            System.out.println("Please login first");
            return;
        }

        List<SingleContact> result =
                loggedInUser.getContacts()
                        .stream()
                        .filter(contact ->
                                contact.getName()
                                        .toLowerCase()
                                        .contains(keyword.toLowerCase()))
                        .map(SingleContact::new)
                        .collect(Collectors.toList());

        ContactGroup group = new ContactGroup();

        result.forEach(group::add);

        group.showDetails();
    }

    public void searchContacts(User loggedInUser, String keyword) {

        if (loggedInUser == null) {
            System.out.println("Please login first");
            return;
        }

        SearchHandler nameHandler = new SearchHandler(new NameCriteria());
        SearchHandler phoneHandler = new SearchHandler(new PhoneCriteria());
        SearchHandler emailHandler = new SearchHandler(new EmailCriteria());

        nameHandler.setNext(phoneHandler);
        phoneHandler.setNext(emailHandler);

        List<Contact> result = nameHandler.search(loggedInUser.getContacts(), keyword);

        if (result.isEmpty()) {
            System.out.println("No Contact Found");
            return;
        }

        System.out.println("\n===== SEARCH RESULT =====");

        result.forEach(contact -> {
            System.out.println("----------------------------");
            System.out.println("Name  : " + contact.getName());
            System.out.println("Phone : " + contact.getPhoneNumber());
            System.out.println("Email : " + contact.getEmail());
        });
    }

    public void filterContacts(User loggedInUser,
                               String tag,
                               LocalDate date,
                               boolean sortByFrequency) {

        if (loggedInUser == null) {
            System.out.println("Please login first");
            return;
        }

        CompositeFilter compositeFilter = new CompositeFilter();

        if (tag != null && !tag.isBlank()) {
            compositeFilter.addFilter(new TagFilter(tag));
        }

        if (date != null) {
            compositeFilter.addFilter(new DateFilter(date));
        }

        if (sortByFrequency) {
            compositeFilter.addFilter(new FrequentContactFilter());
        }

        List<Contact> filteredContacts =
                compositeFilter.filter(loggedInUser.getContacts());

        if (filteredContacts.isEmpty()) {
            System.out.println("No Contact Found");
            return;
        }

        System.out.println("\n===== FILTERED CONTACTS =====");

        filteredContacts.forEach(contact -> {
            System.out.println("----------------------------");
            System.out.println("Name          : " + contact.getName());
            System.out.println("Phone         : " + contact.getPhoneNumber());
            System.out.println("Email         : " + contact.getEmail());
            System.out.println("Tag           : " + contact.getTag());
            System.out.println("Date Added    : " + contact.getDateAdded());
            System.out.println("Contact Count : " + contact.getContactCount());
        });
    }


}