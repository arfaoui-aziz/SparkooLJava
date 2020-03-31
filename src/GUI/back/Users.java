package GUI.back;

import Entity.User;
import Service.ServiceUser;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Users implements Initializable{

    @FXML
    private Label logout;

    @FXML

    private HBox btnAdd;

    @FXML
    private TableView<User> tableParent;

    @FXML
    private TableColumn<?, ?> cl_id;

    @FXML
    private TableColumn<?, ?> cl_picture;

    @FXML
    private TableColumn<?, ?> cl_fn;

    @FXML
    private TableColumn<?, ?> cl_ln;

    @FXML
    private TableColumn<?, ?> cl_un;

    @FXML
    private TableColumn<?, ?> cl_gender;

    @FXML
    private TableColumn<?, ?> cl_adr;

    @FXML
    private TableColumn<?, ?> cl_occ;

    @FXML
    private TableColumn<?, ?> cl_phone;

    @FXML
    private TableColumn<?, ?> cl_mail;

    ObservableList<User> data = FXCollections.observableArrayList();
    ServiceUser user = new ServiceUser();












    @FXML
    private void addTeacher(MouseEvent event) throws IOException {
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("addUser.fxml"));
        Parent root=fxml.load();
        btnAdd.getScene().setRoot(root);
    }
    @FXML
    private void logOut(MouseEvent event) throws IOException {
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("/sample/login.fxml"));
        Parent root=fxml.load();
        logout.getScene().setRoot(root);
    }


    public void initialize (URL location,ResourceBundle resources) {
        try {

            ServiceUser user = new ServiceUser();
            data= (ObservableList<User>) user.readAll() ;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }



        cl_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        cl_adr.setCellValueFactory(new PropertyValueFactory<>("address"));
        cl_gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        cl_fn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        cl_ln.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        cl_mail.setCellValueFactory(new PropertyValueFactory<>("email"));
        cl_occ.setCellValueFactory(new PropertyValueFactory<>("occupation"));
        cl_picture.setCellValueFactory(new PropertyValueFactory<>("picture"));
        cl_un.setCellValueFactory(new PropertyValueFactory<>("username"));
        cl_phone.setCellValueFactory(new PropertyValueFactory<>("phone"));





        tableParent.setItems(data);
    }

}
