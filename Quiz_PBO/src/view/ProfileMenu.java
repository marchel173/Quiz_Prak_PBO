/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.*;
import java.awt.*;

import controller.QueryController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import model.CategoryUser;
import model.User;
/**
 *
 * @author Marchel
 */
public class ProfileMenu implements ActionListener {
    
    // Declaring variable
    JFrame frame;
    JPanel panel;
    JLabel lLogin, lEmail, lNama, lPassword, lCategory;
    JTextField tfEmail, tfNama;
    JPasswordField pfPassword;
    JButton btnSimpan, btnDelete, btnBack;
    JComboBox<String> cbCategory;
    QueryController queryController = new QueryController();
    ArrayList<CategoryUser> categories = queryController.selectCategoryUser();
    User user;

    public ProfileMenu(User currentUser) {
        
        // Set User variable to global
        setUser(currentUser);

        // Set JFrame
        frame = new JFrame("Profile Menu");
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
        lLogin = new JLabel("Profile Menu");
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
        tfEmail.setText(user.getEmail());
        
        tfNama = new JTextField();
        tfNama.setFont(new Font("Arial", Font.PLAIN, 20));
        tfNama.setBounds(200, 210, 250, 40);
        tfNama.setText(user.getName());
        
        // Set JPasswordField
        pfPassword = new JPasswordField();
        pfPassword.setFont(new Font("Arial", Font.PLAIN, 20));
        pfPassword.setBounds(200, 310, 250, 40);
        pfPassword.setText(user.getPassword());
        // pfPassword.setEchoChar((char)0);

        // Set JButton
        btnSimpan = new JButton("Simpan");
        btnSimpan.setBackground(new Color(173, 194, 169));
        btnSimpan.setForeground(new Color(63, 77, 63));
        btnSimpan.setBounds(100, 400, 150, 60);
        btnSimpan.setFont(new Font("Arial", Font.BOLD, 20));
        
        btnDelete = new JButton("Hapus Data");
        btnDelete.setBackground(new Color(173, 194, 169));
        btnDelete.setForeground(new Color(63, 77, 63));
        btnDelete.setBounds(300, 400, 150, 60);
        btnDelete.setFont(new Font("Arial", Font.BOLD, 20));
        
        btnBack = new JButton("Back");
        btnBack.setBackground(new Color(173, 194, 169));
        btnBack.setForeground(new Color(63, 77, 63));
        btnBack.setBounds(500, 400, 150, 60);
        btnBack.setFont(new Font("Arial", Font.BOLD, 20));

        btnSimpan.addActionListener(this);
        btnDelete.addActionListener(this);
        btnBack.addActionListener(this);

        // Set JComboBox
        String[] categoryList = new String[categories.size()];
        String categorySelected = "";
        for (int i = 0; i < categories.size(); i++) {
            categoryList[i] = categories.get(i).getName();
            if (categories.get(i).getIdCategory() == user.getIdCategory()) {
                categorySelected = categories.get(i).getName();
            }
        }
        cbCategory = new JComboBox<>(categoryList); 
        cbCategory.setBounds(600, 110, 200, 40);
        cbCategory.setSelectedItem(categorySelected);;

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
        panel.add(btnSimpan);
        panel.add(btnDelete);
        panel.add(btnBack);
        frame.setContentPane(panel);

        // Set vicibility
        panel.setVisible(true);
        frame.setVisible(true);
    }

    public void setUser(User currentUser) {
        user = currentUser;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch(command) {
            case "Simpan":

                // Get value
                String email = tfEmail.getText();
                String name = tfNama.getText();
                String password = String.valueOf(pfPassword.getPassword());
                String category = cbCategory.getSelectedItem().toString();

                // Checking value
                if (email.equals("") || name.equals("") || password.equals("")) {
                    JOptionPane.showMessageDialog(null, "Tolong isi data yang kosong !");
                } else if(password.length() < 8){
                    JOptionPane.showMessageDialog(null, "Password harus  ada 8 karakter atau lebih");
                } else {
                    int idCategory = 0;
                    for (int i = 0; i < categories.size(); i++) {
                        if(categories.get(i).getName().equals(category)) {
                            idCategory = categories.get(i).getIdCategory();
                        }
                    }
                    
                    // Update user data
                    User updatedUser = new User(name, email, password, idCategory);
                    boolean success = queryController.updateUser(user.getIdUser(), updatedUser);

                    if (success) {
                        JOptionPane.showMessageDialog(null, "Update Berhasil");
                    } else {
                        JOptionPane.showMessageDialog(null, "Update Gagal");
                    }
                }
                frame.dispose();
                new MainMenu();
                break;

            case "Hapus Data":

                int result = JOptionPane.showConfirmDialog(null,"Apakah Kamu yakin akan menghapus Akun kamu ?", "konfirmasi",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
                if(result == JOptionPane.YES_OPTION){
                    boolean success = queryController.deleteUser(user.getIdUser());
                    if (success) {
                        JOptionPane.showMessageDialog(null, "Akun telah dihapus");
                    } else {
                        JOptionPane.showMessageDialog(null, "Akun gagal dihapus");
                    }
                    new MainMenu();
                    frame.dispose();
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