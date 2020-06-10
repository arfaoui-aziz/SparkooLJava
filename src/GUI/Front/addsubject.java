package GUI.Front;

import Entity.AlertBox;
import Entity.User;
import Service.ServiceForum;
import Service.ServiceUser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import javax.mail.MessagingException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class addsubject implements Initializable {


    @FXML
    private Label lblName;
    @FXML
    private TextField titlefm;

    @FXML
    private TextField subhectfm;

    @FXML
    private ComboBox typefm;

    @FXML
    private Button addsubfm;

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

    public void addSubjectMan(ActionEvent event) throws IOException, SQLException, MessagingException {
        String titleFm= titlefm.getText();
        String subhectFm= subhectfm.getText();
        String typeFm= typefm.getValue().toString();
        ServiceForum Forum = new ServiceForum();
        boolean acces = Forum.addsubfront(lblName.getText(),titleFm,typeFm,subhectFm);
        AlertBox dis = new AlertBox();
        dis.display("Congratulation ","Your submission has been successfully sent");

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        typefm.getItems().addAll("Select Type","Math","Physique","Lecture");
        typefm.getSelectionModel().select(0);

    }

    public void maindata(String UserN){
        lblName.setText(UserN);
        System.out.println(UserN);
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
