package Service;

import Entity.Club;
import IService.IService;
import java.sql.SQLException;
import java.util.List;
import java.sql.*;
import Utils.DataBase;
import java.util.ArrayList;


public class ServiceClub implements IService<Club> {

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
    public boolean delete(String nomclub) throws SQLException {

        PreparedStatement pre = this.con.prepareStatement("DELETE FROM `sparkool`.`club` WHERE nomClub=? ;");
        pre.setString(1, nomclub);
        if (pre.executeUpdate() != 0) {
            System.out.println("club Deleted");
            return true;
        } else {
            System.out.println("Club Name not found!!!");
            return false;
        }
    }

    @Override
    public boolean update(String nomclub, String act) throws SQLException {
        PreparedStatement pre = this.con.prepareStatement("UPDATE `sparkool`.`club` SET activity = ? WHERE nomClub=? ;");
        pre.setString(1, act);
        pre.setString(2, nomclub);
        if (pre.executeUpdate() != 0) {
            System.out.println("club Updated");
            return true;
        } else {
            System.out.println("Club Name not found!!!");
            return false;
        }
    }

    @Override
    public List<Club> readAll() throws SQLException {
        List<Club> arr = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from club");
        while (rs.next()) {
            int idClub = rs.getInt(1);
            String nomClub = rs.getString("nomClub");
            int members = rs.getInt(3);
            String activity = rs.getString(4);
            float budget = rs.getFloat(5);
            String dateCreation = rs.getString(6);


            Club e = new Club(idClub, nomClub, members, activity, budget, dateCreation);
            arr.add(e);
        }
        return arr;
    }


    @Override
    public List<Club> SearchEvent(String nomE) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}