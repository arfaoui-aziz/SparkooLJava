package IService;

import Entity.SheduleTeacher;

import java.sql.SQLException;

public interface IServiceScheduleTeacher {

    void addSession(String day,String s,String subj,String classe,String id) throws SQLException ;
    SheduleTeacher read(String id, String day, String session) throws SQLException ;
    void clear(String id) throws SQLException ;


    }
