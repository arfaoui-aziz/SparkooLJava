package Service;

import IService.IService;
import java.sql.SQLException;
import java.util.List;
import java.sql.*;
import Utils.DataBase;
import java.util.ArrayList;

import Entity.Event;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ServiceEvent implements IService<Event> {
    private Connection con;
    private Statement ste;


    public ServiceEvent() {
        con = DataBase.getInstance().getCnx();

    }

    public void ajouter(Event e) throws SQLException
    {
        PreparedStatement pre= this.con.prepareStatement("INSERT INTO `sparkool`.`event` ( `nomEvent`, `typeEvent`, `description`,`dateEvent`, `placeEvent`,`nbParticipants`, `theme`,`destination`, `award`,`budget`,`price`) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
        pre.setString(1, e.getNomEvent());
        pre.setString(2, e.getTypeEvent());
        pre.setString(3, e.getDescription());
        pre.setString(4, e.getDateEvent());
        pre.setString(5, e.getPlaceEvent());
        pre.setInt(6, e.getNbParticipants());
        pre.setString(7, e.getTheme());
        pre.setString(8, e.getDestination());
        pre.setFloat(9, e.getAward());
        pre.setFloat(10, e.getBudget());
        pre.setFloat(11, e.getPrice());
        pre.executeUpdate();
    }



    @Override
    public boolean delete(String nomevenement) throws SQLException {
        PreparedStatement pre = this.con.prepareStatement("DELETE FROM `sparkool`.`event` WHERE nomEvent=? ;");
        pre.setString(1, nomevenement );
        if (pre.executeUpdate() != 0) {
            System.out.println("event Deleted");
            return true;
        } else {
            System.out.println("nom evenement not found!!!");
            return false;
        }
    }

    @Override
    public boolean update(String nomevenement, String Type ) throws SQLException {
        PreparedStatement pre = this.con.prepareStatement("UPDATE `sparkool`.`event` SET typeEvent = ? WHERE nomEvent=? ;");
        pre.setString(1, Type);
        pre.setString(2, nomevenement);
        if (pre.executeUpdate() != 0) {
            System.out.println("event Updated");
            return true;
        } else {
            System.out.println("nom evenement not found!!!");
            return false;
        }
    }

    public boolean updateDescrip(String nomevenement, String Descrip ) throws SQLException {
        PreparedStatement pre = this.con.prepareStatement("UPDATE `sparkool`.`event` SET description = ? WHERE nomEvent=? ;");
        pre.setString(1, Descrip);
        pre.setString(2, nomevenement);
        if (pre.executeUpdate() != 0) {
            System.out.println("event Updated");
            return true;
        } else {
            System.out.println("nom evenement not found!!!");
            return false;
        }
    }

    public boolean updateDate(String nomevenement, String date ) throws SQLException {
        PreparedStatement pre = this.con.prepareStatement("UPDATE `sparkool`.`event` SET dateEvent = ? WHERE nomEvent=? ;");
        pre.setString(1, date);
        pre.setString(2, nomevenement);
        if (pre.executeUpdate() != 0) {
            System.out.println("event Updated");
            return true;
        } else {
            System.out.println("nom evenement not found!!!");
            return false;
        }
    }

    public boolean updatePlace(String nomevenement, String place ) throws SQLException {
        PreparedStatement pre = this.con.prepareStatement("UPDATE `sparkool`.`event` SET placeEvent = ? WHERE nomEvent=? ;");
        pre.setString(1, place);
        pre.setString(2, nomevenement);
        if (pre.executeUpdate() != 0) {
            System.out.println("event Updated");
            return true;
        } else {
            System.out.println("nom evenement not found!!!");
            return false;
        }
    }

    public boolean updateNB(String nomevenement, int nb ) throws SQLException {
        PreparedStatement pre = this.con.prepareStatement("UPDATE `sparkool`.`event` SET nbParticipants = ? WHERE nomEvent=? ;");
        pre.setInt(1, nb);
        pre.setString(2, nomevenement);
        if (pre.executeUpdate() != 0) {
            System.out.println("event Updated");
            return true;
        } else {
            System.out.println("nom evenement not found!!!");
            return false;
        }
    }

    public boolean updateTheme(String nomevenement, String theme ) throws SQLException {
        PreparedStatement pre = this.con.prepareStatement("UPDATE `sparkool`.`event` SET theme = ? WHERE nomEvent=? ;");
        pre.setString(1, theme);
        pre.setString(2, nomevenement);
        if (pre.executeUpdate() != 0) {
            System.out.println("event Updated");
            return true;
        } else {
            System.out.println("nom evenement not found!!!");
            return false;
        }
    }

    public boolean updateDestination(String nomevenement, String destination ) throws SQLException {
        PreparedStatement pre = this.con.prepareStatement("UPDATE `sparkool`.`event` SET destination = ? WHERE nomEvent=? ;");
        pre.setString(1, destination);
        pre.setString(2, nomevenement);
        if (pre.executeUpdate() != 0) {
            System.out.println("event Updated");
            return true;
        } else {
            System.out.println("nom evenement not found!!!");
            return false;
        }
    }

    public boolean updateAward(String nomevenement, float award ) throws SQLException {
        PreparedStatement pre = this.con.prepareStatement("UPDATE `sparkool`.`event` SET award = ? WHERE nomEvent=? ;");
        pre.setFloat(1, award);
        pre.setString(2, nomevenement);
        if (pre.executeUpdate() != 0) {
            System.out.println("event Updated");
            return true;
        } else {
            System.out.println("nom evenement not found!!!");
            return false;
        }
    }
    public boolean updateBudget(String nomevenement, float budget ) throws SQLException {
        PreparedStatement pre = this.con.prepareStatement("UPDATE `sparkool`.`event` SET budget = ? WHERE nomEvent=? ;");
        pre.setFloat(1, budget);
        pre.setString(2, nomevenement);
        if (pre.executeUpdate() != 0) {
            System.out.println("event Updated");
            return true;
        } else {
            System.out.println("nom evenement not found!!!");
            return false;
        }
    }

    public boolean updatePrice(String nomevenement, float prix ) throws SQLException {
        PreparedStatement pre = this.con.prepareStatement("UPDATE `sparkool`.`event` SET price = ? WHERE nomEvent=? ;");
        pre.setFloat(1, prix);
        pre.setString(2, nomevenement);
        if (pre.executeUpdate() != 0) {
            System.out.println("event Updated");
            return true;
        } else {
            System.out.println("nom evenement not found!!!");
            return false;
        }
    }


   /* @Override
    public List<Event> readAll() throws SQLException {
        List<Event> arr=new ArrayList<>();
        ste=con.createStatement();
        ResultSet rs=ste.executeQuery("select * from event");
        while (rs.next()) {
            int id=rs.getInt(1);
            String nomEvent=rs.getString("nomEvent");
            String typeEvent=rs.getString(3);
            String description=rs.getString(4);
            String dateEvent=rs.getString(5);
            String placeEvent=rs.getString(6);
            int nbParticipants=rs.getInt(7);
            String theme=rs.getString(8);
            String destination=rs.getString(9);
            float award=rs.getFloat(10);
            float budget=rs.getFloat(11);
            float price=rs.getFloat(12);

            Event e=new Event(id,nomEvent, typeEvent, description, dateEvent,placeEvent,nbParticipants, theme,destination,award,budget, price);
            arr.add(e);
        }
        return arr;
    }*/


    ObservableList<Event> data = FXCollections.observableArrayList();

    @Override
    public List<Event> readAll() throws SQLException {
        try {
            Connection cnx = DataBase.getInstance().getCnx();
            String sql= "select * from event";
            PreparedStatement stat= cnx.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();
            while (rs.next()){
                data.add(new Event(rs.getInt("id"),rs.getString("nomEvent"),rs.getString("typeEvent"),rs.getString("description"),rs.getString("dateEvent"),rs.getString("placeEvent"),rs.getInt("nbParticipants"),rs.getString("theme"),rs.getString("destination"),rs.getFloat("award"),rs.getFloat("budget"),rs.getFloat("price")));

            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return data;
    }

    @Override
    public List<Event> SearchEvent(String nomE) throws SQLException {
        List<Event> arr=new ArrayList<>();
        ste=con.createStatement();
        ResultSet rs=ste.executeQuery("select * from event where nomEvent = '"+nomE+"' ");
        while (rs.next()) {

            int id = rs.getInt(1);
            String nomEvent = rs.getString("nomEvent");
            String typeEvent = rs.getString(3);
            String description = rs.getString(4);
            String dateEvent = rs.getString(5);
            String placeEvent = rs.getString(6);
            int nbParticipants = rs.getInt(7);
            String theme = rs.getString(8);
            String destination = rs.getString(9);
            float award = rs.getFloat(10);
            float budget = rs.getFloat(11);
            float price = rs.getFloat(12);
            Event e = new Event(id, nomEvent, typeEvent, description, dateEvent, placeEvent, nbParticipants, theme, destination, award, budget, price);
            arr.add(e);
        }
        return arr;
    }









}