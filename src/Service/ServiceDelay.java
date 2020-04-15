package Service;

import Entity.Absence;
import Entity.Delay;
import Entity.User;
import IService.IServiceDelay;
import Utils.DataBase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.List;

public class ServiceDelay implements IServiceDelay {
    private Connection cnx = DataBase.getInstance().getConnexion();
    private Statement ste;
    @Override
    public void addDelay(Delay d) throws SQLException {
        try {
            String requeteInsert = "INSERT INTO `delay_teacher` (`id`, `duree`, `jour`, `id_Teacher`) VALUES (NULL, '"+d.getDuree()+"', '"+d.getJour()+"', '"+d.getId_Teacher()+"');";


            ste = cnx.createStatement();
            ste.executeUpdate(requeteInsert);


        } catch (SQLException ex) {
            System.err.println(ex.getMessage());

        }
    }

    @Override
    public List<Delay> readByDate(String id,String d1,String d2) throws SQLException {
        ObservableList<Delay> data = FXCollections.observableArrayList();

        try {
            Connection cnx = DataBase.getInstance().getConnexion();
            String sql= "Select * from `delay_teacher` where `id_Teacher`='"+id+"' and `jour` between '"+d1+"' and '"+d2+"' ";
            PreparedStatement stat= cnx.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();
            while (rs.next()){
                data.add(new Delay(rs.getInt("duree"),rs.getString("jour"),rs.getString("id_Teacher")));

            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return data;
    }


    @Override
    public String NumberOfDelay(String id) throws SQLException {
        try {
            Connection cnx = DataBase.getInstance().getConnexion();
            String sql= "SELECT count(*) FROM delay_teacher WHERE id_Teacher='"+id+"'";
            PreparedStatement stat= cnx.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();
            while (rs.next()) {
                return rs.getString(1);
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return "0";
    }
}
