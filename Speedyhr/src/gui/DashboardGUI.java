package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DashboardGUI extends JFrame {

    public DashboardGUI() {

        setTitle("HighSpeed HR");
        setSize(1000, 620);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Color dunkel = new Color(25, 25, 25);
        Color sidebar = new Color(35, 35, 35);
        Color hell = new Color(245, 245, 245);
        Color grau = new Color(230, 230, 230);

        JPanel kopf = new JPanel();
        kopf.setLayout(null);
        kopf.setBounds(0, 0, 1000, 70);
        kopf.setBackground(dunkel);
        add(kopf);

        JLabel logo = new JLabel("HighSpeed HR");
        logo.setBounds(25, 15, 300, 40);
        logo.setForeground(Color.WHITE);
        logo.setFont(new Font("Arial", Font.BOLD, 28));
        kopf.add(logo);

        JLabel kreis1 = new JLabel("○");
        kreis1.setBounds(860, 12, 35, 35);
        kreis1.setForeground(Color.WHITE);
        kreis1.setFont(new Font("Arial", Font.BOLD, 34));
        kopf.add(kreis1);

        JLabel kreis2 = new JLabel("○");
        kreis2.setBounds(900, 12, 35, 35);
        kreis2.setForeground(Color.WHITE);
        kreis2.setFont(new Font("Arial", Font.BOLD, 34));
        kopf.add(kreis2);

        JLabel kreis3 = new JLabel("○");
        kreis3.setBounds(940, 12, 35, 35);
        kreis3.setForeground(Color.WHITE);
        kreis3.setFont(new Font("Arial", Font.BOLD, 34));
        kopf.add(kreis3);

        JPanel seite = new JPanel();
        seite.setLayout(null);
        seite.setBounds(0, 70, 170, 550);
        seite.setBackground(sidebar);
        add(seite);

        JButton btnDashboard = menuButton("Dashboard", 30);
        JButton btnBewerbung = menuButton("Bewerbung", 85);
        JButton btnKuendigung = menuButton("Kündigung", 140);
        JButton btnAenderung = menuButton("Änderung", 195);
        JButton btnAuswertung = menuButton("Auswertung", 250);

        btnDashboard.setBackground(grau);
        btnDashboard.setForeground(Color.BLACK);

        seite.add(btnDashboard);
        seite.add(btnBewerbung);
        seite.add(btnKuendigung);
        seite.add(btnAenderung);
        seite.add(btnAuswertung);

        JLabel userIcon = new JLabel("👤");
        userIcon.setBounds(55, 455, 60, 60);
        userIcon.setForeground(Color.WHITE);
        userIcon.setFont(new Font("Arial", Font.BOLD, 42));
        seite.add(userIcon);

        JPanel inhalt = new JPanel();
        inhalt.setLayout(null);
        inhalt.setBounds(170, 70, 830, 550);
        inhalt.setBackground(hell);
        add(inhalt);

        JPanel titelBox = new JPanel();
        titelBox.setLayout(null);
        titelBox.setBounds(0, 0, 830, 80);
        titelBox.setBackground(Color.WHITE);
        titelBox.setBorder(BorderFactory.createLineBorder(new Color(210, 210, 210)));
        inhalt.add(titelBox);

        JLabel titel = new JLabel("Dashboard");
        titel.setBounds(30, 20, 300, 40);
        titel.setFont(new Font("Arial", Font.BOLD, 26));
        titelBox.add(titel);

        JPanel karte1 = karte("Gesamt Mitarbeiter", "5", 40, 120);
        JPanel karte2 = karte("Bewerbungen", "0", 240, 120);
        JPanel karte3 = karte("Kündigungen", "0", 440, 120);
        JPanel karte4 = karte("Änderungen", "0", 640, 120);

        inhalt.add(karte1);
        inhalt.add(karte2);
        inhalt.add(karte3);
        inhalt.add(karte4);

        JPanel infoBox = new JPanel();
        infoBox.setLayout(null);
        infoBox.setBounds(40, 250, 740, 180);
        infoBox.setBackground(Color.WHITE);
        infoBox.setBorder(BorderFactory.createLineBorder(new Color(210, 210, 210)));
        inhalt.add(infoBox);

        JLabel infoTitel = new JLabel("Willkommen im HighSpeed HR-System");
        infoTitel.setBounds(25, 20, 500, 30);
        infoTitel.setFont(new Font("Arial", Font.BOLD, 20));
        infoBox.add(infoTitel);

        JLabel infoText = new JLabel("Bitte wählen Sie links einen Bereich aus.");
        infoText.setBounds(25, 65, 500, 30);
        infoText.setFont(new Font("Arial", Font.PLAIN, 16));
        infoBox.add(infoText);

        btnBewerbung.addActionListener(e -> {
        });

        btnKuendigung.addActionListener(e -> {
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

    private JPanel karte(String titel, String wert, int x, int y) {

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(x, y, 160, 90);
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createLineBorder(new Color(210, 210, 210)));

        JLabel titelLabel = new JLabel(titel);
        titelLabel.setBounds(15, 10, 140, 25);
        titelLabel.setFont(new Font("Arial", Font.PLAIN, 13));
        panel.add(titelLabel);

        JLabel wertLabel = new JLabel(wert);
        wertLabel.setBounds(15, 40, 120, 35);
        wertLabel.setFont(new Font("Arial", Font.BOLD, 30));
        wertLabel.setForeground(Color.BLACK);
        panel.add(wertLabel);

        return panel;
    }
}