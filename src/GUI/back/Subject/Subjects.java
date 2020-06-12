package GUI.back.Subject;

import Entity.Classe;
import Entity.Subject;
import GUI.back.Classe.UpdateClasse;
import Service.ServiceClasse;
import Service.ServiceSubject;
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

public class Subjects implements Initializable {

    @FXML
    private Label logout;

    @FXML
    private HBox btnAdd;

    @FXML
    private HBox btnUpdate;



    @FXML
    private TableView<Subject> tabSubjects;

    @FXML
    private TableColumn<?, ?> sid;

    @FXML
    private TableColumn<?, ?> sName;

    @FXML
    private TableColumn<?, ?> sCoeficient;

    @FXML
    private TableColumn<?, ?> sClasse;




    ObservableList<Subject> SubjectData = FXCollections.observableArrayList();

    public void affichage() {
        try {
            ServiceSubject subject = new ServiceSubject();
            SubjectData = (ObservableList<Subject>) subject.AfficherSubject();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        sid.setCellValueFactory(new PropertyValueFactory<>("id"));
        sName.setCellValueFactory(new PropertyValueFactory<>("SubjectName"));
        sCoeficient.setCellValueFactory(new PropertyValueFactory<>("coefficient") );
        sClasse.setCellValueFactory(new PropertyValueFactory<>("SubjectByClasse") );
        tabSubjects.setItems(SubjectData);
    }

    @FXML
    void DeleteClasse(MouseEvent event) throws SQLException {
        int SubjectId = tabSubjects.getSelectionModel().getSelectedItem().getId();
        tabSubjects.getItems().removeAll(tabSubjects.getSelectionModel().getSelectedItem());
        ServiceSubject subject = new ServiceSubject();
        subject.supprimer(SubjectId);

    }
     @FXML
     private void addClasse(MouseEvent event) throws IOException {
         FXMLLoader fxml = new FXMLLoader(getClass().getResource("addSubject.fxml"));
         Parent root = fxml.load();
         btnAdd.getScene().setRoot(root);
     }


    @FXML
    void UpdateClasse(MouseEvent event) throws IOException {
        int SubjectId = tabSubjects.getSelectionModel().getSelectedItem().getId();
        String SubjectName = tabSubjects.getSelectionModel().getSelectedItem().getSubjectName();
        int Coefficient = tabSubjects.getSelectionModel().getSelectedItem().getCoefficient();
        String SubjectByClasse = tabSubjects.getSelectionModel().getSelectedItem().getSubjectByClasse();
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("updateSubject.fxml"));
        Parent root = fxml.load();
        btnAdd.getScene().setRoot(root);

        updateSubject upSubject = fxml.getController();
        upSubject.recupID(SubjectId,SubjectName,Coefficient,SubjectByClasse);
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