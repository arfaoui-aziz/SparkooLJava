package IService;

import java.sql.SQLException;
import java.util.List;

public interface IServiceClasse<C> {
    void ajouter(C c) throws SQLException;
    List<C> AfficherClasse() throws SQLException ;
    void supprimer(int id) throws SQLException ;
    void update(C c,int id) throws SQLException ;
}
