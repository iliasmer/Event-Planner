package com.domain;

import java.util.ArrayList;

public class SubteamMember extends User{
    Subteam subteam;
    ArrayList<Task> tasks;

    public SubteamMember(String username, char[] password, UserRole role, Subteam subteam) {
        super(username, password, role);
        this.subteam = subteam;
        this.tasks = new ArrayList<Task>();
    }

    public void addTask(Task task) {
        this.tasks.add(task);
    }
    public Subteam getSubteam() {
        return subteam;
    }

    public void setSubteam(Subteam subteam) {
        this.subteam = subteam;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }
}
