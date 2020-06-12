package GUI.back.Forum;

import Entity.Forum;
import Entity.User;
import GUI.back.Student.Students;
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
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

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
    private Text lblName;

    @FXML
    private Label erreur;
    @FXML
    private Label logout;


    @FXML
    private void logOut(MouseEvent event) throws IOException {
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("/GUI/login.fxml"));
        Parent root=fxml.load();
        logout.getScene().setRoot(root);
    }



    @FXML
    private void gotoStudent(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/GUI/back/Student/Students.fxml"));
        Parent root = loader.load();
        gotoStudt.getScene().setRoot(root);
        Students controller = loader.getController();
        controller.maindata(lblName.getText());
    }

    ServiceForum Forum = new ServiceForum();

    public void maindata(Entity.Forum selectedItem, String name){
        titleup.setText(selectedItem.getTitle());
        Subjectup.setText(selectedItem.getSubject());
        forumid.setText(String.valueOf(selectedItem.getId()));
        typeip.getSelectionModel().select(selectedItem.getType());
        statusup.getSelectionModel().select(selectedItem.getEtat());
        solvedup.getSelectionModel().select(selectedItem.getSolved());
        lblName.setText(name);
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

        if (Titleup.length() <5){erreur.setText("Title Length Must be at least 5"); erreur.setVisible(true);}
        else if (subjectup.length() <5){erreur.setText("Subject Length Must be at least 10"); erreur.setVisible(true);}
        else if (Typeip.equals("Select Type") == true){erreur.setText("Please Select a Type"); erreur.setVisible(true);}
        else if (statusup.getValue().toString().equals("Status") == true){erreur.setText("Please select The status"); erreur.setVisible(true);}
        else if (solvedup.getValue().toString().equals("Solved") == true){erreur.setText("Please select If the subject is solved or not"); erreur.setVisible(true);}
        else
        {
            Byte Statusupp=Byte.parseByte(statusup.getValue().toString());
            Byte Solvedupp=Byte.parseByte(solvedup.getValue().toString());
            Forum F = new Forum(Titleup,Typeip,subjectup,Statusupp,Solvedupp);
            Forum. updateForum(F,Forumid);
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/GUI/back/Forum/ListForum.fxml"));
            Parent root = loader.load();
            addsubfm.getScene().setRoot(root);
            ForumList controller = loader.getController();
            controller.maindata(lblName.getText());
        }
    }

}
