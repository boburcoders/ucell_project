package com.company.ucell_service.entity;

import com.company.ucell_service.entity.enums.UserRole;

import java.time.LocalDateTime;
import java.util.Random;

public class Users {
    private Long id;
    private String username;
    private String email;
    private String passwordHash;
    private UserRole role;
    private LocalDateTime registeredAt;

    public Users(Long id,
                 String username,
                 String email,
                 String passwordHash,
                 UserRole role,
                 LocalDateTime registeredAt) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.passwordHash = passwordHash;
        this.role = role;
        this.registeredAt = registeredAt;
    }

    public Long getId() {
        return id;
    }

    public void setId() {
        Random random = new Random();
        this.id = random.nextLong();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public LocalDateTime getRegisteredAt() {
        return registeredAt;
    }

    public void setRegisteredAt(LocalDateTime registeredAt) {
        this.registeredAt = registeredAt;
    }
}
