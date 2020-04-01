package GUI.back;

import Entity.User;
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
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Users implements Initializable {

    @FXML
    private Label logout;

    @FXML
    private HBox btnAdd;

    @FXML
    private HBox btnUpdate;



    @FXML
    private TableView<User> tabUsers;

    @FXML
    private TableColumn<?, ?> id;

    @FXML
    private TableColumn<?, ?> userN;

    @FXML
    private TableColumn<?, ?> name;


    @FXML
    private TableColumn<?, ?> gender;

    @FXML
    private TableColumn<?, ?> address;

    @FXML
    private TableColumn<?, ?> phone;

    @FXML
    private TableColumn<?, ?> email;



    ObservableList<User> UserData = FXCollections.observableArrayList();

    public void affichage() {
        try {
            ServiceUser user = new ServiceUser();
            UserData = (ObservableList<User>) user.AfficherUser();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        userN.setCellValueFactory(new PropertyValueFactory<>("username"));
        name.setCellValueFactory(new PropertyValueFactory<>("firstName") );
        gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        address.setCellValueFactory(new PropertyValueFactory<>("address"));
        phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));

        tabUsers.setItems(UserData);
    }
    @FXML
    void DeleteUser(MouseEvent event) throws SQLException {
       String UserId = tabUsers.getSelectionModel().getSelectedItem().getId();
        tabUsers.getItems().removeAll(tabUsers.getSelectionModel().getSelectedItem());
        ServiceUser user = new ServiceUser();
        user.supprimer(UserId);

    }
     @FXML
     private void addUser(MouseEvent event) throws IOException {
         FXMLLoader fxml = new FXMLLoader(getClass().getResource("addUser.fxml"));
         Parent root = fxml.load();
         btnAdd.getScene().setRoot(root);
     }


    @FXML
    void UpdateUser(MouseEvent event) throws IOException {

        FXMLLoader fxml = new FXMLLoader(getClass().getResource("UpdateUser.fxml"));

        Parent root = fxml.load();
        btnUpdate.getScene().setRoot(root);
        UpdateUser upUser = fxml.getController();
        String idu = tabUsers.getSelectionModel().getSelectedItem().getId();
        String firstNu = tabUsers.getSelectionModel().getSelectedItem().getFirstName();
        String lastNu = tabUsers.getSelectionModel().getSelectedItem().getLastName();
        String username = tabUsers.getSelectionModel().getSelectedItem().getUsername();
        String genderu = tabUsers.getSelectionModel().getSelectedItem().getGender();
        String roleu = tabUsers.getSelectionModel().getSelectedItem().getRoles();
        String userTu = tabUsers.getSelectionModel().getSelectedItem().getUserType();
        String dateBu = tabUsers.getSelectionModel().getSelectedItem().getDateOfBirth();
        String joiningDu = tabUsers.getSelectionModel().getSelectedItem().getJoiningDate();
        String mailu = tabUsers.getSelectionModel().getSelectedItem().getEmail();
        Float salaireu = tabUsers.getSelectionModel().getSelectedItem().getSalaire();
        String phoneu = tabUsers.getSelectionModel().getSelectedItem().getPhone();
        String addressu = tabUsers.getSelectionModel().getSelectedItem().getAddress();
        upUser.setDefaultText(idu,firstNu,lastNu,genderu,roleu,userTu,dateBu,joiningDu,mailu,salaireu,phoneu,addressu);
    }

    @FXML
    private void logOut(MouseEvent event) throws IOException {
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("../login.fxml"));
        Parent root = fxml.load();
        logout.getScene().setRoot(root);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        affichage();


    }
}