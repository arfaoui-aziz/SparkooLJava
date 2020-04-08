package IService;

import Entity.Diploma;
import Entity.User;

import java.sql.SQLException;

public interface IServiceDiploma {
    void addDiploma(Diploma d) throws SQLException;
    Diploma readById(String id) throws SQLException;
    void update(Diploma d,String id) throws SQLException ;


}