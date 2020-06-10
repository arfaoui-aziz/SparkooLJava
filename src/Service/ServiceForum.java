package Service;

import Entity.Commentaire;
import Entity.Forum;
import Entity.User;
import Utils.DataBase;
import Utils.bcrypt;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServiceForum {

    private Connection cnx = DataBase.getInstance().getCnx();
    private Statement ste;


    public boolean addsub(String auteur_id, String title, String type, String subject) throws SQLException {


        Statement ste = cnx.createStatement();
        int random = (int)(Math.random() * 9999999 + 1);
        Date currentday = new Date();
        SimpleDateFormat timeformat = new SimpleDateFormat("MM/dd/yyyy");
        ste.executeUpdate("insert into forum (id, auteur_id, title, type, subject, dateajout, etat, solved, nbreponse) "+" VALUES ('"+random+"', '"+auteur_id+"', '"+title+"', '"+type+"', '"+subject+"', '"+timeformat.format(currentday)+"', '"+1+"', '"+0+"', '"+0+"') ;");
        return true;
    }


    public boolean addsubfront(String auteur_id, String title, String type, String subject) throws SQLException {


        Statement ste = cnx.createStatement();
        int random = (int)(Math.random() * 9999999 + 1);
        Date currentday = new Date();
        SimpleDateFormat timeformat = new SimpleDateFormat("MM/dd/yyyy");
        ste.executeUpdate("insert into forum (id, auteur_id, title, type, subject, dateajout, etat, solved, nbreponse) "+" VALUES ('"+random+"', '"+auteur_id+"', '"+title+"', '"+type+"', '"+subject+"', '"+timeformat.format(currentday)+"', '"+0+"', '"+0+"', '"+0+"') ;");
        return true;
    }


    ObservableList<Forum> data = FXCollections.observableArrayList();

    public List<Forum> ForumList() throws SQLException {
        try {
            Connection cnx = DataBase.getInstance().getCnx();
            String sql= "Select * from forum ";
            PreparedStatement stat= cnx.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();
            System.out.println(rs);
            while (rs.next()){
                Forum F =new Forum(rs.getInt("id"),rs.getString("auteur_id"),rs.getString("title"),rs.getString("type"),rs.getString("subject"),rs.getString("dateajout"),rs.getByte("etat"),rs.getByte("solved"),rs.getInt("nbreponse"));
                data.add(F);

            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return data;
    }

    public void updateForum(Forum f,int forum_id) throws SQLException {
        System.out.println(f);
        PreparedStatement ste=cnx.prepareStatement("UPDATE forum SET title= '" +f.getTitle()+ "',subject= '" +f.getSubject()+ "',type='"+f.getType()+"',etat='"+f.getEtat()+"',solved='"+f.getSolved()+"' WHERE id='"+forum_id+"' ;");
        ste.executeUpdate();
    }

    public void deletesubj(int id) throws SQLException {
        String rqt = "DELETE FROM `forum` WHERE id=?";
        PreparedStatement ste = cnx.prepareStatement(rqt);
        ste.setInt(1, id);
        ste.executeUpdate();
    }

    public List<Commentaire> Commentslist(int subject) throws SQLException {
        ObservableList<Commentaire> data1 = FXCollections.observableArrayList();
        try {
            Connection cnx = DataBase.getInstance().getCnx();
            String sql= "Select * from commentaire where subject='"+subject+"' ";
            PreparedStatement stat= cnx.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();
            System.out.println(rs);
            while (rs.next()){
                Commentaire C =new Commentaire(rs.getInt("id"),rs.getString("comentor_id"),rs.getInt("subject"),rs.getString("commentaire"),rs.getString("commentdate"));
                data1.add(C);

            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return data1;
    }

    public boolean like(String voter, int subjectvoted, byte status) throws SQLException {


        Statement ste = cnx.createStatement();
        int random = (int)(Math.random() * 9999999 + 1);
        ste.executeUpdate("insert into votes (id, voter, subjectvoted, status) "+" VALUES ('"+random+"', '"+voter+"', '"+subjectvoted+"', '"+status+"') ;");
        return true;
    }

    public int showlike(int subjectvoted) throws SQLException {
        Connection cnx = DataBase.getInstance().getCnx();
        String sql= " SELECT COUNT(voter) FROM votes  WHERE subjectvoted='"+subjectvoted+"' and status='"+0+"'";
        PreparedStatement stat= cnx.prepareStatement(sql);
        ResultSet rs = stat.executeQuery();

        while (rs.next()){
            return rs.getInt(1);
        }

        return 0;
    }

    public int voted(String voter , int subjectvoted) throws SQLException {
        Connection cnx = DataBase.getInstance().getCnx();
        String sql = " SELECT COUNT(voter) FROM votes  WHERE voter='" + voter + "' and subjectvoted='"+subjectvoted+"'";
        PreparedStatement stat = cnx.prepareStatement(sql);
        ResultSet rs = stat.executeQuery();

        while (rs.next()) {
            return rs.getInt(1);
        }

        return 0;
    }

    public int showstatus(int subjectvoted, String voter) throws SQLException {
        Connection cnx = DataBase.getInstance().getCnx();
        String sql= " SELECT status FROM votes  WHERE subjectvoted='"+subjectvoted+"' and voter='"+voter+"' ";
        PreparedStatement stat= cnx.prepareStatement(sql);
        ResultSet rs = stat.executeQuery();

        while (rs.next()){
            return rs.getInt("status");
        }

        return 0;
    }

    public void updatelike(int subjectvoted, String voter) throws SQLException {
        PreparedStatement ste=cnx.prepareStatement("UPDATE votes SET status='"+0+"' WHERE subjectvoted='"+subjectvoted+"' and voter='"+voter+"' ;");
        ste.executeUpdate();
    }




    public boolean dislike(String voter, int subjectvoted, byte status) throws SQLException {


        Statement ste = cnx.createStatement();
        int random = (int)(Math.random() * 9999999 + 1);
        ste.executeUpdate("insert into votes (id, voter, subjectvoted, status) "+" VALUES ('"+random+"', '"+voter+"', '"+subjectvoted+"', '"+status+"') ;");
        return true;
    }

    public int showdislike(int subjectvoted) throws SQLException {
        Connection cnx = DataBase.getInstance().getCnx();
        String sql= " SELECT COUNT(voter) FROM votes  WHERE subjectvoted='"+subjectvoted+"' and status='"+1+"'";
        PreparedStatement stat= cnx.prepareStatement(sql);
        ResultSet rs = stat.executeQuery();
        while (rs.next()){
            return rs.getInt(1);
        }
        return 0;
    }


    public void updatedislike(int subjectvoted, String voter) throws SQLException {
        PreparedStatement ste=cnx.prepareStatement("UPDATE votes SET status='"+1+"' WHERE subjectvoted='"+subjectvoted+"' and voter='"+voter+"' ;");
        ste.executeUpdate();
    }

    public boolean commentsubmit(String comentor_id, int subject, String commentaire) throws SQLException {

        Statement ste = cnx.createStatement();

        int random = (int)(Math.random() * 9999999 + 1);
        int newnbr = 0;
        Date currentday = new Date();
        SimpleDateFormat timeformat = new SimpleDateFormat("MM/dd/yyyy");
        ste.executeUpdate("insert into commentaire (id, comentor_id, subject, commentaire, commentdate) "+" VALUES ('"+random+"', '"+comentor_id+"', '"+subject+"', '"+commentaire+"', '"+timeformat+"') ;");
        String sql= "SELECT nbreponse FROM forum  WHERE id='"+subject+"' ";
        PreparedStatement stat= cnx.prepareStatement(sql);
        ResultSet rs = stat.executeQuery();
        while (rs.next()){
            newnbr = rs.getInt(1)+1;
        }
        PreparedStatement ste1 =cnx.prepareStatement("UPDATE Forum SET nbreponse='"+newnbr+"' WHERE id='"+subject+"';");
        ste1.executeUpdate();

       
        
        return true;
    }


    public void deletecomment(int id) throws SQLException {
        String rqt = "DELETE FROM `commentaire` WHERE id=?";
        PreparedStatement ste = cnx.prepareStatement(rqt);
        ste.setInt(1, id);
        ste.executeUpdate();
    }


    public void solved(int id) throws SQLException {
        PreparedStatement ste=cnx.prepareStatement("UPDATE forum SET solved= '" +1+ "'WHERE id='"+id+"' ;");
        ste.executeUpdate();
    }



}
