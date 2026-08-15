package com.company.ucell_service.auth;

import com.company.ucell_service.entity.Users;
import com.company.ucell_service.repository.UserRepository;

import java.io.IOException;

public class AuthService {
    private static UserRepository userRepository;

    public Users login(String email, String password) throws IOException {
        Users user = userRepository.findByEmail(email);
        if (user != null) {
            if (user.getPasswordHash().equals(password)) {
                return user;
            }
        }
        throw new RuntimeException("User not found with email: " + email);
    }
}
