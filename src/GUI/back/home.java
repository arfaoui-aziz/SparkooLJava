package GUI.back;

import Service.ServiceUser;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class home implements Initializable {

    @FXML
    private Label logout;


    @FXML
    private HBox gotoParents;
    @FXML
    private Label lblNbParent;

    @FXML
    private void gotoParent(MouseEvent event) throws IOException {
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("Users.fxml"));
        Parent root=fxml.load();
        gotoParents.getScene().setRoot(root);
    }
    @FXML
    private void logOut(MouseEvent event) throws IOException {
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("/sample/login.fxml"));
        Parent root=fxml.load();
        logout.getScene().setRoot(root);
    }


    private void setNbTeacher() throws SQLException {
        ServiceUser user = new ServiceUser();
        int i = user.NumberOfParent();
        String st = Integer.toString(i);
        lblNbParent.setText(st);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            setNbTeacher();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
