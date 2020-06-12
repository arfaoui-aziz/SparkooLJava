package GUI.back.Forum;

import GUI.back.Student.Students;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.IOException;

public class Forum {


    @FXML
    private VBox addstudentman;
    @FXML
    private VBox StudentsList;
    @FXML
    private Text lblName;

    @FXML
    private HBox gotoStudt;

    @FXML
    private Label logout;


    @FXML
    private void gotoStudent(MouseEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/GUI/back/Student/Students.fxml"));
        Parent root = loader.load();
        gotoStudt.getScene().setRoot(root);
        Students controller = loader.getController();
        controller.maindata(lblName.getText());
    }
    @FXML
    private void addmanu(MouseEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/GUI/back/Forum/Addsubject.fxml"));
        Parent root = loader.load();
        addstudentman.getScene().setRoot(root);
        addsubjectForum controller = loader.getController();
        controller.maindata(lblName.getText());
    }

    @FXML
    private void gotolist(MouseEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/GUI/back/Forum/ListForum.fxml"));
        Parent root = loader.load();
        StudentsList.getScene().setRoot(root);
        ForumList controller = loader.getController();
        controller.maindata(lblName.getText());

    }

    public void maindata(String UserN){
        lblName.setText(UserN);
        System.out.println(UserN);
    }

    @FXML
    private void logOut(MouseEvent event) throws IOException {
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("/GUI/login.fxml"));
        Parent root=fxml.load();
        logout.getScene().setRoot(root);
    }




}
