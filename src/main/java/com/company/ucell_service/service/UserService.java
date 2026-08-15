package com.company.ucell_service.service;

import com.company.ucell_service.entity.Users;
import com.company.ucell_service.repository.UserRepository;

import java.io.IOException;
import java.util.regex.Pattern;

public class UserService {
    // todo: fileService
    //  User CRUD

    private static final String EMAIL_REGEX = "";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    private static final UserRepository userRepo;
    private static final FileService fileService;

    static {
        try {
            userRepo = new UserRepository();
            fileService = new FileService();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public UserService() throws IOException {
    }

    public boolean createUser(Users users) throws IOException {
        validateRequest(users);
        return fileService.createUser(users);
    }


    public Users getUserByEmail(String email) throws IOException {
        return userRepo.findByEmail(email);
    }

    public boolean updateUserByEmail(String email, Users users) throws IOException {
        Users userByEmail = getUserByEmail(email);
        if (users.getEmail() != null)
            userByEmail.setEmail(users.getEmail());

        return true;

    }

    public boolean deleteUserByEmail(String email) {
        return true;
    }

    // HELPER METHODS

    private boolean isValidEmail(String email) {
        return true;
//        return email != null && EMAIL_PATTERN.matcher(email).matches();
    }

    private void validateRequest(Users users) throws IOException {
        if (users.getEmail() != null) {
            Users userByEmail = getUserByEmail(users.getEmail());
            if (!isValidEmail(users.getEmail())) {
                throw new IllegalAccessError("Email is not valid");
            }
            if (userByEmail != null) {
                throw new RuntimeException("Email already exist");
            }
            if (users.getRole() == null) {
                throw new IllegalArgumentException("Role must not be null");
            }
        }
    }
}
