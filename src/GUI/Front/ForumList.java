package GUI.Front;

import Entity.Forum;
import Entity.User;
import GUI.back.Student.StudentModify;
import Service.ServiceForum;
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
import javafx.scene.layout.VBox;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ForumList implements Initializable {


    @FXML
    private TableView<Forum> tabMsg;
    ObservableList<Entity.Forum> data = FXCollections.observableArrayList();
    @FXML
    private TableColumn<?, ?> cl_subject;
    @FXML
    private TableColumn<?, ?> cl_subject1;
    @FXML
    private TableColumn<?, ?> cl_subject11;
    @FXML
    private TableColumn<?, ?> cl_subject111;
    @FXML
    private TableColumn<?, ?> cl_subject1111;
    @FXML
    private TableColumn<?, ?> cl_subject11111;
    @FXML
    private TableColumn<?, ?> cl_subject111111;
    @FXML
    private TableColumn<Forum, Void> cl_subject1111111;
    @FXML
    private Label lblName;

    @FXML
    private VBox home;
    @FXML
    private VBox btnInfo;
    @FXML
    private VBox btnMarks;
    @FXML
    private VBox btnCourse;
    @FXML
    private VBox btnMessage;
    @FXML
    private VBox btnSignout;






    public void ListForum(String userr){
        try {
            ServiceForum fm = new ServiceForum();
            data = (ObservableList<Forum>) fm.ForumList();
            System.out.println(data);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        cl_subject.setCellValueFactory(new PropertyValueFactory<>("title"));
        cl_subject1.setCellValueFactory(new PropertyValueFactory<>("auteur_id"));
        cl_subject11.setCellValueFactory(new PropertyValueFactory<>("type"));
        cl_subject111.setCellValueFactory(new PropertyValueFactory<>("subject"));
        cl_subject1111.setCellValueFactory(new PropertyValueFactory<>("dateajout"));
        cl_subject11111.setCellValueFactory(new PropertyValueFactory<>("solved"));
        cl_subject111111.setCellValueFactory(new PropertyValueFactory<>("nbreponse"));

        Callback<TableColumn<Forum, Void>, TableCell<Forum, Void>> Forumselected = new Callback<TableColumn<Forum, Void>, TableCell<Forum, Void>>() {
            @Override
            public TableCell<Forum, Void> call(final TableColumn<Forum, Void> param) {

                final TableCell<Forum, Void> cell = new TableCell<Forum, Void>() {
                    private final Button btn1 = new Button("Details");
                    {
                        btn1.setOnAction((ActionEvent event) -> {
                            ServiceForum FForum = new ServiceForum();
                            Forum f = tabMsg.getItems().get(getIndex());
                            try {
                                FXMLLoader loader = new FXMLLoader();
                                loader.setLocation(getClass().getResource("/GUI/Front/Forumdetails.fxml"));
                                Parent root = loader.load();
                                btn1.getScene().setRoot(root);
                                forumdetail controller = loader.getController();
                                controller.maindata(tabMsg.getItems().get(getIndex()), lblName.getText());
                            } catch (IOException | SQLException e) {
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
                            btn1.getStyleClass().add("button2");
                            setGraphic(btn1);

                        }
                    }
                };
                return cell;
            }

        };
        cl_subject1111111.setCellFactory(Forumselected);


        tabMsg.setItems(data);

    }
    public void maindata(String UserN){
        lblName.setText(UserN);
        System.out.println(UserN);
        ListForum(lblName.getText());
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ListForum(lblName.getText());
    }


    @FXML
    void gotoMarks(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/GUI/Front/marks.fxml"));
        Parent root = loader.load();
        btnMarks.getScene().setRoot(root);
        marks controller = loader.getController();
        controller.maindata(lblName.getText());


    }

    @FXML
    void gotoForum(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/GUI/Front/forumlist.fxml"));
        Parent root = loader.load();
        btnMarks.getScene().setRoot(root);
        ForumList controller = loader.getController();
        controller.maindata(lblName.getText());
    }




    @FXML
    void gotoaddman(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/GUI/Front/addsubject.fxml"));
        Parent root = loader.load();
        btnMessage.getScene().setRoot(root);
        addsubject controller = loader.getController();
        controller.maindata(lblName.getText());
    }



    @FXML
    void gotoShedule(MouseEvent event) {

    }

    @FXML
    void gotologin(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/GUI/login.fxml"));
        Parent root = loader.load();
        btnSignout.getScene().setRoot(root);
    }
    @FXML
    void gotoHome(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/GUI/Front/HomeFront.fxml"));
            Parent root = loader.load();
            home.getScene().setRoot(root);
            Home controller = loader.getController();
            controller.maindata(lblName.getText());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void gotoInformation(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/GUI/Front/information.fxml"));
            Parent root = loader.load();
            btnInfo.getScene().setRoot(root);
            information controller = loader.getController();
            ServiceUser user = new ServiceUser();
            User User1 = user.getStud(lblName.getText());
            controller.maindata(User1);
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}


