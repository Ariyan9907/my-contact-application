package com.bridgelabz.validations;

import java.util.regex.Pattern;

public class Validation {
    public static boolean validateName(String name){
        String pattern="^[A-Z][a-z]{3,8}$";
        return Pattern.matches(pattern,name);
    }

    public static boolean validateEmail(String email){
        String pattern="^[A-Za-z0-9]+@[a-z]+\\.[a-z]{2,3}$";
        return Pattern.matches(pattern,email);
    }

    public static boolean validatePassword(String password){
        String pattern="^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[@%&&#!])";
        return Pattern.matches(pattern,password);
    }
}
