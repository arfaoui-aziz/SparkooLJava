package GUI.back.Forum;

import Service.ServiceForum;
import Service.ServiceUser;
import Utils.javaMailUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

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
    private void gotoStudent(MouseEvent event) throws IOException {
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("/GUI/back/Student/Students.fxml"));
        Parent root=fxml.load();
        gotoStudt.getScene().setRoot(root);
    }


    public void addSubjectMan(ActionEvent event) throws IOException, SQLException, MessagingException {
        String titleFm= titlefm.getText();
        String subhectFm= subhectfm.getText();
        String typeFm= typefm.getValue().toString();
        ServiceForum Forum = new ServiceForum();
        boolean acces = Forum.addsub("dalidali" ,titleFm,typeFm,subhectFm);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        typefm.getItems().addAll("Select Type","Administartion","Math","Physique","Lecture");
        typefm.getSelectionModel().select(0);

    }


}
