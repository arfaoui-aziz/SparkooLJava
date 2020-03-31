package IService;

import java.sql.SQLException;
import java.util.List;

public interface IServiceUser<T> {
    int preauth(String userN, String psw) throws SQLException;
    List<T> readAll() throws SQLException;

}
