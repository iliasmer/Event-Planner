package com.view.admin;

import com.dao.Initializer;
import com.domain.EventRequest;
import com.domain.States;
import com.view.general.items.EventRequestItem;
import com.view.login.Login;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static com.view.admin.AdminViewEventRequest.createAdminViewEventRequest;

public class AdminMainPage {

    private static JFrame jFrame;
    private JPanel panel1;
    private JTabbedPane tabbedPane1;
    private JList eventRequestList;
    private JButton logOutButtonAdm;
    private static ArrayList<JFrame> children;


    public static void createAdminMainPage() {
        children = new ArrayList<JFrame>();
        jFrame = new JFrame("Main page (Admin)");
        AdminMainPage adminMainPage = new AdminMainPage();
        jFrame.setContentPane(adminMainPage.panel1);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adminMainPage.showEventRequests();
        jFrame.pack();
        jFrame.setVisible(true);
    }



    public AdminMainPage() {
        eventRequestList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedItemIndex = eventRequestList.getSelectedIndex();
                    EventRequestItem eventRequestItem = (EventRequestItem) eventRequestList.getModel().getElementAt(selectedItemIndex);
                    JFrame child = createAdminViewEventRequest((EventRequest) eventRequestItem.getRequest());
                    children.add(child);
                }
            }
        });


        logOutButtonAdm.addActionListener(new ActionListener() {
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





    public void showEventRequests() {
        DefaultListModel<EventRequestItem> newRequestsListModel = createList(States.ADMIN);
        this.eventRequestList.setModel(newRequestsListModel);
        this.eventRequestList.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);

    }

    public static DefaultListModel<EventRequestItem> createList(States state) {
        DefaultListModel<EventRequestItem> listModel = new DefaultListModel<>();

        ArrayList<EventRequest> eventRequests = (new Initializer()).getEventRequestDAO().getEventRequests(state);

        for (EventRequest eventRequest: eventRequests){
            listModel.addElement(new EventRequestItem(eventRequest));
        }
        return listModel;
    }
}
