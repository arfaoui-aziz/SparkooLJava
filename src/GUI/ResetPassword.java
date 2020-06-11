package GUI;

import Service.ServiceUser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.sql.SQLException;

public class ResetPassword {
    @FXML
    private PasswordField NPassword;

    @FXML
    private PasswordField RPassword;

    @FXML
    private Button btn;

    @FXML
    private Label lbl;

    private String  UEmail = "";

    public void getEmail(String Email){
     UEmail  = Email ;
    }

    public void confirm(ActionEvent event) throws IOException, SQLException {

        String Npwd = NPassword.getText();
        String Rpwd = RPassword.getText();
        if (!(Npwd.equals(Rpwd))) {
            lbl.setText("You have to enter the same Password");
        }else {
            ServiceUser user = new ServiceUser();
            user.ResetPassword(UEmail,Npwd);
            FXMLLoader fxml=new FXMLLoader(getClass().getResource("login.fxml"));
            Parent root=fxml.load();
            btn.getScene().setRoot(root);
        }

// String password = bcrypt.hashpw(psw,bcrypt.gensalt(12));




       /* ServiceUser user = new ServiceUser();
        int acces = user.login(userN, psw);

        if (acces == 1) {

            FXMLLoader fxml = new FXMLLoader(getClass().getResource("/GUI/back/home.fxml"));
            Parent root = fxml.load();
            btn.getScene().setRoot(root);
            lbl.setText("valid");
        } else if (acces == 2) {
            lbl.setText("MDP invalid");
        } else {
            lbl.setText("invalid");
        }
*/
    }




}
