package com.memorydao;

import com.dao.UserDAO;
import com.domain.Manager;
import com.domain.User;
import com.domain.UserRole;

import java.util.Arrays;
import java.util.HashMap;

public class UserDAOMemory implements UserDAO {

    protected static HashMap<String, User> entities = new HashMap<String, User>();

    @Override
    public void save(User user) {
        entities.put(user.getUsername(), user);
    }

    @Override
    public UserRole checkUser(String username, char[] password) {
        if (entities.containsKey(username)) {
            User user = entities.get(username);
            if (Arrays.equals(user.getPassword(), password)) {
                return user.getUserRole();
            } else {
                return null;
            }
        }else{
            return null;
        }
    }
    @Override
    public User getUser(String username) {
        if (entities.containsKey(username)) {
            return entities.get(username);
        }else {
            return null;
        }
    }
}
