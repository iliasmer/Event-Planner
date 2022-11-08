package com.view.psm;

import com.dao.Initializer;
import com.domain.RecruitmentRequest;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HireStaff {

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
    private JButton submitButton;


    public HireStaff() {
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String contractType = "no selection";
                if (fullTimeRadioButton.isSelected()) contractType = "Full time";
                else if (partTimeRadioButton.isSelected()) contractType = "Part time";

                String department = "no selection";
                if(administrationRadioButton.isSelected()) department = "Administration";
                else if (servicesRadioButton.isSelected()) department = "Sevices";
                else if (productionRadioButton.isSelected()) department = "Production";
                else if (financialRadioButton.isSelected()) department = "Financial";

                Integer yearsOfExperience = Integer.parseInt(experience.getText());
                String jobTitle = jobTitleTxt.getText();
                String jobDescription = jobDescriptionTxt.getText();

                RecruitmentRequest recruitmentRequest = new RecruitmentRequest(contractType, department, yearsOfExperience, jobTitle, jobDescription);
                new Initializer().getRecruitmentRequestDAO().save(recruitmentRequest);

            }
        });
    }

    public static JFrame createHireForm () {
        jFrame = new JFrame();
        HireStaff hireStaffPage = new HireStaff();
        jFrame.setContentPane(hireStaffPage.jPanel);
        jFrame.pack();
        jFrame.setVisible(true);

        return jFrame;

    }
}
