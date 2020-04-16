package GUI.back;


import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import org.json.JSONException;



import Entity.WeatherModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

import javafx.scene.control.*;
import javafx.stage.Stage;
import org.json.JSONException;

import java.io.IOException;

public class Owm  extends Application {

    @FXML
    private Button AllEvents;

    @FXML
    private ToggleGroup cityTg;

    @FXML
    private Button refreshBtn;

    @FXML
    private Label iconLbl;

    @FXML
    private Label cityNameLbl;

    @FXML
    private Label descriptionLbl;

    @FXML
    private Label temperatureLbl;

    @FXML
    private Label celsiusLbl;

    @FXML
    private Label pressureLbl;

    @FXML
    private Label humidityLbl;

    @FXML
    private Label windLbl;

    @FXML
    private Label timeLbl;

    @FXML
    private HBox botBox;

    WeatherModel wm;
    int cityID=2464461;


    @FXML
    private void initialize() throws ClassNotFoundException, JSONException {

        wm = new WeatherModel(cityID);
        System.out.println(wm.toString());



        cityNameLbl.textProperty().bindBidirectional(wm.cityNameProperty());
        descriptionLbl.textProperty().bindBidirectional(wm.descriptionProperty());
        temperatureLbl.textProperty().bindBidirectional(wm.temperatureProperty());
        pressureLbl.textProperty().bindBidirectional(wm.pressureProperty());
        humidityLbl.textProperty().bindBidirectional(wm.humidityProperty());
        windLbl.textProperty().bindBidirectional(wm.windProperty());

        iconLbl.setGraphic(new ImageView("http://openweathermap.org/img/w/"+wm.getIconID()+".png"));
        iconLbl.setScaleX(1.5);
        iconLbl.setScaleY(1.5);
        //refreshBtn.setGraphic(new ImageView("/recherche.png"));
        // refreshBtn.setScaleX(0.8);
        //refreshBtn.setScaleY(0.8);+
        timeLbl.setText(new java.util.Date().toString());
        cityTg.selectedToggleProperty().addListener((observable,
                                                     oldValue, newValue) -> {
            try {
                toggle(observable, oldValue, newValue);
            } catch (JSONException ex) {

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Owm.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    private void toggle(ObservableValue<? extends Toggle> observable,
                        Toggle oldValue, Toggle newValue) throws JSONException, ClassNotFoundException {

        ToggleButton tBtn = (ToggleButton) newValue;
        switch(tBtn.getText()){
            case "Tunis":
                cityID=2464470; // City IDs provided by OWM ( not WOEID )
                break;
            case "London":
                cityID=2643743;
                break;
            case "Sousse":
                cityID=2464915;
                break;
        }
        initialize();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



    @FXML
    void AllEvents(MouseEvent event) throws IOException {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();

        FXMLLoader fxml=new FXMLLoader(getClass().getResource("AllEvents.fxml"));

        Parent root=fxml.load();
        stage.setScene(new Scene(root, 1280, 700));

        AllEvents.getScene().setRoot(root);
    }




}