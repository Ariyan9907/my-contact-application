package com.test;


import com.bridgelabz.validations.Validation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Main {

    @Test
    public void Aryan_true_for_validateName(){
        boolean actual= Validation.validateName("Aryan");
        assertTrue(actual);
    }

    @Test
    public void aryan_false_for_validateName(){
        boolean actual= Validation.validateName("aryan");
        assertFalse(actual);
    }

    @Test
    public void validateEmail_return_true_aryanatgmaildotcom(){
        boolean actual= Validation.validateEmail("aryan@gmail.com");
        assertTrue(actual);
    }

    @Test
    public void validateEmail_return_false_aryangmailcom(){
        boolean actual= Validation.validateEmail("aryangmailcom");
        assertFalse(actual);
    }


}
