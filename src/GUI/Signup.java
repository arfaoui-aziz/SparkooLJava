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
import org.omg.PortableInterceptor.ORBInitInfoPackage.DuplicateName;

import javax.mail.MessagingException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

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

    @FXML
    private Label erreur;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        bloodgroup.getItems().addAll("Select Your Blood Group","A+","A-","B+","B-","AB+","AB-","O+","O-");
        bloodgroup.getSelectionModel().select(0);
        academicyear.getItems().addAll("Select Your Academic Year","1st Year","2nd Year","3rd Year","4th Year","5th Year","6th Year");
        academicyear.getSelectionModel().select(0);
        gender.getItems().addAll("Select Your Gender","Male","Female");
        gender.getSelectionModel().select(0);
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




    public void signupAc(ActionEvent event) throws IOException, SQLException, MessagingException {
        String userN = Username.getText();
        String LastN = lastname.getText();
        String emailU = email.getText();
        String placeofbirthU = placeofbirth.getText();
        String phoneU = phone.getText();
        String dateofbirthU = dateofbirth.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String bloodgroupU = bloodgroup.getValue().toString();
        String academicyearU = academicyear.getValue().toString();
        String adressU = adress.getText();
        String genderU = gender.getValue().toString();
        ServiceUser user = new ServiceUser();
        if (userN.length() < 5) {
            erreur.setText("First Name Must contain at least 5 characters"); erreur.setVisible(true);
        } else if (LastN.length() < 5) {erreur.setText("Last Name Must contain at least 5 characters"); erreur.setVisible(true); }
        else if (emailvalid(emailU) == false) {
            erreur.setText("Invalid Email address "); erreur.setVisible(true);
        }
        else if (placeofbirthU.length() < 4 ) {
            erreur.setText("Place Birth Must contain at least 4 characters"); erreur.setVisible(true);
        }
        else if (bloodgroupU.equals("Select Your Blood Group")) {
            erreur.setText("Please chose your blood Grouo"); erreur.setVisible(true);
        }
        else if (academicyearU.equals("Select Your Academic Year")) {
            erreur.setText("Please chose your Academic Year"); erreur.setVisible(true);
        }
        else if (adressU.length() < 8) {
            erreur.setText("Please select a valid address"); erreur.setVisible(true);
        }
        else if (genderU.equals("Select Your Gender")) {
            erreur.setText("Please chose your Gender"); erreur.setVisible(true);
        }

        else if (dateofbirthU.compareTo("2013-01-01") > 0 ) {
            erreur.setText("You cant join our School"); erreur.setVisible(true);
        }
        else if ((phoneU.matches("[0-9]+") == false) || (phoneU.length() != 8)) {
            erreur.setText("Phone number must be 8 and only numbers"); erreur.setVisible(true);
        }
        else if (placeofbirthU.length() < 5) {erreur.setText("Place of birth Must contain at least 5 characters"); erreur.setVisible(true);}
            else {
                try {
                    boolean acces = user.signup(userN, LastN, emailU, placeofbirthU, phoneU, dateofbirthU, bloodgroupU, academicyearU, adressU, genderU);
                    javaMailUtil.sendMail(emailU, userN + LastN);
                    FXMLLoader fxml = new FXMLLoader(getClass().getResource("login.fxml"));
                    Parent root = fxml.load();
                    btn.getScene().setRoot(root);
                }
                catch (SQLException e) {
                    if (e.getErrorCode() == 1062)
                    {
                        erreur.setText("Please Verify your informations"); erreur.setVisible(true);
                    }
                }
        }
    }

    @FXML
    private void gotologinForm(MouseEvent event) throws IOException {
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("login.fxml"));
        Parent root=fxml.load();
        gobacklog.getScene().setRoot(root);
    }
}

