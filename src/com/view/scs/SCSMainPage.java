package com.view.scs;

import com.dao.Initializer;
import com.domain.EventRequest;
import com.domain.States;
import com.view.general.items.EventRequestItem;
import com.view.general.event_requests.ListModels;
import com.view.login.Login;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static com.view.scs.SCSViewApprovedRequests.createSCSViewApprovedRequest;
import static com.view.scs.SCSViewNewRequest.createSCSViewNewRequest;

public class SCSMainPage {
    private JTabbedPane tabbedPane1;
    private JList<EventRequestItem> approvedRequestsList;
    private JList<EventRequestItem> newRequestsList;
    private static JFrame jFrame;
    private JPanel jPanel;
    private JButton logOutButton;
    private static ArrayList<JFrame> children;

    public SCSMainPage() {
        newRequestsList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedItemIndex = newRequestsList.getSelectedIndex();
                    EventRequestItem eventRequestItem = newRequestsList.getModel().getElementAt(selectedItemIndex);
                    JFrame child = createSCSViewNewRequest((EventRequest) eventRequestItem.getRequest());
                    children.add(child);
                }
            }
        });

        approvedRequestsList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedItemIndex = approvedRequestsList.getSelectedIndex();
                    EventRequestItem eventRequestItem = approvedRequestsList.getModel().getElementAt(selectedItemIndex);
                    JFrame child = createSCSViewApprovedRequest((EventRequest) eventRequestItem.getRequest());
                    children.add(child);
                }
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

    public static void createSCSMainPage() {
        children = new ArrayList<JFrame>();
        jFrame = new JFrame("Main page (SCS)");
        SCSMainPage scsMainPage = new SCSMainPage();
        jFrame.setContentPane(scsMainPage.jPanel);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        scsMainPage.showEventRequests();
        jFrame.pack();
        jFrame.setVisible(true);
    }

    public void showEventRequests() {
        ArrayList<EventRequest> eventRequests = (new Initializer()).getEventRequestDAO().getEventRequests(States.SCS_INIT);
        DefaultListModel<EventRequestItem> newRequestsListModel = (new ListModels<EventRequestItem>()).createList(eventRequests);
        this.newRequestsList.setModel(newRequestsListModel);
        this.newRequestsList.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);


        ArrayList<EventRequest> eventRequests2 = (new Initializer()).getEventRequestDAO().getEventRequests(States.SCS_BACK);
        DefaultListModel<EventRequestItem> approvedRequestsListModel =  (new ListModels<EventRequestItem>()).createList(eventRequests2);
        this.approvedRequestsList.setModel(approvedRequestsListModel);
        this.approvedRequestsList.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);
    }


}
