package GUI.Parent.Dark;

import Entity.User;
import GUI.front.Dark.DModifyLogin;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class DHomeParent {

    @FXML
    private HBox btnTheme;

    @FXML
    private Circle photo;

    @FXML
    private Label lblName;

    @FXML
    private Label lblType;

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
    void gotoAccount(MouseEvent event) throws IOException, SQLException {
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("DAccountParent.fxml"));
        Parent root = fxml.load();
        btnAccount.getScene().setRoot(root);
        DAccountParent controller = fxml.getController();
        controller.initData(user);
    }

    @FXML
    void gotoCourses(MouseEvent event) {

    }

    @FXML
    void gotoHome(MouseEvent event) throws IOException {
        FXMLLoader fxml=new FXMLLoader(getClass().getClassLoader().getResource("DHomeParent.fxml"));
        Parent root=fxml.load();
        btnHome.getScene().setRoot(root);
        DHomeParent controller = fxml.getController();
        controller.initData(user);
    }

    @FXML
    void gotoInfo(MouseEvent event) throws IOException, SQLException {
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("DInfoParent.fxml"));
        Parent root = fxml.load();
        btnInfo.getScene().setRoot(root);
        DInfoParent controller = fxml.getController();
        controller.initData(user);
    }

    @FXML
    void gotoMarks(MouseEvent event) throws IOException, SQLException {
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("DMarksParent.fxml"));
        Parent root = fxml.load();
        btnInfo.getScene().setRoot(root);
        DMarksParent controller = fxml.getController();
        controller.initData(user);
    }

    @FXML
    void gotoMessage(MouseEvent event) throws IOException, SQLException {
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("DClaimParent.fxml"));
        Parent root = fxml.load();
        btnMessage.getScene().setRoot(root);
        DClaimParent controller = fxml.getController();
        controller.initData(user);
    }

    @FXML
    void gotoShedule(MouseEvent event) {

    }

    @FXML
    void gotoSignout(MouseEvent event) throws IOException {
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("/sample/login.fxml"));
        Parent root = fxml.load();
        btnSignout.getScene().setRoot(root);
    }

    @FXML
    void switchTheme(MouseEvent event) {

    }

User user;
    public void initData(User u) {
        lblName.setText(u.getFirstName()+' '+u.getLastName());
        File file = new File(u.getPicture());
        Image image = new Image(file.toURI().toString());
        photo.setFill(new ImagePattern(image));
        user=u;

    }
}
