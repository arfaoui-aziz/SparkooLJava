package IService;

import java.sql.SQLException;
import java.util.List;

public interface  IService<T> {
    void ajouter(T t) throws SQLException;
    boolean delete(String name) throws SQLException;
    boolean update(String s1, String s2) throws SQLException;
    List<T> readAll() throws SQLException;
    List<T> SearchEvent(String nomEvent) throws SQLException;
}
