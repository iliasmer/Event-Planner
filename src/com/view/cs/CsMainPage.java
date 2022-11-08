package com.view.cs;

import com.view.login.Login;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CsMainPage {
    private JButton createRequest;
    private JPanel jPanel;
    private JButton logOutButton;
    private static JFrame jFrame;

    private static ArrayList<JFrame> children;

    public CsMainPage() {
        createRequest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame jFrame = CreateEventRequest.createCreateEventRequest();
                children.add(jFrame);
            }
        });
        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.setVisible(false);
                Login.createLogin();

                for (JFrame child: children){
                    child.setVisible(false);
                }
            }
        });
    }

    public static void createCsMainPage() {
        children = new ArrayList<JFrame>();
        jFrame = new JFrame("Main page (CS)");
        jFrame.setContentPane(new CsMainPage().jPanel);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
    }
}
