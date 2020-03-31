package Service;

import Entity.User;
import IService.IServiceUser;
import Utils.DataBase;
import Utils.bcrypt;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ServiceUser implements IServiceUser {

    private Connection cnx = DataBase.getInstance().getConnexion();
    private Statement ste;



    @Override
    public int preauth(String userN, String psw) throws SQLException {


        Statement ste = cnx.createStatement();


        ResultSet rs = ste.executeQuery("SELECT * FROM user WHERE username='"+userN+"' ;");
        while (rs.next()) {
            String crypted = rs.getString(8);
            if (bcrypt.checkpw(psw,crypted))
                return 1;
            else return 2;
        }

        return 0;


    }

    ObservableList<User> data = FXCollections.observableArrayList();

    @Override
    public List<User> readAll() throws SQLException {
        try {
            Connection cnx = DataBase.getInstance().getConnexion();
            String sql= "Select * from user where userType='"+"Teacher"+"'";
            PreparedStatement stat= cnx.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();
            while (rs.next()){
                data.add(new User(rs.getString("id"),rs.getString("email"),rs.getString("firstName"),rs.getString("lastName"),rs.getString("gender"),rs.getString("address"),rs.getString("phone"),rs.getString("picture")));

            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return data;
    }

    @Override
    public void delete(String id) throws SQLException {
        try {
            PreparedStatement pt = cnx.prepareStatement(" DELETE FROM `user` WHERE id = '" + id + "' ;");

            pt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);


        }
    }
}
