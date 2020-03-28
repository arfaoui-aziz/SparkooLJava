package Service;

import IService.IServiceUser;
import Utils.DataBase;
import Utils.bcrypt;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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





    }

