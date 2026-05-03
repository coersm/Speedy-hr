package businessobjects;

public class Bewerber {
private String name;
private String 	email;
private String position;
private int telefon;
private String status;
private String eingangsdatum;
private String interviewdatum;
private String zustaendigerVorgesetzter;
public Bewerber(String name, String email, String position, int telefon, String status, String eingangsdatum, String interviewdatum, String zustaendigerVorgesetzte) {
	this.name= name;
	this.email= email;
	this.position = position;
	this.telefon= telefon;
	this.status= status;
	this.eingangsdatum = eingangsdatum;
	this.interviewdatum = interviewdatum;
	this.zustaendigerVorgesetzter=  zustaendigerVorgesetzte;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPosition() {
	return position;
}
public void setPosition(String position) {
	this.position = position;
}
public int getTelefon() {
	return telefon;
}
public void setTelefon(int telefon) {
	this.telefon = telefon;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getEingangsdatum() {
	return eingangsdatum;
}
public void setEingangsdatum(String eingangsdatum) {
	this.eingangsdatum = eingangsdatum;
}
public String getInterviewdatum() {
	return interviewdatum;
}
public void setInterviewdatum(String interviewdatum) {
	this.interviewdatum = interviewdatum;
}
public String getZustaendigerVorgesetzter() {
	return zustaendigerVorgesetzter;
}
public void setZustaendigerVorgesetzter(String zustaendigerVorgesetzter) {
	this.zustaendigerVorgesetzter = zustaendigerVorgesetzter;
}

}
