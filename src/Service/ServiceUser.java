package Service;

import Entity.User;
import IService.IServiceUser;
import Utils.DataBase;
import Utils.bcrypt;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ServiceUser implements IServiceUser {

    private Connection cnx = DataBase.getInstance().getConnexion();
    private Statement ste;

    @Override
    public void addParent(User u) throws SQLException {
        try {

            String requeteInsert = " INSERT INTO `user` (`id`, `username`, `username_canonical`, `email`, `email_canonical`, `enabled`, `salt`, `password`, `last_login`, `confirmation_token`, `password_requested_at`, `roles`, `firstName`, `lastName`, `gender`, `userType`, `joiningDate`, `address`, `phone`, `picture`, `bloodGroup`, `salaire`, `birthDay`, `occupation`) VALUES ('"+u.getId()+"', '" + u.getFirstName()+'.'+u.getLastName() + "', '" + u.getFirstName()+'.'+u.getLastName() + "', '"+u.getEmail()+"', '"+u.getEmail()+"', '1', NULL, '" + bcrypt.hashpw(u.getId(),bcrypt.gensalt()) + "', NULL, NULL, NULL, '', '"+u.getFirstName()+"', '"+u.getLastName()+"', '"+u.getGender()+"', 'Parent', '', '"+u.getAddress()+"', '"+u.getPhone()+"', '/Users/amen/Documents/SparkoolGit/src/teacher2.png', NULL, NULL, '', '"+u.getOccupation()+"');\n";
            ste = cnx.createStatement();
            ste.executeUpdate(requeteInsert);
            System.out.println("aded"+u.getUsername());



        } catch (SQLException ex) {
            System.err.println(ex.getMessage());

            System.out.println("NOT aded"+u.getUsername());
        }

    }
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
    public List<User> readAllParents() throws SQLException {
        try {
            Connection cnx = DataBase.getInstance().getConnexion();
            String sql= "Select * from user where userType='"+"Parent"+"'";
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
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = new Date();
            String d= (dateFormat.format(date));

            String requeteInsert = "INSERT INTO `user` (`id`, `username`, `username_canonical`, `email`, `email_canonical`, `enabled`, `salt`, `password`, `last_login`, `confirmation_token`, `password_requested_at`, `roles`, `firstName`, `lastName`, `gender`, `userType`, `joiningDate`, `address`, `phone`, `picture`, `bloodGroup`, `salaire`, `birthDay`, `occupation`, `classe_id`, `placeobirth`, `academicyear`) VALUES ('"+u.getId()+"', '" + u.getFirstName()+'.'+u.getLastName() + "', '" + u.getFirstName()+'.'+u.getLastName() + "', '"+u.getEmail()+"', '"+u.getEmail()+"', '1', NULL, '" + bcrypt.hashpw(u.getId(),bcrypt.gensalt()) + "', NULL, NULL, NULL, '', '"+u.getFirstName()+"', '"+u.getLastName()+"', '"+u.getGender()+"', 'Teacher', '"+d+"', '"+u.getAddress()+"', '"+u.getPhone()+"', '"+u.getPicture()+"', NULL, NULL, '"+u.getBirthDay()+"', NULL, NULL, NULL, NULL);";


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

    @Override
    public void changePassword(String pass, String id) throws SQLException {
        PreparedStatement ste=cnx.prepareStatement("UPDATE user SET password='" + bcrypt.hashpw(pass,bcrypt.gensalt()) + "' WHERE id='"+id+"' ;");
        ste.executeUpdate();
    }

    @Override
    public User readById(String id) throws SQLException {
        try {
            Connection cnx = DataBase.getInstance().getConnexion();
            String sql= "Select * from user where id='"+id+"'";
            PreparedStatement stat= cnx.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();
            while (rs.next()){
                return new User(rs.getString("id"),rs.getString("email"),rs.getString("firstName"),rs.getString("lastName"),rs.getString("gender"),rs.getString("address"),rs.getString("phone"),rs.getString("picture"),rs.getString("birthDay"));

            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return null;
    }


    @Override
    public int NumberOfTeachers() throws SQLException {
        int i=0;
        try {
            Connection cnx = DataBase.getInstance().getConnexion();
            String sql= "SELECT * FROM user WHERE userType='Teacher'";
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
    public ResultSet StatSexM() throws SQLException {
        //To change body of generated methods, choose Tools | Templates.ste=con.createStatement();
        ResultSet rs=ste.executeQuery("select count(*) from `user` where gender='Male'");
        return rs;
    }

    @Override
    public List<User> readDangerZone() throws SQLException {
        try {
            Connection cnx = DataBase.getInstance().getConnexion();
            String sql= "SELECT DISTINCT user.id,user.firstName,user.lastName,user.phone ,COUNT(*) AS nbAbsence FROM user INNER JOIN absent_teacher ON user.id = absent_teacher.id_Teacher GROUP BY absent_teacher.id_Teacher ";
            PreparedStatement stat= cnx.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();
            while (rs.next()){
                if (Integer.parseInt(rs.getString(5)) > 5) {
                    data.add(new User(rs.getString("id"),rs.getString("firstName"), rs.getString("lastName"), rs.getString("phone")));
                }
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return data;
    }


    @Override
    public User getUserByLogin(String userN, String psw) throws SQLException {
        try {
            Connection cnx = DataBase.getInstance().getConnexion();
            String sql= "Select * from user where username='"+userN+"'";
            PreparedStatement stat= cnx.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();
            while (rs.next()){
                return new User(rs.getString("id"),rs.getString("username"),rs.getString("firstName"),rs.getString("lastName"),rs.getString("userType"),rs.getString("picture"),rs.getString("password"));

            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return null;


    }


    //Parent (Youssef)
    @Override
    public int NumberOfParent() throws SQLException {
        int i=0;
        try {
            Connection cnx = DataBase.getInstance().getConnexion();
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
            Connection cnx = DataBase.getInstance().getConnexion();
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


    @Override
    public String getChildName(String id) throws SQLException {

        try {
            Connection cnx = DataBase.getInstance().getConnexion();
            String sql= "SELECT user.firstName, user.lastName FROM user INNER JOIN parent_eleve ON user.id= parent_eleve.id_eleve WHERE parent_eleve.id_parent='"+id+"'";
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

    @Override
    public ArrayList<User> readInPDF(String year) throws SQLException {
        ArrayList<User> list = new ArrayList<User>();
        try {
            Connection cnx = DataBase.getInstance().getConnexion();
            String sql= "SELECT * FROM user WHERE joiningDate LIKE '"+year+"%' AND userType='Teacher'";
            PreparedStatement stat= cnx.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();
            while (rs.next()){
                list.add(new User(rs.getString("id"),rs.getString("email"),rs.getString("firstName"),rs.getString("lastName"),rs.getString("gender"),rs.getString("address"),rs.getString("phone"),rs.getString("picture"),rs.getString("birthDay")));
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;
    }
}
