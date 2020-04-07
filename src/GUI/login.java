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

public class login {
    @FXML
    private TextField Username;

    @FXML
    private PasswordField pass;

    @FXML
    private Button btn;

    @FXML
    private Label lbl;

    @FXML
    private Label lblForget;

    public void confirm(ActionEvent event) throws IOException, SQLException {

      String userN= Username.getText();
        String psw =pass.getText();
// String password = bcrypt.hashpw(psw,bcrypt.gensalt(12));


        ServiceUser user = new ServiceUser();
        int acces = user.preauth(userN ,psw);

        if ( acces == 1){

           FXMLLoader fxml=new FXMLLoader(getClass().getResource("/GUI/back/home.fxml"));
            Parent root=fxml.load();
            btn.getScene().setRoot(root);
            lbl.setText("valid");
        }
        else if(acces == 2) {
            lbl.setText("MDP invalid");
        }
        else{
            lbl.setText("invalid");
        }




        FXMLLoader fxml=new FXMLLoader(getClass().getResource("/GUI/back/home.fxml"));
        Parent root=fxml.load();
        btn.getScene().setRoot(root);
    }

    @FXML
    private void goto_forget(MouseEvent event) throws IOException {
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("forget.fxml"));
        Parent root=fxml.load();
        lblForget.getScene().setRoot(root);
    }

}
