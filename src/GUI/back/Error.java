package GUI.back;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Error {
    @FXML
    private Button btn;


    @FXML
    private void closeButtonAction(){
        Stage primaryStage = new Stage();

        Stage stage = (Stage) btn.getScene().getWindow();
        stage.close();
    }
}
