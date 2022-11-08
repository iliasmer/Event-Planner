package com.view.general.event_requests;

import javax.swing.*;

public interface ViewEventRequest {
    JPanel getjPanel();

    JTextField getRecordNumber();

    JTextField getName();

    JTextField getEventType();

    JTextField getFromDate();

    JTextField getToDate();

    JTextField getNumOfAttendees();

    JCheckBox getDecorationsCheckBox();

    JCheckBox getPartiesCheckBox();

    JCheckBox getFoodCheckBox();

    JCheckBox getDrinksCheckBox();

    JTextField getExpectedBudget();

    JCheckBox getPhotosFilmingCheckBox();

    JTextArea getFeedbackArea();

}
