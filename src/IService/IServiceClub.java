package IService;
import Entity.Club;
import javax.swing.text.html.parser.Entity;
import java.sql.SQLException;
import java.util.List;

public interface IServiceClub<T> {
    void ajouter(T t) throws SQLException;
    boolean delete(int id) throws SQLException;
    void update(Club e, int id) throws SQLException;
    List<T> readAll() throws SQLException;
    List<T> SearchEvent(String nomEvent) throws SQLException;
}
