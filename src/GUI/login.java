package GUI;
import Entity.User;
import GUI.back.home;
import GUI.frontAdmin.Dark.DarkHome;
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


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
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

        String userN = Username.getText();
        String psw = pass.getText(); ServiceUser user = new ServiceUser();
        int access = user.login(userN,psw);
        if ( access == 1) {
            User u = user.getActiveUser(userN);
            FXMLLoader fxml = new FXMLLoader(getClass().getResource("/GUI/frontAdmin/Dark/DarkHome.fxml"));
            Parent root = fxml.load();
            btn.getScene().setRoot(root);
            DarkHome controller = fxml.getController();
            controller.initData(u);

        } else if ( access == 2) {
            lbl.setText("MDP invalid");
        }else if ( access == 3 ){
            User u = user.getActiveUser(userN);
            FXMLLoader fxml = new FXMLLoader(getClass().getResource("/GUI/back/home.fxml"));
            Parent root = fxml.load();
            btn.getScene().setRoot(root);
            home controller = fxml.getController();
            controller.initData(u);
        } else {
            lbl.setText("invalid");
        }

    }

    @FXML
    private void goto_forget(MouseEvent event) throws IOException {
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("forget.fxml"));
        Parent root=fxml.load();
        lblForget.getScene().setRoot(root);
    }

}
