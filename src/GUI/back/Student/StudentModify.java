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

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

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
    private HBox gotoTeacher;

    @FXML
    private HBox gotoStudt;

    @FXML
    private void gotoStudent(MouseEvent event) throws IOException {
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("Students.fxml"));
        Parent root=fxml.load();
        gotoStudt.getScene().setRoot(root);
    }

    ServiceUser user = new ServiceUser();
    public void maindata(User selectedItem){
        idS.setText(selectedItem.getId());
        System.out.println(idS.getText());
        firstnameS.setText(selectedItem.getFirstName());
        lastnameS.setText(selectedItem.getLastName());
        emailS.setText(selectedItem.getEmail());
        phoneS.setText(selectedItem.getPhone());
        adressS.setText(selectedItem.getAddress());
        EtatS.setText(Integer.toString(selectedItem.getEnabled()));
        BloodGroupS.setValue(selectedItem.getBloodGroup());

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        BloodGroupS.getItems().addAll("Select Blood Group","A+","A-","B+","B-","AB+","AB-","O+","O-");
        BloodGroupS.getSelectionModel().select(0);
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
        User u = new User(emailSS,EtatSS,firstnameSS,lastnameSS,adressSS,phoneSS,BloodGroupSS);
        user.updateStudent(u,idss);
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("/GUI/back/Student/StudentsList.fxml"));
        Parent root=fxml.load();
        addstudent.getScene().setRoot(root);
    }

    @FXML
    private void logOut(MouseEvent event) throws IOException {
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("/sample/login.fxml"));
        Parent root=fxml.load();
        logout.getScene().setRoot(root);
    }
}
