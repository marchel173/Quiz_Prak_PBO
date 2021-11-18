/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controller.QueryController;
import model.User;

/**
 *
 * @author Marchel
 */
public class LoginMenu implements ActionListener{
    JFrame frame;
    JPanel panel;
    JLabel lLogin, lEmail, lPassword;
    JTextField tfEmail;
    JPasswordField pfPassword;
    JButton loginButton;
    JButton backButton;
    
    LoginMenu() {
         // Set JFrame
        frame = new JFrame("Login Menu");
        frame.setSize(900, 550);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Image icon = Toolkit.getDefaultToolkit().getImage("src\\image\\Logo_Color.png");  
        frame.setIconImage(icon);

        // Set JPanel
        panel = new JPanel();
        panel.setBackground(new Color(254, 245, 237));
        panel.setSize(900, 550);
        panel.setLayout(null);

        // Set components
        // Set JLabel
        lLogin = new JLabel("Login Menu");
        lLogin.setForeground(new Color(63, 77, 63));
        lLogin.setFont(new Font("Arial", Font.BOLD, 30));
        lLogin.setBounds(85, 20, 450, 40);

        lEmail = new JLabel("Email :");
        lEmail.setForeground(new Color(63, 77, 63));
        lEmail.setFont(new Font("Arial", Font.BOLD, 20));
        lEmail.setBounds(85, 120, 200, 20);

        lPassword = new JLabel("Password :");
        lPassword.setForeground(new Color(63, 77, 63));
        lPassword.setFont(new Font("Arial", Font.BOLD, 20));
        lPassword.setBounds(85, 220, 200, 20);

        // Set JTextField
        tfEmail = new JTextField();
        tfEmail.setFont(new Font("Arial", Font.PLAIN, 20));
        tfEmail.setBounds(200, 110, 250, 40);

        // Set JPasswordField
        pfPassword = new JPasswordField();
        pfPassword.setFont(new Font("Arial", Font.PLAIN, 20));
        pfPassword.setBounds(200, 210, 250, 40);

        // Set JButton
        loginButton = new JButton("Login");
        loginButton.setBackground(new Color(173, 194, 169));
        loginButton.setForeground(new Color(63, 77, 63));
        loginButton.setBounds(100, 400, 150, 60);
        loginButton.setFont(new Font("Arial", Font.BOLD, 20));
        
        backButton = new JButton("Back");
        backButton.setBackground(new Color(173, 194, 169));
        backButton.setForeground(new Color(63, 77, 63));
        backButton.setBounds(300, 400, 150, 60);
        backButton.setFont(new Font("Arial", Font.BOLD, 20));

        loginButton.addActionListener(this);
        backButton.addActionListener(this);

        // Adding components
        panel.add(lLogin);
        panel.add(lEmail);
        panel.add(lPassword);
        panel.add(tfEmail);
        panel.add(pfPassword);
        panel.add(loginButton);
        panel.add(backButton);
        frame.setContentPane(panel);

        // Set vicibility
        panel.setVisible(true);
        frame.setVisible(true);
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
        //LOGIN button
        String command = e.getActionCommand();
        switch(command) {
            case "Login":

                // Get value
                String email = tfEmail.getText();
                String password = String.valueOf(pfPassword.getPassword());

                // Checking value
                if (email.equals("") && password.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill all field !");
                } else {

                    // Get data from database
                    QueryController queryController = new QueryController();
                    User user = queryController.selectUser(email, password);
                    if (user == null) {
                        JOptionPane.showMessageDialog(null, "User not found");
                    } else {
                        new ProfileMenu(user);
                        frame.dispose();
                    }
                }
                break;
            case "Back":
                new MainMenu();
                frame.dispose();
                break;
            default: 
                break;
        }
    }
}

