package GUI.back;

import Entity.Delay;
import Entity.User;
import Service.ServiceContactTeacher;
import Service.ServiceDelay;
import Service.ServiceUser;
import Utils.DataBase;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.crypto.NullCipher;
import javax.swing.*;
import javax.swing.text.html.ImageView;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Predicate;
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
    private Label inbox;

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

    @FXML
    private HBox btnShow;

    @FXML
    private HBox btnAbsence;

    @FXML
    private HBox btnDelay;

    @FXML
    private HBox btnCourses;

    @FXML
    private HBox btnAtt;

    @FXML
    private JFXTextField fn;

    @FXML
    private HBox btnSchedule;

    @FXML
    private Button btnSearch;


    ObservableList<User> data = FXCollections.observableArrayList();
    ServiceUser user = new ServiceUser();

    public void aff() {
        try {
            ServiceUser usr = new ServiceUser();
            data = (ObservableList<User>) user.readAll();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        cl_id.setCellValueFactory(new PropertyValueFactory<>("id"));
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
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("addTeacher.fxml"));
        Parent root = fxml.load();
        btnAdd.getScene().setRoot(root);
    }

    @FXML
    private void logOut(MouseEvent event) throws IOException {
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("/sample/login.fxml"));
        Parent root = fxml.load();
        logout.getScene().setRoot(root);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        aff();
        searchBy();
        try {
            setNbNotShowed();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
        } else {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("ModifyTeacher.fxml"));
            Parent root = loader.load();
            btnModify.getScene().setRoot(root);
            ModifyTeacher controller = loader.getController();
            controller.initData(tabTeacher.getSelectionModel().getSelectedItem());

        }
    }


    @FXML
    void showTeacher(MouseEvent event) throws IOException, SQLException {
       /* FXMLLoader fxml=new FXMLLoader(getClass().getResource("detailTeacher.fxml"));
        Parent root=fxml.load();
        logout.getScene().setRoot(root);*/
        User u = tabTeacher.getSelectionModel().getSelectedItem();
        Stage primaryStage = new Stage();
        if (u == null) {
            Parent root1 = FXMLLoader.load(getClass().getResource("error.fxml"));
            primaryStage.initStyle(StageStyle.UNDECORATED);
            primaryStage.setScene(new Scene(root1, 280, 400));
            primaryStage.show();
        }else {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("detailTeacher.fxml"));
            Parent root = loader.load();
            btnShow.getScene().setRoot(root);
            DetailTeacher controller = loader.getController();
            controller.setLabels(tabTeacher.getSelectionModel().getSelectedItem());
        }
    }

    @FXML
    void Absence(MouseEvent event) throws IOException {

        User u = tabTeacher.getSelectionModel().getSelectedItem();
        Stage primaryStage = new Stage();
        if (u == null) {
            Parent root1 = FXMLLoader.load(getClass().getResource("error.fxml"));
            primaryStage.initStyle(StageStyle.UNDECORATED);
            primaryStage.setScene(new Scene(root1, 280, 400));
            primaryStage.show();
        }else {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("addAbsence.fxml"));
            Parent root = loader.load();
            primaryStage.initStyle(StageStyle.UNDECORATED);
            primaryStage.setScene(new Scene(root, 280, 400));
            primaryStage.show();
            AddAbsence controller = loader.getController();
            controller.initData(tabTeacher.getSelectionModel().getSelectedItem().getId());
        }

    }
    @FXML
    void Delay(MouseEvent event) throws IOException {

        User u = tabTeacher.getSelectionModel().getSelectedItem();
        Stage primaryStage = new Stage();
        if (u == null) {
            Parent root1 = FXMLLoader.load(getClass().getResource("error.fxml"));
            primaryStage.initStyle(StageStyle.UNDECORATED);
            primaryStage.setScene(new Scene(root1, 280, 400));
            primaryStage.show();
        }else {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("addDelay.fxml"));
            Parent root = loader.load();
            primaryStage.initStyle(StageStyle.UNDECORATED);
            primaryStage.setScene(new Scene(root, 280, 400));
            primaryStage.show();
            AddDelay controller = loader.getController();
            controller.initData(tabTeacher.getSelectionModel().getSelectedItem().getId());

        }
    }

    @FXML
    void Attendance(MouseEvent event) throws IOException {






        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("showAbsence.fxml"));
        Parent root = loader.load();
        btnAtt.getScene().setRoot(root);
        ShowAbsence controller = loader.getController();
        controller.initData(tabTeacher.getSelectionModel().getSelectedItem().getId());

    }

    @FXML
    void searchBy() {
        FilteredList<User> filteredData=new FilteredList<>(data, b -> true);
        fn.setOnKeyReleased(e->{
            fn.textProperty().addListener((observable, oldValue, newValue) -> {
                filteredData.setPredicate((Predicate<? super User>) User -> {
                    // If filter text is empty, display all persons.

                    if (newValue == null || newValue.isEmpty()) {
                        return true;
                    }

                    // Compare first name and last name of every person with filter text.
                    String lowerCaseFilter = newValue.toLowerCase();

                    if (User.getFirstName().toLowerCase().contains(lowerCaseFilter) ) {
                        return true; // Filter matches first name.
                    } else if (User.getLastName().toLowerCase().contains(lowerCaseFilter)) {
                        return true; }
                    else if (User.getId().toLowerCase().contains(lowerCaseFilter)) {
                        return true; }
                    //else if (Reclamation.getIdR().contains(newValue)){
                    // return true;}

                    return false; // Does not match.
                });
            });
            SortedList<User>soretedData=new SortedList<>(filteredData);
            soretedData.comparatorProperty().bind(tabTeacher.comparatorProperty());
            tabTeacher.setItems(soretedData);
        });
    }


    private void setNbNotShowed() throws SQLException {
        ServiceContactTeacher ct = new ServiceContactTeacher();

        inbox.setText("Inbox ("+ct.NumberOfNotShowed()+")");

    }


    @FXML
    void gotoBox(MouseEvent event) throws IOException {
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("showBox.fxml"));
        Parent root = fxml.load();
        btnAdd.getScene().setRoot(root);
    }

    @FXML
    void Courses(MouseEvent event) throws IOException {
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("courses.fxml"));
        Parent root = fxml.load();
        btnCourses.getScene().setRoot(root);
    }


    @FXML
    void gotoSchedule(MouseEvent event) throws IOException, SQLException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("scheduleTeacher.fxml"));
        Parent root = loader.load();
        btnSchedule.getScene().setRoot(root);
        ScheduleTeacher controller = loader.getController();
        controller.initData(tabTeacher.getSelectionModel().getSelectedItem().getId());

    }
}
