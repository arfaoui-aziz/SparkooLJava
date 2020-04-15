package GUI.front.Dark;

import Entity.Absence;
import Entity.Mark;
import Service.ServiceMarks;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.sql.SQLException;

public class DaddMarkStudent {

    @FXML
    private TextField cc;

    @FXML
    private TextField exan;

    @FXML
    private TextField note;

    @FXML
    private Button send;
String idS="";
String idT="";
String sub="";
    @FXML
    void send(MouseEvent event) throws SQLException {
        Double c= Double.valueOf(cc.getText());
        Double ex= Double.valueOf(exan.getText());
        String not=note.getText();
        ServiceMarks sm =new ServiceMarks();
        Mark m = new Mark(0,sub,c,ex,not,idS,idT);
sm.addMark(m);

        Stage primaryStage = new Stage();

        Stage stage = (Stage) send.getScene().getWindow();
        stage.close();
    }

    public void initData(String id, String id1,String su) {
        idS=id;
        idT=id1;
        sub=su;
    }
}
