package GUI;

import Utils.Mailer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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
    @FXML
    void Mailing(MouseEvent event) throws IOException {

        Stage primaryStage = new Stage();
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("Success.fxml"));
        Parent root=fxml.load();
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(new Scene(root, 280, 400));
        primaryStage.show();
        Mailer.send("sparkooL.sparkit@gmail.com","123456Admin","aziz.arfaou.98@gmail.com");
    }
}
