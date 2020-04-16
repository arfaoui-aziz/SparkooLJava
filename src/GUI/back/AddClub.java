package GUI.back;
import Entity.Club;
import Service.ServiceClub;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXComboBox;

import tray.notification.NotificationType;
import tray.notification.TrayNotification;
import javafx.util.Duration;
import tray.animations.AnimationType;



public class AddClub implements Initializable {


    @FXML
    private Label logout;

    @FXML
    private Label AllClubs;

    @FXML
    private Label GoToNewClub;

    @FXML
    private JFXTextField clubName;

    @FXML
    private JFXTextField budget;

    @FXML
    private JFXComboBox<String> activity;

    @FXML
    private JFXTextField members;

    @FXML
    private JFXDatePicker date;

    @FXML
    private Button addClub;

   // @FXML
    //private JFXTextField activity;

    @FXML
    void AllClubs(MouseEvent event) throws IOException {
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("AllClubs.fxml"));
        Parent root = fxml.load();
        AllClubs.getScene().setRoot(root);
    }

    @FXML
    void GoToNewClub(MouseEvent event) throws IOException {
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("addClub.fxml"));
        Parent root = fxml.load();
        GoToNewClub.getScene().setRoot(root);
    }

    @FXML
    void logOut(MouseEvent event) {

    }

    @FXML
    void AddClub(MouseEvent event) throws IOException, SQLException {

        String name = clubName.getText();
        int memb = Integer.parseInt(members.getText());
        String act = activity.getValue();
        Float budgeet = Float.parseFloat(budget.getText());
        String Datec = date.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            ServiceClub NewClub = new ServiceClub();
            Club c = new Club(name, memb, act, budgeet, Datec) ;
            NewClub.ajouter(c);
            FXMLLoader fxml = new FXMLLoader(getClass().getResource("AllClubs.fxml"));
            Parent root = fxml.load();
            addClub.getScene().setRoot(root);
        TrayNotification tray = new TrayNotification("Successfully", "A New Club Was Added..", NotificationType.SUCCESS);
        tray.setAnimationType(AnimationType.SLIDE);
        tray.showAndDismiss(Duration.seconds(10));

        }


    @FXML
    public void verifDate(ActionEvent event){
        LocalDate ld = date.getValue();
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if ((ld.toString().compareTo(sdf.format(d).toString()) <= 0 ) ) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Date invalide ");
            alert.setContentText("le champs date est invalide");
            alert.showAndWait();
            date.getEditor().clear();
        }
    }
    public  void controleTextFieldNumerique( ActionEvent event) {
        if (members.getText().matches(".*[a-zA-Z].*")) {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog2");
            alert.setHeaderText("Champ invalide ");
            alert.setContentText("le champs members est invalide");
            alert.showAndWait();
        }

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        activity.getItems().addAll("Profit", "Non Profit");
    }
}

