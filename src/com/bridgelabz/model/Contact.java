package com.bridgelabz.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Contact {

    private String id;
    private String name;
    private String phoneNumber;
    private String email;
    private LocalDateTime createdAt;

    // UC10 Fields
    private String tag;
    private LocalDate dateAdded;
    private int contactCount;

    public Contact(String id,
                   String name,
                   String phoneNumber,
                   String email,
                   LocalDateTime createdAt,
                   String tag,
                   LocalDate dateAdded,
                   int contactCount) {

        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.createdAt = createdAt;
        this.tag = tag;
        this.dateAdded = dateAdded;
        this.contactCount = contactCount;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String getTag() {
        return tag;
    }

    public LocalDate getDateAdded() {
        return dateAdded;
    }

    public int getContactCount() {
        return contactCount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setDateAdded(LocalDate dateAdded) {
        this.dateAdded = dateAdded;
    }

    public void setContactCount(int contactCount) {
        this.contactCount = contactCount;
    }
}