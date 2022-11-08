package com.view.fm;

import com.domain.AcceptRejectState;
import com.domain.FinancialRequest;
import com.domain.RecruitmentRequest;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EvaluateFinancialRequest {
    private JTextField amount;
    private JTextField reason;
    private JButton acceptButton;
    private JButton rejectButton;
    private JPanel jPanel;
    private static JFrame jFrame;

    public EvaluateFinancialRequest(FinancialRequest financialRequest) {
        acceptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    financialRequest.setState(AcceptRejectState.COMPLETED);
            }
        });
        rejectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    financialRequest.setState(AcceptRejectState.REJECTED);
            }
        });
    }

    public static JFrame createEvaluateFinancialRequest (FinancialRequest financialRequest) {
        jFrame = new JFrame("Financial Request (FM)");
        EvaluateFinancialRequest evaluateFinancialRequest = new EvaluateFinancialRequest(financialRequest);
        jFrame.setContentPane(evaluateFinancialRequest.jPanel);
        evaluateFinancialRequest.showData(financialRequest);
        jFrame.pack();
        jFrame.setVisible(true);
        return jFrame;
    }


    public void showData (FinancialRequest financialRequest){
        reason.setText(financialRequest.getReason());
        amount.setText(financialRequest.getAmount().toString());
    }
}
