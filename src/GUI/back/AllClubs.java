package GUI.back;
import Entity.Club;
import Service.ServiceClub;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

public class AllClubs  implements Initializable {

    @FXML
    private Label logout;

    @FXML
    private HBox AllEvents;

    @FXML
    private HBox AllClubs;

    @FXML
    private HBox btnAdd;


    @FXML
    private HBox btnDelete;


    @FXML
    private HBox btnModify;


    @FXML
    private TableView<Club> tabClub;

    @FXML
    private TableColumn<?, ?> e_id;

    @FXML
    private TableColumn<?, ?> e_nom;

    @FXML
    private TableColumn<?, ?> e_members;

    @FXML
    private TableColumn<?, ?> e_activity;

    @FXML
    private TableColumn<?, ?> e_date;

    @FXML
    private TableColumn<?, ?> e_budget;

    @FXML
    void AllClubs(MouseEvent event) throws IOException {
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("AllClubs.fxml"));
        Parent root=fxml.load();
        AllClubs.getScene().setRoot(root);
    }

    @FXML
    void AllEvents(MouseEvent event) throws IOException  {
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("AllEvents.fxml"));
        Parent root=fxml.load();
        AllEvents.getScene().setRoot(root);

    }
    ServiceClub Sclub = new ServiceClub();

    public void affC(){

        ObservableList<Club> dataClub = null;
        try {

            dataClub = (ObservableList<Club>) Sclub.readAll() ;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        e_id.setCellValueFactory(new PropertyValueFactory<>("idClub"));
        e_nom.setCellValueFactory(new PropertyValueFactory<>("nomClub"));
        e_members.setCellValueFactory(new PropertyValueFactory<>("members"));
        e_activity.setCellValueFactory(new PropertyValueFactory<>("activity"));
        e_budget.setCellValueFactory(new PropertyValueFactory<>("budget"));
        e_date.setCellValueFactory(new PropertyValueFactory<>("dateCreation"));
        tabClub.setItems(dataClub);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        affC();
    }


    @FXML
    void addClub(MouseEvent event) throws IOException{
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("AddClub.fxml"));
        Parent root=fxml.load();
        btnAdd.getScene().setRoot(root);
    }

    @FXML
    void UpdateClub(MouseEvent event) throws IOException {

        FXMLLoader fxml = new FXMLLoader(getClass().getResource("UpdateClub.fxml"));
        Parent root = fxml.load();
        btnModify.getScene().setRoot(root);
        UpdateClub upClub = fxml.getController();
        int idc = tabClub.getSelectionModel().getSelectedItem().getIdClub();
        String name = tabClub.getSelectionModel().getSelectedItem().getNomClub();
        int memb = tabClub.getSelectionModel().getSelectedItem().getMembers();
        String act = tabClub.getSelectionModel().getSelectedItem().getActivity();
        Float budget = tabClub.getSelectionModel().getSelectedItem().getBudget();
        String date = tabClub.getSelectionModel().getSelectedItem().getDateCreation();

        upClub.setDefaultText(idc,name,memb,act,budget,date);
    }


    @FXML
    void deleteClub(MouseEvent event) throws SQLException, IOException {
        Alert dialogC = new Alert(Alert.AlertType.CONFIRMATION);
        dialogC.setTitle("Confimation");
        dialogC.setHeaderText(null);
        dialogC.setContentText("Do you really want to delete this Club ?");
        Optional<ButtonType> answer = dialogC.showAndWait();
        if (answer.get() == ButtonType.OK) {
        Stage primaryStage = new Stage();
        int id = tabClub.getSelectionModel().getSelectedItem().getIdClub();
        tabClub.getItems().removeAll(tabClub.getSelectionModel().getSelectedItem());
        Sclub.delete(id);}

    }

    @FXML
    void logOut(MouseEvent event) {

    }

}
