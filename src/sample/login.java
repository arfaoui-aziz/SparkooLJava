package sample;

import Entity.User;
import GUI.Parent.Dark.DHomeParent;
import GUI.back.DetailTeacher;
import GUI.front.Light.LightHome;
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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class login {
    @FXML
    private TextField mail;

    @FXML
    private PasswordField pass;

    @FXML
    private Button btn;

    @FXML
    private Label lbl;

    @FXML
    private Label lblForget;

    public void confirm(ActionEvent event) throws IOException, SQLException {
       String userN= mail.getText();
        String psw =pass.getText();
// String password = bcrypt.hashpw(psw,bcrypt.gensalt(12));


        ServiceUser user = new ServiceUser();
        int acces = user.preauth(userN ,psw);

        if ( acces == 1){
            User u = user.getUserByLogin(userN,psw);
            if (u.getUserType().equals("Administrator")) {
                if (u.getUsername().equals("aparent")){
                    FXMLLoader fxml=new FXMLLoader(getClass().getClassLoader().getResource("GUI/back/home.fxml"));
                    Parent root=fxml.load();
                    btn.getScene().setRoot(root);
                }
                FXMLLoader fxml=new FXMLLoader(getClass().getResource("/GUI/back/home.fxml"));
                Parent root=fxml.load();
                btn.getScene().setRoot(root);

            }
            else if (u.getUserType().equals("Teacher")){
                FXMLLoader fxml=new FXMLLoader(getClass().getClassLoader().getResource("GUI/front/Light/LightHome.fxml"));
                Parent root=fxml.load();
                btn.getScene().setRoot(root);
                LightHome controller = fxml.getController();
                controller.initData(u);
                String source = new File("/Users/amen/Documents/SparkoolGit/src/GUI/sound/welcome.mp4").toURI().toString();
                Media media = null;
                media = new Media(source);
                MediaPlayer mediaPlayer = new MediaPlayer(media);
                mediaPlayer.play();
            }
            else if (u.getUserType().equals("Parent")){
                FXMLLoader fxml=new FXMLLoader(getClass().getClassLoader().getResource("GUI/Parent/Dark/DHomeParent.fxml"));
                Parent root=fxml.load();
                btn.getScene().setRoot(root);
                DHomeParent controller = fxml.getController();
                controller.initData(u);

            }



            lbl.setText("valid");




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

}
