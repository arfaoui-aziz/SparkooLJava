package GUI.back;
import IService.IService;
import Entity.Event;
import Service.ServiceEvent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.Node;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.xml.soap.Text;


public class AllEvents implements Initializable {
    @FXML
    private Label logout;
    @FXML
    private Button trierEvent;
    @FXML
    private HBox recherche;
    @FXML
    private TextField idE;

    @FXML
    private HBox btnAdd;

    @FXML
    private HBox AllEvents;

    @FXML
    private HBox AllClubs;

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
    private HBox btnModify;

    @FXML
    private HBox btnDelete;
    @FXML
    private Button bmeteo;
    @FXML
    private HBox log;

    @FXML
    void logout(MouseEvent event) throws IOException {
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("../front/Dark/DShowEvent.fxml"));
        Parent root = fxml.load();
        log.getScene().setRoot(root);
    }

    @FXML
    void AllEvents(MouseEvent event) throws IOException {
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("AllEvents.fxml"));
        Parent root = fxml.load();
        AllEvents.getScene().setRoot(root);
    }

    @FXML
    private void AllClubs(MouseEvent event) throws IOException {
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("AllClubs.fxml"));
        Parent root = fxml.load();
        AllClubs.getScene().setRoot(root);
    }

    @FXML
    void addSchoolLife(MouseEvent event) throws IOException {
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("addEvent.fxml"));
        Parent root = fxml.load();
        btnAdd.getScene().setRoot(root);
    }

    ServiceEvent evenm = new ServiceEvent();


    public void aff() {
        ObservableList<Event> data = null;
        try {

            data = (ObservableList<Event>) evenm.readAll();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }


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

    @FXML
    private void deleteEvent(MouseEvent event) throws SQLException, IOException {
        Alert dialogC = new Alert(Alert.AlertType.CONFIRMATION);
        dialogC.setTitle("Confimation");
        dialogC.setHeaderText(null);
        dialogC.setContentText("Do you really want to delete this Event ?");
        Optional<ButtonType> answer = dialogC.showAndWait();
        if (answer.get() == ButtonType.OK) {
            Stage primaryStage = new Stage();
            int id = tabEvent.getSelectionModel().getSelectedItem().getId();
            tabEvent.getItems().removeAll(tabEvent.getSelectionModel().getSelectedItem());
            evenm.delete(id);
        }
    }

    @FXML
    void Update(MouseEvent event) throws IOException {

        FXMLLoader fxml = new FXMLLoader(getClass().getResource("UpdateEvent.fxml"));

        Parent root = fxml.load();
        btnModify.getScene().setRoot(root);
        UpdateEvent upEvent = fxml.getController();
        int ide = tabEvent.getSelectionModel().getSelectedItem().getId();
        String name = tabEvent.getSelectionModel().getSelectedItem().getNomEvent();
        String typeE = tabEvent.getSelectionModel().getSelectedItem().getTypeEvent();
        String desc = tabEvent.getSelectionModel().getSelectedItem().getDescription();
        String date = tabEvent.getSelectionModel().getSelectedItem().getDateEvent();
        String place = tabEvent.getSelectionModel().getSelectedItem().getPlaceEvent();
        int nb = tabEvent.getSelectionModel().getSelectedItem().getNbParticipants();
        String theme = tabEvent.getSelectionModel().getSelectedItem().getTheme();
        String dest = tabEvent.getSelectionModel().getSelectedItem().getDestination();
        Float award = tabEvent.getSelectionModel().getSelectedItem().getAward();
        Float budget = tabEvent.getSelectionModel().getSelectedItem().getBudget();
        Float price = tabEvent.getSelectionModel().getSelectedItem().getPrice();
        upEvent.setDefaultText(ide, name, typeE, desc, date, place, nb, theme, dest, award, budget, price);
    }

    @FXML
    private void recherche(MouseEvent event) throws SQLException {
        String nomE = idE.getText();
        ServiceEvent se = new ServiceEvent();
        ObservableList<Event> data = FXCollections.observableArrayList(se.SearchEvent(nomE));

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



   /* @FXML
    private void trierEvent(MouseEvent event)  throws IOException,SQLException{
        ServiceEvent se = new ServiceEvent();
        ObservableList<Event> data = FXCollections.observableArrayList(se.trier());


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

*/
    @FXML
    private void meteo(ActionEvent event) {
        try {
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            stage.close();

            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("owm.fxml")));
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }



}










