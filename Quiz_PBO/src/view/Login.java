/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JFrame;

/**
 *
 * @author Marchel
 */
public class Login{
    public static void main(String[] args) {
        LoginFrame frame =new LoginFrame();
        frame.setTitle("Login");
        frame.setVisible(true);
        frame.setBounds(10,10,370,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }

    Login(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
