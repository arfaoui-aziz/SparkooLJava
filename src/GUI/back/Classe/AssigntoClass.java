package GUI.back.Classe;

import Entity.User;
import GUI.back.Student.StudentModify;
import Service.ServiceClasse;
import Service.ServiceUser;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AssigntoClass implements Initializable {

    @FXML
    private TableView<User> studentstoassign;

    @FXML
    private TableColumn<?, ?> firstname;
    @FXML
    private TableColumn<?, ?> lastname;
    @FXML
    private TableColumn<?, ?> cllass;
    @FXML
    private TableColumn<?, ?> academicyear;
    @FXML
    private TableColumn<User, Void> assign;
    @FXML
    private ComboBox comboclasse;
@FXML
    private HBox students;


    ObservableList<User> data = FXCollections.observableArrayList();
    ServiceUser user = new ServiceUser();
    public void Studentslist(){
        try {
            ServiceUser usr = new ServiceUser();
            data= (ObservableList<User>) user.StudentsList() ;
            System.out.println(data);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        firstname.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastname.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        cllass.setCellValueFactory(new PropertyValueFactory<>("classe_id"));
        academicyear.setCellValueFactory(new PropertyValueFactory<>("academicyear"));



        Callback<TableColumn<User, Void>, TableCell<User, Void>> AssignButton = new Callback<TableColumn<User, Void>, TableCell<User, Void>>() {
            @Override
            public TableCell<User, Void> call(final TableColumn<User, Void> param) {

                final TableCell<User, Void> cell = new TableCell<User, Void>() {
                    private final Button btn1 = new Button("Assign");
                    {
                        btn1.setOnAction((ActionEvent event) -> {
                            ServiceUser user = new ServiceUser();
                            User u = studentstoassign.getItems().get(getIndex());
                            try {
                                FXMLLoader loader = new FXMLLoader();
                                loader.setLocation(getClass().getResource("/GUI/back/Classe/Classassign.fxml"));
                                Parent root = loader.load();
                                btn1.getScene().setRoot(root);
                                ClassAssign controller = loader.getController();
                                controller.maindata(studentstoassign.getItems().get(getIndex()));
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn1);
                        }
                    }
                };
                return cell;
            }

        };

        assign.setCellFactory(AssignButton);
        studentstoassign.setItems(data);
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Studentslist();

    }

    @FXML
    private void gotoStudent(MouseEvent event) throws IOException {
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("/GUI/back/Student/Students.fxml"));
        Parent root=fxml.load();
        students.getScene().setRoot(root);
    }



}
