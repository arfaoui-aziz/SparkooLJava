package IService;

import Entity.Absence;
import Entity.Delay;

import java.sql.SQLException;
import java.util.List;

public interface IServiceDelay {
    void addDelay(Delay d) throws SQLException;
    List<Delay> readByDate(String id,String d1,String d2) throws SQLException ;
    String NumberOfDelay(String id) throws SQLException ;



    }
