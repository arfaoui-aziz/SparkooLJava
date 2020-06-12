package IService;
import java.sql.SQLException;
import java.util.List;

public interface IServiceSubject<S> {
    void ajouter(S s) throws SQLException;
    List<S> AfficherSubject() throws SQLException ;
    void supprimer(int id) throws SQLException ;
    void update(S s,int id) throws SQLException ;
}
