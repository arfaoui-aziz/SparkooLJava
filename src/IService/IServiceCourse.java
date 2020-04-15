package IService;

import Entity.Course;
import Entity.User;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public interface IServiceCourse {
    void addCourse(Course c) throws SQLException ;
    ObservableList<Course> readCourses(String spe) ;


    }
