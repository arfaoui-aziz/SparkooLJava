package Service;

import Entity.User;
import IService.IServiceUser;
import Utils.DataBase;
import Utils.bcrypt;
import Utils.javaMailUtil;
import com.sun.jmx.snmp.SnmpStatusException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Observable;


public class ServiceUser implements IServiceUser {
    private Connection cnx = DataBase.getInstance().getCnx();
    private Statement ste;



    @Override
    public int login(String userN, String psw) throws SQLException {


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

    public int role(String userN, String psw) throws SQLException {


        Statement ste = cnx.createStatement();

        ResultSet rs = ste.executeQuery("SELECT * FROM user WHERE username='"+userN+"' ;");
        while (rs.next()) {
            String crypted = rs.getString(8);
            if (rs.getString("userType").equals("Administrator"))
                return 1;
            else if (rs.getString("userType").equals("Etudiant"))
                return 2;
        }
        return 0;
    }

    public boolean signup(String userN, String LastN, String emailU, String placeofbirthU, String phoneU, String dateofbirthU, String bloodgroupU, String academicyearU, String adressU, String genderU) throws SQLException {


        Statement ste = cnx.createStatement();
String usernameU= userN+LastN;
        Date currentday = new Date();
        String salt= bcrypt.gensalt(12);
        String password = bcrypt.hashpw(usernameU,salt);
        System.out.println(password);
    SimpleDateFormat timeformat = new SimpleDateFormat("MM/dd/yyyy");
        System.out.println(timeformat.format(currentday));
         ste.executeUpdate("insert into user (id, username, username_canonical, email, email_canonical, enabled, password, firstName, lastName, gender, userType, joiningDate, address, birthDay, phone, placeobirth, academicyear) "+" VALUES ('"+usernameU+"', '"+usernameU+"', '"+usernameU+"', '"+emailU+"', '"+emailU+"', '"+0+"', '"+password+"', '"+userN+"', '"+LastN+"', '"+genderU+"', '"+"Etudiant"+"', '"+timeformat.format(currentday)+"', '"+adressU+"','"+dateofbirthU+"','"+phoneU+"', '"+placeofbirthU+"', '"+academicyearU+"') ;");

        return true;
    }

    ObservableList<User> data = FXCollections.observableArrayList();


    public List<User> StudentsList() throws SQLException {
        try {
            Connection cnx = DataBase.getInstance().getCnx();
            String sql= "Select * from user where userType='"+"Etudiant"+"'";
            PreparedStatement stat= cnx.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();
            System.out.println(rs);
            while (rs.next()){
                User u=new User(rs.getString("email"),rs.getByte("enabled"),rs.getString("firstName"),rs.getString("lastName"),rs.getString("address"),rs.getString("phone"),rs.getString("bloodGroup"));
                u.setId(rs.getString("id"));
                u.setAcademicyear(rs.getString("academicyear"));
                u.setClasse("classe_id");
                data.add(u);

            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return data;
    }


    public List<User> Unverif() throws SQLException {
        try {
            Connection cnx = DataBase.getInstance().getCnx();
            String sql= "Select * from user where userType='"+"Etudiant"+"'"+"and enabled='"+"0"+"'";
            PreparedStatement stat= cnx.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();
            System.out.println(rs);
            while (rs.next()){
                User user = new User(rs.getString("email"),rs.getByte("enabled"),rs.getString("firstName"),rs.getString("lastName"),rs.getString("address"),rs.getString("phone"),rs.getString("bloodGroup"));
               user.setId(rs.getString("id"));
               user.setUsername(rs.getString("username"));
                user.setGender(rs.getString("gender"));
                user.setJoiningDate(rs.getString("joiningDate"));
                user.setBirthDay(rs.getString("birthDay"));
                user.setPlaceofbirth("placeobirth");
                user.setAcademicyear("academicyear");
                data.add(user);

            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return data;
    }


    public void deleteStudent(String id) throws SQLException {
        String rqt = "DELETE FROM `user` WHERE id=?";
        PreparedStatement ste = cnx.prepareStatement(rqt);
        ste.setString(1, id);
        ste.executeUpdate();
    }

    public void updateStudent(User u, String id) throws SQLException {
        PreparedStatement ste=cnx.prepareStatement("UPDATE user SET firstName= '" +u.getFirstName()+ "',lastName= '" +u.getLastName()+ "',email='"+u.getEmail()+"',address='"+u.getAddress()+"',phone='"+u.getPhone()+"',bloodGroup='"+u.getBloodGroup()+"',enabled='"+u.getEnabled()+"' WHERE id='"+id+"' ;");
        System.out.println(ste);
        System.out.println(ste.executeUpdate()+" nb update");

    }

    public void enableStudent(String id) throws SQLException {
        PreparedStatement ste=cnx.prepareStatement("UPDATE user SET enabled='"+1+"' WHERE id='"+id+"' ;");
        ste.executeUpdate();

    }
    public void assignStudent(int classe_id, String id_Student) throws SQLException {
        PreparedStatement ste=cnx.prepareStatement("UPDATE user SET classe_id='"+classe_id+"' WHERE id='"+id_Student+"' ;");
        ste.executeUpdate();
    }

    public int getold(String id) throws SQLException {
        Connection cnx = DataBase.getInstance().getCnx();
        String sql= "Select classe_id from user  WHERE id='"+id+"'";
        PreparedStatement stat= cnx.prepareStatement(sql);
        ResultSet rs = stat.executeQuery();
        System.out.println(rs);
        while (rs.next()){
            return rs.getInt("classe_id");
        }

        return 0;
    }

    public User getStud(String username) throws SQLException {

        try {
            Connection cnx = DataBase.getInstance().getCnx();
            String sql= "Select * from user  WHERE username='"+username+"'";
            PreparedStatement stat= cnx.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();
            while (rs.next()){
                User user = new User(rs.getString("email"),rs.getByte("enabled"),rs.getString("firstName"),rs.getString("lastName"),rs.getString("address"),rs.getString("phone"),rs.getString("bloodGroup"));
                user.setId(rs.getString("id"));
                user.setUsername(rs.getString("username"));
                user.setGender(rs.getString("gender"));
                user.setJoiningDate(rs.getString("joiningDate"));
                user.setBirthDay(rs.getString("birthDay"));
                user.setPlaceofbirth("placeobirth");
                user.setAcademicyear("academicyear");
                return user;
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return null;
    }


    public void updateacademic(String id, String academicyear) throws SQLException {
        PreparedStatement ste=cnx.prepareStatement("UPDATE user SET academicyear='"+academicyear+"'  WHERE id='"+id+"' ;");
        ste.executeUpdate();
        System.out.println(academicyear);
        System.out.println(ste);
        System.out.println("academic year updated");

    }



    }

