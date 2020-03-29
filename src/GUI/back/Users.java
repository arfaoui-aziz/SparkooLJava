package GUI.back;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

import java.io.IOException;

public class Users {

    @FXML
    private Label logout;

    @FXML
    private HBox btnAdd;

    @FXML
    private void addUser(MouseEvent event) throws IOException {
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("addUser.fxml"));
        Parent root=fxml.load();
        btnAdd.getScene().setRoot(root);
    }
    @FXML
    private void logOut(MouseEvent event) throws IOException {
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("/GUI/login.fxml"));
        Parent root=fxml.load();
        logout.getScene().setRoot(root);
    }

}
