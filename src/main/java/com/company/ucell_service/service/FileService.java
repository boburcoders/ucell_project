package com.company.ucell_service.service;

import com.company.ucell_service.entity.Users;
import com.company.ucell_service.entity.enums.UserRole;
import com.company.ucell_service.repository.UserRepository;

import java.io.*;
import java.time.LocalDateTime;
import java.util.Arrays;

public class FileService {
    private static final UserRepository userRepo;

    static {
        try {
            userRepo = new UserRepository();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public FileService() throws IOException {
    }

    public void createDefaultSuperAdmin() throws IOException {
        Users users = new Users();
        users.setId(1L);
        users.setEmail("root@gmail.com");
        users.setRole(UserRole.SUPER_ADMIN);
        users.setUsername("root");
        users.setPasswordHash("root123");
        users.setRegisteredAt(LocalDateTime.now());
        //todo: defaultUserCreate
        if (!userRepo.isHasSuperAdmin()) {
            try (FileWriter writer = new FileWriter("users.txt", true)) {
                writer.write(users.getId() + "," + users.getUsername() + ","
                        + users.getEmail() + "," + users.getPasswordHash() + ","
                        + users.getRole() + "," + users.getRegisteredAt() + "\n");
            }
            System.out.println("Defualt User created: " + users.getEmail());
        } else {
            System.out.println("Super admin already exist with email: " + users.getEmail());
        }

    }

    public boolean createUser(Users users) throws IOException {
        try (FileWriter writer = new FileWriter("users.txt", true)) {
            writer.write(users.getId() + "," + users.getUsername() + ","
                    + users.getEmail() + "," + users.getPasswordHash() + ","
                    + users.getRole() + "," + users.getRegisteredAt());
        }
        return true;

    }


    public Users findByEmail(String email) throws FileNotFoundException {
        try (BufferedReader reader = new BufferedReader(new FileReader("users.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                System.out.println(Arrays.toString(data));

                Long id = Long.parseLong(data[0]);
                String username = data[1];
                String fileEmail = data[2];
                String password = data[3];
                String role = data[4];
                LocalDateTime registered = LocalDateTime.parse(data[5]);

                Users users = new Users();
                users.setId(id);
                users.setUsername(username);
                users.setEmail(fileEmail);
                users.setPasswordHash(password);
                users.setRole(UserRole.valueOf(role));
                users.setRegisteredAt(registered);

                if (email.equals(fileEmail)) {
                    return users;
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
