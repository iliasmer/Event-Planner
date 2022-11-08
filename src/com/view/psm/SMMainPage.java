package com.view.psm;

import com.dao.Initializer;
import com.domain.*;
import com.view.general.items.EventRequestItem;
import com.view.general.items.FinancialRequestItem;
import com.view.general.items.RecruitmentRequestItem;
import com.view.general.items.UserItem;
import com.view.general.event_requests.ListModels;
import com.view.login.Login;
import com.view.subteam.JTableButtonMouseListener;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableCellRenderer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static com.view.psm.PSMViewEvent.createPSMViewEvent;

public class SMMainPage {
    private JLabel loggedIn;
    private JPanel jPanel;
    private JTabbedPane tab2;
    private JList<EventRequestItem> generalList;
    private JPanel createTaskPanel;
    private JTextField description;
    private JTextField eventRecordNumber;
    private JComboBox<UserItem> assignTo;
    private JComboBox<String> priority;
    private JButton sendTaskButton;
    private JButton hireStaffButton;
    private JButton logOutButton;
    private static JFrame jFrame;
    private JList acceptedRecruitments;
    private JList rejectedRecruitments;
    private JTable tasksTable;
    private JScrollPane scrollPane;
    private JButton newFinancialRequestButton;
    private JList financialApprovalsList;
    private JList financialRejectionsList;
    private JTableButtonModelPSM jTableButtonModel;

    private static ArrayList<JFrame> children;


    public SMMainPage() {
        generalList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedItemIndex = generalList.getSelectedIndex();
                    EventRequestItem eventRequestItem = (EventRequestItem) generalList.getModel().getElementAt(selectedItemIndex);
                    JFrame child = createPSMViewEvent(((EventRequest)eventRequestItem.getRequest()).getEvent());
                    children.add(child);
                }
            }
        });
        sendTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String recordNumber = eventRecordNumber.getText();
                String descriptionValue =  description.getText();
                UserItem userItem = (UserItem) assignTo.getSelectedItem();
                String priorityValue = (String) priority.getSelectedItem();
                createTask(recordNumber, descriptionValue, userItem, priorityValue);
            }
        });
        hireStaffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HireStaff.createHireForm();
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

        newFinancialRequestButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FinancialRequest.createFinancialRequestForm();
            }
        });
    }
    public void createTask(String recordNumber, String descriptionValue, UserItem userItem, String priorityValue) {
        int recordNumberInt = Integer.parseInt(recordNumber);
        Event event = (new Initializer()).getEventRequestDAO().getEvent(recordNumberInt);
        SubteamMember subteamMember = (SubteamMember) userItem.getUser();
        try {
            Task task = new Task(event, descriptionValue, subteamMember, priorityValue);
            subteamMember.addTask(task);
        }catch (Exception e){
            showMessage(e.toString());
        }
    }
    public static void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    public static void createSMMainPage(String username) {
        children = new ArrayList<JFrame>();
        jFrame = new JFrame("Main page (SM)");
        SMMainPage smMainPage = new SMMainPage();
        jFrame.setContentPane(smMainPage.jPanel);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        smMainPage.showEventRequests();
        smMainPage.showMembers(username);
        smMainPage.loggedIn.setText("Logged in: " + username);
        jFrame.pack();
        jFrame.setVisible(true);
    }

    public void showMembers(String username) {
        // get manager
        PSManager manager = (PSManager) (new Initializer()).getUserDAO().getUser(username);
        // get the subteams for this manager
        ArrayList<Subteam> subteams = manager.getSubteams();
        for(Subteam subteam: subteams) {
            if (subteam.getName().equals(tab2.getTitleAt(1))) {
                // the first tab
                ArrayList<SubteamMember> members = subteam.getMembers();
                for (SubteamMember member:members) {
                    assignTo.addItem(new UserItem(member));
                }
            }
        }

    }
    public void showEventRequests() {
        ArrayList<EventRequest> eventRequests = (new Initializer()).getEventRequestDAO().getEventRequests(States.SCS_END);
        DefaultListModel<EventRequestItem> newRequestsListModel = (new ListModels<EventRequestItem>()).createList(eventRequests);
        this.generalList.setModel(newRequestsListModel);
        this.generalList.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);



        ArrayList<RecruitmentRequest> recruitmentRequests = (new Initializer()).getRecruitmentRequestDAO().getRecruitmentRequests(AcceptRejectState.COMPLETED);
        DefaultListModel<RecruitmentRequestItem> approvedRecruitListModel =  (new ListModels<RecruitmentRequestItem>()).createList(recruitmentRequests);
        this.acceptedRecruitments.setModel(approvedRecruitListModel);
        this.acceptedRecruitments.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);

        ArrayList<RecruitmentRequest> recruitmentRequests2 = (new Initializer()).getRecruitmentRequestDAO().getRecruitmentRequests(AcceptRejectState.REJECTED);
        DefaultListModel<RecruitmentRequestItem> rejectedRecruitListModel =  (new ListModels<RecruitmentRequestItem>()).createList(recruitmentRequests2);
        this.rejectedRecruitments.setModel(rejectedRecruitListModel);
        this.rejectedRecruitments.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);





        ArrayList<com.domain.FinancialRequest> financialRequestAppr = (new Initializer()).getFinancialRequestDAO().getFinancialRequest(AcceptRejectState.COMPLETED);
        DefaultListModel<FinancialRequestItem> financialRequestItemDefaultListModel =  (new ListModels<FinancialRequestItem>()).createList(financialRequestAppr);
        this.financialApprovalsList.setModel(financialRequestItemDefaultListModel);
        this.financialApprovalsList.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);

        ArrayList<com.domain.FinancialRequest> financialRequestRej = (new Initializer()).getFinancialRequestDAO().getFinancialRequest(AcceptRejectState.REJECTED);
        DefaultListModel<FinancialRequestItem> financialRequestItemDefaultListModel2 =  (new ListModels<FinancialRequestItem>()).createList(financialRequestRej);
        this.financialRejectionsList.setModel(financialRequestItemDefaultListModel2);
        this.financialRejectionsList.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);

        fillTableWithTasks();
    }

    public void fillTableWithTasks() {
        TableCellRenderer tableRenderer;
        // pass tasks to table
        ArrayList<Task> tasks = getAllTasks();

        jTableButtonModel = new JTableButtonModelPSM(tasks);
        // set model
        tasksTable.setModel(jTableButtonModel);
        // button render
        tableRenderer = tasksTable.getDefaultRenderer(JButton.class);
        tasksTable.setDefaultRenderer(JButton.class, new JTableButtonRendererPSM(tableRenderer));
        tasksTable.addMouseListener(new JTableButtonMouseListener(tasksTable));

    }


    public ArrayList<Task> getAllTasks() {
        SubteamMember subteamMember1 = (SubteamMember) (new Initializer()).getUserDAO().getUser("Tobias");
        SubteamMember subteamMember2 = (SubteamMember) (new Initializer()).getUserDAO().getUser("Magdalena");
        ArrayList<Task> tasks = subteamMember1.getTasks();
        if (subteamMember2 != null) {
            for (int i = 0; i < subteamMember2.getTasks().size(); i++) {
                tasks.add(subteamMember2.getTasks().get(i));
            }
        }

        return tasks;
    }
}
