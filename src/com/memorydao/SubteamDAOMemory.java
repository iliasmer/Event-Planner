package com.memorydao;

import com.dao.SubteamDAO;
import com.domain.Subteam;
import com.domain.User;

import java.util.ArrayList;
import java.util.HashMap;

public class SubteamDAOMemory implements SubteamDAO {

    protected static HashMap<String, Subteam> entities = new HashMap<String, Subteam>();

    public void save(Subteam subteam) {
        entities.put(subteam.getName(), subteam);
    }


    public Subteam getSubteam(String name) {
        return entities.get(name);
    }
}
