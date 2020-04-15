package Service;

import Entity.ContactTeacher;
import Entity.Mark;
import Entity.User;
import IService.IServiceMarks;
import Utils.DataBase;
import Utils.bcrypt;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.List;

public class ServiceMarks implements IServiceMarks {
    ObservableList<Mark> data = FXCollections.observableArrayList();


    @Override
    public List<Mark> readAll(String id) throws SQLException {
        try {
            Connection cnx = DataBase.getInstance().getConnexion();
            String sql= "SELECT * FROM mark INNER JOIN parent_eleve on mark.id_Student=parent_eleve.id_eleve WHERE parent_eleve.id_parent='"+id+"'";
            PreparedStatement stat= cnx.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();
            while (rs.next()){
                data.add(new Mark(rs.getInt("id"),rs.getString("subject"),rs.getDouble("cc"),rs.getDouble("exam"),rs.getString("note"),rs.getString("id_Student"),rs.getString("id_Teacher")));

            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return data;
    }
    ObservableList<User> data1 = FXCollections.observableArrayList();
    @Override
    public List<User> readNotMarked()throws SQLException{
        try {
            Connection cnx = DataBase.getInstance().getConnexion();
            String sql= "SELECT * FROM user WHERE id NOT IN (SELECT id_Student FROM mark where `mark`.id_Teacher='32980000') and user.userType='Student'";
            PreparedStatement stat= cnx.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();
            while (rs.next()){
                data1.add(new User(rs.getString("id"),rs.getString("email"),rs.getString("firstName"),rs.getString("lastName"),rs.getString("gender"),rs.getString("address"),rs.getString("phone"),rs.getString("picture"),rs.getString("birthDay")));

            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return data1;
    }

    @Override
    public void addMark(Mark m) throws SQLException {
        try {
            Connection cnx = DataBase.getInstance().getConnexion();
            Statement ste;
            String requeteInsert = "INSERT INTO `mark`(`id`, `subject`, `cc`, `exam`, `note`, `id_Student`, `id_Teacher`) VALUES (NULL ,'"+m.getSubject()+"','"+m.getCc()+"','"+m.getExam()+"','"+m.getNote()+"','"+m.getId_Student()+"','"+m.getId_Teacher()+"')";
            ste = cnx.createStatement();
            ste.executeUpdate(requeteInsert);



        } catch (SQLException ex) {
            System.err.println(ex.getMessage());

        }

    }

}
