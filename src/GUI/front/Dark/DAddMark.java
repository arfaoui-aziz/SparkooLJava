package GUI.front.Dark;

import Entity.Diploma;
import Entity.User;
import GUI.back.AddAbsence;
import Service.ServiceDiploma;
import Service.ServiceMarks;
import Service.ServiceUser;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DAddMark implements Initializable {



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
    private HBox btnOpen;

    @FXML
    private HBox btnCompose;

    @FXML
    private TableView<User> tabMsg;

    @FXML
    private TableColumn<?, ?> cl_id;

    @FXML
    private TableColumn<?, ?> cl_subject;

    @FXML
    private TableColumn<?, ?> cl_cc;

    @FXML
    private TableColumn<?, ?> cl_exam;

    @FXML
    private TableColumn<?, ?> cl_note;

    @FXML
    void compose(MouseEvent event) throws IOException {
        Stage primaryStage = new Stage();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("DaddMarkStudent.fxml"));
        Parent root = loader.load();
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(new Scene(root, 280, 400));
        primaryStage.show();
        DaddMarkStudent controller = loader.getController();
        controller.initData(tabMsg.getSelectionModel().getSelectedItem().getId(),user.getId(),lblSpeciality.getText());
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
    void speak(MouseEvent event) {

    }

    @FXML
    void switchTheme(MouseEvent event) {

    }






    User user;
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

    public void affNotMarked() {
        ObservableList<User> data = FXCollections.observableArrayList();
        ServiceMarks ma = new ServiceMarks();
        try {
            ServiceUser usr = new ServiceUser();

            cl_subject.setCellValueFactory(new PropertyValueFactory<>("id"));
            cl_cc.setCellValueFactory(new PropertyValueFactory<>("firstName"));
            cl_exam.setCellValueFactory(new PropertyValueFactory<>("lastName"));

            tabMsg.setItems((ObservableList<User>) ma.readNotMarked());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        affNotMarked();
    }
}
