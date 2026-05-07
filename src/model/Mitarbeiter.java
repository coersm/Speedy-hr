package model;

public class Mitarbeiter extends Person {

    private int mitarbeiterid;
    private String abteilung;
    private String position;
    private String status;

    public Mitarbeiter(int mitarbeiterid, String name, String email, String telefon,
              String abteilung, String position, String status) {

        super(name, email, telefon);
        this.mitarbeiterid = mitarbeiterid;
        this.abteilung = abteilung;
        this.position = position;
        this.status = status;
    }

    public int getMitarbeiterid() {
        return mitarbeiterid;
    }

    public String getAbteilung() {
        return abteilung;
    }

    public String getPosition() {
        return position;
    }

    public String getStatus() {
        return status;
    }
}
