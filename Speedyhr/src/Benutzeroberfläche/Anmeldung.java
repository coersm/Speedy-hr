package Benutzeroberfläche;

import javax.swing.*;
import datenbank.access;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Anmeldung {
    private JFrame frame;
    private JTextField txtUsername;
    private JPasswordField txtPassword;

    public Anmeldung() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Login");
        frame.setBounds(100, 100, 350, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        txtUsername = new JTextField();
        txtUsername.setBounds(140, 50, 150, 25);
        frame.getContentPane().add(txtUsername);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(140, 90, 150, 25);
        frame.getContentPane().add(txtPassword);

        JButton btnLogin = new JButton("Anmelden");
        btnLogin.setBounds(100, 150, 120, 30);
        frame.getContentPane().add(btnLogin);
        
        JLabel lblNewLabel = new JLabel("Benutzername");
        lblNewLabel.setBounds(29, 55, 101, 14);
        frame.getContentPane().add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("Passwort");
        lblNewLabel_1.setBounds(29, 95, 101, 14);
        frame.getContentPane().add(lblNewLabel_1);

        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String user = txtUsername.getText();
                String pw = new String(txtPassword.getPassword());

                access db1 = new access();
                
                // Wir definieren die Abfrage hier lokal in der Anmeldung
                if (access.anmeldung(user, pw)) {
                    JOptionPane.showMessageDialog(frame, "Erfolg!");
                    frame.dispose();
                    // Nächstes Fenster öffnen...
                }
                
                	
                	
                else {
                   JOptionPane.showMessageDialog(frame, "Fehler!", "Login", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Anmeldung().frame.setVisible(true));
    }
}