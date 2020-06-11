package GUI;

import Service.ServiceUser;
import Utils.Mailer;
import Utils.sendSMS;
import Utils.verificationCode;
import com.twilio.type.PhoneNumber;
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
import java.sql.SQLException;

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
    void Mailing(MouseEvent event) throws IOException, SQLException {
        String Email = mail.getText();
        ServiceUser user = new ServiceUser();
        int phoneNumber = user.checkEmail(Email);
        if (phoneNumber == 0){
            lbl.setText("There is no account Registred with the Entred Email");
        }else {
            String verifCode = verificationCode.getAlphaNumericString(8);
            FXMLLoader fxml = new FXMLLoader(getClass().getResource("VerifCode.fxml"));
            Parent root = fxml.load();
            btn.getScene().setRoot(root);
            VerifCode Vcode = fxml.getController();
            Vcode.checkCode(verifCode, Email);


            Parent root1 = FXMLLoader.load(getClass().getResource("back/Success.fxml"));
            Stage primaryStage = new Stage();
            primaryStage.initStyle(StageStyle.UNDECORATED);
            primaryStage.setScene(new Scene(root1, 280, 400));
            primaryStage.show();

            sendSMS.sms(verifCode,phoneNumber);
            Mailer.send("sparkooL.sparkit@gmail.com", "123456Admin", Email, verifCode);
        }
    }
}
