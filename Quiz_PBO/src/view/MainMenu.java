/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Marchel
 */
public class MainMenu implements ActionListener {
    
    JFrame frame;
    JPanel panel;
    JButton btnLogin, btnRegistrasi,btnLihatData,btnExit;
    
    public MainMenu() {

        // Make JFrame
        frame = new JFrame("Main menu");
        frame.setSize(450, 550);
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Make JPanel
        panel = new JPanel();
        panel.setBackground(new Color(254, 245, 237));
        panel.setSize(450, 550);
        panel.setVisible(true);
        panel.setLayout(null);
        
        // Make label
        JLabel label = new JLabel("Silahkan pilih menu di bawah");
        label.setForeground(new Color(63, 77, 63));
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setBounds(85, 20, 450, 20);

        // Make button
        JButton btnLogin = new JButton("Login");
        btnLogin.setBackground(new Color(173, 194, 169));
        btnLogin.setForeground(new Color(63, 77, 63));
        btnLogin.setBounds(110, 80, 220, 60);
        btnLogin.setFont(new Font("Arial", Font.BOLD, 20));
        
        JButton btnRegistrasi = new JButton("Registrasi");
        btnRegistrasi.setBackground(new Color(173, 194, 169));
        btnRegistrasi.setForeground(new Color(63, 77, 63));
        btnRegistrasi.setBounds(110, 200, 220, 60);
        btnRegistrasi.setFont(new Font("Arial", Font.BOLD, 20));
        
        JButton btnLihatData = new JButton("Lihat Data");
        btnLihatData.setBackground(new Color(173, 194, 169));
        btnLihatData.setForeground(new Color(63, 77, 63));
        btnLihatData.setBounds(110, 320, 220, 60);
        btnLihatData.setFont(new Font("Arial", Font.BOLD, 20));
        
        JButton btnExit = new JButton("Exit");
        btnExit.setBackground(new Color(173, 194, 169));
        btnExit.setForeground(new Color(63, 77, 63));
        btnExit.setBounds(110, 440, 220, 60);
        btnExit.setFont(new Font("Arial", Font.BOLD, 20));

        btnLogin.addActionListener(this);
        btnRegistrasi.addActionListener(this);
        btnLihatData.addActionListener(this);
        btnExit.addActionListener(this);

        // Make mouse listener for button hover
        btnLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLogin.setBackground(new Color(211, 228, 205));
            }
        
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLogin.setBackground(new Color(173, 194, 169));
            }
        });

        btnRegistrasi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRegistrasi.setBackground(new Color(211, 228, 205));
            }
        
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRegistrasi.setBackground(new Color(173, 194, 169));
            }
        });

        btnLihatData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLihatData.setBackground(new Color(211, 228, 205));
            }
        
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLihatData.setBackground(new Color(173, 194, 169));
            }
        });
        
        btnExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnExit.setBackground(new Color(211, 228, 205));
            }
        
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnExit.setBackground(new Color(173, 194, 169));
            }
        });
        
        // Fill JPanel & JFrame
        panel.add(label);
        panel.add(btnLogin);
        panel.add(btnRegistrasi);
        panel.add(btnLihatData);
        panel.add(btnExit);
        frame.setContentPane(panel);
    }

    public void actionMouseEntered(java.awt.event.MouseEvent evt) {
        btnRegistrasi.setBackground(new Color(211, 228, 205));
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        btnRegistrasi.setBackground(new Color(173, 194, 169));
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch(command) {
            case "LoginPengguna":
                new Login(null);
                frame.dispose();
                break;
            case "RegistrasiPenggunaBaru":
                
                frame.dispose();
                break;
            case "LihatDataPengguna":
                new LihatDataPengguna();
                frame.dispose();
                break;
            case "Exit":
                frame.dispose();
                JOptionPane.showMessageDialog(null, "Thankyou for using our app : )");
                System.exit(0);
                break;
            default: 
                break;
        }
    }
}
