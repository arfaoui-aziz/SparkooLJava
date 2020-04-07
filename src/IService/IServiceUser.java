package IService;

import Entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface IServiceUser<T> {
    int preauth(String mail,String pwd) throws SQLException;
    List<T> readAll() throws SQLException;
    void add(User u) throws SQLException ;
    void delete(String id) throws SQLException;
    void update(User u,String id) throws SQLException ;
    User readById(String id) throws SQLException;
    int NumberOfTeachers() throws SQLException ;
    ResultSet StatSexM() throws SQLException ;






    }
