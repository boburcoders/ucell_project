package com.company.ucell_service;

import com.company.ucell_service.auth.AuthService;
import com.company.ucell_service.entity.Users;
import com.company.ucell_service.service.FileService;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static AuthService authService = new AuthService();
    private static FileService fileService = new FileService();

    private static Users current;

    public static void login() {
        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        Users user = authService.login(email, password);
        if (user != null) {
            current = user;
            System.out.println("User Login Successfully");
            startUserSection();
        }

    }

    private static void startUserSection() {

    }

    public static void main(String[] args) {
        fileService.createDefaultSuperAdmin();
        login();

    }
}