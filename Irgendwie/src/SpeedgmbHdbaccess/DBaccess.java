package SpeedgmbHdbaccess;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBaccess {
	

	    public static void main(String[] args) {

	        System.out.println("MySQL Connect Example V2 AWS");

	        // Die folgenden Konstanten könnten auch in ein Property-File
	        // ausgelagert werden.

	        Connection conn = null;

	        String url = "jdbc:mysql://3.69.96.96:80/";
	        String dbName = "db3"; // sollte ersetzt werden

	        String driver = "com.mysql.cj.jdbc.Driver";
	        String userName = "db3"; // sollte ersetzt werden

	        String password = "!db3.winf26?SS3"; // hier kann auch direkt das eigene PW angegeben werden

	        try {

	            Class.forName(driver);
	            conn = DriverManager
	                    .getConnection(url + dbName, userName, password);
	            System.out.println("Connected to the database");

	            Statement stmt = conn.createStatement();
	            ResultSet rs;

	            rs = stmt.executeQuery("SELECT mitarbeiterid, name, abteilung, position FROM mitarbeiter");

	            while (rs.next()) {
	                int mitarbeiterid = rs.getInt("mitarbeiterid");
	                String name = rs.getString("name");
	                String abteilung = rs.getString("abteilung");
	                String position = rs.getString("position");
	                System.out.println("mitarbeiterid: " + mitarbeiterid + " Nachname: " + name + " abteilung: " + abteilung + " position: " + position);
	            }

	            conn.close();
	            System.out.println("Disconnected from database");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	    }
	}


