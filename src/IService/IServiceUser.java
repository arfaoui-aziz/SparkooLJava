package IService;

import Entity.User;

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
    User getActiveUser(String userN) throws SQLException ;
    void ModifyLogin(String id,String username,String pwd) throws SQLException ;

}
