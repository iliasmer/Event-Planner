package com.view.general.items;

import com.domain.User;

public class UserItem {
    User user;

    public UserItem(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    @Override
    public String toString() {
        return user.getUsername();
    }
}
