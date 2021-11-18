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
import java.util.ArrayList;
import model.CategoryUser;
import model.User;
/**
 *
 * @author Marchel
 */
public class RegistrasiMenu implements ActionListener {
    
    // Declaring variable
    JFrame frame;
    JPanel panel;
    JLabel lLogin, lEmail, lNama, lPassword, lCategory;
    JTextField tfEmail, tfNama;
    JPasswordField pfPassword;
    JButton btnRegistrasi, btnBack;
    JComboBox<String> cbCategory;
    QueryController queryController = new QueryController();
    ArrayList<CategoryUser> categories = queryController.selectCategoryUser();

    public RegistrasiMenu() {
        
        // Set JFrame
        frame = new JFrame("Registration Menu");
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
        lLogin = new JLabel("Registration Menu");
        lLogin.setForeground(new Color(63, 77, 63));
        lLogin.setFont(new Font("Arial", Font.BOLD, 30));
        lLogin.setBounds(85, 20, 450, 40);

        lEmail = new JLabel("Email :");
        lEmail.setForeground(new Color(63, 77, 63));
        lEmail.setFont(new Font("Arial", Font.BOLD, 20));
        lEmail.setBounds(85, 120, 200, 20);
        
        lNama = new JLabel("Nama :");
        lNama.setForeground(new Color(63, 77, 63));
        lNama.setFont(new Font("Arial", Font.BOLD, 20));
        lNama.setBounds(85, 220, 200, 20);
        
        lPassword = new JLabel("Password :");
        lPassword.setForeground(new Color(63, 77, 63));
        lPassword.setFont(new Font("Arial", Font.BOLD, 20));
        lPassword.setBounds(85, 320, 200, 20);

        lCategory = new JLabel("Category :");
        lCategory.setForeground(new Color(63, 77, 63));
        lCategory.setFont(new Font("Arial", Font.BOLD, 20));
        lCategory.setBounds(480, 120, 200, 20);

        // Set JTextField
        tfEmail = new JTextField();
        tfEmail.setFont(new Font("Arial", Font.PLAIN, 20));
        tfEmail.setBounds(200, 110, 250, 40);

        tfNama = new JTextField();
        tfNama.setFont(new Font("Arial", Font.PLAIN, 20));
        tfNama.setBounds(200, 210, 250, 40);

        // Set JPasswordField
        pfPassword = new JPasswordField();
        pfPassword.setFont(new Font("Arial", Font.PLAIN, 20));
        pfPassword.setBounds(200, 310, 250, 40);

        // Set JButton
        btnRegistrasi = new JButton("Registrasi");
        btnRegistrasi.setBackground(new Color(173, 194, 169));
        btnRegistrasi.setForeground(new Color(63, 77, 63));
        btnRegistrasi.setBounds(100, 400, 150, 60);
        btnRegistrasi.setFont(new Font("Arial", Font.BOLD, 20));
        
        btnBack = new JButton("Back");
        btnBack.setBackground(new Color(173, 194, 169));
        btnBack.setForeground(new Color(63, 77, 63));
        btnBack.setBounds(300, 400, 150, 60);
        btnBack.setFont(new Font("Arial", Font.BOLD, 20));

        btnRegistrasi.addActionListener(this);
        btnBack.addActionListener(this);

        // Set JComboBox
        String[] categoryList = new String[categories.size()];
        for (int i = 0; i < categories.size(); i++) {
            categoryList[i] = categories.get(i).getName();
        }
        cbCategory = new JComboBox<>(categoryList); 
        cbCategory.setBounds(600, 110, 200, 40);

        // Adding components
        panel.add(lLogin);
        panel.add(lEmail);
        panel.add(lNama);
        panel.add(lPassword);
        panel.add(lCategory);
        panel.add(tfEmail);
        panel.add(tfNama);
        panel.add(pfPassword);
        panel.add(cbCategory);
        panel.add(btnRegistrasi);
        panel.add(btnBack);
        frame.setContentPane(panel);

        // Set vicibility
        panel.setVisible(true);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch(command) {
            case "Registrasi":

                // Get value
                String email = tfEmail.getText();
                String name = tfNama.getText();
                String password = String.valueOf(pfPassword.getPassword());
                String category = cbCategory.getSelectedItem().toString();

                // Checking value
                if (email.equals("") || name.equals("") || password.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill all field !");
                } else if(password.length() < 8){
                    JOptionPane.showMessageDialog(null, "password requires at least 8 character");
                } else {
                    int idCategory = 0;
                    for (int i = 0; i < categories.size(); i++) {
                        if(categories.get(i).getName().equals(category)) {
                            idCategory = categories.get(i).getIdCategory();
                        }
                    }
                    
                    // Make new user and insert to database
                    User user = new User(name, email, password, idCategory);
                    boolean success = queryController.insertUser(user);

                    if (success) {
                        JOptionPane.showMessageDialog(null, "Register success");
                        frame.dispose();
                        new MainMenu();
                    } else {
                        JOptionPane.showMessageDialog(null, "Register failed");
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
