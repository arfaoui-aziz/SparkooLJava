package GUI.back;

import Entity.Diploma;
import Entity.User;
import Service.ServiceDiploma;
import Service.ServiceUser;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class AddDiploma implements Initializable {


    @FXML
    private Label logout;

    @FXML
    private Label gotoTeacher;

    @FXML
    private JFXTextField inti;

    @FXML
    private JFXComboBox<?> lvl;

    @FXML
    private Label btnRes;

    @FXML
    private JFXTextField sch;

    @FXML
    private JFXDatePicker bd;

    @FXML
    private JFXTextField sp;

    @FXML
    private Button btnConf;

    @FXML
    private Label idT;

    ServiceDiploma diploma = new ServiceDiploma();


    @FXML
    void add(MouseEvent event) {

    }

    @FXML
    void gotoTeacher(MouseEvent event) {

    }

    @FXML
    void logOut(MouseEvent event) {

    }

    @FXML
    void restAll(MouseEvent event) {

    }
    public void initData(String st) {
    }

    @FXML
    void addDiploma(MouseEvent event) throws IOException, SQLException {
        String inti1=inti.getText();
        String sch1=sch.getText();
        String spe=sp.getText();
        String lv=(String) lvl.getValue();
        String do1= bd.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        Diploma d = new Diploma(inti1,sch1,spe,lv,do1,"123");
diploma.addDiploma(d);
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("teachers.fxml"));
        Parent root=fxml.load();
        btnConf.getScene().setRoot(root);



    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
