package Service;

import Entity.User;
import IService.IServiceUser;
import Utils.DataBase;
import Utils.bcrypt;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceUser implements IServiceUser<User> {
    private Connection cnx = DataBase.getInstance().getCnx();
    private Statement ste;


    @Override
    public void ajouter(User u) throws SQLException{
        try {
          // String requeteInsert = "INSERT INTO user (id,username,email,enabled,password,roles,firstName,lastName,gender,userType,joiningDate,address,phone,salaire,birthDay) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            String requeteInsert = "INSERT INTO `sparkool`.`user` (`id`, `username`,`username_canonical` ,`email`, `email_canonical`, `enabled`, `password`, `roles`, `firstName`, `lastName`, `gender`, `userType`, `joiningDate`, `address`, `phone`, `salaire`, `birthDay`) VALUES ( '" + u.getId() + "', '" + u.getFirstName()+'.'+u.getLastName() + "' , '" + u.getFirstName()+'.'+u.getLastName() + "' , '" + u.getEmail() + "', '" + u.getEmail() + "',1, '" + bcrypt.hashpw(u.getId(),bcrypt.gensalt()) + "', '" + u.getRoles() + "', '" + u.getFirstName() + "', '" + u.getLastName() + "', '" + u.getGender() +"','" + u.getUserType() +"','"+u.getJoiningDate()+"', '"+ u.getAddress()+"','"+ u.getPhone()+"','"+ u.getSalaire()+"','"+ u.getDateOfBirth()+"');";


            ste = cnx.createStatement();
            ste.executeUpdate(requeteInsert);


        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public int login(String userN, String psw) throws SQLException {


        Statement ste = cnx.createStatement();


        ResultSet rs = ste.executeQuery("SELECT * FROM user WHERE username='"+userN+"' ;");
        while (rs.next()) {
            String crypted = rs.getString(8);
            String UserType = rs.getString(16);
            if (bcrypt.checkpw(psw,crypted)) {
                if(UserType.equals("Administrator")){
                    return 3;
                } else return 1;
            }else return 2;
        }

        return 0;
    }

    @Override
    public List<User> AfficherUser() throws SQLException {
        ObservableList<User> UserData = FXCollections.observableArrayList();
        String readUsers = "Select * from `user` ";
        PreparedStatement pst= cnx.prepareStatement(readUsers);
        ResultSet rs = pst.executeQuery();
        while (rs.next()){
            UserData.add(new User(rs.getString("id") ,rs.getString("username"),rs.getString("firstName"),rs.getString("lastName"),rs.getString("gender"),rs.getString("address"),rs.getString("phone"),rs.getString("email")));
        }
        return UserData;
    }

    @Override
    public void supprimer(String id) throws SQLException {
        String requeteDelete = "DELETE FROM `user` WHERE id=?";
        PreparedStatement pst = cnx.prepareStatement(requeteDelete);
        pst.setString(1, id);
        pst.executeUpdate();
    }

    @Override
    public void update(User u, String id) throws SQLException {
        PreparedStatement pst=cnx.prepareStatement("UPDATE user SET firstName= '" +u.getFirstName()+ "',lastName='"+u.getLastName()+"',roles='"+u.getRoles()+"',email='"+u.getEmail()+"',email_canonical='"+u.getEmail()+"',userType='"+u.getUserType()+"',phone='"+u.getPhone()+"',address='"+u.getAddress()+"',salaire='"+u.getSalaire()+"',birthDay='"+u.getDateOfBirth()+"',gender='"+u.getGender()+"' WHERE id='"+id+"' ;");
        pst.executeUpdate();
        /*String requeteUpdate = "UPDATE user SET nom= '" + u.getId() + "', '"u.getFirstName()+'.'+u.getLastName()"' ,'"u.getFirstName()+'.'+u.getLastName()"' ,'"u.getEmail()"', '"u.getEmail()"',1,'"bcrypt.hashpw(u.getId(),bcrypt.gensalt())"', '"u.getRoles()"', '" + u.getFirstName()"', '"u.getLastName()"', '"u.getGender()"','"u.getUserType() "','"u.getJoiningDate()"', '" u.getAddress()"','" u.getPhone()"','" u.getSalaire()"','" u.getDateOfBirth()"' ;";
        PreparedStatement pst = cnx.prepareStatement(requeteUpdate);
        pst.executeUpdate();*/
    }

    @Override
    public User getActiveUser(String userN) throws SQLException {
        try {

            String sql= "Select * from user where username='"+userN+"'";
            PreparedStatement stat= cnx.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();
            while (rs.next()){
                return new User(rs.getString("id"),rs.getString("username"),rs.getString("firstName"),rs.getString("lastName"),rs.getString("gender"),rs.getString("roles"),rs.getString("userType"),rs.getString("birthDay"),rs.getString("joiningDate"),rs.getString("email"),rs.getString("password"),rs.getString("phone"),rs.getString("address"));

            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return null;


    }
    @Override
    public int checkEmail(String Email) throws SQLException {
        Statement ste = cnx.createStatement();

        ResultSet rs = ste.executeQuery("SELECT * FROM user WHERE email='"+Email+"' ;");
        while (rs.next()) {
            return rs.getInt(19);

        }

        return 0;
    }
    @Override
    public void ResetPassword(String Email, String pwd) throws SQLException {
        PreparedStatement pst=cnx.prepareStatement("UPDATE user SET password ='"+bcrypt.hashpw(pwd,bcrypt.gensalt())+"' WHERE email='"+Email+"' ;");
        pst.executeUpdate();
    }




}

