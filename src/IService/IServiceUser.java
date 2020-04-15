package IService;

import Entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
    List<User> readDangerZone() throws SQLException ;
    User getUserByLogin(String userN, String psw) throws SQLException ;
    void changePassword(String pass, String id) throws SQLException ;
    ArrayList<User> readInPDF(String s) throws SQLException ;
    //Parents (Youssef)
int NumberOfParent() throws SQLException ;
String getnomU(String id) throws SQLException ;
List<User> readAllParents() throws SQLException ;
void addParent(User u) throws SQLException ;
   String getChildName(String id) throws SQLException ;












    }
