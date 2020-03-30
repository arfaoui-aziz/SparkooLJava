package Service;

import Entity.User;
import IService.IServiceUser;
import Utils.DataBase;
import Utils.bcrypt;

import java.sql.*;

public class ServiceUser implements IServiceUser<User> {
    private Connection cnx = DataBase.getInstance().getCnx();
    private Statement ste;


    @Override
    public void ajouter(User u) {
        try {
          // String requeteInsert = "INSERT INTO user (id,username,email,enabled,password,roles,firstName,lastName,gender,userType,joiningDate,address,phone,salaire,birthDay) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            String requeteInsert = "INSERT INTO `sparkool`.`user` (`id`, `username`,`username_canonical` ,`email`, `email_canonical`, `enabled`, `password`, `roles`, `firstName`, `lastName`, `gender`, `userType`, `joiningDate`, `address`, `phone`, `salaire`, `birthDay`) VALUES ( '" + u.getId() + "', '" + u.getFirstName()+'.'+u.getLastName() + "' , '" + u.getFirstName()+'.'+u.getLastName() + "' , '" + u.getEmail() + "', '" + u.getEmail() + "',1, '" + bcrypt.hashpw(u.getId(),bcrypt.gensalt()) + "', '" + u.getRoles() + "', '" + u.getFirstName() + "', '" + u.getLastName() + "', '" + u.getGender() +"','" + u.getUserType() +"','"+u.getJoiningDate()+"', '"+ u.getAddress()+"','"+ u.getPhone()+"','"+ u.getSalaire()+"','"+ u.getDateOfBirth()+"');";


            ste = cnx.createStatement();
            ste.executeUpdate(requeteInsert);
            System.out.println("User ajoutée !");

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
            if (bcrypt.checkpw(psw,crypted))
                return 1;
            else return 2;
            }

        return 0;
        }





    }

