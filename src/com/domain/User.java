package com.domain;

public abstract class User {
    String username;
    char[] password;
    UserRole userRole;

    public User(String username, char[] password, UserRole role) {
        this.username = username;
        this.password = password;
        this.userRole = role;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public String getUsername() {
        return username;
    }

    public char[] getPassword() {
        return password;
    }

    public UserRole getUserRole() {
        return userRole;
    }
}
