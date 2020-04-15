package GUI.Parent.Dark;

import Entity.Diploma;
import Entity.User;
import Service.ServiceDiploma;
import Service.ServiceReclamation;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DComposeParent implements Initializable {

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
    private Label sent1;

    @FXML
    private Label errorSub;

    @FXML
    private Label sent11;

    @FXML
    private JFXTextField cont;

    @FXML
    private Label errorCont;

    @FXML
    private Button btnSend;
    @FXML
    private JFXComboBox<String> sub;

    @FXML
    void SendMail(MouseEvent event) throws IOException, SQLException {

        ServiceReclamation sr = new ServiceReclamation();
        sr.addClaim(user.getId(),sub.getValue(),cont.getText());
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("DClaimParent.fxml"));
        Parent root = fxml.load();
        btnMessage.getScene().setRoot(root);
        DClaimParent controller = fxml.getController();
        controller.initData(user);

    }

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
    void showSent(MouseEvent event) {

    }

    @FXML
    void switchTheme(MouseEvent event) {

    }
User user;
    public void initData(User u) {
        lblName.setText(u.getFirstName()+' '+u.getLastName());
        lblType.setText(u.getUserType());
        File file = new File(u.getPicture());
        Image image = new Image(file.toURI().toString());
        photo.setFill(new ImagePattern(image));
        user=u;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sub.getItems().addAll("Teacher","Mark","Student","Subject");

    }
}
