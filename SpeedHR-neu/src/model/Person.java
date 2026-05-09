package model;

public class Person {

    protected String name;
    protected String email;
    protected String telefon;

    public Person(String name, String email, String telefon) {
        this.name = name;
        this.email = email;
        this.telefon = telefon;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefon() {
        return telefon;
    }
}
