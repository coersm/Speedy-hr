package model;

public class Bewerber extends Person {

    private String position;
    private String status;
    private String eingangsdatum;
    private String interviewdatum;

    public Bewerber(String name, String email, String telefon, String position,
                    String status, String eingangsdatum, String interviewdatum) {

        super(name, email, telefon);

        this.position = position;
        this.status = status;
        this.eingangsdatum = eingangsdatum;
        this.interviewdatum = interviewdatum;
    }

    public String getPosition() {
        return position;
    }

    public String getStatus() {
        return status;
    }

    public String getEingangsdatum() {
        return eingangsdatum;
    }

    public String getInterviewdatum() {
        return interviewdatum;
    }
}