package Service;

import Entity.Absence;
import Entity.ContactTeacher;
import Entity.Diploma;
import Entity.User;
import IService.IServiceContactTeacher;
import Utils.DataBase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ServiceContactTeacher implements IServiceContactTeacher {
    ObservableList<ContactTeacher> data = FXCollections.observableArrayList();

    @Override
    public String NumberOfNotShowed() throws SQLException {
        try {
            Connection cnx = DataBase.getInstance().getConnexion();
            String sql= "SELECT count(*) AS nb FROM `reclamationteacher` WHERE receiverType='Admin' and showed='0'";
            PreparedStatement stat= cnx.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();
            while (rs.next()) {
                return rs.getString(1);
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return "0";
    }

    @Override
    public List<ContactTeacher> readAll(int i) throws SQLException {
        try {
            Connection cnx = DataBase.getInstance().getConnexion();
            String sql;
            if(i==2){
                sql= "SELECT * FROM reclamationteacher INNER JOIN user ON user.id = reclamationteacher.id_Teacher WHERE receiverType='Admin' ORDER BY `dateCreation` DESC";
            }
            else {
                sql= "SELECT * FROM reclamationteacher INNER JOIN user ON user.id = reclamationteacher.id_Teacher WHERE receiverType='Admin' and showed='"+i+"' ORDER BY `dateCreation` DESC";

            }
            PreparedStatement stat= cnx.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();
            while (rs.next()){
                if(!rs.getString("file").equals("")){
                    data.add(new ContactTeacher(rs.getInt("id"),rs.getString("receiverType"),rs.getString("subject"),rs.getString("dateCreation"),"File(s) - "+rs.getString("message"),rs.getString("rely"),rs.getString("file"),rs.getString("firstName")+' '+rs.getString("lastName"),rs.getInt("showed")));

                }
                else {
                    data.add(new ContactTeacher(rs.getInt("id"),rs.getString("receiverType"),rs.getString("subject"),rs.getString("dateCreation"),rs.getString("message"),rs.getString("rely"),rs.getString("file"),rs.getString("firstName")+' '+rs.getString("lastName"),rs.getInt("showed")));

                }

            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return data;
    }







    @Override
    public String getReplies(int id) throws SQLException {
        try {
            Connection cnx = DataBase.getInstance().getConnexion();
            String sql;

            sql= "SELECT rely FROM reclamationteacher  WHERE id='"+id+"'";


            PreparedStatement stat= cnx.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();
            while (rs.next()){


                return rs.getString(1);

            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return "";
    }



    @Override
    public String readById(int id) throws SQLException {
        try {
            Connection cnx = DataBase.getInstance().getConnexion();
            String sql= "Select id_Teacher from reclamationteacher where id='"+id+"'";
            PreparedStatement stat= cnx.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();
            while (rs.next()){

return rs.getString(1);

            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return "Nooooo";
    }
    @Override
    public String getNameSender(int id) throws SQLException {


        try {
            Connection cnx = DataBase.getInstance().getConnexion();
            String sql;

            sql= "SELECT firstName ,lastName FROM user INNER JOIN reclamationteacher ON user.id = reclamationteacher.id_Teacher where user.id='"+readById(id)+"'";


            PreparedStatement stat= cnx.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();
            while (rs.next()){


                return rs.getString(1)+' '+rs.getString(2);
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public void addReply(String rp, int id) throws SQLException {
        Connection cnx = DataBase.getInstance().getConnexion();

        PreparedStatement ste=cnx.prepareStatement("UPDATE `reclamationteacher` SET `rely`='"+rp+"',`showed`='1' WHERE `id`='"+id+"'");

        ste.executeUpdate();
    }

    @Override
    public void addWarning(String id) throws SQLException {
        Connection cnx = DataBase.getInstance().getConnexion();

        PreparedStatement ste=cnx.prepareStatement("INSERT INTO `reclamationteacher` (`id`, `receiverType`, `subject`, `dateCreation`, `message`, `rely`, `file`, `id_Teacher`, `showed`) VALUES (NULL, 'Teacher', 'Absence Warning ⚠️ ', '2020-04-08', 'Hello wir , your Absences has passed the limt .', '', '', '"+id+"', '0');");

        ste.executeUpdate();
    }

    @Override
    public List<ContactTeacher> readSent(String id) throws SQLException {
        try {
            Connection cnx = DataBase.getInstance().getConnexion();
            String sql;


                sql= "SELECT * FROM reclamationteacher WHERE receiverType='Admin' and id_Teacher='"+id+"' ORDER BY `dateCreation` DESC";


            PreparedStatement stat= cnx.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();
            while (rs.next()){


                    data.add(new ContactTeacher(rs.getInt("id"),rs.getString("receiverType"),rs.getString("subject"),rs.getString("dateCreation"),rs.getString("message"),rs.getString("rely"),rs.getString("file"),rs.getString("id_Teacher"),rs.getInt("showed")));



            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return data;
    }


    @Override
    public List<ContactTeacher> readReplied(String id) throws SQLException {
        try {
            Connection cnx = DataBase.getInstance().getConnexion();
            String sql;


            sql= "SELECT * FROM reclamationteacher WHERE receiverType='Admin' and id_Teacher='"+id+"' and showed='1' ORDER BY `dateCreation` DESC";


            PreparedStatement stat= cnx.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();
            while (rs.next()){


                data.add(new ContactTeacher(rs.getInt("id"),rs.getString("receiverType"),rs.getString("subject"),rs.getString("dateCreation"),rs.getString("message"),rs.getString("rely"),rs.getString("file"),rs.getString("id_Teacher"),rs.getInt("showed")));



            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return data;
    }


    @Override
    public List<ContactTeacher> readReceived(String id) throws SQLException {
        try {
            Connection cnx = DataBase.getInstance().getConnexion();
            String sql;


            sql= "SELECT * FROM reclamationteacher WHERE receiverType='Teacher' and id_Teacher='"+id+"' ORDER BY `dateCreation` DESC";


            PreparedStatement stat= cnx.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();
            while (rs.next()){


                data.add(new ContactTeacher(rs.getInt("id"),rs.getString("receiverType"),rs.getString("subject"),rs.getString("dateCreation"),rs.getString("message"),rs.getString("rely"),rs.getString("file"),rs.getString("id_Teacher"),rs.getInt("showed")));



            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return data;
    }

    @Override
    public void sendMail(String id,String sub,String cont,String file) throws SQLException {
        Connection cnx = DataBase.getInstance().getConnexion();

        PreparedStatement ste=cnx.prepareStatement("INSERT INTO `reclamationteacher` (`id`, `receiverType`, `subject`, `dateCreation`, `message`, `rely`, `file`, `id_Teacher`, `showed`) VALUES (NULL, 'Admin', '"+sub+"', '2020-04-08', '"+cont+"', '', '"+file+"', '"+id+"', '0');");

        ste.executeUpdate();
    }

}
