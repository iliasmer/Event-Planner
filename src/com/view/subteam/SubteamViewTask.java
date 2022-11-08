package com.view.subteam;

import com.domain.EventRequest;
import com.domain.Task;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SubteamViewTask {

    private static JFrame jFrame;
    private JPanel jPanel;


    private JTextField recordNumber;
    private JTextArea planning;
    private JTextField extraBudget;
    private JButton addExtraBudgetButton;
    private JButton addExpectedPlanButton;
    private JLabel planLabel;
    private JLabel budgetLabel;
    private JButton submitButton;


    public SubteamViewTask(Task task) {
        addExtraBudgetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                budgetLabel.setVisible(true);
                extraBudget.setVisible(true);
                addExtraBudgetButton.setVisible(false);
                submitButton.setVisible(true);
            }
        });
        addExpectedPlanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                planLabel.setVisible(true);
                planning.setVisible(true);
                addExpectedPlanButton.setVisible(false);
                submitButton.setVisible(true);
            }
        });
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                task.setPlanning(planning.getText());
                task.setExtraBudget(extraBudget.getText());
            }
        });
    }

    public static JFrame createViewTaskPage (Task task) {
        EventRequest eventRequest = task.getEvent().getEventRequest();
        jFrame = new JFrame("View task for event: " + task.getEvent().getEventRequest().getRecordNumber());
        SubteamViewTask viewTaskPage = new SubteamViewTask(task);
        jFrame.setContentPane(viewTaskPage.jPanel);
        jFrame.pack();
        jFrame.setVisible(true);

        viewTaskPage.recordNumber.setText(eventRequest.getRecordNumber().toString());

        viewTaskPage.submitButton.setVisible(false);
        viewTaskPage.planLabel.setVisible(false);
        viewTaskPage.planning.setVisible(false);
        viewTaskPage.budgetLabel.setVisible(false);
        viewTaskPage.extraBudget.setVisible(false);

        return jFrame;
    }
}
