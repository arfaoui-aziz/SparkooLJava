package GUI.back;

import Entity.Event;
import Service.ServiceEvent;
import IService.IService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXMLLoader;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import com.jfoenix.controls.JFXComboBox;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;

public class AddEvent implements Initializable {

    @FXML
    private Label logout;

    @FXML
    private Label AllEvents;

    @FXML
    private Label GoToNewEvent;

    @FXML
    private Label GoToSport;

    @FXML
    private Label GoToTrip;

    @FXML
    private Label GoToCompetition;
    @FXML
    private Button addCompet;

    @FXML
    private JFXTextField eventName;

    @FXML
    private JFXTextField eventPlace;

    @FXML
    private JFXTextField budget;

    @FXML
    private JFXTextField award;

    @FXML
    private JFXTextField eventDescription;

    @FXML
    private JFXTextField participants;
    @FXML
    private JFXTextField price;
    @FXML
    private Button addEvent;

    @FXML
    private Button addSport;
    @FXML
    private Button addTrip;

    @FXML
    private JFXDatePicker eventDate;

    @FXML
    private JFXTextField destination;

    @FXML
    private JFXComboBox<String> Theme;

    @FXML
    void AllEvents(MouseEvent event) throws IOException {
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("AllEvents.fxml"));
        Parent root=fxml.load();
        AllEvents.getScene().setRoot(root);
    }

    @FXML
    void GoToNewEvent(MouseEvent event) throws IOException {
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("addEvent.fxml"));
        Parent root=fxml.load();
        GoToNewEvent.getScene().setRoot(root);
    }
    @FXML
    void GoToSport(MouseEvent event) throws IOException {
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("addSport.fxml"));
        Parent root=fxml.load();
        GoToSport.getScene().setRoot(root);
    }
    @FXML
    void GoToTrip(MouseEvent event) throws IOException {
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("addTrip.fxml"));
        Parent root=fxml.load();
        GoToTrip.getScene().setRoot(root);
    }
    @FXML
    void GoToCompet(MouseEvent event) throws IOException {
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("addCompetition.fxml"));
        Parent root=fxml.load();
        GoToCompetition.getScene().setRoot(root);
    }
    @FXML
    void logOut(MouseEvent event) {

    }
    @FXML
    void AddEvent(MouseEvent event) throws IOException, SQLException {

        String name = eventName.getText();

        String desc = eventDescription.getText();
        String DateEv = eventDate.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String place = eventPlace.getText();
        //int nb = Integer.parseInt(participants.getText());
        String nb=participants.getText();
        String budgeet =budget.getText();
       // Float budgeet = Float.parseFloat(budget.getText());
        String prix =budget.getText();
       // Float prix = Float.parseFloat(price.getText());
        if (!NUMBER(nb)) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Nombre de participants invalide ");
            alert.setContentText("le champs participants doit etre un entier");
            alert.showAndWait();
            participants.clear(); }
       else if(!NUMBER(prix) ) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("price of participation invalide ");
            alert.setContentText("le champs price of participation doit etre un entier");
            alert.showAndWait();
            price.clear(); }
        else if(!NUMBER(budgeet) ) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Budget invalide ");
            alert.setContentText("le champs budget doit etre un entier");
            alert.showAndWait();
            budget.clear(); }
       else {
            ServiceEvent NewEvent = new ServiceEvent();
            Event e = new Event(name, "Event", desc, DateEv, place,Integer.parseInt(nb), Float.parseFloat(budgeet), Float.parseFloat(prix)) ;
            NewEvent.ajouter(e);
            FXMLLoader fxml = new FXMLLoader(getClass().getResource("AllEvents.fxml"));
            Parent root = fxml.load();
            addEvent.getScene().setRoot(root);
        }
    }
    @FXML
    void AddSport(MouseEvent event) throws IOException, SQLException {

        String name = eventName.getText();

        String desc = eventDescription.getText();
        String DateEv = eventDate.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String place = eventPlace.getText();
        int nb = Integer.parseInt(participants.getText());
        String themes= Theme.getValue();
        Float budgeet = Float.parseFloat( budget.getText() );


        ServiceEvent NewEvent = new ServiceEvent();
        Event e = new Event(name,"Sport Activity",desc,DateEv,place,nb,themes,budgeet);
        NewEvent.ajouter(e);
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("AllEvents.fxml"));
        Parent root=fxml.load();
        addSport.getScene().setRoot(root);
    }
 @FXML
    void AddTrip(MouseEvent event) throws IOException, SQLException {

        String name = eventName.getText();
        String desc = eventDescription.getText();
        String DateEv = eventDate.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        int nb = Integer.parseInt(participants.getText());
       String destin = destination.getText();
       Float budgeet = Float.parseFloat( budget.getText() );
        Float prix= Float.parseFloat( price.getText());


        ServiceEvent NewEvent = new ServiceEvent();
        Event e = new Event(name,"Field Trip",desc,DateEv,nb,destin,budgeet, prix);
        NewEvent.ajouter(e);
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("AllEvents.fxml"));
        Parent root=fxml.load();
        addTrip.getScene().setRoot(root);
    }

    @FXML
    void AddCompet(MouseEvent event) throws IOException, SQLException {

        String name = eventName.getText();

        String desc = eventDescription.getText();
        String DateEv = eventDate.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String place = eventPlace.getText();
        int nb = Integer.parseInt(participants.getText());
        String themes= Theme.getValue();
        Float budgeet = Float.parseFloat( budget.getText() );
        Float prix= Float.parseFloat( price.getText());
        Float award = Float.parseFloat( budget.getText() );

        ServiceEvent NewEvent = new ServiceEvent();
        Event e = new Event(name,"Competition",desc,DateEv,place,nb,themes,award,budgeet, prix);
        NewEvent.ajouter(e);
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("AllEvents.fxml"));
        Parent root=fxml.load();
        addCompet.getScene().setRoot(root);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Theme.getItems().addAll("Soccer", "Basketball");

    }

    public static boolean NUMBER(final String str) {

        if (str == null || str.length() == 0) {
            return false;
        }

        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }

        return true;
    }

    @FXML
    public void verifDate(ActionEvent event){
        LocalDate ld = eventDate.getValue();
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if ((ld.toString().compareTo(sdf.format(d).toString()) <= 0 ) ) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Date invalide ");
            alert.setContentText("le champs date est invalide");
            alert.showAndWait();
            eventDate.getEditor().clear();
        }
    }

}

