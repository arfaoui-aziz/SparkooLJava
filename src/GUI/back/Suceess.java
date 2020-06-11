package GUI.back;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Suceess {
    @FXML
    private Button btn;


    @FXML
    private void closeButtonAction() throws IOException {
        Stage stage = (Stage) btn.getScene().getWindow();

        stage.close();

    }
}
