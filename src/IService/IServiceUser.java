package IService;

import Entity.User;

import java.sql.SQLException;
import java.util.List;

public interface IServiceUser<T> {
    int preauth(String userN, String psw) throws SQLException;
    List<T> readAll() throws SQLException;
    void delete(String id) throws SQLException;
    void add(User u) throws SQLException ;
    void update(User u,String id) throws SQLException ;
    int NumberOfParent() throws SQLException ;
    String getnomU(String id) throws SQLException ;



    }
