package com.bridgelabz.model;

import com.bridgelabz.tag.Tag;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class Contact {

    private String id;
    private String name;
    private String phoneNumber;
    private String email;
    private LocalDateTime createdAt;

    // UC10 Fields
    private Set<Tag> tags = new HashSet<>();
    private LocalDate dateAdded;
    private int contactCount;

    public Contact(String id,
                   String name,
                   String phoneNumber,
                   String email,
                   LocalDateTime createdAt,
                   LocalDate dateAdded,
                   int contactCount) {

        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.createdAt = createdAt;
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


    public void setDateAdded(LocalDate dateAdded) {
        this.dateAdded = dateAdded;
    }

    public void setContactCount(int contactCount) {
        this.contactCount = contactCount;
    }

    public Set<Tag> getTags() {
        return tags;
    }
}