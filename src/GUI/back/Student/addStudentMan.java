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
import javafx.scene.text.Text;

import javax.mail.MessagingException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

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
    private Label erreur;

    @FXML
    private Text lblName;


    @FXML
    private void gotoTeatcher(MouseEvent event) throws IOException {
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("../Users.fxml"));
        Parent root=fxml.load();
        gotoTeacher.getScene().setRoot(root);
    }

    @FXML
    private void logOut(MouseEvent event) throws IOException {
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("/GUI/login.fxml"));
        Parent root=fxml.load();
        logout.getScene().setRoot(root);
    }

    @FXML
    private void gotoStudent(MouseEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Students.fxml"));
        Parent root = loader.load();
        gotoStudt.getScene().setRoot(root);
        Students controller = loader.getController();
        controller.maindata(lblName.getText());

    }

    public static boolean emailvalid(String email)
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }

    public void AddStudentMan(ActionEvent event) throws IOException, SQLException, MessagingException {
        String userN = firstnameS.getText();
        String LastN = lastnameS.getText();
        String emailU = emailS.getText();
        String placeofbirthU = placeofbirthS.getText();
        String phoneU = phoneS.getText();
        String dateofbirthU = dateofbirthS.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String bloodgroupU = bloodgroupS.getValue().toString();
        String academicyearU = academicyearS.getValue().toString();
        String adressU = adressS.getText();
        String genderU = genderS.getValue().toString();
        ServiceUser user = new ServiceUser();
        if (userN.length() < 5) {
            erreur.setText("First Name Must contain at least 5 characters");
            erreur.setVisible(true);
        } else if (LastN.length() < 5) {
            erreur.setText("Last Name Must contain at least 5 characters");
            erreur.setVisible(true);
        } else if (emailvalid(emailU) == false) {
            erreur.setText("Invalid Email address ");
            erreur.setVisible(true);
        } else if (placeofbirthU.length() < 4) {
            erreur.setText("Place Birth Must contain at least 4 characters");
            erreur.setVisible(true);
        } else if (bloodgroupU.equals("Select Your Blood Group")) {
            erreur.setText("Please chose your blood Grouo");
            erreur.setVisible(true);
        } else if (academicyearU.equals("Select Your Academic Year")) {
            erreur.setText("Please chose your Academic Year");
            erreur.setVisible(true);
        } else if (adressU.length() < 8) {
            erreur.setText("Please select a valid address");
            erreur.setVisible(true);
        } else if (genderU.equals("Select Your Gender")) {
            erreur.setText("Please chose your Gender");
            erreur.setVisible(true);
        } else if (dateofbirthU.compareTo("2013-01-01") > 0) {
            erreur.setText("You cant join our School");
            erreur.setVisible(true);
        } else if (placeofbirthU.length() < 5) {
            erreur.setText("Place of birth Must contain at least 5 characters");
            erreur.setVisible(true);
        }
        else if ((phoneU.matches("[0-9]+") == false) || (phoneU.length() != 8)) {
            erreur.setText("Phone number must be 8 and only numbers"); erreur.setVisible(true);
        }
        else {
            try {
                boolean acces = user.signup(userN, LastN, emailU, placeofbirthU, phoneU, dateofbirthU, bloodgroupU, academicyearU, adressU, genderU);
                javaMailUtil.sendMail(emailU, userN + LastN);
                erreur.setText("Student Added Successfully"); erreur.setVisible(true);
            } catch (SQLException e) {
                if (e.getErrorCode() == 1062) {
                    erreur.setText("Please Verify your informations");
                    erreur.setVisible(true);
                }
            }
        }
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

    public void maindata(String UserN){
        lblName.setText(UserN);
        System.out.println(UserN);
    }
}
