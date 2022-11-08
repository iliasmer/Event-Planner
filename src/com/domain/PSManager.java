package com.domain;

import java.util.ArrayList;

public class PSManager extends User{
    ArrayList<Subteam> subteams;

    public PSManager(String username, char[] password, UserRole role, ArrayList<Subteam> subteams) {
        super(username, password, role);
        this.subteams = subteams;
    }

    public ArrayList<Subteam> getSubteams() {
        return this.subteams;
    }

    public void setSubteams(ArrayList<Subteam> subteams) {
        this.subteams = subteams;
    }
}
