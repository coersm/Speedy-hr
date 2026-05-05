package datenbank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class access {

   
   private static final String url = "jdbc:mysql://3.69.96.96:80/";
   private static final String dbName = "db3"; // sollte ersetzt werden

   private  static  final  String driver = "com.mysql.cj.jdbc.Driver";
   private static final  String userName = "db3"; // sollte ersetzt werden

   private static final  String password = "!db3.winf26?SS3"; // hier kann auch direkt das eigene PW angegeben werden
   private static Connection con;
   public static void connect() {
        try {

            Class.forName(driver);
            con = DriverManager.getConnection(url + dbName, userName, password);
           


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
   public static void disconnect() {
	   try {
		     con.close();
		     
	   } catch(Exception e ) {
		   e.printStackTrace();
	   }
   }
   public static boolean  anmeldung(String user, String pw) {
	   connect();
	try (
		PreparedStatement pstmt = con.prepareStatement("SELECT passwort FROM Nutzer WHERE name = ?")){
	pstmt.setString(1, user);
	System.out.println(pstmt);
	System.out.println(user);
	System.out.println(pw);
	ResultSet rs = pstmt.executeQuery();
	System.out.println(rs);
	if (rs.next()) {
        // Schritt 1: Name wurde gefunden.
        // Schritt 2: Passwort aus der DB holen und vergleichen
        String dbPasswort = rs.getString("passwort");
        if (dbPasswort.equals(pw)) {
            return true; // Alles okay
		}
	else {
        return false; // Passwort falsch
	}} else {
        return false; // Name nicht gefunden
    }}
	catch(Exception e ) {
		   e.printStackTrace();
		   return false;
	   }
   
}
}