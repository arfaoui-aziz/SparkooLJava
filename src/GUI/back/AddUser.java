package GUI.back;

import Entity.User;
import Service.ServiceUser;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;


import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;

import java.io.IOException;

import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class AddUser {


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
    void AddUser(MouseEvent event) {
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
        user.ajouter(u);
    }


}
