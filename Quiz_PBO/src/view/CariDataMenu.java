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
import javax.swing.table.DefaultTableModel;
import model.CategoryUser;
import model.User;
/**
 *
 * @author Marchel
 */
public class CariDataMenu implements ActionListener {

    // Declaring variable
    JFrame frame;
    JPanel panel;
    JLabel lSearch;
    JButton btnSearch, btnBack;
    JComboBox<String> cbCategory;
    QueryController queryController = new QueryController();
    ArrayList<CategoryUser> categories = queryController.selectCategoryUser();
    JTable dataTable;
    DefaultTableModel model;
    JScrollPane scrollpane;

    public CariDataMenu() {

        // Set JFrame
        frame = new JFrame("Search Menu");
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
        lSearch = new JLabel("Search Menu");
        lSearch.setForeground(new Color(63, 77, 63));
        lSearch.setFont(new Font("Arial", Font.BOLD, 30));
        lSearch.setBounds(85, 20, 450, 40);

        // Set JComboBox
        String[] categoryList = new String[categories.size()];
        for (int i = 0; i < categories.size(); i++) {
            categoryList[i] = categories.get(i).getName();
        }
        cbCategory = new JComboBox<>(categoryList); 
        cbCategory.setBounds(85, 70, 200, 40);

        // Set JButton
        btnSearch = new JButton("Search");
        btnSearch.setBackground(new Color(173, 194, 169));
        btnSearch.setForeground(new Color(63, 77, 63));
        btnSearch.setBounds(300, 70, 120, 40);
        btnSearch.setFont(new Font("Arial", Font.BOLD, 20));

        btnBack = new JButton("Back");
        btnBack.setBackground(new Color(173, 194, 169));
        btnBack.setForeground(new Color(63, 77, 63));
        btnBack.setBounds(430, 70, 120, 40);
        btnBack.setFont(new Font("Arial", Font.BOLD, 20));
        
        btnSearch.addActionListener(this);
        btnBack.addActionListener(this);

        // Set JTable
        
        
        dataTable = new JTable();
        
        dataTable.setBounds(85, 120, 715, 350);    
        
        // Set JScrollPane
        scrollpane = new JScrollPane(dataTable); 
        scrollpane.setBounds(85, 120, 715, 350);

        // Adding components
        panel.add(lSearch);
        panel.add(cbCategory);
        panel.add(btnSearch);
        panel.add(btnBack);
        panel.add(scrollpane);
        frame.setContentPane(panel);

        // Set vicibility
        scrollpane.setVisible(false);
        panel.setVisible(true);
        frame.setVisible(true);   
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch(command) {
            case "Search":

                // Get value
                String category = cbCategory.getSelectedItem().toString();
                ArrayList<User> users = queryController.selectUserByCategory(category);
                
                // Set value
                String[] columnData = {"id_user", "name", "email", "password", "id_category"};
                model = new DefaultTableModel(columnData, 0);

                for (int i = 0; i < users.size(); i++) {
                    String[] newModel = new String[5];
                    newModel[0] = String.valueOf(users.get(i).getIdUser());
                    newModel[1] = users.get(i).getName();
                    newModel[2] = users.get(i).getEmail();
                    newModel[3] = users.get(i).getPassword();
                    newModel[4] = String.valueOf(users.get(i).getIdCategory());
                    model.addRow(newModel);
                }

                dataTable.setModel(model);
                scrollpane.setVisible(true);
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
