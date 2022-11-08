package com.view.psm;

import com.domain.Event;
import com.domain.EventRequest;
import com.view.scs.SCSViewNewRequest;

import javax.swing.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class PSMViewEvent {

    private JTextField pcIssues;
    private JTextField other;
    private JTextField posters;
    private JTextField music;
    private JTextField filmingPhotos;
    private JTextField fromDate;
    private JTextField eventType;
    private JTextField toDate;
    private JTextField numOfAttendees;
    private JTextField decorations;
    private JTextField recordNumber;
    private JTextField name;
    private JTextField budget;
    private JPanel jPanel;
    private JTextField food;

    public static JFrame createPSMViewEvent(Event event) {
        JFrame jFrame = new JFrame(event.getEventRequest().getEventType() + " from " + event.getEventRequest().getCustomer().getName());
        PSMViewEvent psmViewEvent = new PSMViewEvent();
        jFrame.setContentPane(psmViewEvent.jPanel);
        psmViewEvent.showData(event);
        jFrame.pack();
        jFrame.setVisible(true);
        return jFrame;
    }



    public void showData(Event event){
        recordNumber.setText(event.getEventRequest().getRecordNumber().toString());
        name.setText(event.getEventRequest().getCustomer().getName());
        eventType.setText(event.getEventRequest().getEventType());

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        fromDate.setText(dateFormat.format(event.getEventRequest().getFrom()));
        toDate.setText(dateFormat.format(event.getEventRequest().getTo()));

        numOfAttendees.setText(event.getEventRequest().getExpectedNumberOfAttendees().toString());
        budget.setText(event.getBudget().toString());

        pcIssues.setText(event.getPcIssues());
        decorations.setText(event.getDecorations());
        other.setText(event.getOtherNeeds());
        posters.setText(event.getPosters());
        music.setText(event.getMusic());
        filmingPhotos.setText(event.getFilmingPhotos());
    }

}
