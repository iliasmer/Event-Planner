package com.view.fm;

import com.domain.EventRequest;
import com.domain.States;
import com.view.scs.SCSViewApprovedRequests;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class FMAddFeedback {
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
    private JButton sendBtn;
    private JCheckBox partiesCheckBox;
    private JCheckBox photosFilmingCheckBox;
    private JCheckBox foodCheckBox;
    private JCheckBox drinksCheckBox;
    private JTextField eventType;


    public FMAddFeedback(EventRequest eventRequest) {
        sendBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eventRequest.setState(States.ADMIN);
                eventRequest.setFinancialComments(feedbackArea.getText());
            }
        });
    }

    public static JFrame createFMAddFeedback (EventRequest eventRequest) {
        jFrame = new JFrame("Main page (FM)");
        FMAddFeedback fmAddFeedback = new FMAddFeedback(eventRequest);
        jFrame.setContentPane(fmAddFeedback.jPanel);
        fmAddFeedback.showData(eventRequest);
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

        showPreferences(eventRequest.getPreferences());
    }
    public void showPreferences(List<String> preferences) {
        for (String preference : preferences) {
            if (preference.equals(decorationsCheckBox.getText())) {
                decorationsCheckBox.setSelected(true);
            } else if (preference.equals(partiesCheckBox.getText())) {
                partiesCheckBox.setSelected(true);
            } else if (preference.equals(foodCheckBox.getText())) {
                foodCheckBox.setSelected(true);
            } else if (preference.equals(drinksCheckBox.getText())) {
                drinksCheckBox.setSelected(true);
            } else if (preference.equals(photosFilmingCheckBox.getText())) {
                photosFilmingCheckBox.setSelected(true);
            }
        }
    }
}
