package com.view.psm;

import com.domain.Task;
import com.view.subteam.SubteamViewTask;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class JTableButtonModelPSM extends AbstractTableModel {
    private ArrayList<JFrame> children;

    private Object[][] rows;
    private String[] columns = {"Task Subject",
            "Priority",
            "Sender",
            "Details"};


    public JTableButtonModelPSM(ArrayList<Task> tasks) {
        rows = new Object[tasks.size()][columns.length];
        children = new ArrayList<>();
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            JButton jButton = new JButton("View");
            jButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JFrame jFrame = PSMViewTask.createViewTaskPagePSM(task);
                    children.add(jFrame);
                }
            });
            Object[] t = new Object[] {task.getDescription(), task.getPriority(), task.getAssignedTo().getSubteam().getPsManager().getUsername(), jButton};
            rows[i] = t;
        }
    }
    public String getColumnName(int column) {
        return columns[column];
    }
    public int getRowCount() {
        return rows.length;
    }
    public int getColumnCount() {
        return columns.length;
    }
    public Object getValueAt(int row, int column) {
        return rows[row][column];
    }
    public boolean isCellEditable(int row, int column) {
        return false;
    }
    public Class getColumnClass(int column) {
        return getValueAt(0, column).getClass();
    }

    public ArrayList<JFrame> getChildren() {
        return children;
    }

}