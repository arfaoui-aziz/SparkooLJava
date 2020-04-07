package IService;

import Entity.Reclamation;

import java.sql.SQLException;
import java.util.List;

public interface IServiceReclamation {
    List<Reclamation> readAll() throws SQLException ;
    List<Reclamation> readByEtat(int e) throws SQLException ;
    void addReply(String rp,int id) throws SQLException ;
    void RejClaim(int id) throws SQLException ;

}
