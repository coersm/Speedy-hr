package gui;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import db.DBConnection;
import model.Bewerber;

public class BewerbungenGUI extends JFrame {

    public BewerbungenGUI() {

        setTitle("HighSpeed HR - Bewerbungen");
        setSize(1000, 620);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Color dunkel = new Color(25, 25, 25);
        Color sidebar = new Color(35, 35, 35);
        Color hell = new Color(245, 245, 245);
        Color aktiv = new Color(180, 180, 180);

        JPanel kopf = new JPanel(null);
        kopf.setBounds(0, 0, 1000, 70);
        kopf.setBackground(dunkel);
        add(kopf);

        JLabel logo = new JLabel("HighSpeed HR");
        logo.setBounds(25, 15, 300, 40);
        logo.setForeground(Color.WHITE);
        logo.setFont(new Font("Arial", Font.BOLD, 28));
        kopf.add(logo);

        JPanel seite = new JPanel(null);
        seite.setBounds(0, 70, 170, 550);
        seite.setBackground(sidebar);
        add(seite);

        JButton btnDashboard = menuButton("Dashboard", 30);
        JButton btnBewerbung = menuButton("Bewerbung", 85);
        JButton btnKuendigung = menuButton("Kündigung", 140);
        JButton btnAenderung = menuButton("Änderung", 195);
        JButton btnAuswertung = menuButton("Auswertung", 250);

        btnBewerbung.setBackground(aktiv);

        seite.add(btnDashboard);
        seite.add(btnBewerbung);
        seite.add(btnKuendigung);
        seite.add(btnAenderung);
        seite.add(btnAuswertung);

        JLabel personal = new JLabel("Personalabteilung");
        personal.setBounds(25, 455, 130, 30);
        personal.setForeground(Color.WHITE);
        personal.setFont(new Font("Arial", Font.BOLD, 14));
        seite.add(personal);

        JPanel inhalt = new JPanel(null);
        inhalt.setBounds(170, 70, 830, 550);
        inhalt.setBackground(hell);
        add(inhalt);

        JPanel titelBox = new JPanel(null);
        titelBox.setBounds(0, 0, 830, 75);
        titelBox.setBackground(Color.WHITE);
        titelBox.setBorder(BorderFactory.createLineBorder(new Color(210, 210, 210)));
        inhalt.add(titelBox);

        JLabel titel = new JLabel("Bewerbungen");
        titel.setBounds(30, 12, 300, 35);
        titel.setFont(new Font("Arial", Font.BOLD, 26));
        titelBox.add(titel);

        JLabel untertitel = new JLabel("Übersicht und erste Bewerberdaten");
        untertitel.setBounds(32, 45, 400, 25);
        untertitel.setFont(new Font("Arial", Font.PLAIN, 14));
        titelBox.add(untertitel);

        JButton btnNeueBewerbung = new JButton("+ Neue Bewerbung");
        btnNeueBewerbung.setBounds(610, 22, 170, 32);
        btnNeueBewerbung.setBackground(new Color(240, 240, 240));
        btnNeueBewerbung.setFocusPainted(false);
        titelBox.add(btnNeueBewerbung);

        JPanel sucheBox = new JPanel(null);
        sucheBox.setBounds(40, 100, 740, 45);
        sucheBox.setBackground(Color.WHITE);
        sucheBox.setBorder(BorderFactory.createLineBorder(new Color(210, 210, 210)));
        inhalt.add(sucheBox);

        JLabel suche = new JLabel("Suche / Filter");
        suche.setBounds(20, 10, 200, 25);
        suche.setFont(new Font("Arial", Font.PLAIN, 14));
        sucheBox.add(suche);

        JPanel listeBox = new JPanel(null);
        listeBox.setBounds(40, 165, 740, 310);
        listeBox.setBackground(Color.WHITE);
        listeBox.setBorder(BorderFactory.createLineBorder(new Color(210, 210, 210)));
        inhalt.add(listeBox);

        JLabel kopf1 = new JLabel("Bewerber");
        kopf1.setBounds(25, 15, 150, 25);
        kopf1.setFont(new Font("Arial", Font.BOLD, 13));
        listeBox.add(kopf1);

        JLabel kopf2 = new JLabel("Position");
        kopf2.setBounds(230, 15, 150, 25);
        kopf2.setFont(new Font("Arial", Font.BOLD, 13));
        listeBox.add(kopf2);

        JLabel kopf3 = new JLabel("Status");
        kopf3.setBounds(440, 15, 150, 25);
        kopf3.setFont(new Font("Arial", Font.BOLD, 13));
        listeBox.add(kopf3);

        bewerbungenLaden(listeBox);

        btnDashboard.addActionListener(e -> {
            new DashboardGUI();
            dispose();
        });

        setVisible(true);
    }

    private JButton menuButton(String text, int y) {

        JButton button = new JButton(text);
        button.setBounds(20, y, 130, 35);
        button.setBackground(new Color(240, 240, 240));
        button.setForeground(Color.BLACK);
        button.setFocusPainted(false);

        return button;
    }

    private void bewerbungenLaden(JPanel listeBox) {

        int y = 55;

        try {
            Connection conn = DBConnection.getConnection();

            String sql = "SELECT name, position, status FROM bewerbungen LIMIT 5";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Bewerber bewerber = new Bewerber(
                        rs.getString("name"),
                        "",
                        "",
                        rs.getString("position"),
                        rs.getString("status")
                );

                JPanel zeile = new JPanel(null);
                zeile.setBounds(20, y, 700, 38);
                zeile.setBackground(new Color(248, 248, 248));
                zeile.setBorder(BorderFactory.createLineBorder(new Color(230, 230, 230)));
                listeBox.add(zeile);

                JLabel name = new JLabel(bewerber.getName());
                name.setBounds(10, 7, 180, 25);
                zeile.add(name);

                JLabel position = new JLabel(bewerber.getPosition());
                position.setBounds(210, 7, 180, 25);
                zeile.add(position);

                JLabel status = new JLabel(bewerber.getStatus());
                status.setBounds(420, 7, 180, 25);
                zeile.add(status);

                y += 45;
            }

            conn.close();

        } catch (Exception e) {

            JLabel leer = new JLabel("Noch keine Bewerbungsdaten vorhanden.");
            leer.setBounds(25, 65, 300, 25);
            listeBox.add(leer);
        }
    }
}