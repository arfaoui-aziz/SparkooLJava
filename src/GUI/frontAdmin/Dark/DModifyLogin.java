package GUI.frontAdmin.Dark;


import Entity.User;
import GUI.frontAdmin.Light.LightHome;

import Service.ServiceUser;
import Utils.bcrypt;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
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

public class DModifyLogin {

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
    private TextField username;

    @FXML
    private PasswordField currPass;

    @FXML
    private PasswordField newPass;

    @FXML
    private PasswordField renewPass;

    @FXML
    private Button btnConfirm;


    @FXML
    private Label lblMatch;

    @FXML
    private Label lblFound;


    User user;


    @FXML
    void changePass(MouseEvent event) throws SQLException, IOException {

        lblFound.setText("");lblMatch.setText("");

if ((!bcrypt.checkpw(currPass.getText(), user.getPassword())) || (!newPass.getText().equals(renewPass.getText())) ) {
    if (!bcrypt.checkpw(currPass.getText(), user.getPassword())) {
        lblFound.setText("Incorrect Password !");
    }
    if (!newPass.getText().equals(renewPass.getText())) {
        lblMatch.setText("Password doesn't match !");
    }
}
else {
    ServiceUser u = new ServiceUser();
    u.ModifyLogin(user.getId(),username.getText(),newPass.getText());

    FXMLLoader fxml = new FXMLLoader(getClass().getClassLoader().getResource("GUI/frontAdmin/Dark/DarkHome.fxml"));
    Parent root = fxml.load();
    btnTheme.getScene().setRoot(root);
    DarkHome controller = fxml.getController();
    controller.initData(user);
}

    }

    @FXML
    void gotoAccount(MouseEvent event) throws IOException, SQLException {

        FXMLLoader fxml = new FXMLLoader(getClass().getResource("DModifyLogin.fxml"));
        Parent root = fxml.load();
        btnAccount.getScene().setRoot(root);
        DModifyLogin controller = fxml.getController();
        controller.initData(user);
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
        accountInformation  controller = fxml.getController();
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
        username.setText(u.getUsername());

        lblName.setText(u.getFirstName()+' '+u.getLastName());

        user=u;
    }

}
