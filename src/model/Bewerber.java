package model;

public class Bewerber extends Person {

    private String position;
    private String status;

    public Bewerber(String name, String email, String telefon, String position, String status) {
        super(name, email, telefon);
        this.position = position;
        this.status = status;
    }

    public String getPosition() {
        return position;
    }

    public String getStatus() {
        return status;
    }
}
