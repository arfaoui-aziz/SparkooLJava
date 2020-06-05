package GUI.back.Student;

import Entity.User;
import Service.ServiceUser;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class StudentDetails {

    @FXML
    private TextField showfn;

    @FXML
    private TextField showln;

    @FXML
    private TextField showgd;

    @FXML
    private TextField showjd;

    @FXML
    private TextField showad;

    @FXML
    private TextField showbg;

    @FXML
    private TextField showph ;

    @FXML
    private TextField showbd ;

    @FXML
    private TextField showpb ;

    @FXML
    private TextField showay ;

    @FXML
    private ImageView showim ;


    @FXML
    private Button enable;

    @FXML
    private HBox gotoTeacher;

    @FXML
    private HBox gotoStudt;
    @FXML
    private Label logout;

    @FXML
    private void gotoTeatcher(MouseEvent event) throws IOException {
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("../Users.fxml"));
        Parent root=fxml.load();
        gotoTeacher.getScene().setRoot(root);
    }

    @FXML
    private void logOut(MouseEvent event) throws IOException {
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("/sample/login.fxml"));
        Parent root=fxml.load();
        logout.getScene().setRoot(root);
    }

    @FXML
    private void gotoStudent(MouseEvent event) throws IOException {
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("Students.fxml"));
        Parent root=fxml.load();
        gotoStudt.getScene().setRoot(root);
    }

String id;




    public void maindata(User selectedItem){
        showfn.setText(selectedItem.getFirstName());
        showln.setText(selectedItem.getFirstName());
        showgd.setText(selectedItem.getGender());
         id = selectedItem.getId();

        if (selectedItem.getGender() == "Male") {
            showim.setImage(new Image("/Utils/male.png"));
        }
            showjd.setText(selectedItem.getJoiningDate());
        showad.setText(selectedItem.getAddress());
        showbg.setText(selectedItem.getBloodGroup());
        showph.setText(selectedItem.getPhone());
        showbd.setText(selectedItem.getBirthDay());
        showpb.setText(selectedItem.getPlaceofbirth());
        showay.setText(selectedItem.getAcademicyear());
    }

    @FXML
    private void activatedaccount(MouseEvent event) throws IOException, SQLException {
        ServiceUser usr = new ServiceUser();
        usr.enableStudent(id);
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("/GUI/back/Student/Verify.fxml"));
        Parent root=fxml.load();
        enable.getScene().setRoot(root);
    }
}
