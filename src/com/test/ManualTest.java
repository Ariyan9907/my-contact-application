package com.test;

import com.bridgelabz.util.PasswordHasher;

public class ManualTest {
    public static void main(String[] args) {

        String password = "Aryan@123";

        String hashedPassword = PasswordHasher.hashPassword(password);

        System.out.println("Original Password : " + password);
        System.out.println("Hashed Password   : " + hashedPassword);

        // Hashing the same password again
        String hashedPassword2 = PasswordHasher.hashPassword(password);

        System.out.println("\nHash Again        : " + hashedPassword2);

        if (hashedPassword.equals(hashedPassword2)) {
            System.out.println("\nBoth hashes are equal.");
        } else {
            System.out.println("\nHashes are different.");
        }

        // Different password
        String anotherPassword = "Aryan@124";
        String hashedPassword3 = PasswordHasher.hashPassword(anotherPassword);

        System.out.println("\nDifferent Password Hash : " + hashedPassword3);

        if (!hashedPassword.equals(hashedPassword3)) {
            System.out.println("Different passwords produce different hashes.");
        }
    }
}
