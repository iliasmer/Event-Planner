package com.view.general.event_requests;

import com.domain.EventRequest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class ViewEventRequests {

    public static void showPreferences(ViewEventRequest viewEventRequest, List<String> preferences) {
        for (String preference : preferences) {
            if (preference.equals(viewEventRequest.getDecorationsCheckBox().getText())) {
                viewEventRequest.getDecorationsCheckBox().setSelected(true);
            } else if (preference.equals(viewEventRequest.getPartiesCheckBox().getText())) {
                viewEventRequest.getPartiesCheckBox().setSelected(true);
            } else if (preference.equals(viewEventRequest.getFoodCheckBox().getText())) {
                viewEventRequest.getFoodCheckBox().setSelected(true);
            } else if (preference.equals(viewEventRequest.getDrinksCheckBox().getText())) {
                viewEventRequest.getDrinksCheckBox().setSelected(true);
            } else if (preference.equals(viewEventRequest.getPhotosFilmingCheckBox().getText())) {
                viewEventRequest.getPhotosFilmingCheckBox().setSelected(true);
            }
        }
    }

    public static void showData(ViewEventRequest viewEventRequest, EventRequest eventRequest){
        viewEventRequest.getRecordNumber().setText(eventRequest.getRecordNumber().toString());
        viewEventRequest.getName().setText(eventRequest.getCustomer().getName());
        viewEventRequest.getEventType().setText(eventRequest.getEventType());

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        viewEventRequest.getFromDate().setText(dateFormat.format(eventRequest.getFrom()));
        viewEventRequest.getToDate().setText(dateFormat.format(eventRequest.getTo()));

        viewEventRequest.getNumOfAttendees().setText(eventRequest.getExpectedNumberOfAttendees().toString());
        viewEventRequest.getExpectedBudget().setText(eventRequest.getExpectedBudget().toString());
        showPreferences(viewEventRequest, eventRequest.getPreferences());
    }

    public static void showDataAndFeedback(ViewEventRequest viewEventRequest, EventRequest eventRequest) {
        showData(viewEventRequest, eventRequest);
        viewEventRequest.getFeedbackArea().setText(eventRequest.getFinancialComments());
    }

}
