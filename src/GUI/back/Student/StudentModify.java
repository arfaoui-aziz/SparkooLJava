package GUI.back.Student;

import Entity.User;
import Service.ServiceUser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class StudentModify implements Initializable {

    @FXML
    private TextField firstnameS;

    @FXML
    private TextField lastnameS;

    @FXML
    private TextField emailS;

    @FXML
    private TextField idS;

    @FXML
    private TextField phoneS;

    @FXML
    private TextField adressS;

    @FXML
    private TextField EtatS ;

    @FXML
    private ChoiceBox genderS;

    @FXML
    private ChoiceBox BloodGroupS;

    @FXML
    private Button addstudent;


    @FXML
    private Label logout;

    @FXML
    private Label erreur;

    @FXML
    private HBox gotoTeacher;

    @FXML
    private HBox gotoStudt;

    @FXML
    private Text lblName;

    @FXML
    private void gotoStudent(MouseEvent event) throws IOException {
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("Students.fxml"));
        Parent root=fxml.load();
        gotoStudt.getScene().setRoot(root);
    }

    ServiceUser user = new ServiceUser();
    public void maindata(User selectedItem , String name){
        idS.setText(selectedItem.getId());
        System.out.println(idS.getText());
        firstnameS.setText(selectedItem.getFirstName());
        lastnameS.setText(selectedItem.getLastName());
        emailS.setText(selectedItem.getEmail());
        phoneS.setText(selectedItem.getPhone());
        adressS.setText(selectedItem.getAddress());
        EtatS.setText(Integer.toString(selectedItem.getEnabled()));
        BloodGroupS.setValue(selectedItem.getBloodGroup());
        lblName.setText(name);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        BloodGroupS.getItems().addAll("Select Blood Group","A+","A-","B+","B-","AB+","AB-","O+","O-");
        BloodGroupS.getSelectionModel().select(0);
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

    @FXML
    void updateStudent(ActionEvent event) throws SQLException, IOException {
        String idss = idS.getText();
        String firstnameSS = firstnameS.getText();
        String lastnameSS=lastnameS.getText();
        String emailSS=emailS.getText();
        String phoneSS=phoneS.getText();
        String adressSS=adressS.getText();
        Byte EtatSS=Byte.parseByte(EtatS.getText());
        String BloodGroupSS = BloodGroupS.getValue().toString();


        if (firstnameSS.length() < 5) {
            erreur.setText("First Name Must contain at least 5 characters");
            erreur.setVisible(true);
        } else if (lastnameSS.length() < 5) {
            erreur.setText("Last Name Must contain at least 5 characters");
            erreur.setVisible(true);
        } else if (emailvalid(emailSS) == false) {
            erreur.setText("Invalid Email address ");
            erreur.setVisible(true);
        } else if (adressSS.length() < 8) {
            erreur.setText("Please select a valid address");
            erreur.setVisible(true);
        } else if ((EtatSS != 0) && (EtatSS!=1)  ) {
            erreur.setText("Status Must be 0 or 1");
            erreur.setVisible(true);
        }
        else if (BloodGroupSS.equals("Select Blood Group") == true) {
            erreur.setText("Please select a blood group");
            erreur.setVisible(true);
        }
        else if ((phoneSS.matches("[0-9]+") == false) || (phoneSS.length() != 8)) {
            erreur.setText("Phone number must be 8 and only numbers"); erreur.setVisible(true);
        }
        else {

        User u = new User(emailSS,EtatSS,firstnameSS,lastnameSS,adressSS,phoneSS,BloodGroupSS);
        user.updateStudent(u,idss);
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/GUI/back/Student/StudentsList.fxml"));
        Parent root = loader.load();
        addstudent.getScene().setRoot(root);
        StudentsList controller = loader.getController();
        controller.maindata(lblName.getText());
    }
    }

    @FXML
    private void logOut(MouseEvent event) throws IOException {
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("/GUI/login.fxml"));
        Parent root=fxml.load();
        logout.getScene().setRoot(root);
    }
}
