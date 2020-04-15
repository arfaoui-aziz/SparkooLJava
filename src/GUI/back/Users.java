package GUI.back;

import Entity.User;
import Service.ServiceUser;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.function.Predicate;

public class Users implements Initializable{

    @FXML
    private Label logout;

    @FXML

    private HBox btnAdd;


    @FXML

    private HBox btnDelete;

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

    @FXML
    private HBox btnUpdate;

    @FXML
    private JFXTextField searchBarr;
    @FXML
    private HBox btnClaim;

    ObservableList<User> data = FXCollections.observableArrayList();
    ServiceUser user = new ServiceUser();











    @FXML
    private HBox home;



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

    @FXML
    private void delete(MouseEvent event) throws SQLException, IOException {

        User u = tableParent.getSelectionModel().getSelectedItem();

            tableParent.getItems().removeAll(tableParent.getSelectionModel().getSelectedItem());
            user.delete(u.getId());

    }


    @FXML
    void ModifyTeacher(MouseEvent event) throws IOException {


        User u = tableParent.getSelectionModel().getSelectedItem();



            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("updateUser.fxml"));
            Parent root = loader.load();
            btnUpdate.getScene().setRoot(root);
            UpdateUser controller = loader.getController();
            controller.initData(tableParent.getSelectionModel().getSelectedItem());


    }

    @FXML

    public void initialize (URL location,ResourceBundle resources) {
        try {

            ServiceUser user = new ServiceUser();
            data= (ObservableList<User>) user.readAllParents() ;
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
        searchBy();
    }


    @FXML
    void searchBy() {
        FilteredList<User> filteredData=new FilteredList<>(data, b -> true);
        searchBarr.setOnKeyReleased(e->{
            searchBarr.textProperty().addListener((observable, oldValue, newValue) -> {
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
            SortedList<User> soretedData=new SortedList<>(filteredData);
            soretedData.comparatorProperty().bind(tableParent.comparatorProperty());
            tableParent.setItems(soretedData);
        });
    }


    @FXML
    void showClaims(MouseEvent event) throws IOException {
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("showReclamation.fxml"));
        Parent root=fxml.load();
        btnAdd.getScene().setRoot(root);

    }

}
