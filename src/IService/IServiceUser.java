package IService;

import java.sql.SQLException;
import java.util.List;

public interface IServiceUser<U> {
    void ajouter(U u) throws SQLException ;
    int login(String mail , String pwd) throws SQLException ;
    List<U> AfficherUser() throws SQLException ;
    void supprimer(String id) throws SQLException ;
    void update(U u,String id) throws SQLException ;
    void ResetPassword(String Email,String pwd) throws SQLException ;
    int checkEmail(String Email) throws SQLException ;

}
