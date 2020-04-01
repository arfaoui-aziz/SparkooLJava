package GUI.back;

import Entity.User;
import Service.ServiceUser;
import Utils.DataBase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.crypto.NullCipher;
import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class Teachers implements Initializable {

    @FXML
    private Label logout;

    @FXML
    private HBox btnAdd;
    @FXML
    private HBox btnDelete;
    @FXML
    private TableView<User> tabTeacher;

    @FXML
    private TableColumn<?, ?> cl_id;

    @FXML
    private TableColumn<?, ?> cl_photo;

    @FXML
    private TableColumn<?, ?> cl_name;

    @FXML
    private TableColumn<?, ?> cl_name1;


    @FXML
    private TableColumn<?, ?> cl_gender;

    @FXML
    private TableColumn<?, ?> cl_address;

    @FXML
    private TableColumn<?, ?> cl_phone;

    @FXML
    private TableColumn<?, ?> cl_email;

    @FXML
    private HBox btnModify;


    ObservableList<User> data = FXCollections.observableArrayList();
    ServiceUser user = new ServiceUser();
    public void aff(){
        try {
ServiceUser usr = new ServiceUser();
            data= (ObservableList<User>) user.readAll() ;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        cl_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        cl_photo.setCellValueFactory(new PropertyValueFactory<>("picture"));
        cl_name.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        cl_name1.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        cl_gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        cl_address.setCellValueFactory(new PropertyValueFactory<>("address"));
        cl_phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        cl_email.setCellValueFactory(new PropertyValueFactory<>("email"));
        tabTeacher.setItems(data);
    }

    @FXML
    private void delete(MouseEvent event) throws SQLException, IOException {
        Stage primaryStage = new Stage();
        User u = tabTeacher.getSelectionModel().getSelectedItem();
        if (u == null) {
            Parent root = FXMLLoader.load(getClass().getResource("error.fxml"));
            primaryStage.initStyle(StageStyle.UNDECORATED);
            primaryStage.setScene(new Scene(root, 280, 400));
            primaryStage.show();
        } else {
            tabTeacher.getItems().removeAll(tabTeacher.getSelectionModel().getSelectedItem());
            user.delete(u.getId());
        }
    }

    @FXML
    private void addTeacher(MouseEvent event) throws IOException {
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("addTeacher.fxml"));
        Parent root=fxml.load();
        btnAdd.getScene().setRoot(root);
    }

    @FXML
    private void logOut(MouseEvent event) throws IOException {
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("/sample/login.fxml"));
        Parent root=fxml.load();
        logout.getScene().setRoot(root);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        aff();
    }

    @FXML
    void ModifyTeacher(MouseEvent event) throws IOException {


        User u = tabTeacher.getSelectionModel().getSelectedItem();
        Stage primaryStage = new Stage();

        if (u == null) {
            Parent root1 = FXMLLoader.load(getClass().getResource("error.fxml"));
            primaryStage.initStyle(StageStyle.UNDECORATED);
            primaryStage.setScene(new Scene(root1, 280, 400));
            primaryStage.show();
        }
        else{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("ModifyTeacher.fxml"));
            Parent root = loader.load();
            btnModify.getScene().setRoot(root);
            ModifyTeacher controller = loader.getController();
            controller.initData(tabTeacher.getSelectionModel().getSelectedItem());

        }
    }

}
