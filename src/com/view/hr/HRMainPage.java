package com.view.hr;

import com.dao.Initializer;
import com.domain.AcceptRejectState;
import com.domain.RecruitmentRequest;
import com.view.general.items.RecruitmentRequestItem;
import com.view.general.items.RequestItem;
import com.view.general.event_requests.ListModels;
import com.view.login.Login;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static com.view.hr.HREvaluateCandidate.createHREvaluateCandidate;

public class HRMainPage {
    private JList recruitmentRequests;
    private JPanel jPanel;
    private JButton logoutButton;
    private static JFrame jFrame;

    private static ArrayList<JFrame> children;

    public HRMainPage() {

        recruitmentRequests.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedItemIndex = recruitmentRequests.getSelectedIndex();
                    RecruitmentRequestItem recruitmentRequestItem = (RecruitmentRequestItem) recruitmentRequests.getModel().getElementAt(selectedItemIndex);
                    JFrame child = createHREvaluateCandidate((RecruitmentRequest) recruitmentRequestItem.getRequest());
                    children.add(child);
                }
            }
        });

        logoutButton.addActionListener(new ActionListener() {
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

    public static void createHRMainPage() {
        children = new ArrayList<JFrame>();
        jFrame = new JFrame("Main page (HR)");
        HRMainPage hrMainPage = new HRMainPage();
        jFrame.setContentPane(hrMainPage.jPanel);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        hrMainPage.showRecruitmentRequests();
        jFrame.pack();
        jFrame.setVisible(true);
    }

    public void showRecruitmentRequests() {
        ArrayList<RecruitmentRequest> recruitmentRequests = (new Initializer()).getRecruitmentRequestDAO().getRecruitmentRequests(AcceptRejectState.NEW);

        DefaultListModel<RequestItem> newRequestsListModel = (new ListModels<RequestItem>()).createList(recruitmentRequests);

        this.recruitmentRequests.setModel(newRequestsListModel);
        this.recruitmentRequests.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);

    }

}
