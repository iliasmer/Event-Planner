package com.view.cs;

import com.dao.Initializer;
import com.domain.EventRequest;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CreateEventRequest {
    private JFrame jFrame;
    private JPanel jPanel;
    private JTextField recordNumberTxt;
    private JTextField clientNameTxt;
    private JTextField eventTypeTxt;
    private JTextField fromTxt;
    private JTextField toTxt;
    private JTextField numOfAttendeesTxt;
    private JTextField budgetTxt;
    private JButton submitBtn;
    private JCheckBox decorationsCheckBox;
    private JCheckBox partiesCheckBox;
    private JCheckBox photosFilmingCheckBox;
    private JCheckBox breakfastLunchDinnerCheckBox;
    private JCheckBox softHotDrinksCheckBox;


    public CreateEventRequest() {
        submitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // get fields
                String clientNameTxtValue = clientNameTxt.getText();
                String eventTypeTxtValue = eventTypeTxt.getText();
                String fromTxtValue = fromTxt.getText();
                String toTxtValue = toTxt.getText();
                String numOfAttendeesTxtValue = numOfAttendeesTxt.getText();
                String budgetTxtValue = budgetTxt.getText();

                ArrayList<String> preferences = getPreferences();

                String message = saveEventRequest(clientNameTxtValue, eventTypeTxtValue, fromTxtValue, toTxtValue, numOfAttendeesTxtValue, preferences, budgetTxtValue);

                if (message.equals("")) {
                    // close the page
                    showMessage("The event request has been created successfully!");
                    jFrame.setVisible(false);
                } else {
                    showMessage(message);
                }
            }
        });
    }

    public ArrayList getPreferences() {
        ArrayList<String> preferences = new ArrayList<String>();

        if (decorationsCheckBox.isSelected()){
            preferences.add(decorationsCheckBox.getText());
        }

        if (partiesCheckBox.isSelected()){
            preferences.add(partiesCheckBox.getText());
        }

        if (photosFilmingCheckBox.isSelected()){
            preferences.add(photosFilmingCheckBox.getText());
        }

        if (breakfastLunchDinnerCheckBox.isSelected()){
            preferences.add(breakfastLunchDinnerCheckBox.getText());
        }

        if (softHotDrinksCheckBox.isSelected()){
            preferences.add(softHotDrinksCheckBox.getText());
        }

        return preferences;
    }

    public String saveEventRequest(String clientName, String eventType, String from, String to, String expectedNumberOfAttendees, ArrayList<String> preferences, String budget) {
        if ((new Initializer()).getCustomerDAO().exists(clientName)) {
            // if customer is registered create the request
            try {
                (new Initializer()).getEventRequestDAO().save(new EventRequest((new Initializer()).getEventRequestDAO().nextId(), (new Initializer()).getCustomerDAO().get(clientName), eventType, from, to, expectedNumberOfAttendees, preferences, budget));
                return "";
            } catch (Exception e){
                return e.toString();
            }
        } else {
            return "Client doesn't exist";
        }
    }

    public static void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }


    public static JFrame createCreateEventRequest() {
        JFrame jFrame = new JFrame("Create event request");
        CreateEventRequest createEventRequest = new CreateEventRequest();
        jFrame.setContentPane(createEventRequest.jPanel);
        createEventRequest.showID();
        jFrame.pack();
        jFrame.setVisible(true);
        return jFrame;
    }

    public void showID() {
        this.recordNumberTxt.setText(Integer.toString((new Initializer()).getEventRequestDAO().nextId()));
        this.recordNumberTxt.setEditable(false);
    }

}
