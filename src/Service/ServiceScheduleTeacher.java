package Service;

import Entity.SheduleTeacher;
import Entity.User;
import IService.IServiceScheduleTeacher;
import Utils.DataBase;
import Utils.bcrypt;

import java.sql.*;
import java.util.List;

public class ServiceScheduleTeacher implements IServiceScheduleTeacher {

    private Connection cnx = DataBase.getInstance().getConnexion();
    private Statement ste;
    @Override
    public void addSession(String day,String s,String subj,String classe,String id) throws SQLException {
        try {
            String requeteInsert="";

                requeteInsert = "INSERT INTO `sheduleTeacher` (`id`, `day`, `subject`, `session`, `class`, `idTeacher`) VALUES (NULL, '"+day+"', '"+subj+"', '"+s+"', '"+classe+"', '"+id+"')";



            ste = cnx.createStatement();
            ste.executeUpdate(requeteInsert);


        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }


    @Override
    public SheduleTeacher read(String id,String day,String session) throws SQLException {

        try {
            Connection cnx = DataBase.getInstance().getConnexion();
            String sql= "SELECT subject,class FROM sheduleTeacher WHERE idTeacher='"+id+"' and day='"+day+"' and session='"+session+"'";



            PreparedStatement stat= cnx.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();
            while (rs.next()){
                return new SheduleTeacher(rs.getString(1),rs.getString(2));

            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return new SheduleTeacher("","");
    }
    @Override
    public void clear(String id) throws SQLException {
        String rqt = "DELETE FROM `sheduleTeacher` WHERE sheduleTeacher.idTeacher='"+id+"'";
        PreparedStatement ste = cnx.prepareStatement(rqt);
        ste.executeUpdate();
    }

}
