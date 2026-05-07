package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static final String URL =
            "jdbc:mysql://3.69.96.96:80/db3";

    private static final String USER =
            "db3";

    private static final String PASSWORD =
            "!db3.winf26?SS3";

    public static Connection getConnection() {

        try {

            Connection conn =
                    DriverManager.getConnection(
                            URL,
                            USER,
                            PASSWORD
                    );

            System.out.println("Verbindung erfolgreich!");

            return conn;

        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }
    }
}