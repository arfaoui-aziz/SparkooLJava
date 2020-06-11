package GUI.back;

import Entity.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.IOException;
import java.sql.SQLException;

public class home {

    @FXML
    private Label logout;

    @FXML
    private Text activeUser;
    @FXML
    private VBox btnstat;
    @FXML
    private HBox gotoTeacher;
    @FXML
    private HBox gotoAccount;
    @FXML
    private HBox Classe;
    User user = new User();


    @FXML
    private void gotoTeatcher(MouseEvent event) throws IOException {
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("Users.fxml"));
        Parent root=fxml.load();
        gotoTeacher.getScene().setRoot(root);
    }

    @FXML
    private void gotoClasse(MouseEvent event) throws IOException {
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("Classe/Classes.fxml"));
        Parent root=fxml.load();
        Classe.getScene().setRoot(root);
    }
    @FXML
    private void gotoAccount(MouseEvent event) throws IOException {
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("Users.fxml"));
        Parent root=fxml.load();
        gotoAccount.getScene().setRoot(root);
    }
    @FXML
    private void logOut(MouseEvent event) throws IOException {
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("../login.fxml"));
        Parent root=fxml.load();
        logout.getScene().setRoot(root);
    }
    @FXML
    void goToStat(MouseEvent event) throws IOException {
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("stat.fxml"));
        Parent root=fxml.load();
        btnstat.getScene().setRoot(root);
    }
    public void initData(User u) throws SQLException {
        /*lblName.setText(u.getFirstName()+' '+u.getLastName());
        lblType.setText(u.getUserType());*/
        activeUser.setText(u.getFirstName()+' '+u.getLastName());
        user=u;


    }

}
