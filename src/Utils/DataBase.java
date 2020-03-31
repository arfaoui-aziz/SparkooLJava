package Utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase
{
    private static DataBase instance;
    private Connection cnx;
    private final String URL = "jdbc:mysql://localhost:8889/Sparkool";
    private final String LOGIN = "root";
    private final String PASSWORD = "123";
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
    public Connection getConnexion() {
        return cnx;
    }
}
