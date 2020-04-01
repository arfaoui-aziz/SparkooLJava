package GUI.back;

import Entity.User;
import Service.ServiceUser;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UpdateUser {


    @FXML
    private Label logout;

    @FXML
    private Label gotoUser;

    @FXML
    private JFXTextField id;

    @FXML
    private JFXComboBox<String> gender;

    @FXML
    private JFXDatePicker dateB;

    @FXML
    private JFXTextField salaire;

    @FXML
    private JFXTextField firstN;

    @FXML
    private JFXComboBox<String> role;

    @FXML
    private JFXDatePicker joiningD;

    @FXML
    private JFXTextField phone;

    @FXML
    private JFXTextField lastN;

    @FXML
    private JFXComboBox<String> userT;

    @FXML
    private JFXTextField mail;

    @FXML
    private JFXTextField address;
    @FXML
    private Button btnUpdate;

    @FXML
    public void initialize() {
        //gender.setPromptText("Gender");
        gender.getItems().addAll("Male", "Female");
        role.getItems().addAll("ROLE_USER","ROLE_ADMIN","ROLE_SUPER_ADMIN");
        userT.getItems().addAll("Administrator","Parent","Teacher","Student");

    }

    @FXML
    private void logOut(MouseEvent event) throws IOException {
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("/sample/login.fxml"));
        Parent root=fxml.load();
        logout.getScene().setRoot(root);
    }

    @FXML
    private void gotoUser(MouseEvent event) throws IOException {
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("Users.fxml"));
        Parent root=fxml.load();
        gotoUser.getScene().setRoot(root);
    }
    @FXML
    void UpdateUser(MouseEvent event) throws IOException, SQLException {
        String Id = id.getText();
        String FirstName = firstN.getText();
        String LastName = lastN.getText();
        String Gender = (String) gender.getValue();
        String Roles = (String) role.getValue();
        String UserType = (String) userT.getValue();
        String DateOfBirth= dateB.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String JoiningDate =joiningD.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String Email = mail.getText();
        Float Salaire = Float.parseFloat(salaire.getText());
        String Phone = phone.getText();
        String Address = address.getText();
        ServiceUser user = new ServiceUser();
        User u = new User(Id,FirstName,LastName,Gender,Roles,UserType,DateOfBirth,JoiningDate,Email,Salaire,Phone,Address);
        user.update(u,Id);
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("Users.fxml"));
        Parent root=fxml.load();
        btnUpdate.getScene().setRoot(root);
    }

    public void setDefaultText(String id,String firstN, String lastN,String gender,String role,String userT,String dateB,String joiningD,String mail, Float salaire, String phone , String address) {
        this.id.setText(id);
        this.firstN.setText(firstN);
        this.lastN.setText(lastN);
        this.gender.setValue(gender);
        this.role.setValue(role);
        this.userT.setValue(userT);
        this.dateB.setValue(LocalDate.parse(dateB));
        this.joiningD.setValue(LocalDate.parse(joiningD));
        this.mail.setText(mail);
        this.salaire.setText(String.valueOf(salaire));
        this.phone.setText(phone);
        this.address.setText(address);
    }
}
