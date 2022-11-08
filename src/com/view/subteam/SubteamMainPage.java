package com.view.subteam;


import com.dao.Initializer;
import com.domain.Subteam;
import com.domain.SubteamMember;
import com.domain.Task;
import com.view.login.Login;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SubteamMainPage {

    private static JFrame jFrame;
    private JPanel jPanel;
    private JLabel loggedinLabel;
    private JTable table1;
    private JScrollPane scrollPane;
    private JButton logoutButton;
    private JTableButtonModel jTableButtonModel;

    public SubteamMainPage() {
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.setVisible(false);
                Login.createLogin();

                for (JFrame child: jTableButtonModel.getChildren()){
                    child.setVisible(false);
                }
            }
        });
    }

    public static void createSubteamMainPage (String username) {
        jFrame = new JFrame("Main page (Subteam)");
        SubteamMainPage subteamMainPage = new SubteamMainPage();
        jFrame.setContentPane(subteamMainPage.jPanel);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        subteamMainPage.loggedinLabel.setText("Logged in: " + username);
        subteamMainPage.fillTableWithTasks(username);
        jFrame.pack();
        jFrame.setVisible(true);
    }

    public void fillTableWithTasks(String username) {
        TableCellRenderer tableRenderer;
        // pass tasks to table
        SubteamMember subteamMember = (SubteamMember) (new Initializer()).getUserDAO().getUser(username);
        ArrayList<Task> tasks = subteamMember.getTasks();
        jTableButtonModel = new JTableButtonModel(tasks);
        // set model
        table1.setModel(jTableButtonModel);
        // button render
        tableRenderer = table1.getDefaultRenderer(JButton.class);
        table1.setDefaultRenderer(JButton.class, new JTableButtonRenderer(tableRenderer));
        table1.addMouseListener(new JTableButtonMouseListener(table1));
    }


}
