package GUI.frontAdmin.Dark;


import Entity.User;

import Service.ServiceUser;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

public class accountInformation {

    @FXML
    private HBox btnTheme;

    @FXML
    private Circle photo;

    @FXML
    private Label lblName;

    @FXML
    private Label lblType;

    @FXML
    private Label lblSpeciality;

    @FXML
    private VBox btnHome;

    @FXML
    private VBox btnInfo;

    @FXML
    private VBox btnShedule;

    @FXML
    private VBox btnCourse;

    @FXML
    private VBox btnMessage;

    @FXML
    private VBox btnMarks;

    @FXML
    private VBox btnAccount;

    @FXML
    private VBox btnSignout;

    @FXML
    private ImageView btnVoice;

    @FXML
    private Label lblNom;

    @FXML
    private Label lblID;

    @FXML
    private Label lblGn;

    @FXML
    private Label lblPhone;

    @FXML
    private Label lblMail;

    @FXML
    private Label lblAdd;

    @FXML
    private Label lblUserN;

    @FXML
    private Label lblDOB;

    @FXML
    private VBox searchBox;

    @FXML
    private TextField inputWeek;

    @FXML
    private Label lblerror;

    @FXML
    private Button btnSearch;

    @FXML
    private VBox tableAb;

    @FXML
    private Label Nweek;

    @FXML
    private ImageView mon;

    @FXML
    private ImageView tue;

    @FXML
    private ImageView wed;

    @FXML
    private ImageView thu;

    @FXML
    private ImageView fr;

    @FXML
    private ImageView sa;

    User user ;



    @FXML
    void gotoAccount(MouseEvent event) throws IOException, SQLException {


    }

    @FXML
    void gotoCourses(MouseEvent event) throws IOException, SQLException {

    }
    @FXML
    void gotoHome(MouseEvent event) throws IOException, SQLException {
        FXMLLoader fxml = new FXMLLoader(getClass().getClassLoader().getResource("DarkHome.fxml"));
        Parent root = fxml.load();
        btnTheme.getScene().setRoot(root);
        DarkHome controller = fxml.getController();
        controller.initData(user);
    }

    @FXML
    void gotoInfo(MouseEvent event) throws IOException, SQLException {
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("accountInformation.fxml"));
        Parent root = fxml.load();
        btnInfo.getScene().setRoot(root);
        accountInformation controller = fxml.getController();
        controller.initData(user);
    }

    @FXML
    void gotoMarks(MouseEvent event) throws IOException, SQLException {



    }

    @FXML
    void gotoMessage(MouseEvent event) throws IOException, SQLException {




    }

    @FXML
    void gotoShedule(MouseEvent event) throws IOException, SQLException {

    }

    @FXML
    void gotoSignout(MouseEvent event) throws IOException {
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("../../login.fxml"));
        Parent root = fxml.load();
        btnSignout.getScene().setRoot(root);
    }




    @FXML
    void switchTheme(MouseEvent event) {

    }

    public void initData(User u) throws SQLException {

        lblName.setText(u.getFirstName()+' '+u.getLastName());
        lblNom.setText(u.getFirstName()+' '+u.getLastName());
        lblID.setText(u.getId());
        lblGn.setText(u.getGender());
        lblPhone.setText(u.getPhone());
        lblMail.setText(u.getEmail());
        lblAdd.setText(u.getAddress());
        lblUserN.setText(u.getUsername());
        lblDOB.setText(u.getDateOfBirth());

        user=u;








    }
}
