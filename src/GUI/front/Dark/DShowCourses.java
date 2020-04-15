package GUI.front.Dark;

import Entity.ContactTeacher;
import Entity.Course;
import Entity.Diploma;
import Entity.User;
import GUI.front.Light.LightHome;
import Service.ServiceCourse;
import Service.ServiceDiploma;
import Service.ServiceUser;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;



public class DShowCourses {
    ObservableList<Course> data = FXCollections.observableArrayList();


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
    private HBox btnOpen;

    @FXML
    private HBox btnShow;

    @FXML
    private TableView<Course> tabMsg;

    @FXML
    private TableColumn<?, ?> cl_id;

    @FXML
    private TableColumn<?, ?> cl_subject;

    @FXML
    private TableColumn<?, ?> cl_chap;

    @FXML
    private TableColumn<?, ?> cl_path;

    User user;

    @FXML
    void OpenMail(MouseEvent event) {
        try {
            Desktop desktop = Desktop.getDesktop();
            if (desktop.isSupported(Desktop.Action.OPEN)) {
                desktop.open(new File(tabMsg.getSelectionModel().getSelectedItem().getPath()));
            } else {
                System.out.println("Open is not supported");
            }
        } catch (IOException exp) {
            exp.printStackTrace();
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
    void switchTheme(MouseEvent event) {

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

        ServiceUser usr = new ServiceUser();
        ServiceCourse sc = new ServiceCourse();
        data = sc.readCourses(lblSpeciality.getText());
        cl_id.setCellValueFactory((new PropertyValueFactory<>("id")));
        cl_subject.setCellValueFactory(new PropertyValueFactory<>("name"));
        cl_chap.setCellValueFactory(new PropertyValueFactory<>("description"));
        cl_path.setCellValueFactory(new PropertyValueFactory<>("path"));

        tabMsg.setItems(data);
    }
}
