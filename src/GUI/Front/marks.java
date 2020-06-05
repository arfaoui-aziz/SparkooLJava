package GUI.Front;

import Entity.Marks;
import Entity.User;
import Service.ServiceMarks;
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
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class marks  {
    @FXML
    private TableView<Marks> tabMsg;

    @FXML
    private TableColumn<?, ?> cl_subject;
    @FXML
    private TableColumn<?, ?> cl_subject1;
    @FXML
    private TableColumn<?, ?> cl_subject11;

    @FXML
    private Label lblName;

    @FXML
    private VBox btnHome;


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




    ObservableList<Marks> data = FXCollections.observableArrayList();
    public void Markslist() {

        try {

            ServiceMarks usr = new ServiceMarks();
            data = (ObservableList<Marks>) usr.Markslist(lblName.getText());
            System.out.println(data);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        cl_subject.setCellValueFactory(new PropertyValueFactory<>("subject"));
        cl_subject1.setCellValueFactory(new PropertyValueFactory<>("CC"));
        cl_subject11.setCellValueFactory(new PropertyValueFactory<>("Exam"));
        tabMsg.setItems(data);
    }

    public void maindata(String UserN){
        lblName.setText(UserN);
        System.out.println(UserN);
        Markslist();
    }

    @FXML
    void gotoHome(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/GUI/Front/HomeFront.fxml"));
            Parent root = loader.load();
            btnHome.getScene().setRoot(root);
            Home controller = loader.getController();
            controller.maindata(lblName.getText());
        } catch (IOException e) {
            e.printStackTrace();
        }
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
    void gotologin(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/GUI/login.fxml"));
        Parent root = loader.load();
        btnSignout.getScene().setRoot(root);
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
