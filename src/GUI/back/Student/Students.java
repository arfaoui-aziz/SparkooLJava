package GUI.back.Student;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class Students {
    @FXML
    private Label logout;


    @FXML
    private HBox gotoTeacher;

    @FXML
    private HBox gotoStudt;

    @FXML
    private VBox addstudentman;

    @FXML
    private VBox StudentsList;

    @FXML
    private VBox classassignment;

    @FXML
    private VBox forum;

    @FXML
    private void gotoStudent(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/GUI/back/Student/Students.fxml"));
        Parent root = loader.load();
        gotoStudt.getScene().setRoot(root);
    }

    @FXML
    private void gotoTeatcher(MouseEvent event) throws IOException {

    }

    @FXML
    private void logOut(MouseEvent event) throws IOException {

    }

    @FXML
    private void gotoAddStudenMan(MouseEvent event) throws IOException {
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("/GUI/back/Student/addStudentManu.fxml"));
        Parent root=fxml.load();
        addstudentman.getScene().setRoot(root);
    }
    @FXML
    private void gotoStudentsList(MouseEvent event) throws IOException {
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("/GUI/back/Student/StudentsList.fxml"));
        Parent root=fxml.load();
        StudentsList.getScene().setRoot(root);
    }

    @FXML
    private void gotounverifyed(MouseEvent event) throws IOException {
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("/GUI/back/Student/Verify.fxml"));
        Parent root=fxml.load();
        StudentsList.getScene().setRoot(root);
    }

    @FXML
    private void gotoassign(MouseEvent event) throws IOException {
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("/GUI/back/Classe/AssignStudent.fxml"));
        Parent root=fxml.load();
        classassignment.getScene().setRoot(root);
    }

    @FXML
    private void gotoforum(MouseEvent event) throws IOException {
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("/GUI/back/Forum/Forum.fxml"));
        Parent root=fxml.load();
        forum.getScene().setRoot(root);
    }
}
