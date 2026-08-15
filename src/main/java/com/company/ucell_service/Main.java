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
    private static FileService fileService = new FileService();
    public static UserService userService = new UserService();

    private static Users current;

    public static void login() throws IOException {
        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

       // checkUser(email);
        Users user = userService.getUserByEmail(email);
        if (user != null) {
            current = user;
            System.out.println("User Login Successfully");
            startUserSection();
        }

    }



    private static void startUserSection() {

    }

    public static void main(String[] args) throws IOException {
        fileService.createDefaultSuperAdmin();
        login();

    }
}