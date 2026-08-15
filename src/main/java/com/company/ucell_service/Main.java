package com.company.ucell_service;

import com.company.ucell_service.auth.AuthService;
import com.company.ucell_service.entity.Users;
import com.company.ucell_service.service.FileService;
import com.company.ucell_service.service.UserService;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static AuthService authService = new AuthService();
    private static FileService fileService;

    static {
        try {
            fileService = new FileService();
        } catch (IOException e) {
            throw new RuntimeException(e);

        }
    }

    public static UserService userService;

    static {
        try {
            userService = new UserService();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Users current;

    public static void login() throws IOException {
        System.out.print("Email: ");
        String email = "abdumumin@gmail.com"; //(scanner.nextLine();

        System.out.print("Password: ");
        String password = "asdf+123"; //scanner.nextLine();

       // checkUser(email);
        Users user = userService.getUserByEmail(email);
        System.out.println(user.toString());
        if (user.getEmail() != null) {
            current = user;
            System.out.println("User Login Successfully");
            startUserSection();
        }
        else createNewUser(user);

    }
    private static void createNewUser(Users user) throws IOException {
        userService.createUser(user);
    }



    private static void startUserSection() {}

    public static void main(String[] args) throws IOException {
        fileService.createDefaultSuperAdmin();
        login();

    }
}