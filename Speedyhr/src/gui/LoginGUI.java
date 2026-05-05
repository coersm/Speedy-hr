package gui;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import db.DBConnection;

public class LoginGUI extends JFrame {

    private JTextField txtBenutzername;
    private JPasswordField txtPasswort;
    private JButton btnLogin;

    public LoginGUI() {

        setTitle("HighSpeed HR - Login");
        setSize(400, 300);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel lblTitel = new JLabel("HighSpeed HR Login");
        lblTitel.setBounds(90, 30, 250, 30);
        lblTitel.setFont(new Font("Arial", Font.BOLD, 22));
        add(lblTitel);

        JLabel lblBenutzer = new JLabel("Benutzername:");
        lblBenutzer.setBounds(50, 90, 120, 25);
        add(lblBenutzer);

        txtBenutzername = new JTextField();
        txtBenutzername.setBounds(170, 90, 150, 25);
        add(txtBenutzername);

        JLabel lblPasswort = new JLabel("Passwort:");
        lblPasswort.setBounds(50, 140, 120, 25);
        add(lblPasswort);

        txtPasswort = new JPasswordField();
        txtPasswort.setBounds(170, 140, 150, 25);
        add(txtPasswort);

        btnLogin = new JButton("Login");
        btnLogin.setBounds(140, 200, 100, 30);
        add(btnLogin);

        btnLogin.addActionListener(e -> login());

        setVisible(true);
    }

    private void login() {

        String benutzername = txtBenutzername.getText();
        String passwort = new String(txtPasswort.getPassword());

        try {

            Connection conn = DBConnection.getConnection();

            String sql = "SELECT * FROM benutzer WHERE benutzername = ? AND passwort = ?";

            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, benutzername);
            pst.setString(2, passwort);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(this, "Login erfolgreich!");
                new DashboardGUI();
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Benutzername oder Passwort falsch!");
            }

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}