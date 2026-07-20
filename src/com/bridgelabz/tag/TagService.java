package com.bridgelabz.tag;

import com.bridgelabz.model.Contact;

public class TagService {

    public String addTag(Contact contact, String tagName) {

        if (!TagValidator.isValid(tagName)) {
            return "Invalid Tag";
        }

        Tag tag = TagFactory.getTag(tagName);

        contact.getTags().add(tag);

        return "Tag Added Successfully";
    }

    public String removeTag(Contact contact, String tagName) {

        Tag tag = TagFactory.getTag(tagName);

        if (contact.getTags().remove(tag)) {
            return "Tag Removed Successfully";
        }

        return "Tag Not Found";
    }

    public void viewTags(Contact contact) {

        if (contact.getTags().isEmpty()) {
            System.out.println("No Tags");
            return;
        }

        System.out.println("Tags : " + contact.getTags());
    }
}