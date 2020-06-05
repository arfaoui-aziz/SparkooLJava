package GUI;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class forget {
    @FXML
    private TextField mail;

    @FXML
    private Button btn;

    @FXML
    private Label lbl;

    @FXML
    private Label btn_back;


    @FXML
    private void back(MouseEvent event) throws IOException {
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("login.fxml"));
        Parent root=fxml.load();
        btn_back.getScene().setRoot(root);
    }
}
