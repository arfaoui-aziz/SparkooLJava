package IService;

import Entity.Absence;
import Entity.Diploma;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IServiceAbsence {

    void addAbsence(Absence a) throws SQLException;
    ArrayList<String> showAbsences(String week, String uy,String id) throws SQLException ;
    String NumberOfAbsence(String id) throws SQLException ;


    }
