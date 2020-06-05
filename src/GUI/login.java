package GUI;
import GUI.Front.Home;
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

    @FXML
    private Label createacc;



    public void confirm(ActionEvent event) throws IOException, SQLException {

      String userN= Username.getText();
        String psw =pass.getText();
// String password = bcrypt.hashpw(psw,bcrypt.gensalt(12));


        ServiceUser user = new ServiceUser();
        int acces = user.login(userN ,psw);
        int role = user.role(userN ,psw);
        System.out.println(role);
        if ( acces == 1){
if (role == 1 ) {
    FXMLLoader fxml = new FXMLLoader(getClass().getResource("/GUI/back/home.fxml"));
    Parent root = fxml.load();
    btn.getScene().setRoot(root);
    lbl.setText("valid");
}
else if (role == 2)
            {
                try {
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("/GUI/Front/HomeFront.fxml"));
                    Parent root = loader.load();
                    btn.getScene().setRoot(root);
                    Home controller = loader.getController();
                    controller.maindata(userN);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

}
        else if(acces == 2) {
            lbl.setText("MDP invalid");
        }
        else{
            lbl.setText("invalid");
        }



    }

    @FXML
    private void goto_forget(MouseEvent event) throws IOException {
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("forget.fxml"));
        Parent root=fxml.load();
        lblForget.getScene().setRoot(root);
    }

    @FXML
    private void goto_signup(MouseEvent event) throws IOException {

        FXMLLoader fxml=new FXMLLoader(getClass().getResource("signup.fxml"));
        Parent root=fxml.load();
        createacc.getScene().setRoot(root);
    }
}
