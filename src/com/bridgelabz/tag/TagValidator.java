package com.bridgelabz.tag;

public class TagValidator {

    public static boolean isValid(String tagName) {

        return tagName != null
                && !tagName.isBlank();

    }
}