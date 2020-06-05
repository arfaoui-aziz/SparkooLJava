package Service;


import Entity.Classe;
import Utils.DataBase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class ServiceClasse {
    private Connection cnx = DataBase.getInstance().getCnx();
    private Statement ste;

    ObservableList<Classe> data = FXCollections.observableArrayList();
    public ObservableList<Classe> ClassList() throws SQLException {

        try {
            Connection cnx = DataBase.getInstance().getCnx();
            String sql= "Select * from classe where class_nbr != 0";
            PreparedStatement stat= cnx.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();
            System.out.println(rs);
            while (rs.next()){
                Classe classe =new Classe(rs.getInt("class_id"),rs.getString("class_name"),rs.getInt("class_nbr"));
                data.add(classe);

            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return data;
    }

    public int getNumber(String class_name) throws SQLException {
        Connection cnx = DataBase.getInstance().getCnx();
        String sql= "Select * from classe  WHERE class_name='"+class_name+"'";
        PreparedStatement stat= cnx.prepareStatement(sql);
        ResultSet rs = stat.executeQuery();
        System.out.println(rs);
        while (rs.next()){
            return rs.getInt("class_nbr");
        }

        return 0;
    }

    public void updatebr(int class_nbrr, String class_name) throws SQLException {
        PreparedStatement ste=cnx.prepareStatement("UPDATE classe SET class_nbr='"+class_nbrr+"' WHERE class_name='"+class_name+"' ;");
        ste.executeUpdate();
    }


    public int getclass_id(String class_name) throws SQLException {
        Connection cnx = DataBase.getInstance().getCnx();
        String sql= "Select * from classe  WHERE class_name='"+class_name+"'";
        PreparedStatement stat= cnx.prepareStatement(sql);
        ResultSet rs = stat.executeQuery();
        System.out.println(rs);
        while (rs.next()){
            return rs.getInt("class_id");
        }

        return 0;
    }

    public String getclass_name(int class_id) throws SQLException {
        Connection cnx = DataBase.getInstance().getCnx();
        String sql= "Select * from classe  WHERE class_id='"+class_id+"'";
        PreparedStatement stat= cnx.prepareStatement(sql);
        ResultSet rs = stat.executeQuery();
        System.out.println(rs);
        while (rs.next()){
            return rs.getString("class_name");
        }
        return "nothing found";
    }


}
