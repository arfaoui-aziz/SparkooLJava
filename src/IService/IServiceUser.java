package IService;

import java.sql.SQLException;
import java.util.List;

public interface IServiceUser<U> {
    void ajouter(U u) throws SQLException ;
    int login(String mail , String pwd) throws SQLException ;
    List<U> AfficherUser() throws SQLException ;
}
