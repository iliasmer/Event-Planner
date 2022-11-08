package com.dao;

import com.domain.Manager;
import com.domain.User;
import com.domain.UserRole;

public interface UserDAO {

    void save(User user);

    UserRole checkUser(String username, char[] passsword);

    User getUser(String username);
}
