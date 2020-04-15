package GUI.back;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;


public class Validation {
    @FXML
    private Label txt;

    @FXML
    private Button btn;

    @FXML
    void closeButtonAction(ActionEvent event) throws IOException {
        Stage primaryStage = new Stage();

        Stage stage = (Stage) btn.getScene().getWindow();
        stage.close();
    }

}
