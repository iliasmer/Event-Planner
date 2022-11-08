package com.view.psm;

import com.dao.Initializer;
import com.domain.AcceptRejectState;
import com.domain.RecruitmentRequest;
import com.domain.Task;
import com.domain.WrongValueException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FinancialRequest {

    private JTextField amountTxt;
    private JTextField reasonTxt;
    private JButton submitButton;
    private JPanel jPanel;
    private static JFrame jFrame;


    public FinancialRequest() {
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String reason = reasonTxt.getText();
                String amount = amountTxt.getText();

                com.domain.FinancialRequest financialRequestObj = new com.domain.FinancialRequest(Integer.parseInt(amount), reason);
                new Initializer().getFinancialRequestDAO().save(financialRequestObj);

            }
        });
    }


    public static JFrame createFinancialRequestForm () {
        jFrame = new JFrame();
        FinancialRequest financialRequestPage = new FinancialRequest();
        jFrame.setContentPane(financialRequestPage.jPanel);
        jFrame.pack();
        jFrame.setVisible(true);

        return jFrame;

    }
}
