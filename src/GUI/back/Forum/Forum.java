package GUI.back.Forum;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class Forum {


    @FXML
    private VBox addstudentman;
    @FXML
    private VBox StudentsList;

    @FXML
    private HBox gotoStudt;
    @FXML
    private void gotoStudent(MouseEvent event) throws IOException {
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("Students.fxml"));
        Parent root=fxml.load();
        gotoStudt.getScene().setRoot(root);
    }
    @FXML
    private void addmanu(MouseEvent event) throws IOException {
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("Addsubject.fxml"));
        Parent root=fxml.load();
        addstudentman.getScene().setRoot(root);
    }

    @FXML
    private void gotolist(MouseEvent event) throws IOException {
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("ListForum.fxml"));
        Parent root=fxml.load();
        StudentsList.getScene().setRoot(root);
    }
}
