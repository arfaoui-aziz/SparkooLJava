package GUI.Parent.Dark;

import Entity.Diploma;
import Entity.User;
import Service.ServiceDiploma;
import Service.ServiceUser;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class DInfoParent {

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
    private Label lblNom;

    @FXML
    private Label lblID;

    @FXML
    private Label lblGn;

    @FXML
    private Label lblPhone;

    @FXML
    private Label lblMail;

    @FXML
    private Label childName;

    @FXML
    private VBox searchBox;

    @FXML
    private TextField inputWeek;

    @FXML
    private Label lblerror;

    @FXML
    private Button btnSearch;

    @FXML
    private VBox tableAb;

    @FXML
    private Label Nweek;

    @FXML
    private ImageView mon;

    @FXML
    private ImageView tue;

    @FXML
    private ImageView wed;

    @FXML
    private ImageView thu;

    @FXML
    private ImageView fr;

    @FXML
    private ImageView sa;

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
    void searchAb(MouseEvent event) {

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
        lblNom.setText(lblName.getText());
        ServiceUser us = new ServiceUser();
        User usr=us.readById(u.getId());
        lblID.setText(usr.getId());
        lblGn.setText(usr.getGender());
        lblPhone.setText(usr.getPhone());
        lblMail.setText(usr.getEmail());

        user=u;



        childName.setText(us.getChildName(u.getId()));

    }
}
