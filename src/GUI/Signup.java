package GUI;
import Service.ServiceUser;
import Utils.javaMailUtil;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import javax.mail.MessagingException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class Signup implements Initializable {
    @FXML
    private TextField Username;

    @FXML
    private TextField lastname;

    @FXML
    private TextField email;

    @FXML
    private TextField placeofbirth;

    @FXML
    private TextField phone;

    @FXML
    private DatePicker dateofbirth;

    @FXML
    private ChoiceBox  bloodgroup ;

    @FXML
    private ChoiceBox academicyear;

    @FXML
    private TextField adress;

    @FXML
    private ChoiceBox gender;

    @FXML
    private Button btn;

    @FXML
    private Label gobacklog;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        bloodgroup.getItems().addAll("Select Your Blood Group","A+","A-","B+","B-","AB+","AB-","O+","O-");
        bloodgroup.getSelectionModel().select(0);
        academicyear.getItems().addAll("Select Your Academic Year","1st Year","2nd Year","3rd Year","4th Year","5th Year","6th Year");
        academicyear.getSelectionModel().select(0);
        gender.getItems().addAll("Select Your Gender","Male","Female");
        gender.getSelectionModel().select(0);
    }

    public void signupAc(ActionEvent event) throws IOException, SQLException, MessagingException {
        String userN= Username.getText();
        String LastN= lastname.getText();
        String emailU= email.getText();
        String placeofbirthU= placeofbirth.getText();
        String phoneU= phone.getText();
        String dateofbirthU= dateofbirth.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String bloodgroupU = bloodgroup.getValue().toString();
        String academicyearU = academicyear.getValue().toString();
        String adressU= adress.getText();
        String genderU= gender.getValue().toString();
        ServiceUser user = new ServiceUser();
        boolean acces = user.signup(userN ,LastN,emailU,placeofbirthU,phoneU,dateofbirthU,bloodgroupU,academicyearU,adressU,genderU);
        javaMailUtil.sendMail(emailU,userN+LastN);
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("login.fxml"));
        Parent root=fxml.load();
        btn.getScene().setRoot(root);
    }

    @FXML
    private void gotologinForm(MouseEvent event) throws IOException {
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("login.fxml"));
        Parent root=fxml.load();
        gobacklog.getScene().setRoot(root);
    }
}

