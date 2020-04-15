package IService;

import Entity.Mark;
import Entity.User;

import java.sql.SQLException;
import java.util.List;

public interface IServiceMarks {

    List<Mark> readAll(String id) throws SQLException ;
    List<User> readNotMarked()throws SQLException;
    void addMark(Mark m) throws SQLException ;


    }
