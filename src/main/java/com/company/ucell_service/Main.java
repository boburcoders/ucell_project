package com.company.ucell_service;

import com.company.ucell_service.auth.AuthService;
import com.company.ucell_service.entity.Users;
import com.company.ucell_service.entity.enums.UserRole;
import com.company.ucell_service.service.FileService;
import com.company.ucell_service.service.UserService;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final AuthService authService;
    private static final UserService userService;
    private static final FileService fileService;

    static {
        try {
            userService = new UserService();
            authService = new AuthService();
            fileService = new FileService();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Users current;  // CONTEXT HOLDER

    public static void login() throws IOException {
        System.out.println("You are not in system, pls login by email and password");

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


    private static void startUserSection() throws IOException {
        UserRole role = current.getRole();
        switch (role) {
            case SUPER_ADMIN -> {
                System.out.printf("Wecome to Sytem %s, " +
                                "pls choose action as number what you want to do" +
                                "1-> User CREATE Action",
                        "2-> User GET Action",
                        "3-> User UPDATE Action",
                        "4-> User DELETE Action",
                        current.getUsername());

                System.out.println();
                System.out.print("Chose one of them (1,2,3,4)");

                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1 -> {
                        System.out.println("You are enter CREATE Action pls write user details in bottom");

                        System.out.print("ID: ");
                        String id = scanner.nextLine();

                        System.out.print("USERNAME: ");
                        String username = scanner.nextLine();

                        System.out.print("EMAIL: ");
                        String email = scanner.nextLine();

                        System.out.print("PASSWORD: ");
                        String password = scanner.nextLine();

                        System.out.print("USERROLE-> (SUPER_ADMIN,ADMIN, MANAGER,USER): ");
                        String userRole = scanner.nextLine().toUpperCase();

                        Users newUser = new Users(Long.parseLong(id), username, email, password, UserRole.valueOf(userRole), LocalDateTime.now());

                        boolean user = userService.createUser(newUser);
                        if (user) {
                            System.out.println("User created successfully: " + username);
                        }
                    }
                }

            }
            case USER -> {
                userMenueSection();
                System.out.println("USER");
            }
        }
        // if current role SuperAdmin ,
    }

    private static void userMenueSection() {
        System.out.println("You are USER");

    }

    public static void main(String[] args) throws IOException {
        fileService.createDefaultSuperAdmin();
        login();

    }
}