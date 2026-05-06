package gui;

import java.awt.Color;
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
import javax.swing.JPanel;
import javax.swing.BorderFactory;

import db.DBConnection;

public class LoginGUI extends JFrame {

    private JTextField txtBenutzername;
    private JPasswordField txtPasswort;

    public LoginGUI() {

        setTitle("HighSpeed HR - Login");
        setSize(520, 380);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Color dunkel = new Color(25, 25, 25);
        Color hell = new Color(245, 245, 245);
        Color blau = new Color(0, 90, 180);

        JPanel kopf = new JPanel();
        kopf.setLayout(null);
        kopf.setBounds(0, 0, 520, 70);
        kopf.setBackground(dunkel);
        add(kopf);

        JLabel logo = new JLabel("HighSpeed HR");
        logo.setBounds(25, 15, 300, 40);
        logo.setForeground(Color.WHITE);
        logo.setFont(new Font("Arial", Font.BOLD, 26));
        kopf.add(logo);

        JPanel inhalt = new JPanel();
        inhalt.setLayout(null);
        inhalt.setBounds(0, 70, 520, 310);
        inhalt.setBackground(hell);
        add(inhalt);

        JPanel loginBox = new JPanel();
        loginBox.setLayout(null);
        loginBox.setBounds(90, 35, 330, 230);
        loginBox.setBackground(Color.WHITE);
        loginBox.setBorder(BorderFactory.createLineBorder(new Color(210, 210, 210)));
        inhalt.add(loginBox);

        JLabel titel = new JLabel("Login");
        titel.setBounds(135, 20, 100, 30);
        titel.setFont(new Font("Arial", Font.BOLD, 22));
        loginBox.add(titel);

        JLabel lblBenutzer = new JLabel("Benutzername");
        lblBenutzer.setBounds(35, 65, 150, 25);
        loginBox.add(lblBenutzer);

        txtBenutzername = new JTextField();
        txtBenutzername.setBounds(35, 90, 260, 30);
        loginBox.add(txtBenutzername);

        JLabel lblPasswort = new JLabel("Passwort");
        lblPasswort.setBounds(35, 125, 150, 25);
        loginBox.add(lblPasswort);

        txtPasswort = new JPasswordField();
        txtPasswort.setBounds(35, 150, 260, 30);
        loginBox.add(txtPasswort);

        JButton btnLogin = new JButton("Login");
        btnLogin.setBounds(85, 185, 160, 35);
        btnLogin.setBackground(new Color(240, 240, 240));
        btnLogin.setForeground(Color.BLACK);
        btnLogin.setFont(new Font("Arial", Font.BOLD, 14));
        btnLogin.setFocusPainted(false);
        loginBox.add(btnLogin);

        btnLogin.addActionListener(e -> login());

        setVisible(true);
    }

    private void login() {

        String benutzername = txtBenutzername.getText();
        String passwort = new String(txtPasswort.getPassword());

        if (benutzername.isEmpty() || passwort.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Bitte Benutzername und Passwort eingeben.");
            return;
        }

        try {

            Connection conn = DBConnection.getConnection();

            String sql = "SELECT * FROM benutzer WHERE benutzername = ? AND passwort = ?";

            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, benutzername);
            pst.setString(2, passwort);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

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