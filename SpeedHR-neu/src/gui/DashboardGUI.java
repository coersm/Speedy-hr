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

public class DashboardGUI extends JFrame {

    private int anzahlMitarbeiter = 0;
    private int anzahlBewerbungen = 0;
    private int anzahlKuendigungen = 0;
    private int anzahlAenderungen = 0;

    public DashboardGUI() {

        datenLaden();

        setTitle("HighSpeed HR");
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

        btnDashboard.setBackground(aktiv);

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

        JLabel titel = new JLabel("Dashboard");
        titel.setBounds(30, 12, 300, 35);
        titel.setFont(new Font("Arial", Font.BOLD, 26));
        titelBox.add(titel);

        JLabel untertitel = new JLabel("Übersicht der Personalabteilung");
        untertitel.setBounds(32, 45, 400, 25);
        untertitel.setFont(new Font("Arial", Font.PLAIN, 14));
        titelBox.add(untertitel);

        inhalt.add(statistikKarte("Mitarbeiter", anzahlMitarbeiter, 40, 100));
        inhalt.add(statistikKarte("Bewerbungen", anzahlBewerbungen, 240, 100));
        inhalt.add(statistikKarte("Kündigungen", anzahlKuendigungen, 440, 100));
        inhalt.add(statistikKarte("Änderungen", anzahlAenderungen, 640, 100));

        inhalt.add(leereKarte("Bewerbungen", 40, 230));
        inhalt.add(leereKarte("Kündigungen", 420, 230));
        inhalt.add(leereKarte("Änderungen", 40, 380));
        inhalt.add(leereKarte("Auswertungen", 420, 380));

        btnBewerbung.addActionListener(e -> {
            new BewerbungenGUI();
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

    private JPanel statistikKarte(String titel, int wert, int x, int y) {

        JPanel panel = new JPanel(null);
        panel.setBounds(x, y, 160, 90);
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createLineBorder(new Color(210, 210, 210)));

        JLabel titelLabel = new JLabel(titel);
        titelLabel.setBounds(15, 8, 140, 25);
        panel.add(titelLabel);

        JLabel wertLabel = new JLabel(String.valueOf(wert));
        wertLabel.setBounds(15, 32, 120, 35);
        wertLabel.setFont(new Font("Arial", Font.BOLD, 30));
        panel.add(wertLabel);

        return panel;
    }

    private JPanel leereKarte(String titel, int x, int y) {

        JPanel panel = new JPanel(null);
        panel.setBounds(x, y, 340, 120);
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createLineBorder(new Color(210, 210, 210)));

        JLabel titelLabel = new JLabel(titel);
        titelLabel.setBounds(20, 15, 250, 30);
        titelLabel.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(titelLabel);

        return panel;
    }

    private void datenLaden() {

        try {
            Connection conn = DBConnection.getConnection();

            anzahlMitarbeiter = zaehle(conn, "mitarbeiter");
            anzahlBewerbungen = zaehle(conn, "bewerbungen");
            anzahlKuendigungen = zaehle(conn, "kuendigungen");
            anzahlAenderungen = zaehle(conn, "aenderungen");

            conn.close();

        } catch (Exception e) {
            System.out.println("Dashboard-Daten konnten nicht geladen werden.");
        }
    }

    private int zaehle(Connection conn, String tabelle) {

        int anzahl = 0;

        try {
            String sql = "SELECT COUNT(*) FROM " + tabelle;
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                anzahl = rs.getInt(1);
            }

        } catch (Exception e) {
            anzahl = 0;
        }

        return anzahl;
    }
}