package GUI.back.Classe;

import Entity.Classe;

import Service.ServiceClasse;
import Service.ServiceUser;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Classes implements Initializable {

    @FXML
    private Label logout;

    @FXML
    private HBox btnAdd;

    @FXML
    private HBox btnUpdate;



    @FXML
    private TableView<Classe> tabClasses;

    @FXML
    private TableColumn<?, ?> cid;

    @FXML
    private TableColumn<?, ?> cName;

    @FXML
    private TableColumn<?, ?> cNumber;



    ObservableList<Classe> ClasseData = FXCollections.observableArrayList();

    public void affichage() {
        try {
            ServiceClasse classe = new ServiceClasse();
            ClasseData = (ObservableList<Classe>) classe.AfficherClasse();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        cid.setCellValueFactory(new PropertyValueFactory<>("classId"));
        cName.setCellValueFactory(new PropertyValueFactory<>("className"));
        cNumber.setCellValueFactory(new PropertyValueFactory<>("classNbr") );
        tabClasses.setItems(ClasseData);
    }

    @FXML
    void DeleteClasse(MouseEvent event) throws SQLException {
     int ClasseId = tabClasses.getSelectionModel().getSelectedItem().getClassId();
        tabClasses.getItems().removeAll(tabClasses.getSelectionModel().getSelectedItem());
        ServiceClasse classe = new ServiceClasse();
        classe.supprimer(ClasseId);

    }
     @FXML
     private void addClasse(MouseEvent event) throws IOException {
         FXMLLoader fxml = new FXMLLoader(getClass().getResource("addClasse.fxml"));
         Parent root = fxml.load();
         btnAdd.getScene().setRoot(root);
     }


    @FXML
    void UpdateClasse(MouseEvent event) throws IOException {
        int ClasseId = tabClasses.getSelectionModel().getSelectedItem().getClassId();
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("UpdateClasse.fxml"));
        Parent root = fxml.load();
        btnAdd.getScene().setRoot(root);

        UpdateClasse updateClasse = fxml.getController();
        updateClasse.recupID(ClasseId);
    }

    @FXML
    private void logOut(MouseEvent event) throws IOException {
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("/GUI/login.fxml"));
        Parent root = fxml.load();
        logout.getScene().setRoot(root);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        affichage();


    }
}