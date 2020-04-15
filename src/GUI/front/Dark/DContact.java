package GUI.front.Dark;

import Entity.ContactTeacher;
import Entity.Diploma;
import Entity.User;
import GUI.back.ShowMessage;
import GUI.front.Light.LightHome;
import Service.ServiceContactTeacher;
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

public class DContact {
    @FXML
    private HBox btnOpen;

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
    private Label sent;

    @FXML
    private Label rep;

    @FXML
    private Label rec;

    @FXML
    private HBox btnCompose;

    @FXML
    private TableView<ContactTeacher> tabMsg;

    @FXML
    private TableColumn<?, ?> cl_id;

    @FXML
    private TableColumn<?, ?> cl_subject;

    @FXML
    private TableColumn<?, ?> cl_content;

    @FXML
    private TableColumn<?, ?> cl_date;

    ObservableList<ContactTeacher> data = FXCollections.observableArrayList();
    ServiceContactTeacher ct = new ServiceContactTeacher();
    User user;


    @FXML
    void compose(MouseEvent event) throws IOException {

        FXMLLoader fxml = new FXMLLoader(getClass().getResource("DCompose.fxml"));
        Parent root = fxml.load();
        btnCompose.getScene().setRoot(root);
        DCompose controller = fxml.getController();
        controller.initData(user);


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
    void OpenMail(MouseEvent event) throws IOException, SQLException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("DShowMsg.fxml"));
        Parent root = loader.load();
        btnOpen.getScene().setRoot(root);

        DShowMsg controller = loader.getController();
        controller.initData(tabMsg.getSelectionModel().getSelectedItem());
        controller.initData1(user);

    }

    @FXML
    void recived(MouseEvent event) {
        rep.setStyle("-fx-underline: false;-fx-cursor :hand");
        sent.setStyle("-fx-underline: false;-fx-cursor :hand");
        rec.setStyle("-fx-underline: true;-fx-cursor :hand");
        refresh();
        try {
            ServiceUser usr = new ServiceUser();
            data = (ObservableList<ContactTeacher>) ct.readReceived(user.getId());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        cl_id.setCellValueFactory((new PropertyValueFactory<>("id")));
        cl_subject.setCellValueFactory(new PropertyValueFactory<>("subject"));
        cl_content.setCellValueFactory(new PropertyValueFactory<>("message"));
        cl_date.setCellValueFactory(new PropertyValueFactory<>("dateCreation"));

        tabMsg.setItems(data);

    }

    @FXML
    void replied(MouseEvent event) {
        rep.setStyle("-fx-underline: true;-fx-cursor :hand");
        sent.setStyle("-fx-underline: false;-fx-cursor :hand");
        rec.setStyle("-fx-underline: false;-fx-cursor :hand");
        refresh();
        try {
            ServiceUser usr = new ServiceUser();
            data = (ObservableList<ContactTeacher>) ct.readReplied(user.getId());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        cl_id.setCellValueFactory((new PropertyValueFactory<>("id")));
        cl_subject.setCellValueFactory(new PropertyValueFactory<>("subject"));
        cl_content.setCellValueFactory(new PropertyValueFactory<>("message"));
        cl_date.setCellValueFactory(new PropertyValueFactory<>("dateCreation"));

        tabMsg.setItems(data);
    }


    @FXML
    void showSent(MouseEvent event) {
        rep.setStyle("-fx-underline: false;-fx-cursor :hand");
        sent.setStyle("-fx-underline: true;-fx-cursor :hand");
        rec.setStyle("-fx-underline: false;-fx-cursor :hand");
        refresh();
        try {
            ServiceUser usr = new ServiceUser();
            data = (ObservableList<ContactTeacher>) ct.readSent(user.getId());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        cl_id.setCellValueFactory((new PropertyValueFactory<>("id")));
        cl_subject.setCellValueFactory(new PropertyValueFactory<>("subject"));
        cl_content.setCellValueFactory(new PropertyValueFactory<>("message"));
        cl_date.setCellValueFactory(new PropertyValueFactory<>("dateCreation"));

        tabMsg.setItems(data);
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
        sent.setStyle("-fx-underline: true");
        try {
            ServiceUser usr = new ServiceUser();
            data = (ObservableList<ContactTeacher>) ct.readSent(user.getId());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        cl_id.setCellValueFactory((new PropertyValueFactory<>("id")));
        cl_subject.setCellValueFactory(new PropertyValueFactory<>("subject"));
        cl_content.setCellValueFactory(new PropertyValueFactory<>("message"));
        cl_date.setCellValueFactory(new PropertyValueFactory<>("dateCreation"));

        tabMsg.setItems(data);
    }
    void refresh(){
        for ( int i = 0; i<tabMsg.getItems().size(); i++) {
            tabMsg.getItems().clear();
        }
    }

    @FXML
    private ImageView btnVoice;
    @FXML
    void speak(MouseEvent event) {
        String source = new File("/Users/amen/Documents/SparkoolGit/src/GUI/sound/msg.mov").toURI().toString();
        Media media = null;
        media = new Media(source);
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
    }
}
