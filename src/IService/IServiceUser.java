package IService;

import java.sql.SQLException;

public interface IServiceUser<U> {
    public void ajouter(U u) ;
    int login(String mail , String pwd) throws SQLException ;
}
