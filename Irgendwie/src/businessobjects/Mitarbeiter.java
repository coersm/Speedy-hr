package businessobjects;

public class Mitarbeiter {
	private int mitarbeiter_id;
	private String name ;
	private String abteilung;
	private String position;
	
	public Mitarbeiter (int mitarbeiter_id, String name, String abteilung, String position) {
		this.mitarbeiter_id= mitarbeiter_id;
		this.name = name;
		this.abteilung= abteilung;
		this.position= position;
	}
	
	public int getMitarbeiter_id() {
		return mitarbeiter_id;
	}
	
	public void setMitarbeiter_id(int mitarbeiter_id) {
		this.mitarbeiter_id = mitarbeiter_id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAbteilung() {
		return abteilung;
	}
	
	public void setAbteilung(String abteilung) {
		this.abteilung = abteilung;
	}
	
	public String getPosition() {
		return position;
	}
	
	public void setPosition(String position) {
		this.position = position;
	}
	

}
