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
                data.add(new User(rs.getString("id"),rs.getString("email"),rs.getString("firstName"),rs.getString("lastName"),rs.getString("gender"),rs.getString("address"),rs.getString("phone"),rs.getString("picture"),rs.getString("birthDay")));

            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return data;
    }

    @Override
    public void add(User u) throws SQLException {
        try {
            String requeteInsert = "INSERT INTO `user` (`id`, `username`, `username_canonical`, `email`, `email_canonical`, `enabled`, `salt`, `password`, `last_login`, `confirmation_token`, `password_requested_at`, `roles`, `firstName`, `lastName`, `gender`, `userType`, `joiningDate`, `address`, `phone`, `picture`, `bloodGroup`, `salaire`, `birthDay`, `occupation`, `classe_id`, `placeobirth`, `academicyear`) VALUES ('"+u.getId()+"', '" + u.getFirstName()+'.'+u.getLastName() + "', '" + u.getFirstName()+'.'+u.getLastName() + "', '"+u.getEmail()+"', '"+u.getEmail()+"', '1', NULL, '" + bcrypt.hashpw(u.getId(),bcrypt.gensalt()) + "', NULL, NULL, NULL, '', '"+u.getFirstName()+"', '"+u.getLastName()+"', '"+u.getGender()+"', 'Teacher', '', '"+u.getAddress()+"', '"+u.getPhone()+"', '"+u.getPicture()+"', NULL, NULL, '"+u.getBirthDay()+"', NULL, NULL, NULL, NULL);";


            ste = cnx.createStatement();
            ste.executeUpdate(requeteInsert);


        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }


    @Override
    public void delete(String id) throws SQLException {
        String rqt = "DELETE FROM `user` WHERE id=?";
        PreparedStatement ste = cnx.prepareStatement(rqt);
        ste.setString(1, id);
        ste.executeUpdate();
    }

    @Override
    public void update(User u, String id) throws SQLException {
        PreparedStatement ste=cnx.prepareStatement("UPDATE user SET id= '" +u.getId()+ "',firstName= '" +u.getFirstName()+ "',lastName='"+u.getLastName()+"',email='"+u.getEmail()+"',email_canonical='"+u.getEmail()+"',phone='"+u.getPhone()+"',address='"+u.getAddress()+"',birthDay='"+u.getBirthDay()+"',gender='"+u.getGender()+"',picture='"+u.getPicture()+"' WHERE id='"+id+"' ;");
        ste.executeUpdate();
    }
}
