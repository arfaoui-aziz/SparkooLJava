package IService;

import java.sql.SQLException;

public interface IServiceUser {
    int login(String mail, String pwd) throws SQLException;
}
