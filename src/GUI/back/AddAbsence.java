package GUI.back;

import Entity.Absence;
import Entity.Diploma;
import Service.ServiceAbsence;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTimePicker;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;

public class AddAbsence {

    @FXML
    private JFXComboBox<String> week;

    @FXML
    private JFXComboBox<String> day;

    @FXML
    private JFXComboBox<String> uy;


    @FXML
    private Button btnCan;

    @FXML
    private Button btConf;

    @FXML
    private TextField idT;


    ServiceAbsence absence = new ServiceAbsence();
    public void initData(String id) {
        idT.setText(id);
        System.out.println(id);
    }

    @FXML
    private void cancelButtonAction(MouseEvent event){
        Stage primaryStage = new Stage();

        Stage stage = (Stage) btnCan.getScene().getWindow();
        stage.close();
    }

    @FXML
    void addAbsence(MouseEvent event) throws IOException, SQLException {
        String sem= week.getValue();
        String jour=day.getValue();
        String au = uy.getValue();
        String id=idT.getText();

        Absence a = new Absence(sem,au,jour,id);

        absence.addAbsence(a);
        Stage primaryStage = new Stage();

        Stage stage = (Stage) btConf.getScene().getWindow();
        stage.close();



    }
    public void initialize() {

uy.setValue("2019-20");
        day.getItems().addAll("Monday","Tuesday","Wednesday","Thursay","Friday","Sturday");
        week.getItems().addAll("1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36");
        uy.getItems().addAll("2019-20","2018-19","2017-18");
    }



}
