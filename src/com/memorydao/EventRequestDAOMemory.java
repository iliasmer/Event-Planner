package com.memorydao;

import com.dao.EventRequestDAO;
import com.domain.Event;
import com.domain.EventRequest;
import com.domain.States;

import java.util.ArrayList;

public class EventRequestDAOMemory implements EventRequestDAO{

    protected static ArrayList<EventRequest> entities = new ArrayList<EventRequest>();


    @Override
    public void save(EventRequest eventRequest) {
        entities.add(eventRequest);
    }

    @Override
    public int nextId() {
        return (entities.size() > 0 ? entities.get(entities.size()-1).getRecordNumber()+1 : 1);
    }

    @Override
    public ArrayList<EventRequest> getEventRequests(States state) {
        ArrayList<EventRequest> result = new ArrayList<>();
        for(EventRequest eventRequest : entities){
            if (eventRequest.getState() == state) {
                result.add(eventRequest);
            }
        }
        return result;
    }

    @Override
    public Event getEvent(Integer recordNumber) {
        for (EventRequest eventRequest: entities) {
            if (eventRequest.getRecordNumber() == recordNumber){
                return eventRequest.getEvent();
            }
        }
        return null;
    }


    @Override
    public ArrayList<EventRequest> getAll() {
        return this.entities;
    }
}
