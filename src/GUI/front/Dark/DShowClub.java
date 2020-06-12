package GUI.front.Dark;


import Entity.Club;
import Entity.Event;
import Service.ServiceClub;
import Service.ServiceEvent;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;
import java.io.IOException;
import java.util.Optional;


public class DShowClub extends Application {

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
    private Label ref;

    @FXML
    private Label rep;

    @FXML
    private HBox btnOpen;

    @FXML
    private HBox btnCompose;

    @FXML
    private Label bpart;

    @FXML
    private HBox btnCompose1;

    @FXML
    private Label bcancel;
    @FXML
    private TableView<Club> tabMsg;

    @FXML
    private TableColumn<?, ?> cl_id;

    @FXML
    private TableColumn<?, ?> cl_Name;

    @FXML
    private TableColumn<?, ?> cl_memb;

    @FXML
    private TableColumn<?, ?> cl_act;

    @FXML
    private TableColumn<?, ?> cl_date;
    @FXML
    private ImageView gotoClub;
    @FXML
    private ImageView gotoEvent;



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
    public void aff() {
        ServiceClub cluuub = new ServiceClub();

        ObservableList<Club> dataF = null;
        try {

            dataF = (ObservableList<Club>) cluuub.readAll();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }


        cl_Name.setCellValueFactory(new PropertyValueFactory<>("nomClub"));
        cl_memb.setCellValueFactory(new PropertyValueFactory<>("members"));

        cl_act.setCellValueFactory(new PropertyValueFactory<>("activity"));

        cl_date.setCellValueFactory(new PropertyValueFactory<>("dateCreation"));
        tabMsg.setItems(dataF);
    }

    @FXML
    private void initialize()  {
        aff();
    }

    @FXML
    public void participer(MouseEvent event) throws SQLException, IOException {
        ServiceClub cl = new ServiceClub();

        Club c =  tabMsg.getSelectionModel().getSelectedItem();
        int idc = tabMsg.getSelectionModel().getSelectedItem().getIdClub();
        if ((c.getMembers() > 0) && (!cl.testClub("12Test", idc))) {
            String name = c.getNomClub();
            int memnew = c.getMembers() - 1;
            String act = c.getActivity();
            Float bud = c.getBudget();
            String date = c.getDateCreation();

                c = new Club(idc, name, memnew, act, bud, date);

            cl.update(c, idc);

            //String source2 = event.getPickResult().getIntersectedNode().getId();
            //eve.ADDevent(ide, source2 );

            cl.ADDclub(idc, "12Test");
            JOptionPane.showMessageDialog(null, " You Will Receive An Email With More Details !");
            TrayNotification tray = new TrayNotification("Successfully", "Thank you For your Participation! " + name, NotificationType.SUCCESS);
            tray.setAnimationType(AnimationType.SLIDE);
            tray.showAndDismiss(Duration.seconds(10));

        } else if (c.getMembers() <= 0) {
            String name = c.getNomClub();
            int memnew = c.getMembers() ;
            String act = c.getActivity();
            Float bud = c.getBudget();
            String date = c.getDateCreation();
            c = new Club(idc, name, memnew, act, bud, date);
            cl.update(c, idc);
            JOptionPane.showMessageDialog(null, "Sorry But There Are No More Available Interviews For This Club!");

        } else {
            JOptionPane.showMessageDialog(null, "Sorry But You've already signed up for this Club!");

        }
}

    public void Cancel(MouseEvent event) throws SQLException, IOException {
        ServiceClub cluuub = new ServiceClub();
        Club c = tabMsg.getSelectionModel().getSelectedItem();
        int idc = tabMsg.getSelectionModel().getSelectedItem().getIdClub();
        if( cluuub.testClub("12Test", idc) )   {

            Alert dialogC = new Alert(Alert.AlertType.CONFIRMATION);
            dialogC.setTitle("Confimation");
            dialogC.setHeaderText(null);
            dialogC.setContentText("Do you really want to cancel your participation for this Club ?");
            Optional<ButtonType> answer = dialogC.showAndWait();
            if (answer.get() == ButtonType.OK) {

                cluuub.deleteParticipC( idc);

                String name = c.getNomClub();
                int memnew = c.getMembers() +1;
                String act = c.getActivity();
                Float bud = c.getBudget();
                String date = c.getDateCreation();
                c = new Club(idc, name, memnew, act, bud, date);
                cluuub.update(c, idc);
                JOptionPane.showMessageDialog(null, "You Are No Longer Part Of This Club"+name);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Sorr");


        }

    }





    @FXML
    void ref (MouseEvent event)throws IOException {
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("DShowClub.fxml"));
        Parent root=fxml.load();
        ref.getScene().setRoot(root);
    }

    @FXML
    private void gotoEvent (MouseEvent event) throws IOException {
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("DShowEvent.fxml"));
        Parent root=fxml.load();
        gotoEvent.getScene().setRoot(root);
    }
    @FXML
    private void gotoClub(MouseEvent event) throws IOException {
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("DShowClub.fxml"));
        Parent root=fxml.load();
        gotoClub.getScene().setRoot(root);
    }
    @FXML
    void replied(MouseEvent event) {

    }

    @FXML
    void switchTheme(MouseEvent event) {

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");

    }

}
