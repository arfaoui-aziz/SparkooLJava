package GUI.Front;


import Entity.Marks;
import Entity.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import Service.ServiceUser;
import javafx.scene.shape.Circle;
import Service.ServiceMarks;
import javax.xml.ws.Service;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Home  {
    @FXML
    private HBox btnTheme;

    @FXML
    private Circle photo;

    @FXML
    private Label lblName;

    @FXML
    private Label lblType;

    @FXML
    private Label lblSpeciality;

    @FXML
    private VBox btnHome;

    @FXML
    private VBox btnInfo;

    @FXML
    private VBox btnShedule;

    @FXML
    private VBox btnCourse;

    @FXML
    private VBox btnMessage;

    @FXML
    private VBox btnMarks;

    @FXML
    private VBox btnAccount;

    @FXML
    private VBox btnSignout;




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

    @FXML
    void gotoHome(MouseEvent event) {

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






    public void maindata(String UserN){
        lblName.setText(UserN);
System.out.println(UserN);
    }



}
