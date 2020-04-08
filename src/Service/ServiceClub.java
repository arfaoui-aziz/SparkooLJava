package Service;

import Entity.Club;
import IService.IServiceClub;
import java.sql.SQLException;
import java.util.List;
import java.sql.*;
import Utils.DataBase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;


public class ServiceClub implements IServiceClub<Club> {

    private Connection con;
    private Statement ste;


    public ServiceClub() {
        con = DataBase.getInstance().getCnx();

    }

    @Override
    public void ajouter(Club c) throws SQLException {

        PreparedStatement pre = this.con.prepareStatement("INSERT INTO `sparkool`.`club` ( `nomClub`, `members`, `activity`,`budget`,`dateCreation`) VALUES ( ?, ?, ?, ?, ? );");
        pre.setString(1, c.getNomClub());
        pre.setInt(2, c.getMembers());
        pre.setString(3, c.getActivity());
        pre.setFloat(4, c.getBudget());
        pre.setString(5, c.getDateCreation());

        pre.executeUpdate();
    }


    @Override
    public boolean delete(int idclub) throws SQLException {

        PreparedStatement pre = this.con.prepareStatement("DELETE FROM `sparkool`.`club` WHERE idClub=? ;");
        pre.setInt(1, idclub);
        if (pre.executeUpdate() != 0) {
            System.out.println("club Deleted");
            return true;
        } else {
            System.out.println("Club Name not found!!!");
            return false;
        }
    }

    @Override
        public void update(Club c, int id) throws SQLException {
        PreparedStatement pre = con.prepareStatement("UPDATE `sparkool`.`club` SET nomClub='" + c.getNomClub()+ "',members='" + c.getMembers() + "',activity='" + c.getActivity() + "',budget='" + c.getBudget() + "',dateCreation='" + c.getDateCreation() +  "' WHERE idClub='" + id + "' ;");
        pre.executeUpdate(); }

    ObservableList<Club> dataClub = FXCollections.observableArrayList();

    @Override
    public List<Club> readAll() throws SQLException {
        try {
            Connection cnx = DataBase.getInstance().getCnx();
            String sql= "select * from club";
            PreparedStatement stat= cnx.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();
            while (rs.next()){
                dataClub.add(new Club(rs.getInt("idClub"),rs.getString("nomClub"),rs.getInt("members"),rs.getString("activity"),rs.getFloat("budget"),rs.getString("dateCreation")));

            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return dataClub;
    }



    @Override
    public List<Club> SearchEvent(String nomE) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}