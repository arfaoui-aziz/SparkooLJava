package Utils;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DataBase {
    String url = "jdbc:mysql://localhost:3306/sparkool";
    String login = "root";
    String pwd = "";
    public  static DataBase instance;
    public Connection cnx;
    private DataBase() {
        try {
            cnx=DriverManager.getConnection(url, login, pwd);
            System.out.println("connexion etablie");
        } catch (SQLException ex) {
            System.out.println(ex);
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