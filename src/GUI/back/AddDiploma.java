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
import javafx.scene.control.TextField;
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
    private JFXComboBox<String> lvl;

    @FXML
    private Label btnRes;

    @FXML
    private JFXTextField sch;

    @FXML
    private JFXDatePicker bd;

    @FXML
    private JFXComboBox<String> sp;

    @FXML
    private Button btnConf;

    @FXML
    private TextField idT;

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
        idT.setText(st);

    }

    @FXML
    void addDiploma(MouseEvent event) throws IOException, SQLException {
        String inti1=inti.getText();
        String sch1=sch.getText();
        String spe=sp.getValue();
        String lv=(String) lvl.getValue();
        String do1= bd.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String idT1=idT.getText();

        Diploma d = new Diploma(inti1,sch1,spe,lv,do1,idT1);
        diploma.addDiploma(d);
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("teachers.fxml"));
        Parent root=fxml.load();
        btnConf.getScene().setRoot(root);



    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lvl.getItems().addAll("Bachelor", "Master","Doctoral","Professional");
        sp.getItems().addAll("Computer Science", "Mathematics","Physics","History and Geography","Literature","Natural Science","Sport");



    }
}
