package Service;

import Entity.User;
import IService.IServiceUser;
import Utils.bcrypt;
import com.company.Utils.DataBase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ServiceUser implements IServiceUser {

    private Connection cnx = DataBase.getInstance().getConnection();
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
    @Override
    public void update(User u, String id) throws SQLException {
        PreparedStatement ste=cnx.prepareStatement("UPDATE `user` SET `id` = '"+u.getId()+"', `email` = '"+u.getEmail()+"', `email_canonical` = '"+u.getEmail()+"', `firstName` = '"+u.getFirstName()+"', `lastName` = '"+u.getLastName()+"', `gender` = '"+u.getGender()+"', `address` = '"+u.getAddress()+"', `phone` = '"+u.getAddress()+"', `picture` = '"+u.getPicture()+"', `occupation` = '"+u.getOccupation()+"' WHERE `user`.`id` = '"+id+"';");
        ste.executeUpdate();

    }
    @Override
    public void add(User u) throws SQLException {
        try {
            String requeteInsert = " INSERT INTO `user` (`id`, `username`, `username_canonical`, `email`, `email_canonical`, `enabled`, `salt`, `password`, `last_login`, `confirmation_token`, `password_requested_at`, `roles`, `firstName`, `lastName`, `gender`, `userType`, `joiningDate`, `address`, `phone`, `picture`, `bloodGroup`, `salaire`, `birthDay`, `occupation`) VALUES ('"+u.getId()+"', '" + u.getFirstName()+'.'+u.getLastName() + "', '" + u.getFirstName()+'.'+u.getLastName() + "', '"+u.getEmail()+"', '"+u.getEmail()+"', '1', NULL, '" + bcrypt.hashpw(u.getId(),bcrypt.gensalt()) + "', NULL, NULL, NULL, '', '"+u.getFirstName()+"', '"+u.getLastName()+"', '"+u.getGender()+"', 'Parent', '', '"+u.getAddress()+"', '"+u.getPhone()+"', '"+u.getPicture()+"', NULL, NULL, '', '"+u.getOccupation()+"');\n";
            ste = cnx.createStatement();
            ste.executeUpdate(requeteInsert);


        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }

    ObservableList<User> data = FXCollections.observableArrayList();

    @Override
    public List<User> readAll() throws SQLException {
        try {
            Connection cnx = DataBase.getInstance().getConnection();
            String sql= "Select * from `user` where userType='"+"Parent"+"'";
            PreparedStatement stat= cnx.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();
            while (rs.next()){
                data.add(new User(rs.getString("id"),rs.getString("username"),rs.getString("email"),rs.getString("firstName"),rs.getString("lastName"),rs.getString("gender"),rs.getString("address"),rs.getString("phone"),rs.getString("picture"),rs.getString("occupation")));
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return data;
    }

    @Override
    public void delete(String id) throws SQLException {
        String rqt = "DELETE FROM `user` WHERE id=?";
        PreparedStatement ste = cnx.prepareStatement(rqt);
        ste.setString(1, id);
        ste.executeUpdate();
    }


    @Override
    public int NumberOfParent() throws SQLException {
        int i=0;
        try {
            Connection cnx = DataBase.getInstance().getConnection();
            String sql= "SELECT * FROM `user` WHERE userType='Parent'";
            PreparedStatement stat= cnx.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();
            while (rs.next()){
                i++;
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return i;
    }

    @Override
    public String getnomU(String id) throws SQLException {

        try {
            Connection cnx = DataBase.getInstance().getConnection();
            String sql= "SELECT firstName,lastName FROM `user` WHERE id='"+id+"'";
            PreparedStatement stat= cnx.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();
            while (rs.next()){
                return rs.getString("firstName")+' '+rs.getString("lastName");

            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return "NOO";
    }


}
