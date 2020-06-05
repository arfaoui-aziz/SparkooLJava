package GUI.back.Student;

import Service.ServiceUser;
import Utils.javaMailUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

import javax.mail.MessagingException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class addStudentMan implements Initializable {

    @FXML
    private TextField firstnameS;

    @FXML
    private TextField lastnameS;

    @FXML
    private TextField emailS;

    @FXML
    private TextField placeofbirthS;

    @FXML
    private TextField phoneS;

    @FXML
    private DatePicker dateofbirthS;

    @FXML
    private ChoiceBox bloodgroupS ;

    @FXML
    private ChoiceBox academicyearS;

    @FXML
    private TextField adressS;

    @FXML
    private ChoiceBox genderS;

    @FXML
    private Label logout;


    @FXML
    private HBox gotoTeacher;

    @FXML
    private HBox gotoStudt;



    @FXML
    private void gotoTeatcher(MouseEvent event) throws IOException {
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("../Users.fxml"));
        Parent root=fxml.load();
        gotoTeacher.getScene().setRoot(root);
    }

    @FXML
    private void logOut(MouseEvent event) throws IOException {
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("../home.fxml"));
        Parent root=fxml.load();
        logout.getScene().setRoot(root);
    }

    @FXML
    private void gotoStudent(MouseEvent event) throws IOException {
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("Students.fxml"));
        Parent root=fxml.load();
        gotoStudt.getScene().setRoot(root);
    }

    public void AddStudentMan(ActionEvent event) throws IOException, SQLException, MessagingException {
        String userN= firstnameS.getText();
        String LastN= lastnameS.getText();
        String emailU= emailS.getText();
        String placeofbirthU= placeofbirthS.getText();
        String phoneU= phoneS.getText();
        String dateofbirthU= dateofbirthS.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String bloodgroupU = bloodgroupS.getValue().toString();
        String academicyearU = academicyearS.getValue().toString();
        String adressU= adressS.getText();
        String genderU= genderS.getValue().toString();
        ServiceUser user = new ServiceUser();
        boolean acces = user.signup(userN ,LastN,emailU,placeofbirthU,phoneU,dateofbirthU,bloodgroupU,academicyearU,adressU,genderU);
        javaMailUtil.sendMail(emailU,userN+LastN);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        bloodgroupS.getItems().addAll("Select Your Blood Group","A+","A-","B+","B-","AB+","AB-","O+","O-");
        bloodgroupS.getSelectionModel().select(0);
        academicyearS.getItems().addAll("Select Your Academic Year","1st Year","2nd Year","3rd Year","4th Year","5th Year","6th Year");
        academicyearS.getSelectionModel().select(0);
        genderS.getItems().addAll("Select Your Gender","Male","Female");
        genderS.getSelectionModel().select(0);

    }
}
