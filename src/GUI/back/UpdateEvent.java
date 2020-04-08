package GUI.back;

import Entity.Event;
import Service.ServiceEvent;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class UpdateEvent implements Initializable {

    @FXML
    private Label logout;

    @FXML
    private Label AllEvents;

    @FXML
    private JFXTextField id;

    @FXML
    private JFXTextField eventDescription;

    @FXML
    private JFXTextField participants;

    @FXML
    private JFXTextField award;

    @FXML
    private JFXTextField eventName;

    @FXML
    private JFXDatePicker eventDate;

    @FXML
    private JFXComboBox<String> theme;

    @FXML
    private JFXTextField budget;

    @FXML
    private JFXTextField eventType;

    @FXML
    private JFXTextField eventPlace;

    @FXML
    private JFXTextField destination;

    @FXML
    private JFXTextField price;
    @FXML
    private Button updateEvent;


    @FXML
    void AllEvents(MouseEvent event) {

    }

    @FXML
    void logOut(MouseEvent event)throws IOException {
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("AllEvents.fxml"));
        Parent root=fxml.load();
        AllEvents.getScene().setRoot(root);
       }

    ServiceEvent NewEvent = new ServiceEvent();


    public void setDefaultText(int id,String eventName, String eventType,String eventDescription,String eventDate,String eventPlace,int participants,String theme,String destination, Float award, Float budget , Float price) {

        this.id.setText(String.valueOf((id)));
        this.eventName.setText(eventName);
        this.eventType.setText(eventType);
        this.eventDescription.setText(eventDescription);
        this.eventDate.setValue(LocalDate.parse(eventDate));
        this.eventPlace.setText(eventPlace);
        this.participants.setText(String.valueOf((participants)));
        this.theme.setValue(theme);
        this.destination.setText(destination);
        this.award.setText(String.valueOf(award));
        this.budget.setText(String.valueOf(budget));
        this.price.setText(String.valueOf(price));

    }


        @FXML
    void updateEvent(MouseEvent event) throws SQLException, IOException {
            int idn= Integer.parseInt(id.getText());
            String name=eventName.getText();
            String typeE=eventType.getText();
            String desc=eventDescription.getText();
            String DateEv = eventDate.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            String place = eventPlace.getText();
            int nb = Integer.parseInt(participants.getText());
            String themeE=theme.getValue();
            String dest=destination.getText();
            Float awardE = Float.parseFloat( award.getText() );
            Float budgeet = Float.parseFloat( budget.getText() );
            Float prix= Float.parseFloat( price.getText());
            Event e = new Event(idn,name,typeE,desc,DateEv,place,nb,themeE,dest,awardE,budgeet,prix);
            ServiceEvent eve = new ServiceEvent();
            eve.update(e,idn);
            FXMLLoader fxml=new FXMLLoader(getClass().getResource("AllEvents.fxml"));
            Parent root=fxml.load();
            updateEvent.getScene().setRoot(root);
        }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        theme.getItems().addAll("Soccer", "Basketball");

    }
    }

