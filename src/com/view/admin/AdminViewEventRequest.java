package com.view.admin;

import com.domain.EventRequest;
import com.domain.States;
import com.view.fm.FMAddFeedback;
import com.view.general.event_requests.ViewEventRequest;
import com.view.general.event_requests.ViewEventRequests;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class AdminViewEventRequest implements ViewEventRequest {
    private static JFrame jFrame;
    private JPanel jPanel;
    private JTextField recordNumber;
    private JTextField name;
    private JTextField fromDate;
    private JTextField toDate;
    private JTextField numOfAttendees;
    private JCheckBox decorationsCheckBox;
    private JTextField expectedBudget;
    private JTextArea feedbackArea;
    private JCheckBox partiesCheckBox;
    private JCheckBox photosFilmingCheckBox;
    private JCheckBox foodCheckBox;
    private JCheckBox drinksCheckBox;
    private JTextField eventType;
    private JButton approveBtn;
    private JButton rejectBtn;


    public AdminViewEventRequest(EventRequest eventRequest) {
        approveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eventRequest.setState(States.SCS_BACK);
                jFrame.setVisible(false);
            }
        });
        rejectBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eventRequest.setState(States.ADMIN_REJECTED);
                jFrame.setVisible(false);
            }
        });
    }

    public static JFrame createAdminViewEventRequest (EventRequest eventRequest) {
        jFrame = new JFrame("Main page (Admin)");
        AdminViewEventRequest adminViewEventRequest = new AdminViewEventRequest(eventRequest);
        jFrame.setContentPane(adminViewEventRequest.jPanel);
        ViewEventRequests.showDataAndFeedback(adminViewEventRequest ,eventRequest);
        jFrame.pack();
        jFrame.setVisible(true);
        return jFrame;
    }


    @Override
    public JPanel getjPanel() {
        return jPanel;
    }

    @Override
    public JTextField getRecordNumber() {
        return recordNumber;
    }

    @Override
    public JTextField getName() {
        return name;
    }

    @Override
    public JTextField getEventType() {
        return eventType;
    }

    @Override
    public JTextField getFromDate() {
        return fromDate;
    }

    @Override
    public JTextField getToDate() {
        return toDate;
    }

    @Override
    public JTextField getNumOfAttendees() {
        return numOfAttendees;
    }

    @Override
    public JCheckBox getDecorationsCheckBox() {
        return decorationsCheckBox;
    }

    @Override
    public JCheckBox getPartiesCheckBox() {
        return partiesCheckBox;
    }

    @Override
    public JCheckBox getFoodCheckBox() {
        return foodCheckBox;
    }

    @Override
    public JCheckBox getDrinksCheckBox() {
        return drinksCheckBox;
    }

    @Override
    public JTextField getExpectedBudget() {
        return expectedBudget;
    }

    @Override
    public JCheckBox getPhotosFilmingCheckBox() {
        return photosFilmingCheckBox;
    }

    @Override
    public JTextArea getFeedbackArea() {
        return feedbackArea;
    }
}
