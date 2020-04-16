package GUI.front.Dark;

import Entity.Event;
import Service.ServiceEvent;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

import javax.swing.*;

public class DShowEventDetail implements Initializable  {

    public static int ide;
   private int id;
    @FXML
    private Button breturn;
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
    private Label id1;

    @FXML
    private Label nomE;


    @FXML
    private Label desc;

    @FXML
    private Label typeE;

    @FXML
    private Label dateE;

    @FXML
    private Label place;

    @FXML
    private Label nb;
    @FXML
    private Label theme;

    @FXML
    private Label destination;

    @FXML
    private Label award;

    @FXML
    private Label price;

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
    void replied(MouseEvent event) {

    }

    @FXML
    void showSent(MouseEvent event) {

    }

    @FXML
    void switchTheme(MouseEvent event) {

    }



    public void setDefaultText(String eventName, String eventType,String eventDescription,String eventDate,String eventPlace,int nb,String theme,String destination, Float award , Float price) {

     //  this.id1.setText(String.valueOf((id)));
        this.nomE.setText(eventName);
        this.typeE.setText(eventType);
        this.desc.setText(eventDescription);
        this.dateE.setText(eventDate);
        this.place.setText(eventPlace);
        this.nb.setText(String.valueOf((nb)));
        this.theme.setText(theme);
        this.destination.setText(destination);
        this.award.setText(String.valueOf(award));
        this.price.setText(String.valueOf(price));

    }

    public void setContent(int id) {

        Event n = new Event();
        ide = id;
        n.setId(id);
        System.out.println(id);
        ServiceEvent sn = new ServiceEvent();
        try {
            n = sn.readID(n);
            nomE.setText(n.getNomEvent());
            typeE.setText(n.getTypeEvent());
            desc.setText(n.getDescription());
            dateE.setText(n.getDateEvent());
            place.setText(n.getPlaceEvent());
            nb.setText(String.valueOf(n.getNbParticipants()));
            theme.setText(n.getTheme());
            destination.setText(n.getDestination());
            award.setText(String.valueOf(n.getAward()));

            price.setText(String.valueOf(n.getPrice()));

        } catch (SQLException ex) {
            Logger.getLogger(DShowEventDetail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setid(int id) {
        this.id = id;
    }
   // @Override
    public void initialize(URL url, ResourceBundle rb) {}

    @FXML
    void Return (MouseEvent event)throws IOException {
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("DShowEvent.fxml"));
        Parent root=fxml.load();
        breturn.getScene().setRoot(root);
    }

    public void participer(MouseEvent event) throws SQLException, IOException {
        ServiceEvent eve = new ServiceEvent();
        // ServiceEvent se = new ServiceEvent();
        //ObservableList<Event> data = FXCollections.observableArrayList(se.Particip(e));
        Event e= new Event();
        e= eve.readID(e);
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
        Event ev= new Event();
        ev = eve.readID(ev);
       // nomE.setText(n.getNomEvent());

        int ide = ev.getId();
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
}
