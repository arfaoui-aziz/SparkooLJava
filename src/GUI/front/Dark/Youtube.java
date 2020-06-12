package GUI.front.Dark;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class Youtube implements Initializable {

    @FXML
    private WebView WebView;
    private WebEngine engine;

    @FXML
    private Button bReturn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        engine = WebView.getEngine();
        engine.load("https://www.youtube.com/watch?v=AtoqTlazl9Q&feature=youtu.be&fbclid=IwAR0FJ1v7uf9HIRTqmAh_mZNLg6sVRTpE6a9Bx6zTxbeat1Nfac0ItfjLuZc");
        // TODO
    }

    @FXML
    void Return(MouseEvent event) throws IOException {
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("DShowEvent.fxml"));
        Parent root = fxml.load();
        bReturn.getScene().setRoot(root);
    }

}
