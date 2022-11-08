package com.domain;

public class Task {
    String description;
    Event event;
    SubteamMember assignedTo;
    String priority;
    String planning;
    String extraBudget;

    public Task(Event event, String description, SubteamMember assignedTo, String priority) throws WrongValueException {
        setDescription(description);
        setEvent(event);
        setAssignedTo(assignedTo);
        setPriority(priority);
    }

    public String getExtraBudget() {
        return extraBudget;
    }

    public void setExtraBudget(String extraBudget) {
        if (extraBudget == null) throw new NullPointerException("Extra budget can not be null.");
        if (extraBudget.isEmpty()) throw new IllegalArgumentException("Extra budget can not empty.");
        this.extraBudget = extraBudget;
    }

    public String getPlanning() {
        return planning;
    }

    public void setPlanning(String planning) {
        if (planning == null) throw new NullPointerException("Planning can not be null.");
        if (planning.isEmpty()) throw new IllegalArgumentException("Planning can not empty.");
        this.planning = planning;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description == null) throw new NullPointerException("Description can not be null.");
        if (description.isEmpty()) throw new IllegalArgumentException("Description can not empty.");
        this.description = description;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        if (event == null) throw new NullPointerException("Event can not be null.");
        this.event = event;
    }

    public SubteamMember getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(SubteamMember assignedTo) {
        if (assignedTo == null) throw new NullPointerException("Member can not be null.");
        this.assignedTo = assignedTo;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        if (priority == null) throw new NullPointerException("Priority can not be null.");
        if (priority.isEmpty()) throw new IllegalArgumentException("Priority can not empty.");
        if (!priority.equals("Medium") && !priority.equals("Low") && !priority.equals("High")) throw new IllegalArgumentException("Priority should be Medium, High or Low");
        this.priority = priority;
    }
}
