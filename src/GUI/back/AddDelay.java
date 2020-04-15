package GUI.back;

import Entity.Absence;
import Entity.Delay;
import Service.ServiceDelay;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;

public class AddDelay {


    @FXML
    private JFXTextField dur;

    @FXML
    private JFXDatePicker date;

    @FXML
    private Button btnCan;

    @FXML
    private Button btConf;

    @FXML
    private TextField idT;

ServiceDelay delay = new ServiceDelay();
    @FXML
    private void cancelButtonAction(MouseEvent event){
        Stage primaryStage = new Stage();

        Stage stage = (Stage) btnCan.getScene().getWindow();
        stage.close();
    }

    @FXML
    void addDelay(MouseEvent event) throws IOException, SQLException {
        int duration = Integer.parseInt(dur.getText());
        String j= date.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String id=idT.getText();

        Delay d=new Delay(duration,j,id);

        delay.addDelay(d);
        Stage primaryStage = new Stage();

        Stage stage = (Stage) btConf.getScene().getWindow();
        stage.close();



    }

    public void initData(String id) {
        idT.setText(id);
    }
}
