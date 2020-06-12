package GUI.back.Forum;

import Entity.User;
import Service.ServiceForum;
import Service.ServiceUser;
import Utils.javaMailUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

import javax.mail.MessagingException;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class addsubjectForum implements Initializable {
    @FXML
    private TextField titlefm;

    @FXML
    private TextField subhectfm;

    @FXML
    private ComboBox typefm;

    @FXML
    private Button addsubfm;

    @FXML
    private HBox gotoStudt;

    @FXML
    private Text lblName;

    @FXML
    private Label erreur;

    @FXML
    private Label logout;




    public void maindata(String name) {
        lblName.setText(name);

    }



    @FXML
    private void gotoStudent(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/GUI/back/Forum/Forum.fxml"));
        Parent root = loader.load();
        gotoStudt.getScene().setRoot(root);
        Forum controller = loader.getController();
        controller.maindata(lblName.getText());
    }


    public void addSubjectMan(ActionEvent event) throws IOException, SQLException, MessagingException {
        String titleFm= titlefm.getText();
        String subhectFm= subhectfm.getText();
        String typeFm= typefm.getValue().toString();

        if (titleFm.length() < 10) {
            erreur.setText("Title Length needs to be 10 at least ");
            erreur.setVisible(true);
        }
        else if (subhectFm.length() < 20)
        {
            erreur.setText("Title Length needs to be 20 at least ");
            erreur.setVisible(true);
        }
        else  if (typeFm.equals("Select Type"))
        {
            erreur.setText("Please Select a Type");
            erreur.setVisible(true);
        }
        else {
            ServiceForum Forum = new ServiceForum();
            boolean acces = Forum.addsub(lblName.getText(),titleFm,typeFm,subhectFm);
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/GUI/back/Forum/Forum.fxml"));
            Parent root = loader.load();
            addsubfm.getScene().setRoot(root);
            Forum controller = loader.getController();
            controller.maindata(lblName.getText());
        }


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        typefm.getItems().addAll("Select Type","Administartion","Math","Physique","Lecture");
        typefm.getSelectionModel().select(0);

    }

    @FXML
    private void logOut(MouseEvent event) throws IOException {
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("/GUI/login.fxml"));
        Parent root=fxml.load();
        logout.getScene().setRoot(root);
    }


}
