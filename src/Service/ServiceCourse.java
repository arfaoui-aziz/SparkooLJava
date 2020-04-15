package Service;

import Entity.Course;
import Entity.User;
import IService.IServiceCourse;
import Utils.DataBase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class ServiceCourse implements IServiceCourse {


    private Connection cnx = DataBase.getInstance().getConnexion();
    private Statement ste;
    ObservableList<Course> data = FXCollections.observableArrayList();

    @Override
    public void addCourse(Course  c) throws SQLException {
        try {
            String requeteInsert = "INSERT INTO `Course`(`id`, `name`, `description`, `path`) VALUES ('"+c.getId()+"','"+c.getName()+"','"+c.getDescription()+"','"+c.getPath()+"')";


            ste = cnx.createStatement();
            ste.executeUpdate(requeteInsert);


        } catch (SQLException ex) {
            System.err.println(ex.getMessage());

        }
    }
@Override
    public ObservableList<Course> readCourses(String spe) {
        try {
            Connection cnx = DataBase.getInstance().getConnexion();
            String sql= "SELECT * FROM `Course` WHERE `name`='"+spe+"'";
            PreparedStatement stat= cnx.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();
            while (rs.next()){
                data.add(new Course(rs.getString("name"),rs.getString("description"),rs.getString("path")));

            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return data;
    }
}
