package com.view.fm;

import com.dao.Initializer;
import com.domain.*;
import com.view.general.items.EventRequestItem;
import com.view.general.items.FinancialRequestItem;
import com.view.general.event_requests.ListModels;
import com.view.login.Login;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static com.view.fm.EvaluateFinancialRequest.createEvaluateFinancialRequest;
import static com.view.fm.FMAddFeedback.createFMAddFeedback;

public class FMMainPage {
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JList eventRequestList;
    private JList financialRequestList;
    private JButton logOutButton;
    private static JFrame jFrame;
    private static ArrayList<JFrame> children;

    public static void createFMMainPage() {
        children = new ArrayList<JFrame>();
        jFrame = new JFrame("Main page (FM)");
        FMMainPage fmMainPage = new FMMainPage();
        jFrame.setContentPane(fmMainPage.panel1);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fmMainPage.showEventRequests();
        jFrame.pack();
        jFrame.setVisible(true);
    }


    public FMMainPage() {
        eventRequestList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedItemIndex = eventRequestList.getSelectedIndex();
                    EventRequestItem eventRequestItem = (EventRequestItem) eventRequestList.getModel().getElementAt(selectedItemIndex);
                    JFrame child = createFMAddFeedback((EventRequest) eventRequestItem.getRequest());
                    children.add(child);
                }
            }
        });


        financialRequestList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedItemIndex = financialRequestList.getSelectedIndex();
                    FinancialRequestItem financialRequestItem = (FinancialRequestItem) financialRequestList.getModel().getElementAt(selectedItemIndex);
                    JFrame child = createEvaluateFinancialRequest((FinancialRequest) financialRequestItem.getRequest());
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


    public void showEventRequests() {
        ArrayList<EventRequest> eventRequests = (new Initializer()).getEventRequestDAO().getEventRequests(States.FM);
        DefaultListModel<EventRequestItem> newRequestsListModel = (new ListModels<EventRequestItem>()).createList(eventRequests);
        this.eventRequestList.setModel(newRequestsListModel);
        this.eventRequestList.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);

        ArrayList<FinancialRequest> financialRequests = (new Initializer()).getFinancialRequestDAO().getFinancialRequest(AcceptRejectState.NEW);
        DefaultListModel<FinancialRequestItem> newRequestsListModel2 = (new ListModels<FinancialRequestItem>()).createList(financialRequests);
        this.financialRequestList.setModel(newRequestsListModel2);
        this.financialRequestList.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);


    }



}
