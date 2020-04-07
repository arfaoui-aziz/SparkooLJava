package Service;

import Entity.Reclamation;
import Entity.User;
import IService.IServiceReclamation;
import IService.IServiceUser;
import com.company.Utils.DataBase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.List;

public class ServiceReclamation implements IServiceReclamation {
    ObservableList<Reclamation> data = FXCollections.observableArrayList();
    private Connection cnx = DataBase.getInstance().getConnection();
    private Statement ste;
    @Override
    public List<Reclamation> readAll() throws SQLException {
        try {
            Connection cnx = DataBase.getInstance().getConnection();
            String sql= "SELECT * FROM `reclamation`";
            PreparedStatement stat= cnx.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();
            while (rs.next()){
                data.add(new Reclamation(rs.getInt("id"),rs.getString("type"),rs.getString("datecree"),rs.getString("message"),rs.getInt("etat"),rs.getInt("id_Parent"),rs.getString("reponse")));
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return data;
    }

    @Override
    public List<Reclamation> readByEtat(int e) throws SQLException {
        try {
            Connection cnx = DataBase.getInstance().getConnection();
            String sql= "SELECT * FROM `reclamation` where `etat`="+e+"";
            PreparedStatement stat= cnx.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();
            while (rs.next()){
                data.add(new Reclamation(rs.getInt("id"),rs.getString("type"),rs.getString("datecree"),rs.getString("message"),rs.getInt("etat"),rs.getInt("id_Parent"),rs.getString("reponse")));
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return data;
    }

    public void addReply(String rp,int id) throws SQLException {
        PreparedStatement ste=cnx.prepareStatement("UPDATE `reclamation` SET `etat`='2',`reponse`='"+rp+"' WHERE `id`='"+id+"';");
        ste.executeUpdate();
    }

    public void RejClaim(int id) throws SQLException {
        PreparedStatement ste=cnx.prepareStatement("UPDATE `reclamation` SET `etat`='0' WHERE `id`='"+id+"';");
        ste.executeUpdate();
    }
}
