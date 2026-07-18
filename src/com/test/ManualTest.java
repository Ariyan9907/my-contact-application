package com.test;

import com.bridgelabz.model.User;
import com.bridgelabz.service.UserService;
import com.bridgelabz.util.PasswordHasher;

public class ManualTest {
    public static void main(String[] args) {

        UserService userService = new UserService();
        String aryan = userService.register("Aryan", "aryan@gmail.com", "Aryan@9907", "Aryan@9907");
        System.out.println(aryan);

        User login = userService.login("aryan@gmail.com", "Aryan@9907");
        System.out.println(login.getName());


    }
}
