package GUI.back;

import Entity.Event;
import Service.ServiceEvent;
import IService.IService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AddEvent implements Initializable {

    @FXML
    private Label logout;

    @FXML
    private Label gotoTeacher;

    @FXML
    private JFXTextField eventName;

    @FXML
    private JFXTextField eventPlace;

    @FXML
    private JFXTextField price;

    @FXML
    private JFXTextField eventDescription;

    @FXML
    private JFXTextField participants;

    @FXML
    private Button addEvent;

    @FXML
    private JFXDatePicker eventDate;

    @FXML
    private JFXTextField budget;

    @FXML
    void gotoTeacher(MouseEvent event) {

    }

    @FXML
    void logOut(MouseEvent event) {

    }
   /* @FXML
    void AddNewEvent(MouseEvent event) throws SQLException {
        Event e= new Event();
        ServiceEvent eve=new ServiceEvent();
        event.ajouter(e);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Classe");
        alert.setContentText("Classe Ajouter Avec Succes");
        alert.show();
    }


*/

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}

