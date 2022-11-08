package com.view.general.items;

import com.domain.EventRequest;

public class EventRequestItem extends RequestItem{
    public EventRequestItem(EventRequest eventRequest) {
        super(eventRequest);
    }

    @Override
    public String toString() {
        return ((EventRequest) getRequest()).getEventType() + " from " + ((EventRequest) getRequest()).getCustomer().getName();
    }
}
