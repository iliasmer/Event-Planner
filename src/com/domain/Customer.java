package com.domain;

import java.util.ArrayList;

public class Customer {
    private String name;
    private String tel;
    private String address;

    private ArrayList<EventRequest> eventRequests;

    public Customer(String name, String tel, String address) {
        setName(name);
        setTel(tel);
        setAddress(address);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null) throw new NullPointerException("Name can not be null.");
        if (name.isEmpty()) throw new IllegalArgumentException("Name can not empty.");
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        if (tel == null) throw new NullPointerException("Tel can not be null.");
        if (tel.isEmpty()) throw new IllegalArgumentException("Tel can not empty.");
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (address == null) throw new NullPointerException("Address can not be null.");
        if (address.isEmpty()) throw new IllegalArgumentException("Address can not empty.");
        this.address = address;
    }

    public ArrayList<EventRequest> getEventRequests() {
        return eventRequests;
    }

    public void setEventRequests(ArrayList<EventRequest> eventRequests) {
        this.eventRequests = eventRequests;
    }
}
