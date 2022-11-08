package com.dao;

import com.domain.Event;
import com.domain.EventRequest;
import com.domain.States;

import java.util.ArrayList;

public interface EventRequestDAO {

    void save(EventRequest eventRequest);
    int nextId();
    ArrayList<EventRequest> getAll();
    ArrayList<EventRequest> getEventRequests(States state);
    Event getEvent(Integer recordNumber);
}
