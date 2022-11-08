package com.view.psm;

import com.domain.EventRequest;
import com.domain.Task;
import com.view.subteam.SubteamViewTask;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PSMViewTask {
    private static JFrame jFrame;
    private JPanel jPanel;
    private JTextField recordNumber;
    private JTextArea planning;
    private JTextField extraBudget;
    private JLabel planLabel;
    private JLabel budgetLabel;

    public PSMViewTask(Task task) {}

    public static JFrame createViewTaskPagePSM (Task task) {
        EventRequest eventRequest = task.getEvent().getEventRequest();
        jFrame = new JFrame("View task for event: " + task.getEvent().getEventRequest().getRecordNumber());
        PSMViewTask viewTaskPage = new PSMViewTask(task);
        jFrame.setContentPane(viewTaskPage.jPanel);
        jFrame.pack();
        jFrame.setVisible(true);

        viewTaskPage.recordNumber.setText(eventRequest.getRecordNumber().toString());
        viewTaskPage.planning.setText(task.getPlanning());
        viewTaskPage.extraBudget.setText(task.getExtraBudget());

        return jFrame;
    }
}
