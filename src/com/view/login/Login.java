package com.view.login;

import com.dao.Initializer;
import com.domain.UserRole;
import com.view.admin.AdminMainPage;
import com.view.cs.CsMainPage;
import com.view.fm.FMMainPage;
import com.view.hr.HRMainPage;
import com.view.psm.PMMainPage;
import com.view.psm.SMMainPage;
import com.view.scs.SCSMainPage;
import com.view.subteam.SubteamMainPage;
import com.view.subteam.SubteamViewTask;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login {
    private JTextField username;
    private JPasswordField password;
    private JButton login;
    private JPanel jPanel;
    private static JFrame jFrame;

    public Login() {
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // get username
                String usernameValue = username.getText();
                // get password
                char[] passwordValue = password.getPassword();
                // check that user exists and get his job title
                UserRole userRole = (new Initializer()).getUserDAO().checkUser(usernameValue, passwordValue);
                // if user doesn't exist show error message
                if (userRole == null) {
                    showMessage("Wrong username or password!");
                }else {
                    // else enters the system
                    loadMainPage(usernameValue, userRole);
                }
            }
        });
    }

    public static void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    public void loadMainPage(String username, UserRole role) {
        // close login page
        jFrame.setVisible(false);

        if (role == UserRole.CS) {
            CsMainPage.createCsMainPage();
        } else if (role == UserRole.SCS) {
            SCSMainPage.createSCSMainPage();
        }
        else if (role == UserRole.FM) {
            FMMainPage.createFMMainPage();
        }
        else if (role == UserRole.Adm) {
            AdminMainPage.createAdminMainPage();
        }
        else if (role == UserRole.PM) {
            PMMainPage.createPMMainPage(username);
        }
        else if (role == UserRole.SM) {
            SMMainPage.createSMMainPage(username);
        }
        else if (role == UserRole.SubteamP || role == UserRole.SubteamS) {
            SubteamMainPage.createSubteamMainPage(username);
        }
        else if (role == UserRole.HR) {
            HRMainPage.createHRMainPage();
        }
    }

    public static void createLogin(){
        jFrame = new JFrame("Login");
        jFrame.setContentPane(new Login().jPanel);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
    }

    public static void main(String[] args) {
        // initialize data
        Initializer.init();
        try {
            (new Initializer()).prepareData();
        } catch (Exception e){
            showMessage("An Error has occurred");
        }
        // start login page
       createLogin();
    }
}
