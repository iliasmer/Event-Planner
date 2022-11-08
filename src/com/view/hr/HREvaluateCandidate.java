package com.view.hr;

import com.domain.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HREvaluateCandidate {

    private static JFrame jFrame;
    private JPanel jPanel;

    private JRadioButton fullTimeRadioButton;
    private JRadioButton partTimeRadioButton;

    private JRadioButton administrationRadioButton;
    private JRadioButton servicesRadioButton;
    private JRadioButton productionRadioButton;
    private JRadioButton financialRadioButton;

    private JTextField experience;
    private JTextField jobTitleTxt;
    private JTextArea jobDescriptionTxt;
    private JButton acceptButton;
    private JButton rejectButton;


    public HREvaluateCandidate(RecruitmentRequest recruitmentRequest) {
        acceptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                recruitmentRequest.setState(AcceptRejectState.COMPLETED);
            }
        });
        rejectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                recruitmentRequest.setState(AcceptRejectState.REJECTED);
            }
        });
    }


    public static JFrame createHREvaluateCandidate (RecruitmentRequest recruitmentRequest) {
        jFrame = new JFrame("Candidate Details (HR)");
        HREvaluateCandidate hrEvaluateCandidate = new HREvaluateCandidate(recruitmentRequest);
        jFrame.setContentPane(hrEvaluateCandidate.jPanel);
        hrEvaluateCandidate.showData(recruitmentRequest);
        jFrame.pack();
        jFrame.setVisible(true);
        return jFrame;
    }


    public void showData (RecruitmentRequest recruitmentRequest){


        experience.setText(recruitmentRequest.getYearsOfExperience().toString());
        jobTitleTxt.setText(recruitmentRequest.getJobTitle());
        jobDescriptionTxt.setText(recruitmentRequest.getJobDescription());

        if (recruitmentRequest.getContractType().equals("Full time")) {
            fullTimeRadioButton.setSelected(true);
        }
        else partTimeRadioButton.setSelected(true);

        if (recruitmentRequest.getDepartment().equals("Administration")) {
            administrationRadioButton.setSelected(true);
        }
        else if (recruitmentRequest.getDepartment().equals("Production")) {
            productionRadioButton.setSelected(true);
        }
        else if (recruitmentRequest.getDepartment().equals("Services")) {
            servicesRadioButton.setSelected(true);
        }
        else {
            financialRadioButton.setSelected(true);
        }

    }

}
