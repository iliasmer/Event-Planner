package com.domain;

public class Event {
    EventRequest eventRequest;
    String description;
    Integer plannedBudget;
    String decorations;
    String foodDrinks;
    String filmingPhotos;
    String music;
    String posters;
    String pcIssues;
    String otherNeeds;
    Integer budget;

    public Event(EventRequest eventRequest) {
        this.eventRequest = eventRequest;
    }

    public Event(EventRequest eventRequest, String description, Integer plannedBudget, String decorations, String foodDrinks, String filmingPhotos, String music, String posters, String pcIssues, String otherNeeds, Integer budget) {
        setEventRequest(eventRequest);
        setDescription(description);
        setBudget(plannedBudget);
        setDecorations(decorations);
        setFoodDrinks(foodDrinks);
        setFilmingPhotos(filmingPhotos);
        setMusic(music);
        setPosters(posters);
        setPcIssues(pcIssues);
        setOtherNeeds(otherNeeds);
    }

    public Integer getBudget() {
        return budget;
    }

    public void setBudget(Integer budget) {
        if (budget <= 0) throw new IllegalArgumentException("Budget should be positive.");
        this.budget = budget;
    }

    public EventRequest getEventRequest() {
        return eventRequest;
    }

    public void setEventRequest(EventRequest eventRequest) {
        if (eventRequest == null) throw new NullPointerException("Event request can not be null.");
        this.eventRequest = eventRequest;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description == null) throw new NullPointerException("Description can not be null.");
        if (description.isEmpty()) throw new IllegalArgumentException("Description can not empty.");
        this.description = description;
    }

    public String getDecorations() {
        return decorations;
    }

    public void setDecorations(String decorations) {
        if (decorations == null) throw new NullPointerException("Decorations can not be null.");
        if (decorations.isEmpty()) throw new IllegalArgumentException("Decorations can not empty.");
        this.decorations = decorations;
    }

    public String getFoodDrinks() {
        return foodDrinks;
    }

    public void setFoodDrinks(String foodDrinks) {
        if (foodDrinks == null) throw new NullPointerException("Food/Drinks can not be null.");
        if (foodDrinks.isEmpty()) throw new IllegalArgumentException("Food/Drinks can not empty.");
        this.foodDrinks = foodDrinks;
    }

    public String getFilmingPhotos() {
        return filmingPhotos;
    }

    public void setFilmingPhotos(String filmingPhotos) {
        if (filmingPhotos == null) throw new NullPointerException("Filming/Photos can not be null.");
        if (filmingPhotos.isEmpty()) throw new IllegalArgumentException("Filming/Photos can not empty.");
        this.filmingPhotos = filmingPhotos;
    }

    public String getMusic() {
        return music;
    }

    public void setMusic(String music) {
        if (music == null) throw new NullPointerException("Music can not be null.");
        if (music.isEmpty()) throw new IllegalArgumentException("Music can not empty.");
        this.music = music;
    }

    public String getPosters() {
        return posters;
    }

    public void setPosters(String posters) {
        if (posters == null) throw new NullPointerException("Posters can not be null.");
        if (posters.isEmpty()) throw new IllegalArgumentException("Posters can not empty.");
        this.posters = posters;
    }

    public String getPcIssues() {
        return pcIssues;
    }

    public void setPcIssues(String pcIssues) {
        if (pcIssues == null) throw new NullPointerException("Issues can not be null.");
        if (pcIssues.isEmpty()) throw new IllegalArgumentException("Issues can not empty.");
        this.pcIssues = pcIssues;
    }

    public String getOtherNeeds() {
        return otherNeeds;
    }

    public void setOtherNeeds(String otherNeeds) {
        this.otherNeeds = otherNeeds;
    }
}
