package GUI.back.Student;

import Entity.User;
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
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class StudentVerify  implements Initializable

{


        @FXML
        private TableView<User> StudentsTable ;

        @FXML
        private TableColumn<?, ?> FN_S;
        @FXML
        private TableColumn<?, ?> LN_S;

        @FXML
        private TableColumn<?, ?> Adress_S;
        @FXML
        private TableColumn<?, ?> Phone_S;
        @FXML
        private TableColumn<?, ?> Email_S;
        @FXML
        private TableColumn<?, ?> etat_S;
        @FXML
        private TableColumn<?, ?> BloodGroupS;
        @FXML
        private TableColumn<User, Void> DeleteS;

        @FXML
        private TableColumn<User, Void> DetailS;

        @FXML
        private Label logout;


        @FXML
        private HBox gotoTeacher;

        @FXML
        private HBox students;

        @FXML
        private VBox StudentsList;

    @FXML
    private Text lblName;



    public void maindata(String UserN){
        lblName.setText(UserN);
        System.out.println(UserN);
    }


    @FXML
    private void gotoStudent(MouseEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/GUI/back/Student/Students.fxml"));
        Parent root = loader.load();
        students.getScene().setRoot(root);
        Students controller = loader.getController();
        controller.maindata(lblName.getText());
    }

    ObservableList<User> data = FXCollections.observableArrayList();
    ServiceUser user = new ServiceUser();
    public void UnverifyedList(){
        try {
            ServiceUser usr = new ServiceUser();
            data= (ObservableList<User>) user.Unverif() ;
            System.out.println(data);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        FN_S.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        LN_S.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        Adress_S.setCellValueFactory(new PropertyValueFactory<>("address"));
        Phone_S.setCellValueFactory(new PropertyValueFactory<>("phone"));
        Email_S.setCellValueFactory(new PropertyValueFactory<>("email"));
        etat_S.setCellValueFactory(new PropertyValueFactory<>("enabled"));
        BloodGroupS.setCellValueFactory(new PropertyValueFactory<>("bloodGroup"));
        Callback<TableColumn<User, Void>, TableCell<User, Void>> Show = new Callback<TableColumn<User, Void>, TableCell<User, Void>>() {
            @Override
            public TableCell<User, Void> call(final TableColumn<User, Void> param) {

                final TableCell<User, Void> cell = new TableCell<User, Void>() {
                    private final Button btn1 = new Button("Show");
                    {
                        btn1.setOnAction((ActionEvent event) -> {
                            ServiceUser user = new ServiceUser();
                            User u = StudentsTable.getItems().get(getIndex());

                            try {
                                FXMLLoader loader = new FXMLLoader();
                                loader.setLocation(getClass().getResource("/GUI/back/Student/StudentDetails.fxml"));
                                Parent root = loader.load();
                                btn1.getScene().setRoot(root);
                                StudentDetails controller = loader.getController();
                                controller.maindata(StudentsTable.getItems().get(getIndex()) , lblName.getText());
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


        DetailS.setCellFactory(Show);
        StudentsTable.setItems(data);
    }



    @FXML
    private void gotoTeatcher(MouseEvent event) throws IOException {
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("../Users.fxml"));
        Parent root=fxml.load();
        gotoTeacher.getScene().setRoot(root);
    }

    @FXML
    private void logOut(MouseEvent event) throws IOException {
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("/GUI/login.fxml"));
        Parent root=fxml.load();
        logout.getScene().setRoot(root);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        UnverifyedList();
    }
}
