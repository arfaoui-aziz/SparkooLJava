package GUI.front.Dark;

import Entity.Diploma;
import Entity.User;
import GUI.front.Light.LightHome;
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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.Duration;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;

public class DarkHome implements Initializable {

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

        FXMLLoader fxml = new FXMLLoader(getClass().getResource("DModifyLogin.fxml"));
        Parent root = fxml.load();
        btnAccount.getScene().setRoot(root);
        DModifyLogin controller = fxml.getController();
        controller.initData(user);
    }

    @FXML
    void gotoCourses(MouseEvent event) throws IOException, SQLException {
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("DShowCourses.fxml"));
        Parent root = fxml.load();
        btnCourse.getScene().setRoot(root);
        DShowCourses controller = fxml.getController();
        controller.initData(user);
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
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("DAttendanceSheet.fxml"));
        Parent root = fxml.load();
        btnInfo.getScene().setRoot(root);
        DAttendanceSheet controller = fxml.getController();
        controller.initData(user);
    }

    @FXML
    void gotoMarks(MouseEvent event) throws IOException, SQLException {
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("DAddMark.fxml"));
        Parent root = fxml.load();
        btnMarks.getScene().setRoot(root);
        DAddMark controller = fxml.getController();
        controller.initData(user);


    }

    @FXML
    void gotoMessage(MouseEvent event) throws IOException, SQLException {
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("DContact.fxml"));
        Parent root = fxml.load();
        btnInfo.getScene().setRoot(root);
        DContact controller = fxml.getController();
        controller.initData(user);



    }

    @FXML
    void gotoShedule(MouseEvent event) throws IOException, SQLException {
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("DShowSchedule.fxml"));
        Parent root = fxml.load();
        btnCourse.getScene().setRoot(root);
        DShowSchedule controller = fxml.getController();
        controller.initData(user);
    }

    @FXML
    void gotoSignout(MouseEvent event) throws IOException {
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("/sample/login.fxml"));
        Parent root = fxml.load();
        btnSignout.getScene().setRoot(root);
    }

    @FXML
    void switchTheme(MouseEvent event) throws IOException, SQLException {
        FXMLLoader fxml = new FXMLLoader(getClass().getClassLoader().getResource("GUI/front/Light/LightHome.fxml"));
        Parent root = fxml.load();
        btnTheme.getScene().setRoot(root);
        LightHome controller = fxml.getController();
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
