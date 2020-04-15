package GUI.front.Light;

import Entity.Diploma;
import Entity.User;
import GUI.front.Dark.DAttendanceSheet;
import GUI.front.Dark.DModifyLogin;
import GUI.front.Dark.DarkHome;
import Service.ServiceDiploma;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LightHome implements Initializable {
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

    User user = new User("");

    @FXML
    void gotoAccount(MouseEvent event) throws IOException, SQLException {

        FXMLLoader fxml = new FXMLLoader(getClass().getResource("LModifyLogin.fxml"));
        Parent root = fxml.load();
        btnAccount.getScene().setRoot(root);
        LModifyLogin controller = fxml.getController();
        controller.initData(user);
    }

    @FXML
    void gotoCourses(MouseEvent event) {

    }

    @FXML
    void gotoHome(MouseEvent event) {

    }

    @FXML
    void gotoInfo(MouseEvent event) throws SQLException, IOException {
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("LAttendanceSheet.fxml"));
        Parent root = fxml.load();
        btnInfo.getScene().setRoot(root);
        LAttendanceSheet controller = fxml.getController();
        controller.initData(user);
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
    void gotoSignout(MouseEvent event) throws IOException {
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("/sample/login.fxml"));
        Parent root = fxml.load();
        btnSignout.getScene().setRoot(root);
    }

    @FXML
    void switchTheme(MouseEvent event) throws IOException, SQLException {
        FXMLLoader fxml = new FXMLLoader(getClass().getClassLoader().getResource("GUI/front/Dark/DarkHome.fxml"));
        Parent root = fxml.load();
        btnTheme.getScene().setRoot(root);
        DarkHome controller = fxml.getController();
        controller.initData(user);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {


        File file = new File("/Users/amen/Desktop/teacher3.png");
        Image image = new Image(file.toURI().toString());
        photo.setFill(new ImagePattern(image));

    }

    public void initData(User u) throws SQLException {
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
