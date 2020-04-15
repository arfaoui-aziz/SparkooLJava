package Service;

import Entity.Reclamation;
import IService.IServiceReclamation;
import Utils.DataBase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class ServiceReclamation implements IServiceReclamation {
    ObservableList<Reclamation> data = FXCollections.observableArrayList();
    private Connection cnx = DataBase.getInstance().getConnexion();
    private Statement ste;
    @Override
    public List<Reclamation> readAll() throws SQLException {
        try {
            Connection cnx = DataBase.getInstance().getConnexion();
            String sql= "SELECT * FROM `reclamationparent`";
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
            Connection cnx = DataBase.getInstance().getConnexion();
            String sql= "SELECT * FROM `reclamationparent` where `etat`="+e+"";
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
        PreparedStatement ste=cnx.prepareStatement("UPDATE `reclamationparent` SET `etat`='2',`reponse`='"+rp+"' WHERE `id`='"+id+"';");
        ste.executeUpdate();
    }

    public void RejClaim(int id) throws SQLException {
        PreparedStatement ste=cnx.prepareStatement("UPDATE `reclamationparent` SET `etat`='0' WHERE `id`='"+id+"';");
        ste.executeUpdate();
    }

    @Override
    public List<Reclamation> readRec(String id) throws SQLException {
        try {
            Connection cnx = DataBase.getInstance().getConnexion();
            String sql= "SELECT * FROM `reclamationparent` where `id_Parent`='"+id+"'";
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
    public void addClaim(String id,String type,String msg) throws SQLException {

    Date date = (Date) Calendar.getInstance().getTime();
    DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
    String strDate = dateFormat.format(date);



    PreparedStatement ste=cnx.prepareStatement("INSERT INTO `reclamationparent` (`id`, `type`, `datecree`, `message`, `etat`, `reponse`, `id_Parent`) VALUES (NULL, '"+type+"', '"+strDate+"', '"+msg+"', '0', '', '"+id+"');");
        ste.executeUpdate();
    }


}
