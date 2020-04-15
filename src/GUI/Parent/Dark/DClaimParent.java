package GUI.Parent.Dark;

import Entity.ContactTeacher;
import Entity.Diploma;
import Entity.Reclamation;
import Entity.User;
import Service.ServiceContactTeacher;
import Service.ServiceDiploma;
import Service.ServiceReclamation;
import Service.ServiceUser;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DClaimParent implements Initializable {

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
    private HBox btnOpen;

    @FXML
    private HBox btnShow;

    @FXML
    private HBox btnCompose;

    @FXML
    private TableView<Reclamation> tabMsg;

    @FXML
    private TableColumn<?, ?> cl_id;

    @FXML
    private TableColumn<?, ?> cl_subject;

    @FXML
    private TableColumn<?, ?> cl_content;

    @FXML
    private TableColumn<?, ?> cl_date;
    @FXML
    private TableColumn<?, ?> cl_rep;

    @FXML
    void OpenMail(MouseEvent event) throws IOException, SQLException {
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("DShowClaimParent.fxml"));
        Parent root = fxml.load();
        btnOpen.getScene().setRoot(root);
        DShowClaimParent controller = fxml.getController();
        controller.initData(user,tabMsg.getSelectionModel().getSelectedItem());
    }

    @FXML
    void compose(MouseEvent event) throws IOException {
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("DComposeParent.fxml"));
        Parent root = fxml.load();
        btnMessage.getScene().setRoot(root);
        DComposeParent controller = fxml.getController();
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
    void switchTheme(MouseEvent event) {

    }


    User user;
    public void initData(User u) throws SQLException {



        lblName.setText(u.getFirstName()+' '+u.getLastName());
        ServiceDiploma d= new ServiceDiploma();
        Diploma dp = d.readById(u.getId());
        lblType.setText(u.getUserType());
        File file = new File(u.getPicture());
        Image image = new Image(file.toURI().toString());
        photo.setFill(new ImagePattern(image));
        user=u;
        try {
            data = (ObservableList<Reclamation>) sr.readRec(user.getId());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        cl_id.setCellValueFactory((new PropertyValueFactory<>("id")));
        cl_subject.setCellValueFactory(new PropertyValueFactory<>("type"));
        cl_content.setCellValueFactory(new PropertyValueFactory<>("message"));
        cl_date.setCellValueFactory(new PropertyValueFactory<>("datecree"));
        cl_rep.setCellValueFactory(new PropertyValueFactory<>("reponse"));


        tabMsg.setItems(data);
    }
    ObservableList<Reclamation> data = FXCollections.observableArrayList();
    ServiceReclamation sr = new ServiceReclamation();

    @Override
    public void initialize(URL location, ResourceBundle resources) {



    }


}
