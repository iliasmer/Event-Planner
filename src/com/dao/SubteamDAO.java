package com.dao;

import com.domain.EventRequest;
import com.domain.States;
import com.domain.Subteam;

import java.util.ArrayList;

public interface SubteamDAO {

    void save(Subteam subteam);

    Subteam getSubteam(String name);
}
