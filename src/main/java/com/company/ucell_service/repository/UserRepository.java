package com.company.ucell_service.repository;

import com.company.ucell_service.entity.Users;
import com.company.ucell_service.service.FileService;

import java.io.IOException;

public class UserRepository {
    //todo:fildan userlarni check qiladi
    private static final FileService fileService; // dependency injection

    static {
        try {
            fileService = new FileService();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public UserRepository() throws IOException {
    }

    public Users findByEmail(String email) throws IOException {
        return fileService.findByEmail(email);
    }

    public boolean isHasSuperAdmin() throws IOException {
        Users byEmail = fileService.findByEmail("root@gmail.com");
        return byEmail != null;
    }

}
