package com.view.scs;

import com.domain.Event;
import com.domain.EventRequest;
import com.domain.States;
import com.view.general.event_requests.ViewEventRequest;
import com.view.general.event_requests.ViewEventRequests;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class SCSViewApprovedRequests implements ViewEventRequest {

    private static JFrame jFrame;
    private JPanel jPanel;
    private JCheckBox partiesCheckBox;
    private JCheckBox photosFilmingCheckBox;
    private JCheckBox foodCheckBox;
    private JCheckBox drinksCheckBox;
    private JCheckBox decorationsCheckBox;
    private JTextField expectedBudget;
    private JTextField recordNumber;
    private JTextField eventType;
    private JTextField fromDate;
    private JTextField toDate;
    private JTextField numOfAttendees;
    private JTextField name;
    private JTextArea feedbackArea;

    private JButton sendBtn;

    public SCSViewApprovedRequests(EventRequest eventRequest) {
        sendBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eventRequest.setState(States.SCS_END);
                eventRequest.setEvent(new Event(eventRequest));
            }
        });
    }

    public static JFrame createSCSViewApprovedRequest(EventRequest eventRequest) {
        jFrame = new JFrame(eventRequest.getEventType() + " from " + eventRequest.getCustomer().getName());
        SCSViewApprovedRequests scsViewApprovedRequests = new SCSViewApprovedRequests(eventRequest);
        jFrame.setContentPane(scsViewApprovedRequests.jPanel);
        ViewEventRequests.showDataAndFeedback(scsViewApprovedRequests, eventRequest);
        jFrame.pack();
        jFrame.setVisible(true);
        return jFrame;
    }


    public void showData(EventRequest eventRequest){
        recordNumber.setText(eventRequest.getRecordNumber().toString());
        name.setText(eventRequest.getCustomer().getName());
        eventType.setText(eventRequest.getEventType());

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        fromDate.setText(dateFormat.format(eventRequest.getFrom()));
        toDate.setText(dateFormat.format(eventRequest.getTo()));

        numOfAttendees.setText(eventRequest.getExpectedNumberOfAttendees().toString());
        expectedBudget.setText(eventRequest.getExpectedBudget().toString());


        feedbackArea.setText(eventRequest.getFinancialComments());
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
