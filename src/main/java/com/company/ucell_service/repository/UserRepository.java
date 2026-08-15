package com.company.ucell_service.repository;

import com.company.ucell_service.entity.Users;
import com.company.ucell_service.entity.enums.UserRole;
import com.company.ucell_service.handler.LogSendHandler;
import com.company.ucell_service.service.UserService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Handler;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserRepository {
    //todo:fildan userlarni check qiladi
    public static Handler handler=new LogSendHandler();
    public static Users users = new Users();
    public static Logger logger = Logger.getLogger(UserService.class.getName());
    public Users findByEmail(String email) throws IOException {
        logger.addHandler(handler);
        String logcheck = Files.readString(Path.of("logs.log"));
        Pattern pattern = Pattern.compile(
                "email='([^']+)'.*?username='([^']+)'.*?role='([^']+)'"
        );
        Matcher matcher = pattern.matcher(logcheck);
        if (matcher.find()) {
            users.setEmail(matcher.group(1));
            users.setUsername(matcher.group(2));
            users.setRole(UserRole.valueOf(matcher.group(3)));
        }
        return  users;
    }


}
