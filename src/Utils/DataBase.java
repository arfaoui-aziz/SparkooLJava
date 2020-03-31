package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {
    private static DataBase instance;
    private Connection cnx;

    private final String URL = "jdbc:mysql://localhost:3306/sparkool?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
    //?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC
   /* SET @@global.time_zone = '+00:00';
      SET @@session.time_zone = '+00:00';
with the following sql statements check if the values were set:
SELECT @@global.time_zone, @@session.time_zone;*/

    private final String LOGIN = "root";
    private final String PASSWORD = "";

    private DataBase() {
        try {
            cnx = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            System.out.println("Conncting !");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public static DataBase getInstance() {
        if (instance == null) {
            instance = new DataBase();
        }
        return instance;
    }

    public Connection getCnx() {
        return cnx;
    }
}
