package IService;

import java.sql.SQLException;
import java.util.List;

public interface IServiceUser<T> {
    int preauth(String mail,String pwd) throws SQLException;
    List<T> readAll() throws SQLException;
    void delete(String id) throws SQLException;


}
