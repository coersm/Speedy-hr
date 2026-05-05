package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DashboardGUI extends JFrame {

    public DashboardGUI() {

        setTitle("HighSpeed HR");
        setSize(950, 600);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Color dunkel = new Color(35, 35, 35);
        Color blau = new Color(40, 85, 160);
        Color hell = new Color(245, 245, 245);

        JPanel oben = new JPanel();
        oben.setLayout(null);
        oben.setBounds(0, 0, 950, 70);
        oben.setBackground(dunkel);
        add(oben);

        JLabel titel = new JLabel("HighSpeed HR");
        titel.setBounds(25, 15, 300, 40);
        titel.setForeground(Color.WHITE);
        titel.setFont(new Font("Arial", Font.BOLD, 28));
        oben.add(titel);

        JPanel seite = new JPanel();
        seite.setLayout(null);
        seite.setBounds(0, 70, 170, 530);
        seite.setBackground(new Color(50, 50, 50));
        add(seite);

        JButton dashboardButton = new JButton("Dashboard");
        dashboardButton.setBounds(20, 30, 130, 35);
        seite.add(dashboardButton);

        JButton bewerbungButton = new JButton("Bewerbung");
        bewerbungButton.setBounds(20, 80, 130, 35);
        seite.add(bewerbungButton);

        JButton kuendigungButton = new JButton("Kündigung");
        kuendigungButton.setBounds(20, 130, 130, 35);
        seite.add(kuendigungButton);

        JButton aenderungButton = new JButton("Änderung");
        aenderungButton.setBounds(20, 180, 130, 35);
        seite.add(aenderungButton);

        JButton auswertungButton = new JButton("Auswertung");
        auswertungButton.setBounds(20, 230, 130, 35);
        seite.add(auswertungButton);

        JPanel inhalt = new JPanel();
        inhalt.setLayout(null);
        inhalt.setBounds(170, 70, 780, 530);
        inhalt.setBackground(hell);
        add(inhalt);

        JLabel ueberschrift = new JLabel("Dashboard");
        ueberschrift.setBounds(35, 25, 250, 40);
        ueberschrift.setFont(new Font("Arial", Font.BOLD, 26));
        inhalt.add(ueberschrift);

        JPanel karte1 = karte("Gesamt Mitarbeiter", "5", 40, 100);
        JPanel karte2 = karte("Aktive Bewerbungen", "0", 230, 100);
        JPanel karte3 = karte("Offene Kündigungen", "0", 420, 100);
        JPanel karte4 = karte("Auswertungen", "0", 610, 100);

        inhalt.add(karte1);
        inhalt.add(karte2);
        inhalt.add(karte3);
        inhalt.add(karte4);

        JLabel info = new JLabel("Willkommen im HighSpeed HR-System");
        info.setBounds(40, 230, 500, 30);
        info.setFont(new Font("Arial", Font.PLAIN, 18));
        inhalt.add(info);

        bewerbungButton.addActionListener(e -> {
            // später: new BewerbungenGUI();
        });

        kuendigungButton.addActionListener(e -> {
            // später: new KuendigungenGUI();
        });

        setVisible(true);
    }

    private JPanel karte(String titel, String wert, int x, int y) {

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(x, y, 160, 90);
        panel.setBackground(Color.WHITE);

        JLabel titelLabel = new JLabel(titel);
        titelLabel.setBounds(15, 10, 140, 25);
        titelLabel.setFont(new Font("Arial", Font.PLAIN, 13));
        panel.add(titelLabel);

        JLabel wertLabel = new JLabel(wert);
        wertLabel.setBounds(15, 38, 120, 40);
        wertLabel.setFont(new Font("Arial", Font.BOLD, 30));
        panel.add(wertLabel);

        return panel;
    }
}