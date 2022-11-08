package com.view.scs;

import com.domain.EventRequest;
import com.domain.States;
import com.view.general.event_requests.ViewEventRequest;
import com.view.general.event_requests.ViewEventRequests;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SCSViewNewRequest implements ViewEventRequest {

    private JPanel jPanel;
    private JTextField recordNumber;
    private JTextField name;
    private JTextField eventType;
    private JTextField fromDate;
    private JTextField toDate;
    private JTextField numOfAttendees;
    private JCheckBox decorationsCheckBox;
    private JCheckBox partiesCheckBox;
    private JCheckBox foodCheckBox;
    private JCheckBox drinksCheckBox;
    private JTextField expectedBudget;
    private JButton approveBtn;
    private JCheckBox photosFilmingCheckBox;
    private JButton rejectBtn;

    public SCSViewNewRequest(JFrame jFrame, EventRequest eventRequest) {
        approveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eventRequest.setState(States.FM);
                jFrame.setVisible(false);
            }
        });
        rejectBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eventRequest.setState(States.SCS_REJECTED);
                jFrame.setVisible(false);
            }
        });
    }

    public static JFrame createSCSViewNewRequest(EventRequest eventRequest) {
        JFrame jFrame = new JFrame(eventRequest.getEventType() + " from " + eventRequest.getCustomer().getName());
        SCSViewNewRequest scsViewNewRequest = new SCSViewNewRequest(jFrame, eventRequest);
        jFrame.setContentPane(scsViewNewRequest.jPanel);
        ViewEventRequests.showData(scsViewNewRequest, eventRequest);
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
        return null;
    }
}
