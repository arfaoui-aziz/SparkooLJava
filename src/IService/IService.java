package IService;

import Entity.Event;

import javax.swing.text.html.parser.Entity;
import java.sql.SQLException;
import java.util.List;

public interface  IService<T> {
    void ajouter(T t) throws SQLException;
    boolean delete(int id) throws SQLException;
    void update(Event e, int id) throws SQLException;
    List<T> readAll() throws SQLException;
    List<T> SearchEvent(String nomEvent) throws SQLException;
    List<T> trier() throws SQLException;
    public T readID(T t) throws SQLException;

}
