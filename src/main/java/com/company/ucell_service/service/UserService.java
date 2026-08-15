package com.company.ucell_service.service;

import com.company.ucell_service.entity.Users;
import com.company.ucell_service.entity.enums.UserRole;
import com.company.ucell_service.handler.LogSendHandler;
import com.company.ucell_service.repository.UserRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.logging.Handler;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserService extends UserRepository {
    // todo: fileService
    //  User CRUD

    static {
        String file = UserService.class.getClassLoader().getResource("logging.properties").getFile();
        System.setProperty("java.util.logging.config.file", file);
    }
    public static Handler handler=new LogSendHandler();
    public static Users users = new Users();
    public static Logger logger = Logger.getLogger(UserService.class.getName());

    public Users checkUser(String email) throws IOException {
return null;
    }

    public boolean createUser(Users users) throws IOException {
        logger.info(LocalDateTime.now() + users.toString());
        return true;
    }

    public Users getUserByEmail(String email) throws IOException {
        return findByEmail(email);
    }

    public boolean updateUserByEmail(String email, Users users) {
        return true;

    }

    public boolean deleteUserByEmail(String email) {
        return true;
    }
}
