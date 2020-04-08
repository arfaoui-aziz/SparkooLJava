package GUI.back;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class home {

    @FXML
    private Label logout;

    @FXML
    private VBox btnstat;
    @FXML
    private HBox gotoTeacher;
    @FXML
    private HBox gotoAccount;
    @FXML
    private HBox Classe;

    @FXML
    private void gotoTeatcher(MouseEvent event) throws IOException {
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("Users.fxml"));
        Parent root=fxml.load();
        gotoTeacher.getScene().setRoot(root);
    }

    @FXML
    private void gotoClasse(MouseEvent event) throws IOException {
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("Classe/Classes.fxml"));
        Parent root=fxml.load();
        Classe.getScene().setRoot(root);
    }
    @FXML
    private void gotoAccount(MouseEvent event) throws IOException {
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("Users.fxml"));
        Parent root=fxml.load();
        gotoAccount.getScene().setRoot(root);
    }
    @FXML
    private void logOut(MouseEvent event) throws IOException {
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("../login.fxml"));
        Parent root=fxml.load();
        logout.getScene().setRoot(root);
    }
    @FXML
    void goToStat(MouseEvent event) throws IOException {
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("stat.fxml"));
        Parent root=fxml.load();
        btnstat.getScene().setRoot(root);
    }

}
