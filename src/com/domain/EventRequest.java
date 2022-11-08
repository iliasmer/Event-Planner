package com.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class EventRequest extends Request{

    private Integer recordNumber;
    private Customer customer;
    private String eventType;
    private Date from;
    private Date to;
    private Integer expectedNumberOfAttendees;
    private List<String> preferences;
    private Integer expectedBudget;
    private States state;
    private String financialComments;

    private String expectedPlan;
    private Integer additionalBudget;

    private Event event;

    public EventRequest(int recordNumber, Customer client, String eventType, String from,
                        String to, String expectedNumberOfAttendees, List<String> preferences, String expectedBudget) throws IllegalArgumentException, ParseException, WrongValueException {
        setRecordNumber(recordNumber);
        setClient(client);
        setEventType(eventType);
        setDates(from, to);
        setAttendeesAndBudget(expectedNumberOfAttendees, expectedBudget);
        setPreferences(preferences);
        setState(States.SCS_INIT);
    }


    public void setDates(String from, String to) throws ParseException, WrongValueException {
        Date toDate = new SimpleDateFormat("dd/MM/yyyy").parse(to);
        Date fromDate = new SimpleDateFormat("dd/MM/yyyy").parse(from);
        if (toDate.before(fromDate)){
            throw new WrongValueException("The to date must not be before the from date");
        }
        setFrom(fromDate);
        setTo(toDate);
    }

    public void setAttendeesAndBudget(String expectedNumberOfAttendees, String expectedBudget) throws IllegalArgumentException {
        int expectedNumberOfAttendeesConverted = Integer.parseInt(expectedNumberOfAttendees);
        int budgetConverted = Integer.parseInt(expectedBudget);

        if (expectedNumberOfAttendeesConverted <= 0) {
            throw new IllegalArgumentException("Expected Number of Attendees must be positive");
        }
        if(budgetConverted <= 0) {
            throw new IllegalArgumentException("Budget must be positive");
        }

        setExpectedNumberOfAttendees(expectedNumberOfAttendeesConverted);
        setExpectedBudget(budgetConverted);
    }

    public Integer getRecordNumber() {
        return recordNumber;
    }

    public void setRecordNumber(Integer recordNumber) {
        this.recordNumber = recordNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setClient(Customer client) {
        this.customer = client;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }

    public Integer getExpectedNumberOfAttendees() {
        return expectedNumberOfAttendees;
    }

    public void setExpectedNumberOfAttendees(Integer expectedNumberOfAttendees) {
        this.expectedNumberOfAttendees = expectedNumberOfAttendees;
    }

    public List<String> getPreferences() {
        return preferences;
    }

    public void setPreferences(List<String> preferences) {
        this.preferences = preferences;
    }

    public Integer getExpectedBudget() {
        return expectedBudget;
    }

    public States getState() {
        return state;
    }

    public void setState(States state) {
        this.state = state;
    }

    public void setExpectedBudget(Integer expectedBudget) {
        this.expectedBudget = expectedBudget;
    }

    public String getFinancialComments() {
        return financialComments;
    }

    public void setFinancialComments(String financialComments) {
        this.financialComments = financialComments;
    }

    public Customer getClient() {
        return customer;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public String getExpectedPlan() {
        return expectedPlan;
    }

    public void setExpectedPlan(String expectedPlan) {
        this.expectedPlan = expectedPlan;
    }

    public Integer getAdditionalBudget() {
        return additionalBudget;
    }

    public void setAdditionalBudget(Integer additionalBudget) {
        this.additionalBudget = additionalBudget;
    }
}
