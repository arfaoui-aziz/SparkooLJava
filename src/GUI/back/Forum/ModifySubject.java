package GUI.back.Forum;

import Entity.Forum;
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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ModifySubject implements Initializable {


    @FXML
    private TextField titleup;

    @FXML
    private TextField Subjectup;

    @FXML
    private ComboBox typeip;

    @FXML
    private ComboBox statusup;

    @FXML
    private ComboBox solvedup;

    @FXML
    private TextField forumid;

    @FXML
    private Button addsubfm;

    @FXML
    private HBox gotoStudt;
    @FXML
    private void gotoStudent(MouseEvent event) throws IOException {
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("Students.fxml"));
        Parent root=fxml.load();
        gotoStudt.getScene().setRoot(root);
    }

    ServiceForum Forum = new ServiceForum();

    public void maindata(Entity.Forum selectedItem){
        titleup.setText(selectedItem.getTitle());
        Subjectup.setText(selectedItem.getSubject());
        forumid.setText(String.valueOf(selectedItem.getId()));
        typeip.getSelectionModel().select(selectedItem.getType());
        statusup.getSelectionModel().select(selectedItem.getEtat());
        solvedup.getSelectionModel().select(selectedItem.getSolved());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        typeip.getItems().addAll("Select Type","Administartion","Math","Physique","Lecture");

        statusup.getItems().addAll("Status","0","1");

        solvedup.getItems().addAll("Solved","0","1");

    }

    @FXML
    void updateSub(ActionEvent event) throws SQLException, IOException {
        int Forumid=Integer.parseInt(forumid.getText());
        String Titleup = titleup.getText();
        String subjectup = Subjectup.getText();
        String Typeip=typeip.getValue().toString();
        Byte Statusup=Byte.parseByte(statusup.getValue().toString());
        Byte Solvedup=Byte.parseByte(solvedup.getValue().toString());
        Forum F = new Forum(Titleup,Typeip,subjectup,Statusup,Solvedup);
        Forum. updateForum(F,Forumid);
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("/GUI/back/Forum/ListForum.fxml"));
        Parent root=fxml.load();
        addsubfm.getScene().setRoot(root);
    }

}
