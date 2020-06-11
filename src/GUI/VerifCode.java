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
import javafx.event.ActionEvent;

import java.io.IOException;

public class VerifCode {
    @FXML
    private TextField mail;

    @FXML
    private Button btn;

    @FXML
    private Label lbl;

    @FXML
    private Label btn_back;

    private String  code = "";
    private String  UEmail = "";


    public void checkCode(String vCode,String Email){
        code = vCode ;
        UEmail = Email;
    }

    @FXML
    void Mailing(ActionEvent event) throws IOException {
        String CodeEntred = mail.getText();

        if (code.equals(CodeEntred)) {
            FXMLLoader fxml = new FXMLLoader(getClass().getResource("ResetPassword.fxml"));
            Parent root = fxml.load();
            ResetPassword getMail = fxml.getController();
            getMail.getEmail(UEmail);
            btn.getScene().setRoot(root);


        } else {

            Parent root = FXMLLoader.load(getClass().getResource("back/error.fxml"));
            Stage primaryStage = new Stage();
            primaryStage.initStyle(StageStyle.UNDECORATED);
            primaryStage.setScene(new Scene(root, 280, 400));
            primaryStage.show();
        }



    }

    @FXML
    private void back(MouseEvent event) throws IOException {
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("login.fxml"));
        Parent root=fxml.load();
        btn_back.getScene().setRoot(root);
    }




}
