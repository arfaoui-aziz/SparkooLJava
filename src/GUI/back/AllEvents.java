package GUI.back;
import IService.IService;
import Entity.Event;
import Service.ServiceEvent;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.net.URL;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;



public class AllEvents implements Initializable {
    @FXML
    private Label logout;

    @FXML
    private HBox btnSchoolL;

    @FXML
    private TableView<Event> tabEvent;

    @FXML
    private TableColumn<?, ?> e_id;

    @FXML
    private TableColumn<?, ?> e_nom;

    @FXML
    private TableColumn<?, ?> e_type;

    @FXML
    private TableColumn<?, ?> e_desc;

    @FXML
    private TableColumn<?, ?> e_date;

    @FXML
    private TableColumn<?, ?> e_place;

    @FXML
    private TableColumn<?, ?> e_nb;

    @FXML
    private TableColumn<?, ?> e_theme;

    @FXML
    private TableColumn<?, ?> e_dest;

    @FXML
    private TableColumn<?, ?> e_award;

    @FXML
    private TableColumn<?, ?> e_budget;

    @FXML
    private TableColumn<?, ?> e_price;

    @FXML
    private void logOut(MouseEvent event) throws IOException {
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("/sample/login.fxml"));
        Parent root=fxml.load();
        logout.getScene().setRoot(root);
    }
    @FXML
    void addSchoolLife(MouseEvent event) throws IOException {
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("addEvent.fxml"));
        Parent root=fxml.load();
        btnSchoolL.getScene().setRoot(root);
    }


    public void aff(){
        ObservableList<Event> data = null;
        try {

            ServiceEvent event = new ServiceEvent();
            data = (ObservableList<Event>) event.readAll() ;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        e_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        e_nom.setCellValueFactory(new PropertyValueFactory<>("nomEvent"));
        e_type.setCellValueFactory(new PropertyValueFactory<>("typeEvent"));
        e_desc.setCellValueFactory(new PropertyValueFactory<>("description"));
        e_date.setCellValueFactory(new PropertyValueFactory<>("dateEvent"));
        e_place.setCellValueFactory(new PropertyValueFactory<>("placeEvent"));
        e_nb.setCellValueFactory(new PropertyValueFactory<>("nbParticipants"));
        e_theme.setCellValueFactory(new PropertyValueFactory<>("theme"));
        e_dest.setCellValueFactory(new PropertyValueFactory<>("destination"));
        e_award.setCellValueFactory(new PropertyValueFactory<>("award"));
        e_budget.setCellValueFactory(new PropertyValueFactory<>("budget"));
        e_price.setCellValueFactory(new PropertyValueFactory<>("price"));
        tabEvent.setItems(data);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        aff();
    }

}


