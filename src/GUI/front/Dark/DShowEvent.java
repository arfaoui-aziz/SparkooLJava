package GUI.front.Dark;
import Entity.Event;
import Entity.User;
import GUI.back.AddEvent;
import Service.ServiceEvent;
import Utils.DataBase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

/*

 */
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

import javafx.util.Duration;
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
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

import javax.swing.*;
import java.io.IOException;




public class DShowEvent extends Application {
    private int id;
    @FXML
    private Button bcanc;

    @FXML
    private Label bcancel;
    @FXML
    private Label ref;

    @FXML
    private Label bpart;
    @FXML
    private Button refresh;

    @FXML
    private Button AllEvents;
    @FXML
    private Button bmeteo;


    @FXML
    private ToggleGroup cityTg;

    @FXML
    private ImageView refreshBtn;
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
    int cityID = 2464461;


    /**/
    @FXML
    private HBox btnTheme;

    @FXML
    private Circle photo;

    @FXML
    private Label lblName;

    @FXML
    private Label lblType;

    @FXML
    private Label lblSpeciality;

    @FXML
    private VBox btnHome;

    @FXML
    private VBox btnInfo;

    @FXML
    private VBox btnShedule;

    @FXML
    private VBox btnCourse;

    @FXML
    private VBox btnMessage;

    @FXML
    private VBox btnMarks;

    @FXML
    private VBox btnAccount;

    @FXML
    private VBox btnSignout;

    @FXML
    private Label sent;

    @FXML
    private Label rep;

    @FXML
    private Label rec;

    @FXML
    private HBox btnOpen;

    @FXML
    private HBox btnShow;

    @FXML
    private Label show;

    @FXML
    private HBox btnCompose;

    @FXML
    private Label btnParticiper;

    @FXML
    private TableView<Event> tabMsg;
    @FXML
    private TableColumn<?, ?> cl_id;
    @FXML
    private TableColumn<?, ?> cl_Name;

    @FXML
    private TableColumn<?, ?> cl_type;

    @FXML
    private TableColumn<?, ?> cl_date;

    @FXML
    private TableColumn<?, ?> cl_nb;

    @FXML
    private Label bYoutube;
    @FXML
    private ImageView bYoutube1;


    @FXML
    void OpenMail(MouseEvent event) {

    }

    @FXML
    void Participate(MouseEvent event) {


    }

    @FXML
    void compose(MouseEvent event) {

    }

    @FXML
    void gotoAccount(MouseEvent event) {

    }

    @FXML
    void gotoCourses(MouseEvent event) {

    }

    @FXML
    void gotoHome(MouseEvent event) {

    }

    @FXML
    void gotoInfo(MouseEvent event) {

    }

    @FXML
    void gotoMarks(MouseEvent event) {

    }

    @FXML
    void gotoMessage(MouseEvent event) {

    }

    @FXML
    void gotoShedule(MouseEvent event) {

    }

    @FXML
    void gotoSignout(MouseEvent event) {

    }

    @FXML
    void recived(MouseEvent event) {

    }

    @FXML
    void replied(MouseEvent event) {

    }

    @FXML
    void showDetail(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DShowEventDetail.fxml"));
        Parent root = loader.load();
        DShowEventDetail spc = loader.getController();

        int ide = tabMsg.getSelectionModel().getSelectedItem().getId();

        String name = tabMsg.getSelectionModel().getSelectedItem().getNomEvent();
        String typeE = tabMsg.getSelectionModel().getSelectedItem().getTypeEvent();
        String desc = tabMsg.getSelectionModel().getSelectedItem().getDescription();
        String date = tabMsg.getSelectionModel().getSelectedItem().getDateEvent();
        String place = tabMsg.getSelectionModel().getSelectedItem().getPlaceEvent();
        int nb = tabMsg.getSelectionModel().getSelectedItem().getNbParticipants();
        String theme = tabMsg.getSelectionModel().getSelectedItem().getTheme();
        String dest = tabMsg.getSelectionModel().getSelectedItem().getDestination();
        Float award = tabMsg.getSelectionModel().getSelectedItem().getAward();
        Float price = tabMsg.getSelectionModel().getSelectedItem().getPrice();
        // spc.setDefaultText( name, typeE,desc, date, place,nb, theme,dest,award,price);

        spc.setid(ide);
        spc.setContent(ide);
        btnShow.getScene().setRoot(root);
    }

    public void aff() {
        ServiceEvent evenm = new ServiceEvent();

        ObservableList<Event> dataF = null;
        try {

            dataF = (ObservableList<Event>) evenm.readAll();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }


        cl_Name.setCellValueFactory(new PropertyValueFactory<>("nomEvent"));
        cl_type.setCellValueFactory(new PropertyValueFactory<>("typeEvent"));

        cl_date.setCellValueFactory(new PropertyValueFactory<>("dateEvent"));

        cl_nb.setCellValueFactory(new PropertyValueFactory<>("nbParticipants"));
        tabMsg.setItems(dataF);
    }

   /* @Override
    public void initialize(URL location, ResourceBundle resources) {

    }*/


    @FXML
    void showSent(MouseEvent event) {

    }

    @FXML
    void switchTheme(MouseEvent event) {

    }

    @FXML
    private void initialize() throws ClassNotFoundException, JSONException {
        aff();
        wm = new WeatherModel(cityID);
        System.out.println(wm.toString());

        cityNameLbl.textProperty().bindBidirectional(wm.cityNameProperty());
        descriptionLbl.textProperty().bindBidirectional(wm.descriptionProperty());
        temperatureLbl.textProperty().bindBidirectional(wm.temperatureProperty());
        pressureLbl.textProperty().bindBidirectional(wm.pressureProperty());
        humidityLbl.textProperty().bindBidirectional(wm.humidityProperty());
        windLbl.textProperty().bindBidirectional(wm.windProperty());

        iconLbl.setGraphic(new ImageView("http://openweathermap.org/img/w/" + wm.getIconID() + ".png"));
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
                Logger.getLogger(DShowEvent.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    private void toggle(ObservableValue<? extends Toggle> observable,
                        Toggle oldValue, Toggle newValue) throws JSONException, ClassNotFoundException {

        ToggleButton tBtn = (ToggleButton) newValue;
        switch (tBtn.getText()) {
            case "Tunis":
                cityID = 2464470; // City IDs provided by OWM ( not WOEID )
                break;
            case "London":
                cityID = 2643743;
                break;
            case "Sousse":
                cityID = 2464915;
                break;
        }
        initialize();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @FXML
    private void Youtube(MouseEvent event) {
        try {
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            stage.close();

            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("youtube.fxml")));
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void participer(MouseEvent event) throws SQLException, IOException {
        ServiceEvent eve = new ServiceEvent();
        // ServiceEvent se = new ServiceEvent();
        //ObservableList<Event> data = FXCollections.observableArrayList(se.Particip(e));
        Event e = tabMsg.getSelectionModel().getSelectedItem();
        int ide = tabMsg.getSelectionModel().getSelectedItem().getId();
        if( (e.getNbParticipants() > 0)  && ( !eve.testEvent("12Test", ide) )  ) {
            String name = e.getNomEvent();
            String typeE = e.getTypeEvent();
            String desc = e.getDescription();
            String date = e.getDateEvent();
            String place = e.getPlaceEvent();
            int nbnew = e.getNbParticipants() - 1;
            String theme = e.getTheme();
            String dest = e.getDestination();
            Float award = e.getAward();
            Float budgeet = e.getBudget();
            Float price = e.getPrice();
            e = new Event(ide, name, typeE, desc, date, place, nbnew, theme, dest, award, budgeet, price);

            eve.update(e, ide);


            //String source2 = event.getPickResult().getIntersectedNode().getId();
            //eve.ADDevent(ide, source2 );

            eve.ADDevent(ide, "12Test" );
            JOptionPane.showMessageDialog(null, "Thank you For your Participation !" );
            TrayNotification tray = new TrayNotification("Successfully", "You Are Now Part Of The Event "+ name, NotificationType.SUCCESS);
            tray.setAnimationType(AnimationType.SLIDE);
            tray.showAndDismiss(Duration.seconds(10));

        } else if (e.getNbParticipants() <= 0){
            String name = e.getNomEvent();
            String typeE = e.getTypeEvent();
            String desc = e.getDescription();
            String date = e.getDateEvent();
            String place = e.getPlaceEvent();
            int nbnew1 = e.getNbParticipants() ;
            String theme = e.getTheme();
            String dest = e.getDestination();
            Float award = e.getAward();
            Float budgeet = e.getBudget();
            Float price = e.getPrice();
            e = new Event(id, name, typeE, desc, date, place, nbnew1, theme, dest, award, budgeet, price);
            eve.update(e, ide);
            JOptionPane.showMessageDialog(null, "Sorry But There Are No More Empty Places For This Event!");

        } else {
            JOptionPane.showMessageDialog(null, "Sorry But You've already signed up for this event!");

        }

    }


    public void Cancel(MouseEvent event) throws SQLException, IOException {
        ServiceEvent eve = new ServiceEvent();
        Event ev = tabMsg.getSelectionModel().getSelectedItem();
        int ide = tabMsg.getSelectionModel().getSelectedItem().getId();
        if( eve.testEvent("12Test", ide) )   {

            Alert dialogC = new Alert(Alert.AlertType.CONFIRMATION);
            dialogC.setTitle("Confimation");
            dialogC.setHeaderText(null);
            dialogC.setContentText("Do you really want to cancel your participation for this Event ?");
            Optional<ButtonType> answer = dialogC.showAndWait();
            if (answer.get() == ButtonType.OK) {

            eve.deleteParticip( ide );

            String name = ev.getNomEvent();
            String typeE = ev.getTypeEvent();
            String desc = ev.getDescription();
            String date = ev.getDateEvent();
            String place = ev.getPlaceEvent();
            int nbnewb = ev.getNbParticipants() + 1;
            String theme = ev.getTheme();
            String dest = ev.getDestination();
            Float award = ev.getAward();
            Float budgeet = ev.getBudget();
            Float price = ev.getPrice();
            ev = new Event(ide, name, typeE, desc, date, place, nbnewb, theme, dest, award, budgeet, price);
            eve.update(ev, ide);
            JOptionPane.showMessageDialog(null, "You Are No Longer Part Of The Event "+name);
        }

        } else {
            JOptionPane.showMessageDialog(null, "Sorr");


        }

    }


    @FXML
    void ref (MouseEvent event)throws IOException {
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("DShowEvent.fxml"));
        Parent root=fxml.load();
        ref.getScene().setRoot(root);
    }
    @FXML
    private void qrCode(ActionEvent event) throws SQLException{
        QrCode q=new QrCode();


        if (tabMsg.getSelectionModel().getSelectedItem() == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("WARNING");
            alert.setContentText("Aucun element n'est selectionné");
            alert.showAndWait();
        }
        else{
            q.ini(tabMsg.getSelectionModel().getSelectedItem());
        }}


}