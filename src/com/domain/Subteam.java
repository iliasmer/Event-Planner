package com.domain;

import java.util.ArrayList;

public class Subteam {
    String name;
    ArrayList<SubteamMember> members;
    PSManager psManager;

    public Subteam(String name, ArrayList<SubteamMember> members) {
        this.name = name;
        this.members = members;
    }

    public ArrayList<SubteamMember> getMembers() {
        return members;
    }

    public void setMembers(ArrayList<SubteamMember> members) {
        this.members = members;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PSManager getPsManager() {
        return psManager;
    }

    public void setPsManager(PSManager psManager) {
        this.psManager = psManager;
    }

    public void addMember(SubteamMember subteamMember) {
        members.add(subteamMember);
    }
}
