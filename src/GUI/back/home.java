package GUI.back;

import Service.ServiceUser;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class home implements Initializable {

    @FXML
    private Label logout;


    @FXML
    private HBox gotoTeacher;

    @FXML
    private Label nbTeacher;

    @FXML
    private ImageView gotoStats;

    @FXML
    private void gotoStat(MouseEvent event) throws IOException {
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("statsTeacher.fxml"));
        Parent root=fxml.load();
        gotoTeacher.getScene().setRoot(root);
    }

    @FXML
    private void gotoTeatcher(MouseEvent event) throws IOException {
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("teachers.fxml"));
        Parent root=fxml.load();
        gotoTeacher.getScene().setRoot(root);
    }
    @FXML
    private void logOut(MouseEvent event) throws IOException {
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("/sample/login.fxml"));
        Parent root=fxml.load();
        logout.getScene().setRoot(root);
    }

    private void setNbTeacher() throws SQLException {
        ServiceUser user = new ServiceUser();
        int i = user.NumberOfTeachers();
        String st = Integer.toString(i);
        nbTeacher.setText(st);
        System.out.println(i);
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
