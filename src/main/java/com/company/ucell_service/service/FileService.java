package com.company.ucell_service.service;

import com.company.ucell_service.entity.Users;
import com.company.ucell_service.entity.enums.UserRole;
import com.company.ucell_service.repository.UserRepository;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;

public class FileService extends UserRepository {
    Handler handler = new FileHandler("fileservislog.log",true);
    Logger logger = Logger.getLogger("MyLoggerTest");
    Users userSuperAdmin = new Users();
    public FileService() throws IOException {
    }

    public void createDefaultSuperAdmin() throws IOException {
        //todo: defaultUserCreate
        logger.addHandler(handler);
        if (!checkSuperAdmin()){
            users.setEmail("root@gmail.com");
            users.setId();
            users.setRole(UserRole.SUPER_ADMIN);
            users.setUsername("root");
            users.setPasswordHash("root123");
            users.setRegisteredAt(LocalDateTime.now());
            logger.info(LocalDateTime.now()+"--> "+users.toString());
        }
        else {
            logger.info("SuperAdmin Already created!!");
        }

    }
    //todo: SUPER_ADMIN
    public boolean checkSuperAdmin() throws IOException {
        return isHasSuperAdmin();
    }

    public boolean createUser(Users users) throws IOException {
logger.addHandler(handler);
        logger.info(LocalDateTime.now() + users.toString());
        return true;
    }



}
