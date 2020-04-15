package GUI.front.Light;

import Entity.Diploma;
import Entity.User;
import GUI.front.Dark.DModifyLogin;
import Service.ServiceDiploma;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class LModifyLogin {

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
            u.changePassword(newPass.getText(),user.getId());

            FXMLLoader fxml = new FXMLLoader(getClass().getClassLoader().getResource("GUI/front/Light/LightHome.fxml"));
            Parent root = fxml.load();
            btnTheme.getScene().setRoot(root);
            LightHome controller = fxml.getController();
            controller.initData(user);
        }

    }

    @FXML
    void gotoAccount(MouseEvent event) {

    }

    @FXML
    void gotoCourses(MouseEvent event) {

    }

    @FXML
    void gotoHome(MouseEvent event) throws SQLException, IOException {
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("LightHome.fxml"));
        Parent root = fxml.load();
        btnHome.getScene().setRoot(root);
        DModifyLogin controller = fxml.getController();
        controller.initData(user);
    }

    @FXML
    void gotoInfo(MouseEvent event) {

    }

    @FXML
    void gotoMarks(MouseEvent event) {

    }

    @FXML
    void gotoMessage(MouseEvent event) {

    }

    @FXML
    void gotoShedule(MouseEvent event) {

    }

    @FXML
    void gotoSignout(MouseEvent event) {

    }

    @FXML
    void switchTheme(MouseEvent event) throws SQLException, IOException {
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("GUI/front/Dark/DModifyLogin.fxml"));
        Parent root = fxml.load();
        btnAccount.getScene().setRoot(root);
        DModifyLogin controller = fxml.getController();
        controller.initData(user);
    }

    public void initData(User u) throws SQLException {
        username.setText(u.getUsername());

        lblName.setText(u.getFirstName()+' '+u.getLastName());
        ServiceDiploma d= new ServiceDiploma();
        Diploma dp = d.readById(u.getId());
        lblSpeciality.setText(dp.getSpecialite());
        lblType.setText(u.getUserType());
        File file = new File(u.getPicture());
        Image image = new Image(file.toURI().toString());
        photo.setFill(new ImagePattern(image));
        user=u;
    }
}
